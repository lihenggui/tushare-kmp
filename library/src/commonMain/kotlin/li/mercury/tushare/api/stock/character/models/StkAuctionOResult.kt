package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票开盘集合竞价数据返回对象
 */
@Serializable
data class StkAuctionOResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 开盘集合竞价收盘价 */
    val close: Double,
    /** 开盘集合竞价开盘价 */
    val open: Double,
    /** 开盘集合竞价最高价 */
    val high: Double,
    /** 开盘集合竞价最低价 */
    val low: Double,
    /** 开盘集合竞价成交量（股） */
    val vol: Double,
    /** 开盘集合竞价成交额（元） */
    val amount: Double,
    /** 开盘集合竞价均价 */
    val vwap: Double,
)
