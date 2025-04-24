package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 大盘指数每日指标请求参数
 */
@Serializable
data class IndexDailyBasicParams(
    /**
     * 交易日期 (格式：YYYYMMDD)
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /**
     * TS指数代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 开始日期 (格式：YYYYMMDD)
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /**
     * 结束日期 (格式：YYYYMMDD)
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)
