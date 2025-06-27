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
package li.mercury.tushare.sample.jvm

import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.models.TsCode

suspend fun dailyMarketData(tuShare: TuShare) {
    println("Daily Market Data feature")
    tuShare.getDaily(DailyParams(tsCode = TsCode("000001", "SZ")))
}

suspend fun weeklyMarketData(tuShare: TuShare) {
    println("Weekly Market Data feature")
    tuShare.getWeekly(WeeklyParams(tsCode = TsCode("000001", "SZ")))
}

suspend fun monthlyMarketData(tuShare: TuShare) {
    println("Monthly Market Data feature")
    tuShare.getMonthly(MonthlyParams(tsCode = TsCode("000001", "SZ")))
}
