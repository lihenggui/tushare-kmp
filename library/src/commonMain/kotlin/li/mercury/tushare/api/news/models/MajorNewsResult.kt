package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 新闻通讯返回结果
 */
@Serializable
public data class MajorNewsResult(
    /**
     * 标题
     */
    val title: String,
    /**
     * 内容
     */
    val content: String? = null,
    /**
     * 发布时间
     */
    @SerialName("pub_time")
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    val pubTime: LocalDateTime,
    /**
     * 来源网站
     */
    val src: String,
)
