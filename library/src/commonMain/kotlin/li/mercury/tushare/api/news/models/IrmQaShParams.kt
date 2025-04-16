package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上证E互动问答查询参数
 */
@Serializable
data class IrmQaShParams(
    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 交易日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /**
     * 结束日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null
)
