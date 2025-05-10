package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsType
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockBasicApiTest {
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
    fun testHsConstWorks() =
        runTest {
            val client = createClient("hs_const.json")
            client.stockBasic
                .getHsConst(
                    HsConstParams(
                        hsType = HsType.SZ,
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
            client.stockBasic
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
            client.stockBasic
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

    // @Test
    // Test skipped, no permission
    fun testStkPremarketWorks() =
        runTest {
            val client = createClient("stk_premarket.json")
            client.stockBasic
                .getStkPremarket(
                    StkPremarketParams(
                        tradeDate = LocalDate(2025, 1, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testTradeCalWorks() =
        runTest {
            val client = createClient("trade_cal.json")
            client.stockBasic
                .getTradeCal(
                    TradeCalParams(
                        exchange = Exchange.SSE,
                        startDate = LocalDate(2023, 1, 31),
                        endDate = LocalDate(2023, 2, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
//    Test skipped, no permission
    fun testStkManagersWorks() =
        runTest {
            val client = createClient("stk_managers.json")
            client.stockBasic
                .getStkManagers(
                    StkManagersParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
//    Test skipped, no permission
    fun testStkRewardsWorks() =
        runTest {
            val client = createClient("stk_rewards.json")
            client.stockBasic
                .getStkRewards(
                    StkRewardsParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testNewShareWorks() =
        runTest {
            val client = createClient("new_share.json")
            client.stockBasic
                .getNewShare(
                    NewShareParams(
                        startDate = LocalDate(2018, 9, 1),
                        endDate = LocalDate(2018, 10, 18),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testBakBasicWorks() =
        runTest {
            val client = createClient("bak_basic.json")
            client.stockBasic
                .getBakBasic(
                    BakBasicParams(
                        tradeDate = LocalDate(2021, 10, 12),
                        tsCode = TsCode("300605", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
