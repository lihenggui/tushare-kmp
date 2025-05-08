package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票收盘集合竞价数据返回对象
 */
@Serializable
data class StkAuctionCResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 收盘价 */
    @SerialName("close")
    val close: Double? = null,
    /** 开盘价 */
    @SerialName("open")
    val open: Double? = null,
    /** 最高价 */
    @SerialName("high")
    val high: Double? = null,
    /** 最低价 */
    @SerialName("low")
    val low: Double? = null,
    /** 成交量（股） */
    @SerialName("vol")
    val vol: Double? = null,
    /** 成交额（元） */
    @SerialName("amount")
    val amount: Double? = null,
    /** 均价 */
    @SerialName("vwap")
    val vwap: Double? = null,
)
