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
 * 限售股解禁返回对象类
 */
@Serializable
public data class ShareFloatResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 解禁日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("float_date")
    val floatDate: LocalDate,
    /** 解禁股份数量（股） */
    @SerialName("float_share")
    val floatShare: Float,
    /** 解禁股份占总股本比例（%） */
    @SerialName("float_ratio")
    val floatRatio: Float,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String,
    /** 股份类型（如定增股份、首发原股东限售股份） */
    @SerialName("share_type")
    val shareType: String,
)
