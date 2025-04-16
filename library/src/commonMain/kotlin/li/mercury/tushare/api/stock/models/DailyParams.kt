package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 日线行情API请求参数
 */
@Serializable
data class DailyParams(
    /** TS股票代码（支持多个代码，逗号分隔） */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,

    /** 交易日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,

    /** 开始日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,

    /** 结束日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null
)
