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
package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中央结算系统持股明细返回对象
 */
@Serializable
public data class CcassHoldDetailResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    @SerialName("name")
    val name: String? = null,
    /** 参与者编号 */
    @SerialName("col_participant_id")
    val participantId: String? = null,
    /** 机构名称 */
    @SerialName("col_participant_name")
    val participantName: String? = null,
    /** 持股量（股） */
    @SerialName("col_shareholding")
    val shareholding: Long? = null,
    /** 占已发行股份百分比（%） */
    @SerialName("col_shareholding_percent")
    val shareholdingPercent: Double? = null,
)
