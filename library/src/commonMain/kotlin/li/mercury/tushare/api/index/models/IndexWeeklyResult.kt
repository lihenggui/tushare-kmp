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
package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class IndexWeeklyResult(
    /** TS 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 收盘点位 */
    val close: Double,
    /** 开盘点位 */
    val open: Double,
    /** 最高点位 */
    val high: Double,
    /** 最低点位 */
    val low: Double,
    /** 昨日收盘点 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 涨跌点 */
    val change: Double? = null,
    /** 涨跌幅（%） */
    @SerialName("pct_chg")
    val pctChg: Double? = null,
    /** 成交量（手） */
    val vol: Double? = null,
    /** 成交额（千元） */
    val amount: Double? = null,
)
