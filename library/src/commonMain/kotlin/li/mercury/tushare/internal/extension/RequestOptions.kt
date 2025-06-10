package li.mercury.tushare.internal.extension

/**
 * Represents options for configuring a request to an endpoint.
 *
 * @property headers A mutable map of header names to their respective values to be sent with the request.
 * @property urlParameters A mutable map of URL parameter names to their respective values to be appended to the request URL.
 * @property timeout Http operations timeouts.
 */
data class RequestOptions(
    val headers: Map<String, String> = emptyMap(),
    val urlParameters: Map<String, String> = emptyMap(),
    val timeout: Timeout? = null,
)
