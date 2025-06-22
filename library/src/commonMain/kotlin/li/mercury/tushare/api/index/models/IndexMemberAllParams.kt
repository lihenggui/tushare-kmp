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
package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 申万行业成分构成API请求参数
 */
@Serializable
public data class IndexMemberAllParams(
    /**
     * 一级行业代码
     *
     * 可选参数
     */
    @SerialName("l1_code")
    val l1Code: String? = null,
    /**
     * 二级行业代码
     *
     * 可选参数
     */
    @SerialName("l2_code")
    val l2Code: String? = null,
    /**
     * 三级行业代码
     *
     * 可选参数
     */
    @SerialName("l3_code")
    val l3Code: String? = null,
    /**
     * 股票代码
     *
     * 可选参数
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 是否最新（默认为"Y"是）
     *
     * 可选参数
     */
    @SerialName("is_new")
    val isNew: String? = null,
)
