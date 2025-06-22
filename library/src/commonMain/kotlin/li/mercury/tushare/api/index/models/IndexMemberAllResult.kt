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

/**
 * 申万行业成分构成返回结果
 */
@Serializable
public data class IndexMemberAllResult(
    /** 一级行业代码 */
    @SerialName("l1_code")
    val l1Code: String,
    /** 一级行业名称 */
    @SerialName("l1_name")
    val l1Name: String,
    /** 二级行业代码 */
    @SerialName("l2_code")
    val l2Code: String,
    /** 二级行业名称 */
    @SerialName("l2_name")
    val l2Name: String,
    /** 三级行业代码 */
    @SerialName("l3_code")
    val l3Code: String,
    /** 三级行业名称 */
    @SerialName("l3_name")
    val l3Name: String,
    /** 成分股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 成分股票名称 */
    val name: String,
    /** 纳入日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("in_date")
    val inDate: LocalDate,
    /** 剔除日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("out_date")
    val outDate: LocalDate? = null,
    /** 是否最新（Y 是，N 否） */
    @SerialName("is_new")
    val isNew: String,
)
