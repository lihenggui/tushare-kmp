package li.mercury.tushare.http

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.HttpStatement
import io.ktor.util.reflect.TypeInfo
import kotlinx.coroutines.CancellationException
import kotlinx.io.IOException
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import li.mercury.tushare.internal.exception.AuthenticationException
import li.mercury.tushare.internal.exception.GenericIOException
import li.mercury.tushare.internal.exception.InvalidRequestException
import li.mercury.tushare.internal.exception.PermissionException
import li.mercury.tushare.internal.exception.RateLimitException
import li.mercury.tushare.internal.exception.TuShareAPIException
import li.mercury.tushare.internal.exception.TuShareError
import li.mercury.tushare.internal.exception.TuShareErrorDetails
import li.mercury.tushare.internal.exception.TuShareHttpException
import li.mercury.tushare.internal.exception.TuShareServerException
import li.mercury.tushare.internal.exception.TuShareTimeoutException
import li.mercury.tushare.internal.exception.UnknownAPIException
import li.mercury.tushare.models.TuShareData
import li.mercury.tushare.models.TuShareResponse

/**
 * TuShare HTTP传输层
 */
internal class HttpTransport(
    private val httpClient: HttpClient,
) : HttpRequester {
    companion object {
        // TuShare API错误码映射
        private val TUSHARE_ERROR_CODE_MAPPING =
            mapOf(
                40001 to ::AuthenticationException,
                40002 to ::RateLimitException,
                40003 to ::PermissionException,
                40203 to ::PermissionException, // 接口访问权限错误
            )

        // 错误消息关键词映射（按优先级排序）
        private val ERROR_MESSAGE_MAPPING =
            listOf(
                // 认证相关 - 最高优先级
                listOf(
                    "invalid_api_key",
                    "api key",
                    "token",
                    "unauthorized",
                    "authentication",
                ) to ::AuthenticationException,
                // 频率限制
                listOf("rate limit", "too many", "frequency", "exceed") to ::RateLimitException,
                // 权限相关（支持中英文）
                listOf(
                    "permission",
                    "access denied",
                    "forbidden",
                    "not allowed",
                    "权限",
                    "访问权限",
                    "接口访问权限",
                    "没有权限",
                ) to ::PermissionException,
                // 请求参数错误 - 最低优先级，使用更精确的关键词
                listOf(
                    "invalid parameter",
                    "parameter error",
                    "param error",
                    "bad request",
                    "missing parameter",
                ) to ::InvalidRequestException,
            )
    }

    /**
     * 执行HTTP请求并获取结果
     * @param info 类型信息
     * @param block HTTP请求构建器
     * @return 反序列化后的响应对象
     */
    override suspend fun <T : Any> perform(
        info: TypeInfo,
        block: suspend (HttpClient) -> HttpResponse,
    ): T {
        try {
            val response = block(httpClient)
            val tuShareResponse = response.body<TuShareResponse>()

            if (tuShareResponse.code != 0) {
                // 根据TuShare响应体中的错误信息创建相应的异常
                throw createTuShareAPIException(response, tuShareResponse)
            }

            val data =
                tuShareResponse.data ?: throw InvalidRequestException(
                    response.status.value,
                    TuShareError(
                        TuShareErrorDetails(
                            code = "no_data",
                            msg = "No data in response",
                            data = null,
                            requestId = tuShareResponse.requestId,
                        ),
                    ),
                    null,
                )

            return deserializeResponse(info, data)
        } catch (e: Exception) {
            throw handleException(e)
        }
    }

    /**
     * 执行HTTP请求并处理响应
     * @param builder HTTP请求构建器
     * @param block 响应处理器
     */
    override suspend fun <T : Any> perform(
        builder: HttpRequestBuilder,
        block: suspend (response: HttpResponse) -> T,
    ) {
        try {
            HttpStatement(builder = builder, client = httpClient).execute(block)
        } catch (e: Exception) {
            throw handleException(e)
        }
    }

    /**
     * 关闭HTTP客户端
     */
    override fun close() {
        httpClient.close()
    }

    /**
     * 反序列化响应数据
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> deserializeResponse(
        info: TypeInfo,
        data: TuShareData,
    ): T =
        when (info.type) {
            List::class -> {
                val itemType =
                    info.kotlinType
                        ?.arguments
                        ?.firstOrNull()
                        ?.type
                        ?: throw IllegalArgumentException("List type requires one type parameter")
                val serializer = serializer(itemType) as KSerializer<Any>
                data.getResponseItems(serializer) as T
            }
            // 可以在这里扩展支持其他类型
            else -> throw IllegalArgumentException("Unsupported type: ${info.type}")
        }

    /**
     * 根据TuShare响应体中的错误信息创建相应的异常类型
     */
    private fun createTuShareAPIException(
        response: HttpResponse,
        tuShareResponse: TuShareResponse,
    ): TuShareAPIException {
        val errorDetails =
            TuShareErrorDetails(
                code = "api_error_${tuShareResponse.code}",
                msg = tuShareResponse.msg ?: "Unknown API error",
                data = null,
                requestId = tuShareResponse.requestId,
            )
        val error = TuShareError(detail = errorDetails)

        // 为TuShare API错误提供合理的HTTP状态码映射
        val httpStatusCode =
            when (tuShareResponse.code) {
                40001 -> 401 // 认证错误
                40002 -> 429 // 频率限制
                40003 -> 403 // 权限错误
                40203 -> 403 // 接口访问权限错误
                in 30000..39999 -> 400 // 请求参数错误
                else -> response.status.value // 使用原始状态码
            }

        // 优先使用错误码映射
        TUSHARE_ERROR_CODE_MAPPING[tuShareResponse.code]?.let { exceptionConstructor ->
            return exceptionConstructor(httpStatusCode, error, null)
        }

        // 其次使用错误消息匹配
        val errorMessage = tuShareResponse.msg?.lowercase() ?: ""
        for ((keywords, exceptionConstructor) in ERROR_MESSAGE_MAPPING) {
            if (keywords.any { keyword -> errorMessage.contains(keyword) }) {
                val statusCode =
                    when (exceptionConstructor) {
                        ::AuthenticationException -> 401
                        ::RateLimitException -> 429
                        ::PermissionException -> 403
                        ::InvalidRequestException -> 400
                        else -> response.status.value
                    }
                return exceptionConstructor(statusCode, error, null)
            }
        }

        // 最后根据错误码范围判断
        return when (tuShareResponse.code) {
            in 30000..39999 -> InvalidRequestException(400, error, null)
            else -> UnknownAPIException(response.status.value, error, null)
        }
    }

    /**
     * Handles various exceptions that can occur during an API request and converts them into appropriate
     * [li.mercury.tushare.internal.exception.TuShareException] instances.
     */
    private suspend fun handleException(e: Throwable) =
        when (e) {
            is CancellationException -> e // propagate coroutine cancellation
            is TuShareAPIException -> e // TuShare API exceptions already created
            is ClientRequestException -> createHttpAPIException(e)
            is ServerResponseException -> TuShareServerException(e)
            is HttpRequestTimeoutException, is SocketTimeoutException, is ConnectTimeoutException ->
                TuShareTimeoutException(e)

            is IOException -> GenericIOException(e)
            else -> TuShareHttpException(e)
        }

    /**
     * Converts a [ClientRequestException] into a corresponding [TuShareAPIException] based on the HTTP status code.
     * This function helps in handling specific API errors and categorizing them into appropriate exception classes.
     */
    private suspend fun createHttpAPIException(exception: ClientRequestException): TuShareAPIException {
        val response = exception.response
        val status = response.status.value
        val error =
            try {
                response.body<TuShareError>()
            } catch (_: Exception) {
                // 如果无法反序列化错误响应，创建一个默认的错误对象
                TuShareError(
                    TuShareErrorDetails(
                        code = "http_error_$status",
                        msg = exception.message,
                        data = null,
                        requestId = null,
                    ),
                )
            }

        return when (status) {
            429 -> RateLimitException(status, error, exception)
            400, 404, 409, 415 -> InvalidRequestException(status, error, exception)
            401 -> AuthenticationException(status, error, exception)
            403 -> PermissionException(status, error, exception)
            else -> UnknownAPIException(status, error, exception)
        }
    }
}
