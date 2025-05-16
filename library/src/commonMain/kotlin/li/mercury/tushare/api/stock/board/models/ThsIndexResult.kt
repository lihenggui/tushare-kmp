package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class ThsIndexResult(
    /** 代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 名称 */
    val name: String? = null,
    /** 成分个数 */
    val count: Int? = null,
    /** 交易所 */
    val exchange: String? = null,
    /** 上市日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("list_date")
    val listDate: LocalDate? = null,
    /** 指数类型 */
    val type: String? = null,
)
