package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 交易日历返回对象类
 */
@Serializable
data class TradeCalResult(
    /** 交易所代码 */
    val exchange: Exchange,
    /** 日历日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("cal_date")
    val calDate: LocalDate,
    /** 是否交易：0休市 1交易 */
    @SerialName("is_open")
    val isOpen: String,
    /** 上一个交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("pretrade_date")
    val preTradeDate: LocalDate? = null
)
