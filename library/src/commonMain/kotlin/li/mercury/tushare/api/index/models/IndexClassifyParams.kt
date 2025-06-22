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

/**
 * 申万行业分类API请求参数
 */
@Serializable
public data class IndexClassifyParams(
    /**
     * 指数代码
     *
     * 可选参数，来源指数基础信息接口
     */
    @SerialName("index_code")
    val indexCode: String? = null,
    /**
     * 行业分级
     *
     * 可选参数，L1/L2/L3
     */
    val level: Level? = null,
    /**
     * 父级代码
     *
     * 可选参数，一级为0
     */
    @SerialName("parent_code")
    val parentCode: String? = null,
    /**
     * 指数来源
     *
     * 可选参数 (SW2014：申万 2014 年版本，SW2021：申万 2021 年版本)
     */
    val src: String? = null,
)
