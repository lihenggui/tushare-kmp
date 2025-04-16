package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 交易日历API请求参数
 */
@Serializable
data class TradeCalParams(
    /** 交易所代码 */
    val exchange: Exchange? = null,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 是否交易：0休市 1交易 */
    @SerialName("is_open")
    val isOpen: String? = null
)
