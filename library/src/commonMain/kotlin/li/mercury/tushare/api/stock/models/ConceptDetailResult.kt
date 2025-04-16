package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 概念股列表返回对象类
 */
@Serializable
data class ConceptDetailResult(
    /** 概念代码 */
    val id: String,
    /** 概念名称 */
    @SerialName("concept_name")
    val conceptName: String,
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String,
    /** 纳入日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("in_date")
    val inDate: LocalDate? = null,
    /** 剔除日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("out_date")
    val outDate: LocalDate? = null,
) 