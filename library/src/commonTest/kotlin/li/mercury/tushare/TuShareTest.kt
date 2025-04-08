package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsType
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.Market
import li.mercury.tushare.models.TsCode
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class TuShareTest {
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

    @Test
    fun testStockBasicWorks() =
        runTest {
            val client = createClient("stock_basic.json")
            client.stock
                .getStockBasic(
                    StockBasicParams(
                        exchange = Exchange.SSE,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testIndexBasicWorks() =
        runTest {
            val client = createClient("index_basic.json")
            client.index
                .getIndexBasic(
                    IndexBasicParams(
                        market = Market.SSE,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexWeeklyWorks() =
        runTest {
            val client = createClient("index_weekly.json")
            client.index
                .getIndexWeekly(
                    IndexWeeklyParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexDailyWorks() =
        runTest {
            val client = createClient("index_daily.json")
            client.index
                .getIndexDaily(
                    IndexDailyParams(
                        tsCode = TsCode("000001", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testHsConstWorks() =
        runTest {
            val client = createClient("hs_const.json")
            client.stock
                .getHsConst(
                    HsConstParams(
                        hsType = HsType.SH,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testNameChangeWorks() =
        runTest {
            val client = createClient("name_change.json")
            client.stock
                .getNameChange(
                    NameChangeParams(
                        tsCode = TsCode("600519", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testStockCompanyWorks() =
        runTest {
            val client = createClient("stock_company.json")
            client.stock
                .getStockCompany(
                    StockCompanyParams(
                        exchange = Exchange.SZSE,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
