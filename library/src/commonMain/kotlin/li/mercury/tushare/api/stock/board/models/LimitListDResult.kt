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
public data class LimitListDResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 所属行业 */
    val industry: String? = null,
    /** 股票名称 */
    val name: String? = null,
    /** 收盘价 */
    val close: Float? = null,
    /** 涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 成交额 */
    val amount: Float? = null,
    /** 板上成交金额（涨停无此数据） */
    @SerialName("limit_amount")
    val limitAmount: Float? = null,
    /** 流通市值 */
    @SerialName("float_mv")
    val floatMv: Float? = null,
    /** 总市值 */
    @SerialName("total_mv")
    val totalMv: Float? = null,
    /** 换手率 */
    @SerialName("turnover_ratio")
    val turnoverRatio: Float? = null,
    /** 封单金额 */
    @SerialName("fd_amount")
    val fdAmount: Float? = null,
    /** 首次封板时间（跌停无此数据） */
    @SerialName("first_time")
    val firstTime: String? = null,
    /** 最后封板时间 */
    @SerialName("last_time")
    val lastTime: String? = null,
    /** 炸板次数（跌停为开板次数） */
    @SerialName("open_times")
    val openTimes: Int? = null,
    /** 涨停统计（N/T，T天有N次涨停） */
    @SerialName("up_stat")
    val upStat: String? = null,
    /** 连板数 */
    @SerialName("limit_times")
    val limitTimes: Int? = null,
    /** D跌停，U涨停，Z炸板 */
    val limit: String? = null,
)
