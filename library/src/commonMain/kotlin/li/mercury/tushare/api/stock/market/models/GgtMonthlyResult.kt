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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 港股通每月成交统计返回对象类
 */
@Serializable
public data class GgtMonthlyResult(
    /** 交易月份（格式：YYYYMM） */
    val month: String,
    /** 当月日均买入成交金额（亿元） */
    @SerialName("day_buy_amt")
    val dayBuyAmt: Double,
    /** 当月日均买入成交笔数（万笔） */
    @SerialName("day_buy_vol")
    val dayBuyVol: Double,
    /** 当月日均卖出成交金额（亿元） */
    @SerialName("day_sell_amt")
    val daySellAmt: Double,
    /** 当月日均卖出成交笔数（万笔） */
    @SerialName("day_sell_vol")
    val daySellVol: Double,
    /** 总买入成交金额（亿元） */
    @SerialName("total_buy_amt")
    val totalBuyAmt: Double,
    /** 总买入成交笔数（万笔） */
    @SerialName("total_buy_vol")
    val totalBuyVol: Double,
    /** 总卖出成交金额（亿元） */
    @SerialName("total_sell_amt")
    val totalSellAmt: Double,
    /** 总卖出成交笔数（万笔） */
    @SerialName("total_sell_vol")
    val totalSellVol: Double,
)
