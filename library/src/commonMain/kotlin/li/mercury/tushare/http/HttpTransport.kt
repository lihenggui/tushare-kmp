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
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.reflect.TypeInfo
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.SerializationException
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.internal.extension.TuShareAPIException
import li.mercury.tushare.internal.extension.TuShareAuthenticationException
import li.mercury.tushare.internal.extension.TuShareError
import li.mercury.tushare.internal.extension.TuShareException
import li.mercury.tushare.internal.extension.TuShareHttpException
import li.mercury.tushare.internal.extension.TuShareIOException
import li.mercury.tushare.internal.extension.TuShareInvalidRequestException
import li.mercury.tushare.internal.extension.TuShareRateLimitException
import li.mercury.tushare.internal.extension.TuShareServerException
import li.mercury.tushare.internal.extension.TuShareTimeoutException

/**
 * TuShare HTTP传输层
 */
internal class HttpTransport(
    private val httpClient: HttpClient,
    override val config: TuShareConfig,
) : HttpRequester {

    /**
     * 执行HTTP请求并获取结果
     * @param info 类型信息
     * @param block HTTP请求构建器
     * @return 反序列化后的响应对象
     */
    override suspend fun <T : Any> perform(info: TypeInfo, block: suspend (HttpClient) -> HttpResponse): T {
        try {
            val response = block(httpClient)
            return response.body(info)
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
        block: suspend (response: HttpResponse) -> T
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
     * 处理各种异常并转换为相应的TuShareException实例
     */
    private suspend fun handleException(e: Throwable): TuShareException = when (e) {
        is CancellationException -> throw e // 传播协程取消
        is ClientRequestException -> handleClientException(e)
        is ServerResponseException -> handleServerException(e)
        is HttpRequestTimeoutException,
        is SocketTimeoutException,
        is ConnectTimeoutException -> TuShareTimeoutException(
            message = "Request timeout: ${e.message}",
            cause = e
        )

        is IOException -> TuShareIOException(
            message = "Network IO error: ${e.message}",
            cause = e
        )

        is SerializationException -> TuShareHttpException(
            message = "Serialization error: ${e.message}",
            cause = e
        )

        else -> TuShareHttpException(
            message = "Unexpected error: ${e.message}",
            cause = e
        )
    }

    /**
     * 处理客户端异常（4xx错误）
     */
    private suspend fun handleClientException(exception: ClientRequestException): TuShareAPIException {
        val response = exception.response
        val status = response.status.value

        return try {
            val errorBody = response.bodyAsText()
            val error = TuShareError(
                code = status,
                msg = errorBody.ifEmpty { response.status.description },
                details = "HTTP $status: ${response.status.description}"
            )

            when (status) {
                HttpStatusCode.Companion.Unauthorized.value -> TuShareAuthenticationException(status, error, exception)
                HttpStatusCode.Companion.TooManyRequests.value -> TuShareRateLimitException(status, error, exception)
                HttpStatusCode.Companion.BadRequest.value,
                HttpStatusCode.Companion.NotFound.value,
                HttpStatusCode.Companion.UnprocessableEntity.value -> TuShareInvalidRequestException(
                    status,
                    error,
                    exception
                )

                else -> TuShareAPIException(status, error, exception)
            }
        } catch (e: Exception) {
            // 如果无法解析错误响应，返回通用异常
            val error = TuShareError(
                code = status,
                msg = "Failed to parse error response",
                details = exception.message
            )
            TuShareAPIException(status, error, exception)
        }
    }

    /**
     * 处理服务器异常（5xx错误）
     */
    private suspend fun handleServerException(exception: ServerResponseException): TuShareServerException {
        val response = exception.response
        val status = response.status.value

        return try {
            val errorBody = response.bodyAsText()
            val error = TuShareError(
                code = status,
                msg = errorBody.ifEmpty { "Server error: ${response.status.description}" },
                details = "HTTP $status: ${response.status.description}"
            )
            TuShareServerException(status, error, exception)
        } catch (e: Exception) {
            val error = TuShareError(
                code = status,
                msg = "Server error occurred",
                details = exception.message
            )
            TuShareServerException(status, error, exception)
        }
    }
}