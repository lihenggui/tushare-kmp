package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 周线行情返回对象类
 */
@Serializable
public data class WeeklyResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 周收盘价 */
    val close: Float,
    /** 周开盘价 */
    val open: Float,
    /** 周最高价 */
    val high: Float,
    /** 周最低价 */
    val low: Float,
    /** 上一周收盘价 */
    @SerialName("pre_close")
    val preClose: Float,
    /** 周涨跌额 */
    val change: Float,
    /** 周涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float,
    /** 周成交量 */
    val vol: Float,
    /** 周成交额 */
    val amount: Float,
)
