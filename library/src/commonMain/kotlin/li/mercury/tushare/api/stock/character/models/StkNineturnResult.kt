package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 神奇九转指标返回结果
 */
@Serializable
public data class StkNineturnResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDateTime,
    /** 频率 */
    val freq: FreqEnum,
    /** 开盘价 */
    val open: Double? = null,
    /** 最高价 */
    val high: Double? = null,
    /** 最低价 */
    val low: Double? = null,
    /** 收盘价 */
    val close: Double? = null,
    /** 成交量 */
    val vol: Double? = null,
    /** 成交额 */
    val amount: Double? = null,
    /** 上九转计数 */
    @SerialName("up_count")
    val upCount: Double? = null,
    /** 下九转计数 */
    @SerialName("down_count")
    val downCount: Double? = null,
    /** 是否上九转 */
    @SerialName("nine_up_turn")
    val nineUpTurn: String? = null,
    /** 是否下九转 */
    @SerialName("nine_down_turn")
    val nineDownTurn: String? = null,
)
