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
import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockMarginApi : TestTuShare() {
    @Test
    fun testMarginWorks() =
        test {
            val config = createConfigWithMockEngine("margin.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMargin(
                    MarginParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Margin trading summary data should not be null")
        }

    @Test
    fun testMarginDetailWorks() =
        test {
            val config = createConfigWithMockEngine("margin_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMarginDetail(
                    MarginDetailParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Margin trading detail data should not be null")
        }

    @Test
    fun testMarginSecsWorks() =
        test {
            val config = createConfigWithMockEngine("margin_secs.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMarginSecs(
                    MarginSecsParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Margin securities data should not be null")
        }

    @Test
    fun testSlbSecWorks() =
        test {
            val config = createConfigWithMockEngine("slb_sec.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSlbSec(
                    SlbSecParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Securities lending summary data should not be null")
        }

    @Test
    fun testSlbLenWorks() =
        test {
            val config = createConfigWithMockEngine("slb_len.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSlbLen(
                    SlbLenParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Refinancing summary data should not be null")
        }

    @Test
    fun testSlbSecDetailWorks() =
        test {
            val config = createConfigWithMockEngine("slb_sec_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSlbSecDetail(
                    SlbSecDetailParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Securities lending detail data should not be null")
        }

    @Test
    fun testSlbLenMmWorks() =
        test {
            val config = createConfigWithMockEngine("slb_len_mm.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSlbLenMm(
                    SlbLenMmParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Market making securities lending summary data should not be null")
        }

    @Test
    fun testPledgeStatWorks() =
        test {
            val config = createConfigWithMockEngine("pledge_stat.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getPledgeStat(
                    PledgeStatParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Pledge statistics data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testPledgeDetailWorks() =
        test {
            val config = createConfigWithMockEngine("pledge_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getPledgeDetail(
                    PledgeDetailParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Pledge detail data should not be null")
        }

    @Test
    fun testRepurchaseWorks() =
        test {
            val config = createConfigWithMockEngine("repurchase.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getRepurchase(
                    RepurchaseParams(
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Stock repurchase data should not be null")
        }
}
