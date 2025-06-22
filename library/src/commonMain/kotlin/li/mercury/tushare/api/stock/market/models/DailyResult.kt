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
 * 日线行情返回对象类
 */
@Serializable
public data class DailyResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 开盘价 */
    val open: Float? = null,
    /** 最高价 */
    val high: Float? = null,
    /** 最低价 */
    val low: Float? = null,
    /** 收盘价 */
    val close: Float? = null,
    /** 昨收价（除权价，前复权） */
    @SerialName("pre_close")
    val preClose: Float? = null,
    /** 涨跌额 */
    val change: Float? = null,
    /** 涨跌幅（百分比） */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 成交量（手） */
    val vol: Float? = null,
    /** 成交额（千元） */
    val amount: Float? = null,
)
