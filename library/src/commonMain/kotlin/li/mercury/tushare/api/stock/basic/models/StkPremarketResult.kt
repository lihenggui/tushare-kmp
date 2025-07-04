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
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股本情况（盘前）返回对象类
 */
@Serializable
public data class StkPremarketResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 总股本（万股） */
    @SerialName("total_share")
    val totalShare: Double,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double,
    /** 昨日收盘价 */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 今日涨停价 */
    @SerialName("up_limit")
    val upLimit: Double? = null,
    /** 今日跌停价 */
    @SerialName("down_limit")
    val downLimit: Double? = null,
)
