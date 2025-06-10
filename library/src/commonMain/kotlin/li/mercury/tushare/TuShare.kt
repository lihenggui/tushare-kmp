package li.mercury.tushare

import io.ktor.client.HttpClientConfig
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.client.ProxyConfig
import li.mercury.tushare.client.RetryStrategy
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.client.TuShareHost
import li.mercury.tushare.client.createHttpClient
import li.mercury.tushare.http.HttpTransport
import li.mercury.tushare.internal.extension.Timeout
import kotlin.time.Duration.Companion.seconds

/**
 * TuShare API.
 */
interface TuShare :
    NewsApiInterface,
    AutoCloseable

/**
 * Creates an instance of [TuShare]
 *
 * @param token TuShare API token
 * @param host TuShare API base URL
 * @param timeout http client timeout
 * @param header extra http headers
 * @param loggingConfig client logging configuration
 * @param proxy HTTP proxy configuration
 * @param retry rate limit retry configuration
 * @param httpClientConfig additional custom client configuration
 */
fun TuShare(
    token: String,
    loggingConfig: LoggingConfig = LoggingConfig(),
    header: Map<String, String> = emptyMap(),
    host: TuShareHost = TuShareHost.TuShare,
    timeout: Timeout = Timeout(socket = 30.seconds),
    proxy: ProxyConfig? = null,
    retry: RetryStrategy = RetryStrategy(),
    httpClientConfig: HttpClientConfig<*>.() -> Unit = {}
): TuShare = TuShare(
    config = TuShareConfig(
        token = token,
        logging = loggingConfig,
        headers = header,
        host = host,
        timeout = timeout,
        proxy = proxy,
        retry = retry,
        httpClientConfig = httpClientConfig
    )
)

/**
 * Creates an instance of [TuShare]
 *
 * @param config client configuration
 */
fun TuShare(config: TuShareConfig): TuShare {
    val httpClient = createHttpClient(config)
    val transport = HttpTransport(httpClient)
    return TuShareApi(transport, config)
}
