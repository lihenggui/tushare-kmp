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
 * 每日指标返回对象类
 */
@Serializable
public data class DailyBasicResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 当日收盘价 */
    val close: Double,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 换手率（自由流通股） */
    @SerialName("turnover_rate_f")
    val turnoverRateF: Double? = null,
    /** 量比 */
    @SerialName("volume_ratio")
    val volumeRatio: Double? = null,
    /** 市盈率（总市值/净利润） */
    val pe: Double? = null,
    /** 市盈率（TTM） */
    @SerialName("pe_ttm")
    val peTtm: Double? = null,
    /** 市净率（总市值/净资产） */
    val pb: Double? = null,
    /** 市销率 */
    val ps: Double? = null,
    /** 市销率（TTM） */
    @SerialName("ps_ttm")
    val psTtm: Double? = null,
    /** 股息率（%） */
    @SerialName("dv_ratio")
    val dvRatio: Double? = null,
    /** 股息率（TTM）（%） */
    @SerialName("dv_ttm")
    val dvTtm: Double? = null,
    /** 总股本（万股） */
    @SerialName("total_share")
    val totalShare: Double? = null,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double? = null,
    /** 自由流通股本（万股） */
    @SerialName("free_share")
    val freeShare: Double? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Double? = null,
    /** 流通市值（万元） */
    @SerialName("circ_mv")
    val circMv: Double? = null,
)
