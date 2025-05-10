package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.models.TsCode
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockReferenceApiTest {
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
    fun testTop10HoldersWorks() =
        runTest {
            val client = createClient("top10_holders.json")
            client.stock.reference
                .getTop10Holders(
                    Top10HoldersParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2017, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testTop10FloatHoldersWorks() =
        runTest {
            val client = createClient("top10_floatholders.json")
            client.stock.reference
                .getTop10FloatHolders(
                    Top10FloatHoldersParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2017, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testPledgeStatWorks() =
        runTest {
            val client = createClient("pledge_stat.json")
            client.stock.reference
                .getPledgeStat(
                    PledgeStatParams(
                        tsCode = TsCode("000014", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testPledgeDetailWorks() =
        runTest {
            val client = createClient("pledge_detail.json")
            client.stock.reference
                .getPledgeDetail(
                    PledgeDetailParams(
                        tsCode = TsCode("000014", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testRepurchaseWorks() =
        runTest {
            val client = createClient("repurchase.json")
            client.stock.reference
                .getRepurchase(
                    RepurchaseParams(
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 5, 10),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testConceptWorks() =
        runTest {
            val client = createClient("concept.json")
            client.stock.reference
                .getConcept(
                    ConceptParams(
                        src = "ts",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    // @Test
    // Test skipped, no permission
    fun testConceptDetailWorks() =
        runTest {
            val client = createClient("concept_detail.json")
            client.stock.reference
                .getConceptDetail(
                    ConceptDetailParams(
                        id = "TS2",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testShareFloatWorks() =
        runTest {
            val client = createClient("share_float.json")
            client.stock.reference
                .getShareFloat(
                    ShareFloatParams(
                        tsCode = TsCode("000998", "SZ"),
                        annDate = LocalDate(2018, 12, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testBlockTradeWorks() =
        runTest {
            val client = createClient("block_trade.json")
            client.stock.reference
                .getBlockTrade(
                    BlockTradeParams(
                        tsCode = TsCode("600436", "SH"),
                        tradeDate = LocalDate(2018, 12, 27),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStockHolderNumberWorks() =
        runTest {
            val client = createClient("stk_holdernumber.json")
            client.stock.reference
                .getStockHolderNumber(
                    StockHolderNumberParams(
                        tsCode = TsCode("300199", "SZ"),
                        startDate = LocalDate(2016, 1, 1),
                        endDate2 = LocalDate(2018, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStockHolderTradeWorks() =
        runTest {
            val client = createClient("stk_holdertrade.json")
            client.stock.reference
                .getStockHolderTrade(
                    StockHolderTradeParams(
                        tsCode = TsCode("002149", "SZ"),
                        startDate = LocalDate(2022, 1, 1),
                        endDate = LocalDate(2022, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
