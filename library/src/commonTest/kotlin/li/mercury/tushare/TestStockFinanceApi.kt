package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockFinanceApi : TestTuShare() {

    @Test
    fun testIncomeWorks() = test {
        val config = createConfigWithMockEngine("income.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getIncome(
            IncomeParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "利润表数据不应为空")
    }

    @Test
    fun testBalanceSheetWorks() = test {
        val config = createConfigWithMockEngine("balancesheet.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getBalanceSheet(
            BalanceSheetParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "资产负债表数据不应为空")
    }

    @Test
    fun testForecastWorks() = test {
        val config = createConfigWithMockEngine("forecast.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getForecast(
            ForecastParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "业绩预告数据不应为空")
    }

    @Test
    fun testExpressWorks() = test {
        val config = createConfigWithMockEngine("express.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getExpress(
            ExpressParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "业绩快报数据不应为空")
    }

    @Test
    fun testDividendWorks() = test {
        val config = createConfigWithMockEngine("dividend.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getDividend(
            DividendParams(
                tsCode = TsCode("000001", "SZ")
            )
        )
        assertNotNull(result, "分红送股数据不应为空")
    }

    @Test
    fun testFinaIndicatorWorks() = test {
        val config = createConfigWithMockEngine("fina_indicator.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getFinaIndicator(
            FinaIndicatorParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "财务指标数据不应为空")
    }

    @Test
    fun testFinaAuditWorks() = test {
        val config = createConfigWithMockEngine("fina_audit.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getFinaAudit(
            FinaAuditParams(
                tsCode = TsCode("000001", "SZ")
            )
        )
        assertNotNull(result, "财务审计意见数据不应为空")
    }

    @Test
    fun testFinaMainbzWorks() = test {
        val config = createConfigWithMockEngine("fina_mainbz.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getFinaMainbz(
            FinaMainbzParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 12, 31)
            )
        )
        assertNotNull(result, "主营业务构成数据不应为空")
    }
} 