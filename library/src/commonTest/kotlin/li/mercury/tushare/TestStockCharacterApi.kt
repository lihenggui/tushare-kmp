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
            assertNotNull(result, "卖方盈利预测数据不应为空")
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
            assertNotNull(result, "每日筹码及胜率数据不应为空")
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
            assertNotNull(result, "每日筹码分布数据不应为空")
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
            assertNotNull(result, "股票技术面统计数据不应为空")
        }

    //    @Test
    // Test skipped, no permission
    fun testBrokerRecommendWorks() =
        test {
            val config = createConfigWithMockEngine("broker_recommend.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBrokerRecommend(
                    BrokerRecommendParams(
                        month = "201801",
                    ),
                )
            assertNotNull(result, "券商推荐池数据不应为空")
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
            assertNotNull(result, "股票技术因子数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testStkFactorProWorks() =
        test {
            val config = createConfigWithMockEngine("stk_factor_pro.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkFactorPro(
                    StkFactorProParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "股票技术面因子（专业版）数据不应为空")
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
            assertNotNull(result, "中央结算系统持股汇总数据不应为空")
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
            assertNotNull(result, "中央结算系统持股明细数据不应为空")
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
            assertNotNull(result, "沪深港股通持股明细数据不应为空")
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
            assertNotNull(result, "股票开盘集合竞价数据不应为空")
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
            assertNotNull(result, "股票收盘集合竞价数据不应为空")
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
            assertNotNull(result, "神奇九转指标数据不应为空")
        }
}
