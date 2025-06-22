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
public data class StkAuctionResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 数据日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 成交量（股） */
    val vol: Int? = null,
    /** 成交均价（元） */
    val price: Double? = null,
    /** 成交金额（元） */
    val amount: Double? = null,
    /** 昨收价（元） */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 量比 */
    @SerialName("volume_ratio")
    val volumeRatio: Double? = null,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double? = null,
)
