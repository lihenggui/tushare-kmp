package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class TopListResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 名称 */
    val name: String? = null,
    /** 收盘价 */
    val close: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double? = null,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 总成交额 */
    val amount: Double? = null,
    /** 龙虎榜卖出额 */
    @SerialName("l_sell")
    val lSell: Double? = null,
    /** 龙虎榜买入额 */
    @SerialName("l_buy")
    val lBuy: Double? = null,
    /** 龙虎榜成交额 */
    @SerialName("l_amount")
    val lAmount: Double? = null,
    /** 龙虎榜净买入额 */
    @SerialName("net_amount")
    val netAmount: Double? = null,
    /** 龙虎榜净买额占比 */
    @SerialName("net_rate")
    val netRate: Double? = null,
    /** 龙虎榜成交额占比 */
    @SerialName("amount_rate")
    val amountRate: Double? = null,
    /** 当日流通市值 */
    @SerialName("float_values")
    val floatValues: Double? = null,
    /** 上榜理由 */
    val reason: String? = null,
)
