package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class LimitListThsParams(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,

    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,

    /** 板单类别 */
    @SerialName("limit_type")
    val limitType: LimitTypeEnum? = null,

    /** 市场类型 */
    val market: String? = null,

    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,

    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null
)
