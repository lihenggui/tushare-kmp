package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockFlowApiTest {
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
    fun testMoneyFlowWorks() =
        runTest {
            val client = createClient("moneyflow.json")
            client.stock.flow
                .getMoneyflowThs(
                    MoneyflowParams(
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2023, 7, 18),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testMoneyFlowThsWorks() =
        runTest {
            val client = createClient("moneyflow_ths.json")
            client.stock.flow
                .getMoneyflowThs(
                    MoneyflowThsParams(
                        startDate = LocalDate(2024, 10, 1),
                        endDate = LocalDate(2024, 10, 11),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testMoneyFlowDcWorks() =
        runTest {
            val client = createClient("moneyflow_dc.json")
            client.stock.flow
                .getMoneyflowDc(
                    MoneyflowDcParams(
                        startDate = LocalDate(2024, 9, 1),
                        endDate = LocalDate(2024, 9, 13),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testMoneyFlowMktDcWorks() =
        runTest {
            val client = createClient("moneyflow_mkt_dc.json")
            client.stock.flow
                .getMoneyflowMktDc(
                    MoneyflowMktDcParams(
                        startDate = LocalDate(2024, 9, 1),
                        endDate = LocalDate(2024, 9, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testMoneyFlowIndDcWorks() =
        runTest {
            val client = createClient("moneyflow_ind_dc.json")
            client.stock.flow
                .getMoneyflowIndDc(
                    MoneyflowIndDcParams(
                        tradeDate = LocalDate(2024, 9, 27),
                        contentType = "行业",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testMoneyFlowIndThsWorks() =
        runTest {
            val client = createClient("moneyflow_ind_ths.json")
            client.stock.flow
                .getMoneyflowIndThs(
                    MoneyflowIndThsParams(
                        tradeDate = LocalDate(2024, 9, 27),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testMoneyFlowHsgtWorks() =
        runTest {
            val client = createClient("moneyflow_hsgt.json")
            client.stock.flow
                .getMoneyflowHsgt(
                    MoneyflowHsgtParams(
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
