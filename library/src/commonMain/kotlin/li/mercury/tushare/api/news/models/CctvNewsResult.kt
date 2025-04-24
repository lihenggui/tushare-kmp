package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 新闻联播返回结果
 */
@Serializable
data class CctvNewsResult(
    /**
     * 新闻日期
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val date: LocalDate,
    /**
     * 新闻标题
     */
    val title: String,
    /**
     * 新闻内容（分段处理）
     */
    val content: String,
)
