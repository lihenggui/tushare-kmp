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
 * 前十大股东返回对象类
 */
@Serializable
public data class Top10HoldersResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String? = null,
    /** 持有数量（股） */
    @SerialName("hold_amount")
    val holdAmount: Double? = null,
    /** 占总股本比例（%） */
    @SerialName("hold_ratio")
    val holdRatio: Double? = null,
    /** 占流通股本比例（%） */
    @SerialName("hold_float_ratio")
    val holdFloatRatio: Double? = null,
    /** 持股变动 */
    @SerialName("hold_change")
    val holdChange: Double? = null,
    /** 股东类型 */
    @SerialName("holder_type")
    val holderType: String? = null,
)
