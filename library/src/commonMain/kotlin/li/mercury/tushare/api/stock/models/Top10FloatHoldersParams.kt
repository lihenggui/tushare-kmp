package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 前十大流通股东API请求参数
 */
@Serializable
data class Top10FloatHoldersParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val period: LocalDate? = null,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 报告期开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 报告期结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
) 