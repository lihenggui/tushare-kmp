package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 股票分钟行情返回对象类
 */
@Serializable
data class MinsResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("trade_time")
    val tradeTime: LocalDateTime,
    /** 开盘价 */
    val open: Float,
    /** 收盘价 */
    val close: Float,
    /** 最高价 */
    val high: Float,
    /** 最低价 */
    val low: Float,
    /** 成交量 */
    val vol: Float,
    /** 成交金额 */
    val amount: Float,
)
