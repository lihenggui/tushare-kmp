package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockMarginApiTest {
    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

    //    @Test
// Test skipped, no permission
    fun testMarginWorks() =
        runTest {
            val client = createClient("margin.json")
            client.stock.margin
                .getMargin(
                    MarginParams(
                        tradeDate = LocalDate(2018, 8, 2),
                        exchangeId = Exchange.SSE,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testMarginDetailWorks() =
        runTest {
            val client = createClient("margin_detail.json")
            client.stock.margin
                .getMarginDetail(
                    MarginDetailParams(
                        tradeDate = LocalDate(2018, 8, 2),
                        tsCode = TsCode("000001", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testMarginSecsWorks() =
        runTest {
            val client = createClient("margin_secs.json")
            client.stock.margin
                .getMarginSecs(
                    MarginSecsParams(
                        tradeDate = LocalDate(2024, 4, 17),
                        exchange = Exchange.SZSE,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSlbSecWorks() =
        runTest {
            val client = createClient("slb_sec.json")
            client.stock.margin
                .getSlbSec(
                    SlbSecParams(
                        tradeDate = LocalDate(2024, 6, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSlbLenWorks() =
        runTest {
            val client = createClient("slb_len.json")
            client.stock.margin
                .getSlbLen(
                    SlbLenParams(
                        startDate = LocalDate(2024, 6, 1),
                        endDate = LocalDate(2024, 6, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSlbSecDetailWorks() =
        runTest {
            val client = createClient("slb_sec_detail.json")
            client.stock.margin
                .getSlbSecDetail(
                    SlbSecDetailParams(
                        tradeDate = LocalDate(2024, 6, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSlbLenMmWorks() =
        runTest {
            val client = createClient("slb_len_mm.json")
            client.stock.margin
                .getSlbLenMm(
                    SlbLenMmParams(
                        tradeDate = LocalDate(2024, 6, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
