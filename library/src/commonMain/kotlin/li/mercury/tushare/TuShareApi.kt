package li.mercury.tushare

import li.mercury.tushare.api.index.IndexApi
import li.mercury.tushare.api.index.IndexApiInterface
import li.mercury.tushare.api.news.NewsApi
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.api.stock.basic.StockBasicApi
import li.mercury.tushare.api.stock.basic.StockBasicApiInterface
import li.mercury.tushare.api.stock.board.StockBoardApi
import li.mercury.tushare.api.stock.board.StockBoardApiInterface
import li.mercury.tushare.api.stock.character.StockCharacterApi
import li.mercury.tushare.api.stock.character.StockCharacterApiInterface
import li.mercury.tushare.api.stock.finance.StockFinanceApi
import li.mercury.tushare.api.stock.finance.StockFinanceApiInterface
import li.mercury.tushare.api.stock.flow.StockFlowApi
import li.mercury.tushare.api.stock.flow.StockFlowApiInterface
import li.mercury.tushare.api.stock.margin.StockMarginApi
import li.mercury.tushare.api.stock.margin.StockMarginApiInterface
import li.mercury.tushare.api.stock.market.StockMarketApi
import li.mercury.tushare.api.stock.market.StockMarketApiInterface
import li.mercury.tushare.api.stock.reference.StockReferenceApi
import li.mercury.tushare.api.stock.reference.StockReferenceApiInterface
import li.mercury.tushare.http.HttpRequester

/**
 * Implementation of [TuShare]
 *
 * @param requester http transport layer
 */
internal class TuShareApi(
    private val requester: HttpRequester
) : TuShare,
    NewsApiInterface by NewsApi(requester),
    IndexApiInterface by IndexApi(requester),
    StockBasicApiInterface by StockBasicApi(requester),
    StockBoardApiInterface by StockBoardApi(requester),
    StockCharacterApiInterface by StockCharacterApi(requester),
    StockFlowApiInterface by StockFlowApi(requester),
    StockFinanceApiInterface by StockFinanceApi(requester),
    StockMarginApiInterface by StockMarginApi(requester),
    StockMarketApiInterface by StockMarketApi(requester),
    StockReferenceApiInterface by StockReferenceApi(requester),
    AutoCloseable by requester
