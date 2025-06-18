package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockFlowApi : TestTuShare() {
    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflow(
                    MoneyflowParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "个股资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowThsWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ths.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowThs(
                    MoneyflowThsParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "同花顺个股资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowDc(
                    MoneyflowDcParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "东方财富个股资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowMktDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_mkt_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowMktDc(
                    MoneyflowMktDcParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "东方财富大盘资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowIndDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ind_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowIndDc(
                    MoneyflowIndDcParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "东方财富板块资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
    fun testMoneyflowIndThsWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ind_ths.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowIndThs(
                    MoneyflowIndThsParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "同花顺行业板块资金流向数据不应为空")
        }

    @Test
    fun testMoneyflowHsgtWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_hsgt.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowHsgt(
                    MoneyflowHsgtParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "沪深港股通资金流向数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
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
            assertNotNull(result, "港股通每日成交统计数据不应为空")
        }

    //    @Test
//    Skipped due to permission issues
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
            assertNotNull(result, "港股通每月成交统计数据不应为空")
        }
}
