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
package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class ThsMemberResult(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 股票代码 */
    @SerialName("con_code")
    val conCode: String? = null,
    /** 股票名称 */
    @SerialName("con_name")
    val conName: String? = null,
    /** 权重（暂无） */
    val weight: Float? = null,
    /** 纳入日期（暂无） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("in_date")
    val inDate: LocalDate? = null,
    /** 剔除日期（暂无） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("out_date")
    val outDate: LocalDate? = null,
    /** 是否最新（Y 是，N 否） */
    @SerialName("is_new")
    val isNew: String? = null,
)
