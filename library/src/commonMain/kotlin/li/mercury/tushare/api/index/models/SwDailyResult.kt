package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 申万行业日线行情API返回结果
 */
@Serializable
public data class SwDailyResult(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 指数名称 */
    val name: String? = null,
    /** 开盘点位 */
    val open: Double? = null,
    /** 最低点位 */
    val low: Double? = null,
    /** 最高点位 */
    val high: Double? = null,
    /** 收盘点位 */
    val close: Double? = null,
    /** 涨跌点位 */
    val change: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double? = null,
    /** 成交量（万股） */
    val vol: Double? = null,
    /** 成交额（万元） */
    val amount: Double? = null,
    /** 市盈率 */
    val pe: Double? = null,
    /** 市净率 */
    val pb: Double? = null,
    /** 流通市值（万元） */
    @SerialName("float_mv")
    val floatMv: Double? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Double? = null,
)
