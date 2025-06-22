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
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 交易日历返回对象类
 */
@Serializable
public data class TradeCalResult(
    /** 交易所代码 */
    val exchange: Exchange,
    /** 日历日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("cal_date")
    val calDate: LocalDate,
    /** 是否交易：0休市 1交易 */
    @SerialName("is_open")
    val isOpen: String,
    /** 上一个交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("pretrade_date")
    val preTradeDate: LocalDate? = null,
)
