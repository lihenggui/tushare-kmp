package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司公告返回结果
 */
@Serializable
data class AnnouncementResult(
    /**
     * 公告日期
     */
    @SerialName("ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val annDate: LocalDate,

    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /**
     * 股票名称
     */
    val name: String,

    /**
     * 公告标题
     */
    val title: String,

    /**
     * PDF文档链接
     */
    val url: String,

    /**
     * 发布时间
     */
    @SerialName("rec_time")
    val recTime: LocalDateTime? = null,
)
