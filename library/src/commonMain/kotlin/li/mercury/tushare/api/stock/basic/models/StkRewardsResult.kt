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
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 管理层薪酬和持股返回对象类
 */
@Serializable
public data class StkRewardsResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 公告日期 */
    @SerialName("ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val annDate: LocalDate? = null,
    /** 截止日期 */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
    /** 姓名 */
    val name: String? = null,
    /** 职务 */
    val title: String? = null,
    /** 报酬（单位：万元） */
    val reward: Double? = null,
    /** 持股数（单位：股） */
    @SerialName("hold_vol")
    val holdVol: Double? = null,
)
