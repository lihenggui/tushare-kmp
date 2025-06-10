package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 每日停复牌信息返回对象类
 */
@Serializable
public data class SuspendDResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 停复牌日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 日内停牌时间段 */
    @SerialName("suspend_timing")
    val suspendTiming: String? = null,
    /** 停复牌类型（S-停牌，R-复牌） */
    @SerialName("suspend_type")
    val suspendType: SuspendType,
)
