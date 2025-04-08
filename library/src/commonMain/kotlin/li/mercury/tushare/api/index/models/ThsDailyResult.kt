package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 同花顺板块指数行情返回结果
 */
@Serializable
data class ThsDailyResult(
    /** TS 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 收盘点位 */
    val close: Double,
    /** 开盘点位 */
    val open: Double,
    /** 最高点位 */
    val high: Double,
    /** 最低点位 */
    val low: Double,
    /** 昨日收盘点 */
    @SerialName("pre_close")
    val preClose: Double,
    /** 平均价 */
    @SerialName("avg_price")
    val avgPrice: Double,
    /** 涨跌点位 */
    val change: Double,
    /** 涨跌幅（%） */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 成交量 */
    val vol: Double,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Double,
    /** 总市值（千元） */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通市值（千元） */
    @SerialName("float_mv")
    val floatMv: Double? = null,
) 