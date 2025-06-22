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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.internal.extension.TuShareDsl

/**
 * 表示TuShare API请求
 *
 * @property apiName 要调用的API名称
 * @property token TuShare API认证令牌
 * @property params API调用的附加参数
 * @property fields 需要获取的特定字段列表，以逗号分隔
 */
@Serializable
public data class TuShareRequest(
    @SerialName("api_name") val apiName: String,
    @SerialName("token") val token: String = "",
    @SerialName("params") val params: Map<String, String> = emptyMap(),
    @SerialName("fields") val fields: String = "",
)

public fun tuShareRequest(block: TuShareRequestBuilder.() -> Unit): TuShareRequest = TuShareRequestBuilder().apply(block).build()

@TuShareDsl
public class TuShareRequestBuilder {
    public var token: String? = null
    public var apiName: String? = null
    public var fields: List<String>? = null
    public var params: Map<String, String> = emptyMap()

    public fun build(): TuShareRequest =
        TuShareRequest(
            apiName = requireNotNull(apiName) { "API name must be specified" },
            token = token ?: "",
            params = params,
            fields = fields?.joinToString(",") ?: "",
        )
}
