package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 大盘指数每日指标返回结果
 */
@Serializable
data class IndexDailyBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 当日总市值（元） */
    @SerialName("total_mv")
    val totalMv: Double,
    /** 当日流通市值（元） */
    @SerialName("float_mv")
    val floatMv: Double,
    /** 当日总股本（股） */
    @SerialName("total_share")
    val totalShare: Double,
    /** 当日流通股本（股） */
    @SerialName("float_share")
    val floatShare: Double,
    /** 当日自由流通股本（股） */
    @SerialName("free_share")
    val freeShare: Double,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Double,
    /** 换手率（基于自由流通股本） */
    @SerialName("turnover_rate_f")
    val turnoverRateF: Double,
    /** 市盈率 */
    @SerialName("pe")
    val pe: Double? = null,
    /** 市盈率 TTM */
    @SerialName("pe_ttm")
    val peTtm: Double? = null,
    /** 市净率 */
    @SerialName("pb")
    val pb: Double? = null,
)
