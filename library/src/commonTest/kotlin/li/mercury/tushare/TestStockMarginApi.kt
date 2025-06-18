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
    //    @Test
//    Skipped due to permission issues
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
            assertNotNull(result, "融资融券交易汇总数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
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
            assertNotNull(result, "融资融券交易明细数据不应为空")
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
            assertNotNull(result, "融资融券标的数据不应为空")
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
            assertNotNull(result, "转融券交易汇总数据不应为空")
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
            assertNotNull(result, "转融资交易汇总数据不应为空")
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
            assertNotNull(result, "转融券交易明细数据不应为空")
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
            assertNotNull(result, "做市借券交易汇总数据不应为空")
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
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "股权质押统计数据不应为空")
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
            assertNotNull(result, "股权质押明细数据不应为空")
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
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "股票回购数据不应为空")
        }
}
