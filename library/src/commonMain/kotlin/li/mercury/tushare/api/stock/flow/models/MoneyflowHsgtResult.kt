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
package li.mercury.tushare.api.stock.flow.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class MoneyflowHsgtResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 港股通（上海）*/
    @SerialName("ggt_ss")
    val ggtSs: Double,
    /** 港股通（深圳）*/
    @SerialName("ggt_sz")
    val ggtSz: Double,
    /** 沪股通（百万元）*/
    @SerialName("hgt")
    val hgt: Double,
    /** 深股通（百万元）*/
    @SerialName("sgt")
    val sgt: Double,
    /** 北向资金（百万元）*/
    @SerialName("north_money")
    val northMoney: Double,
    /** 南向资金（百万元）*/
    @SerialName("south_money")
    val southMoney: Double,
)
