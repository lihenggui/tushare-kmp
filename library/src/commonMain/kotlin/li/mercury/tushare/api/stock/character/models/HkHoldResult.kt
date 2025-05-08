package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class HkHoldResult(
    /** 交易所代码 */
    val code: String,

    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,

    /** 开始日期 */
    @SerialName("start_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate,

    /** 结束日期 */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate,

    /** 持股数量(股) */
    val vol: Int,

    /** 持股占比（%），占已发行股份百分比 */
    val ratio: Float,

    /** 类型：SH 沪股通（北向）、SZ 深股通（北向）、HK 港股通（南向持股） */
    val exchange: Exchange,
)
