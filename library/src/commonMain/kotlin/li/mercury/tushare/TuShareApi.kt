package li.mercury.tushare

import li.mercury.tushare.api.news.NewsApi
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.http.HttpRequester

/**
 * Implementation of [TuShare]
 *
 * @param requester http transport layer
 * @param config TuShare configuration
 */
internal class TuShareApi(
    private val requester: HttpRequester,
    private val config: TuShareConfig
) : TuShare,
    NewsApiInterface by NewsApi(requester),
    AutoCloseable by requester