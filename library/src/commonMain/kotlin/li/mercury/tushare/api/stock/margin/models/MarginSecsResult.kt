package li.mercury.tushare.api.stock.margin.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 融资融券标的返回结果
 */
@Serializable
data class MarginSecsResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 标的代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 标的名称 */
    val name: String,
    /** 交易所 */
    val exchange: Exchange,
)
