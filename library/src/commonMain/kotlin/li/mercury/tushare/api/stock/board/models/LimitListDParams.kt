package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 涨跌停类型
 */
enum class LimitType {
    /** 涨停 */
    U,

    /** 跌停 */
    D,

    /** 炸板 */
    Z
}

/**
 * 交易所
 */
enum class Exchange {
    /** 上交所 */
    SH,

    /** 深交所 */
    SZ,

    /** 北交所 */
    BJ
}

@Serializable
data class LimitListDParams(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 涨跌停类型 */
    @SerialName("limit_type")
    val limitType: LimitType? = null,
    /** 交易所 */
    val exchange: Exchange? = null,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)
