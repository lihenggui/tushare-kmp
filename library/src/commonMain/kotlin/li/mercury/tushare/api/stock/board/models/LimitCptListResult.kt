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
public data class LimitCptListResult(
    /** 板块代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 板块名称 */
    val name: String? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 上榜天数 */
    val days: Int? = null,
    /** 连板高度 */
    @SerialName("up_stat")
    val upStat: String? = null,
    /** 连板家数 */
    @SerialName("cons_nums")
    val consNums: Int? = null,
    /** 涨停家数 */
    @SerialName("up_nums")
    val upNums: String? = null,
    /** 涨跌幅% */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 板块热点排名 */
    val rank: String? = null,
)
