package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class ThsHotParams(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 热榜类型 */
    val market: String? = null,
    /** 是否最新 */
    @SerialName("is_new")
    val isNew: String? = null,
)
