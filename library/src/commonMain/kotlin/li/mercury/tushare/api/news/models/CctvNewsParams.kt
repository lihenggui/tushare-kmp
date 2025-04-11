package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 新闻联播查询参数
 */
@Serializable
data class CctvNewsParams(
    /**
     * 查询日期 (格式：YYYYMMDD)
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val date: LocalDate,
)
