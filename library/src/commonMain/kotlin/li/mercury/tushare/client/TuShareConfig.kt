package li.mercury.tushare.client

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import li.mercury.tushare.internal.extension.Timeout
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.internal.logging.Logger
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * TuShare客户端配置
 */
class TuShareConfig(
    val token: String,
    val host: TuShareHost = TuShareHost.TuShare,
    val logging: LoggingConfig = LoggingConfig(),
    val headers: Map<String, String> = emptyMap(),
    val timeout: Timeout = Timeout(socket = 30.seconds),
    val engine: HttpClientEngine? = null,
    val retry: RetryStrategy = RetryStrategy(),
    val proxy: ProxyConfig? = null,
    val httpClientConfig: HttpClientConfig<*>.() -> Unit = {}
) {
    constructor(
        token: String,
        logLevel: LogLevel = LogLevel.Headers,
        logger: Logger = Logger.Simple,
        host: TuShareHost = TuShareHost.TuShare,
        headers: Map<String, String> = emptyMap(),
        timeout: Timeout = Timeout(socket = 30.seconds),
        engine: HttpClientEngine = CIO.create(),
        retry: RetryStrategy = RetryStrategy(),
        httpClientConfig: HttpClientConfig<*>.() -> Unit = {}
    ) : this(
        token = token,
        host = host,
        logging = LoggingConfig(logLevel, logger),
        headers = headers,
        timeout = timeout,
        engine = engine,
        retry = retry,
        httpClientConfig = httpClientConfig
    )
}

/**
 * A class to configure the TuShare host.
 * It provides a mechanism to customize the base URL and additional query parameters used in TuShare API requests.
 */
class TuShareHost(

    /**
     * Base URL configuration.
     * This is the root URL that will be used for all API requests to TuShare.
     * The URL can include a base path, but in that case, the base path should always end with a `/`.
     * For example, a valid base URL would be "https://api.tushare.pro/".
     */
    val baseUrl: String,

    /**
     * Additional query parameters to be appended to all API requests to TuShare.
     * These can be used to provide additional configuration or context for the API requests.
     */
    val queryParams: Map<String, String> = emptyMap()
) {

    companion object {
        /**
         * A pre-configured instance of [TuShareHost] with the base URL set as `https://api.tushare.pro/`.
         */
        val TuShare: TuShareHost = TuShareHost(baseUrl = "https://api.tushare.pro/")
    }
}

/** Proxy configuration. */
sealed interface ProxyConfig {

    /** Creates an HTTP proxy from [url]. */
    class Http(val url: String) : ProxyConfig

    /** Create socks proxy from [host] and [port]. */
    class Socks(val host: String, val port: Int) : ProxyConfig
}


/**
 * Specifies the retry strategy
 *
 * @param maxRetries the maximum number of retries to perform for a request
 * @param base retry base value
 * @param maxDelay max retry delay
 */
class RetryStrategy(
    val maxRetries: Int = 3,
    val base: Double = 2.0,
    val maxDelay: Duration = 60.seconds,
)

/**
 * Defines the configuration parameters for logging.
 *
 * @property logLevel the level of logging to be used by the HTTP client.
 * @property logger the logger instance to be used by the HTTP client.
 * @property sanitize flag indicating whether to sanitize sensitive information (i.e., authorization header) in the logs
 */
class LoggingConfig(
    val logLevel: LogLevel = LogLevel.Headers,
    val logger: Logger = Logger.Simple,
    val sanitize: Boolean = true,
)