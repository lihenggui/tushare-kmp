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
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.internal.exception.AuthenticationException
import li.mercury.tushare.internal.exception.GenericIOException
import li.mercury.tushare.internal.exception.InvalidRequestException
import li.mercury.tushare.internal.exception.PermissionException
import li.mercury.tushare.internal.exception.RateLimitException
import li.mercury.tushare.internal.exception.TuShareAPIException
import li.mercury.tushare.internal.exception.TuShareError
import li.mercury.tushare.internal.exception.TuShareHttpException
import li.mercury.tushare.internal.exception.TuShareServerException
import li.mercury.tushare.internal.exception.TuShareTimeoutException
import li.mercury.tushare.internal.exception.UnknownAPIException

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
     * Handles various exceptions that can occur during an API request and converts them into appropriate
     * [li.mercury.tushare.internal.exception.TuShareException] instances.
     */
    private suspend fun handleException(e: Throwable) = when (e) {
        is CancellationException -> e // propagate coroutine cancellation
        is ClientRequestException -> tuShareAPIException(e)
        is ServerResponseException -> TuShareServerException(e)
        is HttpRequestTimeoutException, is SocketTimeoutException, is ConnectTimeoutException -> TuShareTimeoutException(
            e
        )

        is IOException -> GenericIOException(e)
        else -> TuShareHttpException(e)
    }

    /**
     * Converts a [ClientRequestException] into a corresponding [TuShareAPIException] based on the HTTP status code.
     * This function helps in handling specific API errors and categorizing them into appropriate exception classes.
     */
    private suspend fun tuShareAPIException(exception: ClientRequestException): TuShareAPIException {
        val response = exception.response
        val status = response.status.value
        val error = response.body<TuShareError>()
        return when (status) {
            429 -> RateLimitException(status, error, exception)
            400, 404, 409, 415 -> InvalidRequestException(status, error, exception)
            401 -> AuthenticationException(status, error, exception)
            403 -> PermissionException(status, error, exception)
            else -> UnknownAPIException(status, error, exception)
        }
    }
}
