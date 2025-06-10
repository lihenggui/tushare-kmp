package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class KplConceptConsResult(
    /** 题材ID */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 题材名称 */
    val name: String? = null,
    /** 股票名称 */
    @SerialName("con_name")
    val conName: String? = null,
    /** 股票代码 */
    @SerialName("con_code")
    val conCode: String? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 描述 */
    val desc: String? = null,
    /** 人气值 */
    @SerialName("hot_num")
    val hotNum: Int? = null,
)
