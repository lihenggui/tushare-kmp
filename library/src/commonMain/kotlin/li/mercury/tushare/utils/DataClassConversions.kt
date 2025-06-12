package li.mercury.tushare.utils

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.serializer

/**
 * 数据类与Map之间转换的工具类
 */
internal object DataClassConversions {
    val json: Json = Json { ignoreUnknownKeys = true }

    /**
     * 将驼峰命名转换为蛇形命名
     * 例如: thisIsExample -> this_is_example
     */
    fun camelToSnakeCase(input: String): String =
        input
            .replace(Regex("([a-z0-9])([A-Z])"), "$1_$2")
            .replace(
                Regex("([A-Z])([A-Z][a-z])"),
                "$1_$2",
            ).lowercase()

    /**
     * 通用方法：将任何可序列化的数据类转换为Map
     *
     * @param T 数据类类型
     * @param instance 数据类实例
     * @param snakeCase 是否将键转换为蛇形命名
     * @return 转换后的Map
     */
    inline fun <reified T> toMap(
        instance: T,
        snakeCase: Boolean = true,
    ): Map<String, String> {
        val jsonElement = json.encodeToJsonElement(serializer(), instance)
        return buildMap {
            if (jsonElement is JsonObject) {
                jsonElement.forEach { (key, value) ->
                    if (value !is JsonNull) {
                        val paramKey = if (snakeCase) camelToSnakeCase(key) else key
                        val paramValue =
                            when (value) {
                                is JsonPrimitive -> value.toString().removeSurrounding("\"")
                                else -> value.toString()
                            }
                        put(paramKey, paramValue)
                    }
                }
            }
        }
    }
}

/**
 * 扩展函数：将任意可序列化的数据类转换为API参数Map
 */
internal inline fun <reified T> T.toApiParams(snakeCase: Boolean = true): Map<String, String> =
    DataClassConversions.toMap(this, snakeCase)
