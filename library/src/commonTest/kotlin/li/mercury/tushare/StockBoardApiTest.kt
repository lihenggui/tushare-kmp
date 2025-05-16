package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.KplListTag
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexType
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.models.TsCode
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockBoardApiTest {
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
    // no permission, skip
    fun testDCMEMBERWorks() =
        runTest {
            val client = createClient("dc_member.json")
            client.stock.board
                .getDcMember(
                    DcMemberParams(
                        tradeDate = LocalDate(2025, 1, 2)
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testDCINDEXWorks() =
        runTest {
            val client = createClient("dc_index.json")
            client.stock.board
                .getDcIndex(
                    DcIndexParams(
                        tradeDate = LocalDate(2025, 1, 3)
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testDCHOTWorks() =
        runTest {
            val client = createClient("dc_hot.json")
            client.stock.board
                .getDcHot(
                    DcHotParams(
                        tradeDate = LocalDate(2024, 3, 15),
                        market = "A股市场",
                        hotType = "人气榜"
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testThsIndexWorks() =
        runTest {
            val client = createClient("ths_index.json")
            client.stock.board
                .getThsIndex(
                    ThsIndexParams(
                        type = ThsIndexType.CONCEPT,
                        exchange = "A"
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testThsMemberWorks() =
        runTest {
            val client = createClient("ths_member.json")
            client.stock.board
                .getThsMember(
                    ThsMemberParams(
                        tsCode = TsCode("885800", "TI")
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testThsHotWorks() =
        runTest {
            val client = createClient("ths_hot.json")
            client.stock.board
                .getThsHot(
                    ThsHotParams(
                        tradeDate = LocalDate(2024, 3, 15),
                        market = "热股"
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testKplListWorks() =
        runTest {
            val client = createClient("kpl_list.json")
            client.stock.board
                .getKplList(
                    KplListParams(
                        tradeDate = LocalDate(2024, 9, 27),
                        tag = KplListTag.涨停
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testKplConceptWorks() =
        runTest {
            val client = createClient("kpl_concept.json")
            client.stock.board
                .getKplConcept(
                    KplListParams(
                        tradeDate = LocalDate(2024, 9, 27),
                        tag = KplListTag.涨停
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
