package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司公告查询参数
 */
@Serializable
public data class AnnouncementParams(
    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 公告日期 (格式：YYYYMMDD)
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
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
