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
public data class TopListResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 名称 */
    val name: String? = null,
    /** 收盘价 */
    val close: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double? = null,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 总成交额 */
    val amount: Double? = null,
    /** 龙虎榜卖出额 */
    @SerialName("l_sell")
    val lSell: Double? = null,
    /** 龙虎榜买入额 */
    @SerialName("l_buy")
    val lBuy: Double? = null,
    /** 龙虎榜成交额 */
    @SerialName("l_amount")
    val lAmount: Double? = null,
    /** 龙虎榜净买入额 */
    @SerialName("net_amount")
    val netAmount: Double? = null,
    /** 龙虎榜净买额占比 */
    @SerialName("net_rate")
    val netRate: Double? = null,
    /** 龙虎榜成交额占比 */
    @SerialName("amount_rate")
    val amountRate: Double? = null,
    /** 当日流通市值 */
    @SerialName("float_values")
    val floatValues: Double? = null,
    /** 上榜理由 */
    val reason: String? = null,
)
