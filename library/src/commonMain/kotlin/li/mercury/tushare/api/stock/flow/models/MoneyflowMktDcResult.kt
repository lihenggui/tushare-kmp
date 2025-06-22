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
public data class MoneyflowMktDcResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 上证收盘价（点） */
    @SerialName("close_sh")
    val closeSh: Double,
    /** 上证涨跌幅（%） */
    @SerialName("pct_change_sh")
    val pctChangeSh: Double,
    /** 深证收盘价（点） */
    @SerialName("close_sz")
    val closeSz: Double,
    /** 深证涨跌幅（%） */
    @SerialName("pct_change_sz")
    val pctChangeSz: Double,
    /** 今日主力净流入净额（元） */
    @SerialName("net_amount")
    val netAmount: Double,
    /** 今日主力净流入净占比（%） */
    @SerialName("net_amount_rate")
    val netAmountRate: Double,
    /** 今日超大单净流入净额（元） */
    @SerialName("buy_elg_amount")
    val buyElgAmount: Double,
    /** 今日超大单净流入净占比（%） */
    @SerialName("buy_elg_amount_rate")
    val buyElgAmountRate: Double,
    /** 今日大单净流入净额（元） */
    @SerialName("buy_lg_amount")
    val buyLgAmount: Double,
    /** 今日大单净流入净占比（%） */
    @SerialName("buy_lg_amount_rate")
    val buyLgAmountRate: Double,
    /** 今日中单净流入净额（元） */
    @SerialName("buy_md_amount")
    val buyMdAmount: Double,
    /** 今日中单净流入净占比（%） */
    @SerialName("buy_md_amount_rate")
    val buyMdAmountRate: Double,
    /** 今日小单净流入净额（元） */
    @SerialName("buy_sm_amount")
    val buySmAmount: Double,
    /** 今日小单净流入净占比（%） */
    @SerialName("buy_sm_amount_rate")
    val buySmAmountRate: Double,
)
