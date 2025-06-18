package li.mercury.tushare.internal.extension

import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder

/**
 * Apply request options to the request builder.
 */
internal fun HttpRequestBuilder.requestOptions(requestOptions: RequestOptions? = null) {
    if (requestOptions == null) return
    requestOptions.headers.forEach { (key, value) ->
        if (headers.contains(key)) headers.remove(key)
        headers[key] = value
    }
    requestOptions.urlParameters.forEach { (key, value) -> url.parameters.append(key, value) }
    requestOptions.timeout?.let { timeout ->
        timeout {
            timeout.connect?.let { connectTimeout -> connectTimeoutMillis = connectTimeout.inWholeMilliseconds }
            timeout.request?.let { requestTimeout -> requestTimeoutMillis = requestTimeout.inWholeMilliseconds }
            timeout.socket?.let { socketTimeout -> socketTimeoutMillis = socketTimeout.inWholeMilliseconds }
        }
    }
}
