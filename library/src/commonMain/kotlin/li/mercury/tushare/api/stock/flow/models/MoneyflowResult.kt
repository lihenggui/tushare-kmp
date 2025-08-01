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
public data class MoneyflowResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 股票名称 */
    @SerialName("name")
    val name: String? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double? = null,
    /** 最新价 */
    @SerialName("latest")
    val latest: Double? = null,
    /** 资金净流入(万元) */
    @SerialName("net_amount")
    val netAmount: Double? = null,
    /** 5日主力净额(万元) */
    @SerialName("net_d5_amount")
    val netD5Amount: Double? = null,
    /** 今日大单净流入额(万元) */
    @SerialName("buy_lg_amount")
    val buyLgAmount: Double? = null,
    /** 今日大单净流入占比(%) */
    @SerialName("buy_lg_amount_rate")
    val buyLgAmountRate: Double? = null,
    /** 今日中单净流入额(万元) */
    @SerialName("buy_md_amount")
    val buyMdAmount: Double? = null,
    /** 今日中单净流入占比(%) */
    @SerialName("buy_md_amount_rate")
    val buyMdAmountRate: Double? = null,
    /** 今日小单净流入额(万元) */
    @SerialName("buy_sm_amount")
    val buySmAmount: Double? = null,
    /** 今日小单净流入占比(%) */
    @SerialName("buy_sm_amount_rate")
    val buySmAmountRate: Double? = null,
)
