package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股本情况（盘前）返回对象类
 */
@Serializable
data class StkPremarketResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 总股本（万股） */
    @SerialName("total_share")
    val totalShare: Double,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double,
    /** 昨日收盘价 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 今日涨停价 */
    @SerialName("up_limit")
    val upLimit: Double? = null,
    /** 今日跌停价 */
    @SerialName("down_limit")
    val downLimit: Double? = null
)
