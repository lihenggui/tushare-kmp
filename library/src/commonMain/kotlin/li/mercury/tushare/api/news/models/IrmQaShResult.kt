package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 上证E互动问答返回结果
 */
@Serializable
data class IrmQaShResult(
    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: String,
    /**
     * 公司名称
     */
    @SerialName("name")
    val name: String,
    /**
     * 日期
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /**
     * 问题
     */
    @SerialName("q")
    val q: String,
    /**
     * 回复
     */
    @SerialName("a")
    val a: String,
    /**
     * 回复时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("pub_time")
    val pubTime: LocalDateTime? = null
)
