package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 指数基本信息
 *
 * | 名称         | 类型  | 描述 |
 * |--------------|------|------|
 * | ts_code      | str  | TS代码 |
 * | name         | str  | 简称 |
 * | fullname     | str  | 指数全称 |
 * | market       | str  | 市场 |
 * | publisher    | str  | 发布方 |
 * | index_type   | str  | 指数风格 |
 * | category     | str  | 指数类别 |
 * | base_date    | str  | 基期 |
 * | base_point   | float | 基点 |
 * | list_date    | str  | 发布日期 |
 * | weight_rule  | str  | 加权方式 |
 * | desc         | str  | 描述 |
 * | exp_date     | str  | 终止日期 |
 *
 */
@Serializable
data class IndexBasicResult(
    @SerialName("ts_code") val tsCode: String,
    val name: String,
    @SerialName("fullname") val fullName: String? = null,
    val market: String? = null,
    val publisher: String? = null,
    @SerialName("index_type") val indexType: String? = null,
    val category: String? = null,
    @SerialName("base_date") val baseDate: String? = null,
    @SerialName("base_point") val basePoint: Double? = null,
    @SerialName("list_date") val listDate: String? = null,
    @SerialName("weight_rule") val weightRule: String? = null,
    val desc: String? = null,
    @SerialName("exp_date") val expDate: String? = null,
)
