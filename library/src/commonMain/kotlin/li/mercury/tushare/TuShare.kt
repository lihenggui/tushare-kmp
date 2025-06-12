package li.mercury.tushare

import io.ktor.client.HttpClientConfig
import li.mercury.tushare.api.index.IndexApiInterface
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.api.stock.basic.StockBasicApiInterface
import li.mercury.tushare.api.stock.board.StockBoardApiInterface
import li.mercury.tushare.api.stock.character.StockCharacterApiInterface
import li.mercury.tushare.api.stock.finance.StockFinanceApiInterface
import li.mercury.tushare.api.stock.flow.StockFlowApiInterface
import li.mercury.tushare.api.stock.margin.StockMarginApiInterface
import li.mercury.tushare.api.stock.market.StockMarketApiInterface
import li.mercury.tushare.api.stock.reference.StockReferenceApiInterface
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
public interface TuShare :
    NewsApiInterface,
    IndexApiInterface,
    StockBasicApiInterface,
    StockBoardApiInterface,
    StockCharacterApiInterface,
    StockFinanceApiInterface,
    StockFlowApiInterface,
    StockMarginApiInterface,
    StockMarketApiInterface,
    StockReferenceApiInterface,
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
public fun TuShare(
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
public fun TuShare(config: TuShareConfig): TuShare {
    val httpClient = createHttpClient(config)
    val transport = HttpTransport(httpClient, config)
    return TuShareApi(transport)
}
