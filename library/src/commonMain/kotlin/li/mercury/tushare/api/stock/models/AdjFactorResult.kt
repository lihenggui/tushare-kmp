package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 复权因子返回对象类
 */
@Serializable
data class AdjFactorResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,

    /** 复权因子 */
    @SerialName("adj_factor")
    val adjFactor: Double
) 