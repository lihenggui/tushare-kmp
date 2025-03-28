package li.mercury.tushare.utils

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonPrimitive

/**
 * 将JsonElement转换为String
 *
 * @return 字符串值
 */
internal fun JsonElement.asString(): String = jsonPrimitive.content

/**
 * 将JsonElement转换为String或null
 *
 * @return 字符串值，如果无效则返回null
 */
internal fun JsonElement.asStringOrNull(): String? =
    try {
        if (this.jsonPrimitive.content == "null") null else jsonPrimitive.content
    } catch (e: Exception) {
        null
    }

/**
 * 将JsonElement转换为Double或null
 *
 * @return 双精度浮点数值，如果无效则返回null
 */
internal fun JsonElement.asDoubleOrNull(): Double? =
    try {
        val content = jsonPrimitive.content
        if (content == "null") null else content.toDouble()
    } catch (e: Exception) {
        null
    }
