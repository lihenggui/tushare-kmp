package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 每日指标返回对象类
 */
@Serializable
data class DailyBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 当日收盘价 */
    val close: Double,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 换手率（自由流通股） */
    @SerialName("turnover_rate_f")
    val turnoverRateF: Double? = null,
    /** 量比 */
    @SerialName("volume_ratio")
    val volumeRatio: Double? = null,
    /** 市盈率（总市值/净利润） */
    val pe: Double? = null,
    /** 市盈率（TTM） */
    @SerialName("pe_ttm")
    val peTtm: Double? = null,
    /** 市净率（总市值/净资产） */
    val pb: Double? = null,
    /** 市销率 */
    val ps: Double? = null,
    /** 市销率（TTM） */
    @SerialName("ps_ttm")
    val psTtm: Double? = null,
    /** 股息率（%） */
    @SerialName("dv_ratio")
    val dvRatio: Double? = null,
    /** 股息率（TTM）（%） */
    @SerialName("dv_ttm")
    val dvTtm: Double? = null,
    /** 总股本（万股） */
    @SerialName("total_share")
    val totalShare: Double? = null,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double? = null,
    /** 自由流通股本（万股） */
    @SerialName("free_share")
    val freeShare: Double? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通市值（万元） */
    @SerialName("circ_mv")
    val circMv: Double? = null
) 