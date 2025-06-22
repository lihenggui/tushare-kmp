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
import li.mercury.tushare.api.stock.board.models.DcHotMarket
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotType
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.HmDetailParams
import li.mercury.tushare.api.stock.board.models.HmListParams
import li.mercury.tushare.api.stock.board.models.KplConceptConsParams
import li.mercury.tushare.api.stock.board.models.KplConceptParams
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.LimitCptListParams
import li.mercury.tushare.api.stock.board.models.LimitListDParams
import li.mercury.tushare.api.stock.board.models.LimitListThsParams
import li.mercury.tushare.api.stock.board.models.LimitStepParams
import li.mercury.tushare.api.stock.board.models.LimitType
import li.mercury.tushare.api.stock.board.models.StkAuctionParams
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexType
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.TopInstParams
import li.mercury.tushare.api.stock.board.models.TopListParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockBoardApi : TestTuShare() {
    //    @Test
//    Skipped due to permission issues
    fun testDcMemberWorks() =
        test {
            val config = createConfigWithMockEngine("dc_member.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDcMember(
                    DcMemberParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "东方财富板块成分数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testDcIndexWorks() =
        test {
            val config = createConfigWithMockEngine("dc_index.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDcIndex(
                    DcIndexParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "东方财富概念板块数据不应为空")
        }

    @Test
    fun testDcHotWorks() =
        test {
            val config = createConfigWithMockEngine("dc_hot.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDcHot(
                    DcHotParams(
                        tradeDate = LocalDate(2024, 3, 15),
                        market = DcHotMarket.HK_MARKET,
                        hotType = DcHotType.POPULARITY,
                    ),
                )
            assertNotNull(result, "东财热门股票数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testThsIndexWorks() =
        test {
            val config = createConfigWithMockEngine("ths_index.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getThsIndex(
                    ThsIndexParams(
                        exchange = "A",
                        type = ThsIndexType.THEME,
                    ),
                )
            assertNotNull(result, "同花顺概念和行业指数数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testThsMemberWorks() =
        test {
            val config = createConfigWithMockEngine("ths_member.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getThsMember(
                    ThsMemberParams(
                        tsCode = TsCode("865001", "TI"),
                    ),
                )
            assertNotNull(result, "同花顺概念板块成分数据不应为空")
        }

    @Test
    fun testThsHotWorks() =
        test {
            val config = createConfigWithMockEngine("ths_hot.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getThsHot(
                    ThsHotParams(
                        tradeDate = LocalDate(2024, 3, 15),
                        market = "热股",
                    ),
                )
            assertNotNull(result, "同花顺热门股票数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testKplListWorks() =
        test {
            val config = createConfigWithMockEngine("kpl_list.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getKplList(
                    KplListParams(
                        tradeDate = LocalDate(2024, 3, 15),
                    ),
                )
            assertNotNull(result, "开盘啦榜单数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testKplConceptWorks() =
        test {
            val config = createConfigWithMockEngine("kpl_concept.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getKplConcept(
                    KplConceptParams(),
                )
            assertNotNull(result, "开盘啦题材库数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testKplConceptConsWorks() =
        test {
            val config = createConfigWithMockEngine("kpl_concept_cons.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getKplConceptCons(
                    KplConceptConsParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "开盘啦题材成分数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testLimitCptListWorks() =
        test {
            val config = createConfigWithMockEngine("limit_cpt_list.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getLimitCptList(
                    LimitCptListParams(
                        tradeDate = LocalDate(2024, 3, 15),
                    ),
                )
            assertNotNull(result, "最强板块统计数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testLimitListThsWorks() =
        test {
            val config = createConfigWithMockEngine("limit_list_ths.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getLimitListThs(
                    LimitListThsParams(
                        tradeDate = LocalDate(2024, 3, 15),
                    ),
                )
            assertNotNull(result, "同花顺涨跌停榜单数据不应为空")
        }

    @Test
    fun testHmListWorks() =
        test {
            val config = createConfigWithMockEngine("hm_list.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHmList(
                    HmListParams(),
                )
            assertNotNull(result, "游资名录数据不应为空")
        }

    @Test
    fun testHmDetailWorks() =
        test {
            val config = createConfigWithMockEngine("hm_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHmDetail(
                    HmDetailParams(
                        tradeDate = LocalDate(2024, 3, 15),
                    ),
                )
            assertNotNull(result, "游资每日明细数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testLimitStepWorks() =
        test {
            val config = createConfigWithMockEngine("limit_step.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getLimitStep(
                    LimitStepParams(
                        tradeDate = LocalDate(2024, 3, 15),
                    ),
                )
            assertNotNull(result, "连板天梯数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testTopListWorks() =
        test {
            val config = createConfigWithMockEngine("top_list.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTopList(
                    TopListParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "龙虎榜每日明细数据不应为空")
        }

    //    @Test
    // Skipped due to permission issues
    fun testTopInstWorks() =
        test {
            val config = createConfigWithMockEngine("top_inst.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTopInst(
                    TopInstParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "龙虎榜机构明细数据不应为空")
        }

    //    @Test
    // Skipped due to permission issues
    fun testLimitListDWorks() =
        test {
            val config = createConfigWithMockEngine("limit_list_d.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getLimitListD(
                    LimitListDParams(
                        tradeDate = LocalDate(2018, 7, 16),
                        limitType = LimitType.U,
                    ),
                )
            assertNotNull(result, "每日涨跌停统计数据不应为空")
        }

    //    @Test
    // Skipped due to permission issues
    fun testStkAuctionWorks() =
        test {
            val config = createConfigWithMockEngine("stk_auction.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkAuction(
                    StkAuctionParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "股票竞价交易数据不应为空")
        }
}
