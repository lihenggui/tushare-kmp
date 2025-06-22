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
package li.mercury.tushare.api.stock.margin.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 融资融券交易汇总返回结果
 */
@Serializable
public data class MarginResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 交易所代码 */
    @SerialName("exchange_id")
    val exchangeId: Exchange,
    /** 融资余额(元) */
    val rzye: Double? = null,
    /** 融资买入额(元) */
    val rzmre: Double? = null,
    /** 融资偿还额(元) */
    val rzche: Double? = null,
    /** 融券余额(元) */
    val rqye: Double? = null,
    /** 融券卖出量(股, 份, 手) */
    val rqmcl: Double? = null,
    /** 融资融券余额(元) */
    val rzrqye: Double? = null,
    /** 融券余量(股, 份, 手) */
    val rqyl: Double? = null,
)
