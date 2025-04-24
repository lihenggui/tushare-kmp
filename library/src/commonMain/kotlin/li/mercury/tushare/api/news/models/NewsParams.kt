package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 新闻快讯查询参数
 */
@Serializable
data class NewsParams(
    /**
     * 开始时间（格式：YYYY-MM-DD HH:MM:SS）
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDateTime,
    /**
     * 结束时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDateTime,
    /**
     * 新闻来源标识（见数据源对照表）
     */
    @SerialName("src")
    val src: String? = null,
)
