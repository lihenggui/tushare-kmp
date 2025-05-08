package li.mercury.tushare.api.stock.market.models

import HsMarketType
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 沪深股通十大成交股返回结果
 */
@Serializable
data class HsgtTop10Result(
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String,
    /** 收盘价 */
    val close: Double,
    /** 涨跌额 */
    val change: Double,
    /** 资金排名 */
    val rank: Int,
    /** 市场类型 */
    @SerialName("market_type")
    val hsMarketType: HsMarketType,
    /** 成交金额（元） */
    val amount: Double,
    /** 净成交金额（元） */
    @SerialName("net_amount")
    val netAmount: Double,
    /** 买入金额（元） */
    val buy: Double,
    /** 卖出金额（元） */
    val sell: Double,
)
