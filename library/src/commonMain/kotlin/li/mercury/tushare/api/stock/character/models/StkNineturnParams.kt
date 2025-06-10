package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 神奇九转指标请求参数
 */
@Serializable
public data class StkNineturnParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDateTime? = null,
    /** 频率（日/分钟） */
    val freq: FreqEnum? = null,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)

/**
 * 频率枚举
 */
public enum class FreqEnum {
    /** 日线 */
    @SerialName("daily")
    DAILY,

    /** 60分钟线 */
    @SerialName("60min")
    MIN_60,
}
