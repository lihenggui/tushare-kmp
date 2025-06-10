package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.CyqChipsParams
import li.mercury.tushare.api.stock.character.models.CyqPerfParams
import li.mercury.tushare.api.stock.character.models.FreqEnum
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.StkAuctionCParams
import li.mercury.tushare.api.stock.character.models.StkAuctionOParams
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkFactorProParams
import li.mercury.tushare.api.stock.character.models.StkNineturnParams
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockCharacterApiTest {
    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

    @Test
    fun testCyqPerfWorks() =
        runTest {
            val client = createClient("cyq_perf.json")
            client.stock.character
                .getCyqPerf(
                    CyqPerfParams(
                        tsCode = TsCode("600000", "SH"),
                        tradeDate = LocalDate(2022, 4, 29),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testCyqChipsWorks() =
        runTest {
            val client = createClient("cyq_chips.json")
            client.stock.character
                .getCyqChips(
                    CyqChipsParams(
                        tsCode = TsCode("600000", "SH"),
                        tradeDate = LocalDate(2022, 4, 29),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testStkFactorWorks() =
        runTest {
            val client = createClient("stk_factor.json")
            client.stock.character
                .getStkFactor(
                    StkFactorParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2022, 5, 1),
                        endDate = LocalDate(2022, 5, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStkFactorProWorks() =
        runTest {
            val client = createClient("stk_factor_pro.json")
            client.stock.character
                .getStkFactorPro(
                    StkFactorProParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2022, 5, 1),
                        endDate = LocalDate(2022, 5, 20),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testCcassHoldWorks() =
        runTest {
            val client = createClient("ccass_hold.json")
            client.stock.character
                .getCcassHold(
                    CcassHoldParams(
                        tsCode = TsCode.hk("00960"),
                        tradeDate = LocalDate(2022, 5, 19),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testCcassHoldDetailWorks() =
        runTest {
            val client = createClient("ccass_hold_detail.json")
            client.stock.character
                .getCcassHoldDetail(
                    CcassHoldDetailParams(
                        tsCode = TsCode.hk("00960"),
                        tradeDate = LocalDate(2022, 5, 19),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStkAuctionOWorks() =
        runTest {
            val client = createClient("stk_auction_o.json")
            client.stock.character
                .getStkAuctionO(
                    StkAuctionOParams(
                        tradeDate = LocalDate(2024, 11, 22),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStkAuctionCWorks() =
        runTest {
            val client = createClient("stk_auction_c.json")
            client.stock.character
                .getStkAuctionC(
                    StkAuctionCParams(
                        tradeDate = LocalDate(2024, 11, 22),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStkNineturnWorks() =
        runTest {
            val client = createClient("stk_nineturn.json")
            client.stock.character
                .getStkNineturn(
                    StkNineturnParams(
                        tsCode = TsCode("000001", "SZ"),
                        freq = FreqEnum.DAILY,
                        startDate = LocalDate(2023, 1, 1),
                        endDate = LocalDate(2025, 1, 17),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testStkSurvWorks() =
        runTest {
            val client = createClient("stk_surv.json")
            client.stock.character
                .getStkSurv(
                    StkSurvParams(
                        tsCode = TsCode("002223", "SZ"),
                        tradeDate = LocalDate(2021, 10, 24),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testBrokerRecommendWorks() =
        runTest {
            val client = createClient("broker_recommend.json")
            client.stock.character
                .getBrokerRecommend(
                    BrokerRecommendParams(
                        month = "202106",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testHkHoldWorks() =
        runTest {
            val client = createClient("hk_hold.json")
            client.stock.character
                .getHkHold(
                    HkHoldParams(
                        exchange = Exchange.SH,
                        tradeDate = LocalDate(2019, 6, 25),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
