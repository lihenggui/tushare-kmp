package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * 表示TuShare API数据结构
 *
 * @property fields 字段名列表
 * @property items 数据行列表
 */
@Serializable
data class TuShareData(
    @SerialName("fields") val fields: List<String>,
    @SerialName("items") val items: List<List<JsonElement>>
) 