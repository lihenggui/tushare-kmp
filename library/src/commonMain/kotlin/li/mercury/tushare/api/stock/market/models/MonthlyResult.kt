package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 月线行情返回结果
 */
@Serializable
data class MonthlyResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 月收盘价 */
    val close: Float,
    /** 月开盘价 */
    val open: Float,
    /** 月最高价 */
    val high: Float,
    /** 月最低价 */
    val low: Float,
    /** 上月收盘价 */
    @SerialName("pre_close")
    val preClose: Float,
    /** 月涨跌额 */
    val change: Float,
    /** 月涨跌幅（未复权） */
    @SerialName("pct_chg")
    val pctChg: Float,
    /** 月成交量 */
    val vol: Float,
    /** 月成交额 */
    val amount: Float,
)
