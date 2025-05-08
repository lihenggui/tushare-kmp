package li.mercury.tushare.api.stock.margin.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 融资融券交易汇总返回结果
 */
@Serializable
data class MarginResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 交易所代码 */
    @SerialName("exchange_id")
    val exchangeId: Exchange,
    /** 融资余额(元) */
    val rzye: Double? = null,
    /** 融资买入额(元) */
    val rzmre: Double? = null,
    /** 融资偿还额(元) */
    val rzche: Double? = null,
    /** 融券余额(元) */
    val rqye: Double? = null,
    /** 融券卖出量(股, 份, 手) */
    val rqmcl: Double? = null,
    /** 融资融券余额(元) */
    val rzrqye: Double? = null,
    /** 融券余量(股, 份, 手) */
    val rqyl: Double? = null,
)
