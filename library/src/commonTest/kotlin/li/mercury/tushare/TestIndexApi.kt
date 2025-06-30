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
import li.mercury.tushare.api.index.models.CiDailyParams
import li.mercury.tushare.api.index.models.DailyInfoParams
import li.mercury.tushare.api.index.models.IdxFactorProParams
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexCategory
import li.mercury.tushare.api.index.models.IndexClassifyParams
import li.mercury.tushare.api.index.models.IndexDailyBasicParams
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexGlobalParams
import li.mercury.tushare.api.index.models.IndexMemberAllParams
import li.mercury.tushare.api.index.models.IndexMonthlyParams
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeightParams
import li.mercury.tushare.api.index.models.SwDailyParams
import li.mercury.tushare.api.index.models.SzDailyInfoParams
import li.mercury.tushare.api.index.models.ThsDailyParams
import li.mercury.tushare.api.index.models.TsIndexCode
import li.mercury.tushare.models.Market
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestIndexApi : TestTuShare() {
    @Test
    fun testIndexBasicWorks() =
        test {
            val config = createConfigWithMockEngine("index_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexBasic(
                    IndexBasicParams(
                        market = Market.SW,
                        category = IndexCategory.主题指数,
                    ),
                )
            assertNotNull(result, "Index basic data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testIdxFactorProWorks() =
        test {
            val config = createConfigWithMockEngine("idx_factor_pro.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIdxFactorPro(
                    IdxFactorProParams(),
                )
            assertNotNull(result, "Index factor pro data should not be null")
        }

    @Test
    fun testIndexMemberAllWorks() =
        test {
            val config = createConfigWithMockEngine("index_member_all.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexMemberAll(
                    IndexMemberAllParams(tsCode = TsCode("600519", "SH")),
                )
            assertNotNull(result, "Index member all data should not be null")
        }

    @Test
    fun testIndexClassifyWorks() =
        test {
            val config = createConfigWithMockEngine("index_classify.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexClassify(
                    IndexClassifyParams(indexCode = "801020.SI", parentCode = "0"),
                )
            assertNotNull(result, "Index classify data should not be null")
        }

    @Test
    fun testIndexWeightWorks() =
        test {
            val config = createConfigWithMockEngine("index_weight.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexWeight(
                    IndexWeightParams(
                        indexCode = TsCode("000001", "SH"),
                        startDate = LocalDate(2018, 1, 25),
                        endDate = LocalDate(2018, 1, 26)
                    ),
                )
            assertNotNull(result, "Index weight data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testIndexDailyBasicWorks() =
        test {
            val config = createConfigWithMockEngine("index_dailybasic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexDailyBasic(
                    IndexDailyBasicParams(),
                )
            assertNotNull(result, "Index daily basic data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testIndexMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("index_monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexMonthly(
                    IndexMonthlyParams(),
                )
            assertNotNull(result, "Index monthly data should not be null")
        }

    @Test
    fun testSwDailyWorks() =
        test {
            val config = createConfigWithMockEngine("sw_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSwDaily(
                    SwDailyParams(
                        tradeDate = LocalDate(2023, 7, 5),
                        tsCode = TsCode("801012", "SI"),
                    ),
                )
            assertNotNull(result, "SW daily data should not be null")
        }

    @Test
    fun testSzDailyInfoWorks() =
        test {
            val config = createConfigWithMockEngine("sz_daily_info.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSzDailyInfo(
                    SzDailyInfoParams(),
                )
            assertNotNull(result, "Shenzhen daily trading statistics data should not be null")
        }

    @Test
    fun testThsDailyWorks() =
        test {
            val config = createConfigWithMockEngine("ths_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getThsDaily(
                    ThsDailyParams(
                        tsCode = TsCode("865001", "TI"),
                        startDate = LocalDate(2020, 1, 1),
                        endDate = LocalDate(2020, 3, 1),
                    ),
                )
            assertNotNull(result, "THS concept and industry index data should not be null")
        }

    @Test
    fun testCiDailyWorks() =
        test {
            val config = createConfigWithMockEngine("ci_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCiDaily(
                    CiDailyParams(
                        tradeDate = LocalDate(2023, 7, 5),
                        tsCode = TsCode("005002", "SH"),
                    ),
                )
            assertNotNull(result, "CSI daily data should not be null")
        }

    @Test
    fun testIndexGlobalWorks() =
        test {
            val config = createConfigWithMockEngine("index_global.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexGlobal(
                    IndexGlobalParams(
                        tsCode = TsIndexCode.XIN9,
                        tradeDate = LocalDate(2023, 7, 5),
                    ),
                )
            assertNotNull(result, "Global index data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testDailyInfoWorks() =
        test {
            val config = createConfigWithMockEngine("daily_info.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDailyInfo(
                    DailyInfoParams(),
                )
            assertNotNull(result, "Market daily indicators data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testIndexWeeklyWorks() =
        test {
            val config = createConfigWithMockEngine("index_weekly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexWeekly(
                    IndexWeeklyParams(),
                )
            assertNotNull(result, "Index weekly data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testIndexDailyWorks() =
        test {
            val config = createConfigWithMockEngine("index_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIndexDaily(
                    IndexDailyParams(
                        tsCode = TsCode("000001", "SH"),
                    ),
                )
            assertNotNull(result, "Index daily data should not be null")
        }
}
