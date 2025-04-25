package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 新闻快讯返回结果
 */
@Serializable
data class NewsResult(
    /**
     * 新闻发布时间
     */
    @SerialName("datetime")
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    val datetime: LocalDateTime,

    /**
     * 新闻内容
     */
    @SerialName("content")
    val content: String,

    /**
     * 新闻标题
     */
    @SerialName("title")
    val title: String? = null,

    /**
     * 新闻分类（多个分类用逗号分隔）
     */
    @SerialName("channels")
    val channels: String? = null
) 