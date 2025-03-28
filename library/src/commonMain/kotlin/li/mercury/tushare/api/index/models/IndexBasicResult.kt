package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class IndexBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 简称 */
    val name: String,
    /** 指数全称 */
    @SerialName("fullname")
    val fullName: String? = null,
    /** 市场 */
    val market: String? = null,
    /** 发布方 */
    val publisher: String? = null,
    /** 指数风格 */
    @SerialName("index_type")
    val indexType: String? = null,
    /** 指数类别 */
    val category: String? = null,
    /** 基期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("base_date")
    val baseDate: LocalDate? = null,
    /** 基点 */
    @SerialName("base_point")
    val basePoint: Double? = null,
    /** 发布日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("list_date")
    val listDate: LocalDate? = null,
    /** 加权方式 */
    @SerialName("weight_rule")
    val weightRule: String? = null,
    /** 描述 */
    val desc: String? = null,
    /** 终止日期 */
    @SerialName("exp_date")
    val expDate: String? = null,
)
