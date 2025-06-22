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
package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票周/月线行情返回对象类
 */
@Serializable
public data class WeeklyMonthlyResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** 频率（week周线/month月线） */
    val freq: FreqWeekMonth,
    /** （周/月）开盘价 */
    val open: Float,
    /** （周/月）最高价 */
    val high: Float,
    /** （周/月）最低价 */
    val low: Float,
    /** （周/月）收盘价 */
    val close: Float,
    /** 上一（周/月）收盘价 */
    @SerialName("pre_close")
    val preClose: Float,
    /** （周/月）成交量 */
    val vol: Float,
    /** （周/月）成交额 */
    val amount: Float,
    /** （周/月）涨跌额 */
    val change: Float,
    /** （周/月）涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float,
)
