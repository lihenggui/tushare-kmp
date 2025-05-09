package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.CashflowParams
import li.mercury.tushare.api.stock.finance.models.DisclosureDateParams
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.api.stock.finance.models.MainbzType
import li.mercury.tushare.models.TsCode
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockFinanceApiTest {
    private fun createMockEngine(responseFileName: String) =
        MockEngine { _ ->
            val file = "src/commonTest/resources/responses/$responseFileName".toPath()
            val content =
                FileSystem.SYSTEM.read(file) {
                    readUtf8()
                }
            respond(
                content = content,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        }

    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

    //    @Test
//  Test skipped, no permission
    fun testIncomeWorks() =
        runTest {
            val client = createClient("income.json")
            client.stock.finance
                .getIncome(
                    IncomeParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testBalanceSheetWorks() =
        runTest {
            val client = createClient("balancesheet.json")
            client.stock.finance
                .getBalanceSheet(
                    BalanceSheetParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testCashflowWorks() =
        runTest {
            val client = createClient("cashflow.json")
            client.stock.finance
                .getCashflow(
                    CashflowParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testForecastWorks() =
        runTest {
            val client = createClient("forecast.json")
            client.stock.finance
                .getForecast(
                    ForecastParams(
                        annDate = LocalDate(2019, 1, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testExpressWorks() =
        runTest {
            val client = createClient("express.json")
            client.stock.finance
                .getExpress(
                    ExpressParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testDividendWorks() =
        runTest {
            val client = createClient("dividend.json")
            client.stock.finance
                .getDividend(
                    DividendParams(
                        tsCode = TsCode("600848", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testFinaIndicatorWorks() =
        runTest {
            val client = createClient("fina_indicator.json")
            client.stock.finance
                .getFinaIndicator(
                    FinaIndicatorParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2018, 8, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testFinaAuditWorks() =
        runTest {
            val client = createClient("fina_audit.json")
            client.stock.finance
                .getFinaAudit(
                    FinaAuditParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2010, 1, 1),
                        endDate = LocalDate(2018, 8, 8),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testFinaMainbzWorks() =
        runTest {
            val client = createClient("fina_mainbz.json")
            client.stock.finance
                .getFinaMainbz(
                    FinaMainbzParams(
                        tsCode = TsCode("000627", "SZ"),
                        type = MainbzType.P,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testDisclosureDateWorks() =
        runTest {
            val client = createClient("disclosure_date.json")
            client.stock.finance
                .getDisclosureDate(
                    DisclosureDateParams(
                        endDate = LocalDate(2018, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
