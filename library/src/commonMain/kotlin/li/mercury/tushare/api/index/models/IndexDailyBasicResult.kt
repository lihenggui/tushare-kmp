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

/**
 * 大盘指数每日指标返回结果
 */
@Serializable
public data class IndexDailyBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 当日总市值（元） */
    @SerialName("total_mv")
    val totalMv: Double,
    /** 当日流通市值（元） */
    @SerialName("float_mv")
    val floatMv: Double,
    /** 当日总股本（股） */
    @SerialName("total_share")
    val totalShare: Double,
    /** 当日流通股本（股） */
    @SerialName("float_share")
    val floatShare: Double,
    /** 当日自由流通股本（股） */
    @SerialName("free_share")
    val freeShare: Double,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Double,
    /** 换手率（基于自由流通股本） */
    @SerialName("turnover_rate_f")
    val turnoverRateF: Double,
    /** 市盈率 */
    @SerialName("pe")
    val pe: Double? = null,
    /** 市盈率 TTM */
    @SerialName("pe_ttm")
    val peTtm: Double? = null,
    /** 市净率 */
    @SerialName("pb")
    val pb: Double? = null,
)
