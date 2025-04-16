package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票技术面因子（专业版）返回结果
 */
@Serializable
data class StkFactorProResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 开盘价 */
    val open: Float? = null,
    /** 最高价 */
    val high: Float? = null,
    /** 最低价 */
    val low: Float? = null,
    /** 收盘价 */
    val close: Float? = null,
    /** 昨收价（前复权） */
    @SerialName("pre_close")
    val preClose: Float? = null,
    /** 涨跌额 */
    val change: Float? = null,
    /** 涨跌幅（未复权） */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 成交量（手） */
    val vol: Float? = null,
    /** 成交额（千元） */
    val amount: Float? = null,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Float? = null,
    /** 市盈率（总市值/净利润，亏损的PE为空） */
    val pe: Float? = null,
    /** 市净率（总市值/净资产） */
    val pb: Float? = null,
    /** 市销率 */
    val ps: Float? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Float? = null,
    /** 流通市值（万元） */
    @SerialName("circ_mv")
    val circMv: Float? = null,
    /** MACD_DIF（基于前复权价格计算） */
    @SerialName("macd_dif")
    val macdDif: Float? = null,
    /** MACD_DEA */
    @SerialName("macd_dea")
    val macdDea: Float? = null,
    /** MACD */
    val macd: Float? = null,
    /** KDJ_K */
    @SerialName("kdj_k")
    val kdjK: Float? = null,
    /** KDJ_D */
    @SerialName("kdj_d")
    val kdjD: Float? = null,
    /** KDJ_J */
    @SerialName("kdj_j")
    val kdjJ: Float? = null,
    /** RSI_6 */
    @SerialName("rsi_6")
    val rsi6: Float? = null,
    /** RSI_12 */
    @SerialName("rsi_12")
    val rsi12: Float? = null,
    /** RSI_24 */
    @SerialName("rsi_24")
    val rsi24: Float? = null,
    /** BOLL_UPPER */
    @SerialName("boll_upper")
    val bollUpper: Float? = null,
    /** BOLL_MID */
    @SerialName("boll_mid")
    val bollMid: Float? = null,
    /** BOLL_LOWER */
    @SerialName("boll_lower")
    val bollLower: Float? = null,
    /** CCI */
    val cci: Float? = null,
    /** 指数移动平均（N=10） */
    @SerialName("ema_10")
    val ema10: Float? = null,
    /** 指数移动平均（N=20） */
    @SerialName("ema_20")
    val ema20: Float? = null,
    /** 指数移动平均（N=60） */
    @SerialName("ema_60")
    val ema60: Float? = null,
    /** 简单移动平均（N=5） */
    @SerialName("ma_5")
    val ma5: Float? = null,
    /** 简单移动平均（N=10） */
    @SerialName("ma_10")
    val ma10: Float? = null,
    /** 简单移动平均（N=20） */
    @SerialName("ma_20")
    val ma20: Float? = null,
    /** W&R 威廉指标（N=10） */
    @SerialName("wr_10")
    val wr10: Float? = null,
    /** 真实波动N日平均值（N=20） */
    @SerialName("atr_20")
    val atr20: Float? = null,
) 