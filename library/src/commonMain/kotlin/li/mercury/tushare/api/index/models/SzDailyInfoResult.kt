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
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 深圳市场每日交易概况返回结果
 */
@Serializable
public data class SzDailyInfoResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 市场类型 */
    @SerialName("ts_code")
    val tsCode: SzTsCode,
    /** 股票个数 */
    val count: Int,
    /** 成交金额（元） */
    val amount: Double,
    /** 成交量（手） */
    val vol: Double? = null,
    /** 总股本 */
    @SerialName("total_share")
    val totalShare: Double? = null,
    /** 总市值 */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通股本 */
    @SerialName("float_share")
    val floatShare: Double? = null,
    /** 流通市值 */
    @SerialName("float_mv")
    val floatMv: Double? = null,
)
