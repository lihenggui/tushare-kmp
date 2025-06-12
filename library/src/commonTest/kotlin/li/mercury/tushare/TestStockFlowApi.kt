package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.flow.models.GgtDailyParams
import li.mercury.tushare.api.stock.flow.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.flow.models.HsgtFundflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockFlowApi : TestTuShare() {

    @Test
    fun testMoneyflowWorks() = test {
        val config = createConfigWithMockEngine("moneyflow.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getMoneyflow(
            MoneyflowParams(
                tsCode = TsCode("000001", "SZ"),
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "个股资金流向数据不应为空")
    }

    @Test
    fun testMoneyflowHsgtWorks() = test {
        val config = createConfigWithMockEngine("moneyflow_hsgt.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getMoneyflowHsgt(
            MoneyflowHsgtParams(
                tsCode = TsCode("000001", "SZ"),
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "沪深港股通资金流向数据不应为空")
    }

    @Test
    fun testHsgtFundflowWorks() = test {
        val config = createConfigWithMockEngine("hsgt_fundflow.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getHsgtFundflow(
            HsgtFundflowParams(
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "沪深港股通资金流向统计数据不应为空")
    }

    @Test
    fun testGgtDailyWorks() = test {
        val config = createConfigWithMockEngine("ggt_daily.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getGgtDaily(
            GgtDailyParams(
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "港股通每日成交统计数据不应为空")
    }

    @Test
    fun testGgtMonthlyWorks() = test {
        val config = createConfigWithMockEngine("ggt_monthly.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getGgtMonthly(
            GgtMonthlyParams(
                month = "201807"
            )
        )
        assertNotNull(result, "港股通每月成交统计数据不应为空")
    }
} 