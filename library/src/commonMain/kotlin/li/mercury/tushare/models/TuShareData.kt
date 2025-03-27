package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

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
     * TuShare数据中的对象表达方式不是标准方式
     * 必须要使用一个自定义的序列化工具把List<List<JsonElement>>转换为List<T>
     *
     * @param serializer 目标类型的序列化器
     * @return 类型化对象列表
     */
    inline fun <reified T> getResponseItems(serializer: KSerializer<T>): List<T> {
        val json = Json { ignoreUnknownKeys = true }
        
        return items.map { item ->
            val jsonObject = buildJsonObject {
                fields.forEachIndexed { index, field ->
                    if (index < item.size) {
                        put(field, item[index])
                    }
                }
            }
            json.decodeFromJsonElement(serializer, jsonObject)
        }
    }
} 