package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class IndexMonthlyResult(
    /** TS 指数代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: String,
    /** 收盘点位 */
    val close: Double,
    /** 开盘点位 */
    val open: Double,
    /** 最高点位 */
    val high: Double,
    /** 最低点位 */
    val low: Double,
    /** 昨日收盘点 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 涨跌点 */
    val change: Double? = null,
    /** 涨跌幅（%） */
    @SerialName("pct_chg")
    val pctChg: Double? = null,
    /** 成交量（手） */
    val vol: Double? = null,
    /** 成交额（千元） */
    val amount: Double? = null,
) 