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
package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 概念股列表返回对象类
 */
@Serializable
public data class ConceptDetailResult(
    /** 概念代码 */
    val id: String,
    /** 概念名称 */
    @SerialName("concept_name")
    val conceptName: String,
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String,
    /** 纳入日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("in_date")
    val inDate: LocalDate? = null,
    /** 剔除日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("out_date")
    val outDate: LocalDate? = null,
)
