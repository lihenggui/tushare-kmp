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

/**
 * 表示TuShare API响应
 *
 * @property code 响应代码，0表示成功
 * @property msg 错误信息（如果有）
 * @property data 成功时的响应数据
 * @property requestId 请求ID
 */
@Serializable
public data class TuShareResponse(
    @SerialName("code") val code: Int,
    @SerialName("msg") val msg: String? = null,
    @SerialName("data") val data: TuShareData? = null,
    @SerialName("request_id") val requestId: String? = null,
)
