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
) {
    /**
     * 将原始数据转换为指定类型的对象列表
     *
     * @param converter 转换函数，接收字段名列表和数据项，返回指定类型的对象
     * @return 转换后的对象列表
     */
    fun <T> toObjects(converter: (fields: List<String>, item: List<JsonElement>) -> T): List<T> {
        return items.map { item -> converter(fields, item) }
    }
} 