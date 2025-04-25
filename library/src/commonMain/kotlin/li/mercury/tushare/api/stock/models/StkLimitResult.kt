package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 每日涨跌停价格返回对象类
 */
@Serializable
data class StkLimitResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 昨日收盘价 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 涨停价 */
    @SerialName("up_limit")
    val upLimit: Double,
    /** 跌停价 */
    @SerialName("down_limit")
    val downLimit: Double,
)
