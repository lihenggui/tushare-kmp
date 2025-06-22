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

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class IndexBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 简称 */
    val name: String,
    /** 指数全称 */
    @SerialName("fullname")
    val fullName: String? = null,
    /** 市场 */
    val market: String? = null,
    /** 发布方 */
    val publisher: String? = null,
    /** 指数风格 */
    @SerialName("index_type")
    val indexType: String? = null,
    /** 指数类别 */
    val category: String? = null,
    /** 基期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("base_date")
    val baseDate: LocalDate? = null,
    /** 基点 */
    @SerialName("base_point")
    val basePoint: Double? = null,
    /** 发布日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("list_date")
    val listDate: LocalDate? = null,
    /** 加权方式 */
    @SerialName("weight_rule")
    val weightRule: String? = null,
    /** 描述 */
    val desc: String? = null,
    /** 终止日期 */
    @SerialName("exp_date")
    val expDate: String? = null,
)
