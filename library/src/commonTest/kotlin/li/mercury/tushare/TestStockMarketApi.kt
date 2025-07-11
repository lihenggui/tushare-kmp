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
package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.FreqMin
import li.mercury.tushare.api.stock.market.models.FreqWeekMonth
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockMarketApi : TestTuShare() {
    @Test
    fun testDailyWorks() =
        test {
            val config = createConfigWithMockEngine("daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDaily(
                    DailyParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Daily market data should not be null")
        }

    @Test
    fun testMinsWorks() =
        test {
            val config = createConfigWithMockEngine("mins.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMins(
                    MinsParams(
                        tsCode = TsCode("000001", "SZ"),
                        freq = FreqMin.MIN_60,
                    ),
                )
            assertNotNull(result, "Minute market data should not be null")
        }

    @Test
    fun testWeeklyWorks() =
        test {
            val config = createConfigWithMockEngine("weekly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getWeekly(
                    WeeklyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2018, 7, 31),
                    ),
                )
            assertNotNull(result, "Weekly market data should not be null")
        }

    @Test
    fun testMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMonthly(
                    MonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 31),
                    ),
                )
            assertNotNull(result, "Monthly market data should not be null")
        }

    @Test
    fun testWeeklyMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("weekly_monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getWeeklyMonthly(
                    WeeklyMonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        freq = FreqWeekMonth.MONTH,
                    ),
                )
            assertNotNull(result, "Stock weekly/monthly market data should not be null")
        }

    @Test
    fun testAdjFactorWorks() =
        test {
            val config = createConfigWithMockEngine("adj_factor.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getAdjFactor(
                    AdjFactorParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Adjustment factor data should not be null")
        }

    @Test
    fun testSuspendDWorks() =
        test {
            val config = createConfigWithMockEngine("suspend_d.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSuspendD(
                    SuspendDParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Suspension information data should not be null")
        }

    @Test
    fun testDailyBasicWorks() =
        test {
            val config = createConfigWithMockEngine("daily_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDailyBasic(
                    DailyBasicParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Daily basic indicators data should not be null")
        }

    @Test
    fun testStkLimitWorks() =
        test {
            val config = createConfigWithMockEngine("stk_limit.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkLimit(
                    StkLimitParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Daily limit up/down price data should not be null")
        }

    @Test
    fun testGgtDailyWorks() =
        test {
            val config = createConfigWithMockEngine("ggt_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtDaily(
                    GgtDailyParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Hong Kong Stock Connect daily trading statistics data should not be null")
        }

    //    @Test
    // Test skipped, no permission
    fun testGgtMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("ggt_monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtMonthly(
                    GgtMonthlyParams(
                        month = "201807",
                    ),
                )
            assertNotNull(result, "Hong Kong Stock Connect monthly trading statistics data should not be null")
        }

    @Test
    fun testBakDailyWorks() =
        test {
            val config = createConfigWithMockEngine("bak_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBakDaily(
                    BakDailyParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Backup market data should not be null")
        }

    @Test
    fun testHsgtTop10Works() =
        test {
            val config = createConfigWithMockEngine("hsgt_top10.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHsgtTop10(
                    HsgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Shanghai-Shenzhen Stock Connect top 10 trading stocks data should not be null")
        }

    @Test
    fun testGgtTop10Works() =
        test {
            val config = createConfigWithMockEngine("ggt_top10.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtTop10(
                    GgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Hong Kong Stock Connect top 10 trading stocks data should not be null")
        }
}
