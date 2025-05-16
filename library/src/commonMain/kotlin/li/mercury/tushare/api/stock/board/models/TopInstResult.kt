package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class TopInstResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 营业部名称 */
    val exalter: String? = null,
    /** 买卖类型（0：买入金额最大的前5名，1：卖出金额最大的前5名） */
    val side: String? = null,
    /** 买入额（元） */
    val buy: Double? = null,
    /** 买入占总成交比例 */
    @SerialName("buy_rate")
    val buyRate: Double? = null,
    /** 卖出额（元） */
    val sell: Double? = null,
    /** 卖出占总成交比例 */
    @SerialName("sell_rate")
    val sellRate: Double? = null,
    /** 净成交额（元） */
    @SerialName("net_buy")
    val netBuy: Double? = null,
    /** 上榜理由 */
    val reason: String? = null,
)
