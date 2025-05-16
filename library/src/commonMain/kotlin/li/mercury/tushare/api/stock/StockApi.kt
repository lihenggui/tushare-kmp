package li.mercury.tushare.api.stock

import li.mercury.tushare.TuShare
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

/**
 * 股票相关API的统一入口
 */
class StockApi(
    private val tuShare: TuShare,
) {
    /** 股票基础信息相关API */
    val basic: StockBasicApiInterface by lazy { StockBasicApi(tuShare) }

    /** 股票行情信息相关API */
    val market: StockMarketApiInterface by lazy { StockMarketApi(tuShare) }

    /** 股票财务信息相关API */
    val finance: StockFinanceApiInterface by lazy { StockFinanceApi(tuShare) }

    /** 股票参考信息相关API */
    val reference: StockReferenceApiInterface by lazy { StockReferenceApi(tuShare) }

    /** 股票特色信息相关API */
    val character: StockCharacterApiInterface by lazy { StockCharacterApi(tuShare) }

    /** 股票两融信息相关API */
    val margin: StockMarginApiInterface by lazy { StockMarginApi(tuShare) }

    /** 股票资金流向相关API */
    val flow: StockFlowApiInterface by lazy { StockFlowApi(tuShare) }

    /** 股票打版专题数据相关API */
    val board: StockBoardApiInterface by lazy { StockBoardApi(tuShare) }
}
