package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 深圳市场每日交易概况返回结果
 */
@Serializable
data class SzDailyInfoResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 市场类型 */
    @SerialName("ts_code")
    val tsCode: SzTsCode,
    /** 股票个数 */
    val count: Int,
    /** 成交金额（元） */
    val amount: Double,
    /** 成交量（手） */
    val vol: Double? = null,
    /** 总股本 */
    @SerialName("total_share")
    val totalShare: Double? = null,
    /** 总市值 */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通股本 */
    @SerialName("float_share")
    val floatShare: Double? = null,
    /** 流通市值 */
    @SerialName("float_mv")
    val floatMv: Double? = null,
)
