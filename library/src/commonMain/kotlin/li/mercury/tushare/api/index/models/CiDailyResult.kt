package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中信行业指数日线行情返回结果
 */
@Serializable
data class CiDailyResult(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 开盘点位 */
    val open: Double? = null,
    /** 最低点位 */
    val low: Double? = null,
    /** 最高点位 */
    val high: Double? = null,
    /** 收盘点位 */
    val close: Double,
    /** 昨日收盘点 */
    @SerialName("pre_close")
    val preClose: Double,
    /** 涨跌点 */
    val change: Double,
    /** 涨跌幅（%） */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 成交量（万股） */
    val vol: Double? = null,
    /** 成交额（万元） */
    val amount: Double? = null,
)
