package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 深证互动易问答返回结果
 */
@Serializable
data class IrmQaSzResult(
    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /**
     * 公司名称
     */
    val name: String,

    /**
     * 交易日期
     */
    @SerialName("trade_date")
    val tradeDate: String,

    /**
     * 问题内容
     */
    val q: String,

    /**
     * 回复内容
     */
    val a: String,

    /**
     * 发布时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("pub_time")
    val pubTime: LocalDateTime,

    /**
     * 涉及行业
     */
    val industry: String? = null,
)
