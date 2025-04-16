package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票周/月线行情（复权）返回结果
 */
@Serializable
data class WeeklyMonthlyAdjResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 频率（week周线，month月线） */
    val freq: FreqWeekMonth,
    /** 开盘价 */
    val open: Float,
    /** 最高价 */
    val high: Float,
    /** 最低价 */
    val low: Float,
    /** 收盘价 */
    val close: Float,
    /** 上一收盘价（除权价，前复权） */
    @SerialName("pre_close")
    val preClose: Float,
    /** 前复权开盘价 */
    @SerialName("open_qfq")
    val openQfq: Float,
    /** 前复权最高价 */
    @SerialName("high_qfq")
    val highQfq: Float,
    /** 前复权最低价 */
    @SerialName("low_qfq")
    val lowQfq: Float,
    /** 前复权收盘价 */
    @SerialName("close_qfq")
    val closeQfq: Float,
    /** 后复权开盘价 */
    @SerialName("open_hfq")
    val openHfq: Float,
    /** 后复权最高价 */
    @SerialName("high_hfq")
    val highHfq: Float,
    /** 后复权最低价 */
    @SerialName("low_hfq")
    val lowHfq: Float,
    /** 后复权收盘价 */
    @SerialName("close_hfq")
    val closeHfq: Float,
    /** 成交量 */
    val vol: Float,
    /** 成交额 */
    val amount: Float,
    /** 涨跌额 */
    val change: Float,
    /** 涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float
) 