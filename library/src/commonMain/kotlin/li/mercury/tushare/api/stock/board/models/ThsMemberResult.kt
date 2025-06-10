package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class ThsMemberResult(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 股票代码 */
    @SerialName("con_code")
    val conCode: String? = null,
    /** 股票名称 */
    @SerialName("con_name")
    val conName: String? = null,
    /** 权重（暂无） */
    val weight: Float? = null,
    /** 纳入日期（暂无） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("in_date")
    val inDate: LocalDate? = null,
    /** 剔除日期（暂无） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("out_date")
    val outDate: LocalDate? = null,
    /** 是否最新（Y 是，N 否） */
    @SerialName("is_new")
    val isNew: String? = null,
)
