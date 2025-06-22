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

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司管理层返回对象类
 */
@Serializable
public data class StkManagersResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 姓名 */
    val name: String,
    /** 性别 */
    val gender: String,
    /** 岗位类别 */
    val lev: String,
    /** 岗位 */
    val title: String,
    /** 学历 */
    val edu: String? = null,
    /** 国籍 */
    val national: String? = null,
    /** 出生年月 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val birthday: LocalDate? = null,
    /** 上任日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("begin_date")
    val beginDate: LocalDate? = null,
    /** 离任日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 个人简历 */
    val resume: String? = null,
)
