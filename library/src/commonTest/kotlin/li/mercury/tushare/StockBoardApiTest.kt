package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.board.models.DcHotMarket
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotType
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.HmDetailParams
import li.mercury.tushare.api.stock.board.models.HmListParams
import li.mercury.tushare.api.stock.board.models.KplConceptConsParams
import li.mercury.tushare.api.stock.board.models.KplConceptParams
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.KplListTag
import li.mercury.tushare.api.stock.board.models.LimitCptListParams
import li.mercury.tushare.api.stock.board.models.LimitListDParams
import li.mercury.tushare.api.stock.board.models.LimitListThsParams
import li.mercury.tushare.api.stock.board.models.LimitStepParams
import li.mercury.tushare.api.stock.board.models.LimitType
import li.mercury.tushare.api.stock.board.models.LimitTypeEnum
import li.mercury.tushare.api.stock.board.models.StkAuctionParams
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexType
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.TopInstParams
import li.mercury.tushare.api.stock.board.models.TopListParams
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockBoardApiTest {
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
                        tradeDate = LocalDate(2025, 1, 2),
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
                        tradeDate = LocalDate(2025, 1, 3),
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
                        market = DcHotMarket.HK_MARKET,
                        hotType = DcHotType.POPULARITY,
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
                        exchange = "A",
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
                        tsCode = TsCode("885800", "TI"),
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
                        market = "热股",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testKplListWorks() =
        runTest {
            val client = createClient("kpl_list.json")
            client.stock.board
                .getKplList(
                    KplListParams(
                        tradeDate = LocalDate(2024, 9, 27),
                        tag = KplListTag.涨停,
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
                    KplConceptParams(
                        tradeDate = LocalDate(2024, 9, 27),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testKplConceptConsWorks() =
        runTest {
            val client = createClient("kpl_concept_cons.json")
            client.stock.board
                .getKplConceptCons(
                    KplConceptConsParams(
                        tradeDate = LocalDate(2024, 10, 14),
                        tsCode = TsCode("000111", "KP"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testStkAuctionWorks() =
        runTest {
            val client = createClient("stk_auction.json")
            client.stock.board
                .getStkAuction(
                    StkAuctionParams(
                        tradeDate = LocalDate(2025, 2, 18),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testLimitCptListWorks() =
        runTest {
            val client = createClient("limit_cpt_list.json")
            client.stock.board
                .getLimitCptList(
                    LimitCptListParams(
                        tradeDate = LocalDate(2024, 11, 27),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// no permission, skip
    fun testLimitListDWorks() =
        runTest {
            val client = createClient("limit_list_d.json")
            client.stock.board
                .getLimitListD(
                    LimitListDParams(
                        tradeDate = LocalDate(2022, 6, 15),
                        limitType = LimitType.U,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testLimitListThsWorks() =
        runTest {
            val client = createClient("limit_list_ths.json")
            client.stock.board
                .getLimitListThs(
                    LimitListThsParams(
                        tradeDate = LocalDate(2024, 11, 25),
                        limitType = LimitTypeEnum.LIMIT_UP_POOL,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testHmListWorks() =
        runTest {
            val client = createClient("hm_list.json")
            client.stock.board
                .getHmList(
                    HmListParams(
                        name = "龙飞虎",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testHmDetailWorks() =
        runTest {
            val client = createClient("hm_detail.json")
            client.stock.board
                .getHmDetail(
                    HmDetailParams(
                        tradeDate = LocalDate(2023, 8, 15),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testLimitStepWorks() =
        runTest {
            val client = createClient("limit_step.json")
            client.stock.board
                .getLimitStep(
                    LimitStepParams(
                        tradeDate = LocalDate(2024, 11, 25),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// no permission, skip
    fun testTopInstWorks() =
        runTest {
            val client = createClient("limit_step.json")
            client.stock.board
                .getTopInst(
                    TopInstParams(
                        tradeDate = LocalDate(2024, 11, 25),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // no permission, skip
    fun testTopListWorks() =
        runTest {
            val client = createClient("top_list.json")
            client.stock.board
                .getTopList(
                    TopListParams(
                        tradeDate = LocalDate(2018, 9, 28),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
