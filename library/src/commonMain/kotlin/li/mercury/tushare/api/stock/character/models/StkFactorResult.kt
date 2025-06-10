package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票技术因子返回结果
 */
@Serializable
public data class StkFactorResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 收盘价 */
    val close: Double? = null,
    /** 开盘价 */
    val open: Double? = null,
    /** 最高价 */
    val high: Double? = null,
    /** 最低价 */
    val low: Double? = null,
    /** 昨收价 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 涨跌额 */
    val change: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double? = null,
    /** 成交量（手） */
    val vol: Double? = null,
    /** 成交额（千元） */
    val amount: Double? = null,
    /** 复权因子 */
    @SerialName("adj_factor")
    val adjFactor: Double? = null,
    /** 开盘价后复权 */
    @SerialName("open_hfq")
    val openHfq: Double? = null,
    /** 开盘价前复权 */
    @SerialName("open_qfq")
    val openQfq: Double? = null,
    /** 收盘价后复权 */
    @SerialName("close_hfq")
    val closeHfq: Double? = null,
    /** 收盘价前复权 */
    @SerialName("close_qfq")
    val closeQfq: Double? = null,
    /** 最高价后复权 */
    @SerialName("high_hfq")
    val highHfq: Double? = null,
    /** 最高价前复权 */
    @SerialName("high_qfq")
    val highQfq: Double? = null,
    /** 最低价后复权 */
    @SerialName("low_hfq")
    val lowHfq: Double? = null,
    /** 最低价前复权 */
    @SerialName("low_qfq")
    val lowQfq: Double? = null,
    /** 昨收价后复权 */
    @SerialName("pre_close_hfq")
    val preCloseHfq: Double? = null,
    /** 昨收价前复权 */
    @SerialName("pre_close_qfq")
    val preCloseQfq: Double? = null,
    /** MACD_DIF值 */
    @SerialName("macd_dif")
    val macdDif: Double? = null,
    /** MACD_DEA值 */
    @SerialName("macd_dea")
    val macdDea: Double? = null,
    /** MACD值 */
    val macd: Double? = null,
    /** KDJ_K值 */
    @SerialName("kdj_k")
    val kdjK: Double? = null,
    /** KDJ_D值 */
    @SerialName("kdj_d")
    val kdjD: Double? = null,
    /** KDJ_J值 */
    @SerialName("kdj_j")
    val kdjJ: Double? = null,
    /** RSI_6值 */
    @SerialName("rsi_6")
    val rsi6: Double? = null,
    /** RSI_12值 */
    @SerialName("rsi_12")
    val rsi12: Double? = null,
    /** RSI_24值 */
    @SerialName("rsi_24")
    val rsi24: Double? = null,
    /** BOLL上轨 */
    @SerialName("boll_upper")
    val bollUpper: Double? = null,
    /** BOLL中轨 */
    @SerialName("boll_mid")
    val bollMid: Double? = null,
    /** BOLL下轨 */
    @SerialName("boll_lower")
    val bollLower: Double? = null,
    /** CCI指标 */
    val cci: Double? = null,
)
