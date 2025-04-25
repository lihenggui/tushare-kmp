package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票周/月线行情返回对象类
 */
@Serializable
data class WeeklyMonthlyResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 频率（week周线/month月线） */
    val freq: FreqWeekMonth,
    /** （周/月）开盘价 */
    val open: Float,
    /** （周/月）最高价 */
    val high: Float,
    /** （周/月）最低价 */
    val low: Float,
    /** （周/月）收盘价 */
    val close: Float,
    /** 上一（周/月）收盘价 */
    @SerialName("pre_close")
    val preClose: Float,
    /** （周/月）成交量 */
    val vol: Float,
    /** （周/月）成交额 */
    val amount: Float,
    /** （周/月）涨跌额 */
    val change: Float,
    /** （周/月）涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float
) 