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
import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockReferenceApi : TestTuShare() {
    @Test
    fun testTop10HoldersWorks() =
        test {
            val config = createConfigWithMockEngine("top10_holders.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTop10Holders(
                    Top10HoldersParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2017, 12, 31),
                    ),
                )
            assertNotNull(result, "Top 10 shareholders data should not be null")
        }

    @Test
    fun testTop10FloatHoldersWorks() =
        test {
            val config = createConfigWithMockEngine("top10_floatholders.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTop10FloatHolders(
                    Top10FloatHoldersParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2017, 12, 31),
                    ),
                )
            assertNotNull(result, "Top 10 float shareholders data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testPledgeStatWorks() =
        test {
            val config = createConfigWithMockEngine("pledge_stat.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getPledgeStat(
                    PledgeStatParams(
                        tsCode = TsCode("000014", "SZ"),
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
                        tsCode = TsCode("000014", "SZ"),
                    ),
                )
            assertNotNull(result, "Pledge detail data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testRepurchaseWorks() =
        test {
            val config = createConfigWithMockEngine("repurchase.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getRepurchase(
                    RepurchaseParams(
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 5, 10),
                    ),
                )
            assertNotNull(result, "Stock repurchase data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testConceptWorks() =
        test {
            val config = createConfigWithMockEngine("concept.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getConcept(
                    ConceptParams(
                        src = "ts",
                    ),
                )
            assertNotNull(result, "Concept classification data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testConceptDetailWorks() =
        test {
            val config = createConfigWithMockEngine("concept_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getConceptDetail(
                    ConceptDetailParams(
                        id = "TS2",
                    ),
                )
            assertNotNull(result, "Concept list data should not be null")
        }

    @Test
    fun testShareFloatWorks() =
        test {
            val config = createConfigWithMockEngine("share_float.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getShareFloat(
                    ShareFloatParams(
                        tsCode = TsCode("000998", "SZ"),
                        annDate = LocalDate(2018, 12, 20),
                    ),
                )
            assertNotNull(result, "Share float unlock data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testBlockTradeWorks() =
        test {
            val config = createConfigWithMockEngine("block_trade.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBlockTrade(
                    BlockTradeParams(
                        tsCode = TsCode("600436", "SH"),
                        tradeDate = LocalDate(2018, 12, 27),
                    ),
                )
            assertNotNull(result, "Block trade data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testStockHolderNumberWorks() =
        test {
            val config = createConfigWithMockEngine("stk_holdernumber.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockHolderNumber(
                    StockHolderNumberParams(
                        tsCode = TsCode("300199", "SZ"),
                        startDate = LocalDate(2016, 1, 1),
                        endDate2 = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Shareholder number data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testStockHolderTradeWorks() =
        test {
            val config = createConfigWithMockEngine("stk_holdertrade.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockHolderTrade(
                    StockHolderTradeParams(
                        tsCode = TsCode("002149", "SZ"),
                        startDate = LocalDate(2022, 1, 1),
                        endDate = LocalDate(2022, 12, 31),
                    ),
                )
            assertNotNull(result, "Shareholder trading data should not be null")
        }
}
