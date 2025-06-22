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
public data class DcIndexResult(
    /** 概念代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 概念名称 */
    val name: String? = null,
    /** 领涨股票名称 */
    val leading: String? = null,
    /** 领涨股票代码 */
    @SerialName("leading_code")
    val leadingCode: String? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Float? = null,
    /** 领涨股票涨跌幅 */
    @SerialName("leading_pct")
    val leadingPct: Float? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Float? = null,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Float? = null,
    /** 上涨家数 */
    @SerialName("up_num")
    val upNum: Int? = null,
    /** 下降家数 */
    @SerialName("down_num")
    val downNum: Int? = null,
)
