/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package li.mercury.tushare.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

/**
 * 表示TuShare API数据结构
 *
 * @property fields 字段名列表
 * @property items 数据行列表
 * @property hasMore 是否有更多数据
 * @property count 数据总数
 */
@Serializable
public data class TuShareData(
    @SerialName("fields") val fields: List<String>,
    @SerialName("items") val items: List<List<JsonElement>>,
    @SerialName("has_more") val hasMore: Boolean = false,
    @SerialName("count") val count: Int = -1,
) {
    /**
     * TuShare数据中的对象表达方式不是标准方式
     * 必须要使用一个自定义的序列化工具把List<List<JsonElement>>转换为List<T>
     *
     * @param serializer 目标类型的序列化器
     * @return 类型化对象列表
     */
    internal inline fun <reified T> getResponseItems(serializer: KSerializer<T>): List<T> {
        val json = Json { ignoreUnknownKeys = true }

        return items.map { item ->
            val jsonObject =
                buildJsonObject {
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
