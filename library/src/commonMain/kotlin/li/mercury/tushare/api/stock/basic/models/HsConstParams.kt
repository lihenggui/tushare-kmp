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
package li.mercury.tushare.api.stock.basic.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 沪深股通成分股查询参数
 */
@Serializable
public data class HsConstParams(
    /** 类型：沪股通，深股通 */
    @SerialName("hs_type")
    val hsType: HsType,
    /** 是否最新：1是，0否 */
    @SerialName("is_new")
    val isNew: String = "1",
)
