package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.api.stock.market.models.FreqMin
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 股票分钟行情API请求参数
 */
@Serializable
data class MinsParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 分钟频率（1min/5min/15min/30min/60min） */
    val freq: FreqMin,
    /** 开始日期（格式：YYYY-MM-DD HH:MM:SS） */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDateTime? = null,
    /** 结束日期（格式：YYYY-MM-DD HH:MM:SS） */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDateTime? = null,
)
