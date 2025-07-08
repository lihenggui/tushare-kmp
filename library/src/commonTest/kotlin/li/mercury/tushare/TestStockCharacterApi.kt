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
import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.CyqChipsParams
import li.mercury.tushare.api.stock.character.models.CyqPerfParams
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.ReportRcParams
import li.mercury.tushare.api.stock.character.models.StkAuctionCParams
import li.mercury.tushare.api.stock.character.models.StkAuctionOParams
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkFactorProParams
import li.mercury.tushare.api.stock.character.models.StkNineturnParams
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockCharacterApi : TestTuShare() {
    @Test
    fun testReportRcWorks() =
        test {
            val config = createConfigWithMockEngine("report_rc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getReportRc(
                    ReportRcParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Analyst earnings forecast data should not be null")
        }

    @Test
    fun testCyqPerfWorks() =
        test {
            val config = createConfigWithMockEngine("cyq_perf.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCyqPerf(
                    CyqPerfParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Daily chips and win rate data should not be null")
        }

    @Test
    fun testCyqChipsWorks() =
        test {
            val config = createConfigWithMockEngine("cyq_chips.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCyqChips(
                    CyqChipsParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Daily chips distribution data should not be null")
        }

    @Test
    fun testStkSurvWorks() =
        test {
            val config = createConfigWithMockEngine("stk_surv.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkSurv(
                    StkSurvParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Stock technical survey data should not be null")
        }

    @Test
    fun testBrokerRecommendWorks() =
        test {
            val config = createConfigWithMockEngine("broker_recommend.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBrokerRecommend(
                    BrokerRecommendParams(
                        month = "202106",
                    ),
                )
            assertNotNull(result, "Broker recommendation pool data should not be null")
        }

    @Test
    fun testStkFactorWorks() =
        test {
            val config = createConfigWithMockEngine("stk_factor.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkFactor(
                    StkFactorParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Stock technical factor data should not be null")
        }

    @Test
    fun testStkFactorProWorks() =
        test {
            val config = createConfigWithMockEngine("stk_factor_pro.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkFactorPro(
                    StkFactorProParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2022, 5, 1),
                        endDate = LocalDate(2022, 5, 20),
                    ),
                )
            assertNotNull(result, "Stock technical factor pro data should not be null")
        }

    @Test
    fun testCcassHoldWorks() =
        test {
            val config = createConfigWithMockEngine("ccass_hold.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCcassHold(
                    CcassHoldParams(
                        tsCode = TsCode("00700", "HK"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "CCASS holding summary data should not be null")
        }

    @Test
    fun testCcassHoldDetailWorks() =
        test {
            val config = createConfigWithMockEngine("ccass_hold_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCcassHoldDetail(
                    CcassHoldDetailParams(
                        tsCode = TsCode("00700", "HK"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "CCASS holding detail data should not be null")
        }

    @Test
    fun testHkHoldWorks() =
        test {
            val config = createConfigWithMockEngine("hk_hold.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHkHold(
                    HkHoldParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Shanghai-Shenzhen-Hong Kong Stock Connect holding detail data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testStkAuctionOWorks() =
        test {
            val config = createConfigWithMockEngine("stk_auction_o.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkAuctionO(
                    StkAuctionOParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Stock opening auction data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testStkAuctionCWorks() =
        test {
            val config = createConfigWithMockEngine("stk_auction_c.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkAuctionC(
                    StkAuctionCParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Stock closing auction data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testStkNineturnWorks() =
        test {
            val config = createConfigWithMockEngine("stk_nineturn.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkNineturn(
                    StkNineturnParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Stock nine-turn indicator data should not be null")
        }
}
