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
 * 股票收盘集合竞价数据返回对象
 */
@Serializable
public data class StkAuctionCResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 收盘价 */
    @SerialName("close")
    val close: Double? = null,
    /** 开盘价 */
    @SerialName("open")
    val open: Double? = null,
    /** 最高价 */
    @SerialName("high")
    val high: Double? = null,
    /** 最低价 */
    @SerialName("low")
    val low: Double? = null,
    /** 成交量（股） */
    @SerialName("vol")
    val vol: Double? = null,
    /** 成交额（元） */
    @SerialName("amount")
    val amount: Double? = null,
    /** 均价 */
    @SerialName("vwap")
    val vwap: Double? = null,
)
