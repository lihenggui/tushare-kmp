package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 新闻通讯查询参数
 */
@Serializable
data class MajorNewsParams(
    /**
     * 新闻来源（新华网、凤凰财经、同花顺、新浪财经、华尔街见闻、中证网）
     */
    val src: String? = null,

    /**
     * 新闻发布开始时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDateTime? = null,

    /**
     * 新闻发布结束时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDateTime? = null
)
