package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class KplConceptResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 题材代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 题材名称 */
    val name: String? = null,
    /** 涨停数量 */
    @SerialName("z_t_num")
    val ztNum: Int? = null,
    /** 排名上升位数 */
    @SerialName("up_num")
    val upNum: String? = null,
)
