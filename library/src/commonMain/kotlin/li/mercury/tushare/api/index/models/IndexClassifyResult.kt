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

@Serializable
public data class IndexClassifyResult(
    /** 指数代码*/
    @SerialName("index_code")
    val indexCode: String,
    /** 行业名称*/
    @SerialName("industry_name")
    val industryName: String,
    /** 父级代码*/
    @SerialName("parent_code")
    val parentCode: String,
    /** 行业分级（L1/L2/L3）*/
    val level: String,
    /** 行业代码*/
    @SerialName("industry_code")
    val industryCode: String,
    /** 是否发布指数*/
    @SerialName("is_pub")
    val isPub: String?,
    /** 行业分类来源*/
    val src: String?,
)
