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
import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsType
import li.mercury.tushare.api.stock.basic.models.ListStatus
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockBasicApi : TestTuShare() {
    @Test
    fun testStockBasicWorks() =
        test {
            val config = createConfigWithMockEngine("stock_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockBasic(
                    StockBasicParams(
                        listStatus = ListStatus.L,
                        exchange = Exchange.SZSE,
                    ),
                )
            assertNotNull(result, "Stock basic information data should not be null")
        }

    @Test
    fun testHsConstWorks() =
        test {
            val config = createConfigWithMockEngine("hs_const.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHsConst(
                    HsConstParams(
                        hsType = HsType.SZ,
                    ),
                )
            assertNotNull(result, "HS connect constituent data should not be null")
        }

    @Test
    fun testNameChangeWorks() =
        test {
            val config = createConfigWithMockEngine("name_change.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getNameChange(
                    NameChangeParams(
                        tsCode = TsCode("600519", "SH"),
                    ),
                )
            assertNotNull(result, "Stock name change data should not be null")
        }

    @Test
    fun testStockCompanyWorks() =
        test {
            val config = createConfigWithMockEngine("stock_company.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockCompany(
                    StockCompanyParams(
                        exchange = Exchange.SZSE,
                    ),
                )
            assertNotNull(result, "Listed company basic information data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testStkPremarketWorks() =
        test {
            val config = createConfigWithMockEngine("stk_premarket.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkPremarket(
                    StkPremarketParams(
                        tradeDate = LocalDate(2025, 1, 1),
                    ),
                )
            assertNotNull(result, "Stock pre-market data should not be null")
        }

    @Test
    fun testTradeCalWorks() =
        test {
            val config = createConfigWithMockEngine("trade_cal.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTradeCal(
                    TradeCalParams(
                        exchange = Exchange.SSE,
                        startDate = LocalDate(2023, 1, 31),
                        endDate = LocalDate(2023, 2, 1),
                    ),
                )
            assertNotNull(result, "Trading calendar data should not be null")
        }

    @Test
    fun testStkManagersWorks() =
        test {
            val config = createConfigWithMockEngine("stk_managers.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkManagers(
                    StkManagersParams(
                        tsCode = TsCode("600000", "SH"),
                    ),
                )
            assertNotNull(result, "Listed company management data should not be null")
        }

    @Test
    fun testStkRewardsWorks() =
        test {
            val config = createConfigWithMockEngine("stk_rewards.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkRewards(
                    StkRewardsParams(
                        tsCode = TsCode("000001", "SZ"),
                        endDate = LocalDate(2014, 12, 31),
                    ),
                )
            assertNotNull(result, "Management compensation and shareholding data should not be null")
        }

    @Test
    fun testNewShareWorks() =
        test {
            val config = createConfigWithMockEngine("new_share.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getNewShare(
                    NewShareParams(
                        startDate = LocalDate(2018, 9, 1),
                        endDate = LocalDate(2018, 10, 18),
                    ),
                )
            assertNotNull(result, "IPO new share list data should not be null")
        }

    @Test
    fun testBakBasicWorks() =
        test {
            val config = createConfigWithMockEngine("bak_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBakBasic(
                    BakBasicParams(
                        tradeDate = LocalDate(2021, 10, 12),
                        tsCode = TsCode("300605", "SZ"),
                    ),
                )
            assertNotNull(result, "Backup list data should not be null")
        }
}
