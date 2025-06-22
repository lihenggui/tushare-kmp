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

/**
 * 东方财富热板市场类型
 */
public enum class DcHotMarket {
    /** A股市场 */
    A_MARKET,

    /** ETF基金 */
    ETF_FUND,

    /** 港股市场 */
    HK_MARKET,

    /** 美股市场 */
    US_MARKET,
}

/**
 * 东方财富热板热点类型
 */
public enum class DcHotType {
    /** 人气榜 */
    POPULARITY,

    /** 飙升榜 */
    RISING,
}

@Serializable
public data class DcHotParams(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 类型（A股市场、ETF基金、港股市场、美股市场） */
    val market: DcHotMarket? = null,
    /** 热点类型（人气榜、飙升榜） */
    @SerialName("hot_type")
    val hotType: DcHotType? = null,
    /** 是否最新（默认Y，如果为N则为盘中和盘后阶段采集） */
    @SerialName("is_new")
    val isNew: String? = null,
)
