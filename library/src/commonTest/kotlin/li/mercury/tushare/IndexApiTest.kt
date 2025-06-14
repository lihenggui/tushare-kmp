package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.index.models.CiDailyParams
import li.mercury.tushare.api.index.models.DailyInfoParams
import li.mercury.tushare.api.index.models.IdxFactorProParams
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexCategory
import li.mercury.tushare.api.index.models.IndexClassifyParams
import li.mercury.tushare.api.index.models.IndexDailyBasicParams
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexGlobalParams
import li.mercury.tushare.api.index.models.IndexMemberAllParams
import li.mercury.tushare.api.index.models.IndexMonthlyParams
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeightParams
import li.mercury.tushare.api.index.models.SwDailyParams
import li.mercury.tushare.api.index.models.SzDailyInfoParams
import li.mercury.tushare.api.index.models.ThsDailyParams
import li.mercury.tushare.api.index.models.TsIndexCode
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.Market
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class IndexApiTest {
    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

    @Test
    fun testIndexBasicWorks() =
        runTest {
            val client = createClient("index_basic.json")
            client.index
                .getIndexBasic(
                    IndexBasicParams(
                        market = Market.SW,
                        category = IndexCategory.主题指数,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIdxFactorProWorks() =
        runTest {
            val client = createClient("idx_factor_pro.json")
            client.index
                .getIdxFactorPro(
                    IdxFactorProParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexMemberAllWorks() =
        runTest {
            val client = createClient("index_member_all.json")
            client.index
                .getIndexMemberAll(
                    IndexMemberAllParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexClassifyWorks() =
        runTest {
            val client = createClient("index_classify.json")
            client.index
                .getIndexClassify(
                    IndexClassifyParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexWeightWorks() =
        runTest {
            val client = createClient("index_weight.json")
            client.index
                .getIndexWeight(
                    IndexWeightParams(
                        indexCode = TsCode("000001", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexDailyBasicWorks() =
        runTest {
            val client = createClient("index_dailybasic.json")
            client.index
                .getIndexDailyBasic(
                    IndexDailyBasicParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testIndexMonthlyWorks() =
        runTest {
            val client = createClient("index_monthly.json")
            client.index
                .getIndexMonthly(
                    IndexMonthlyParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSwDailyWorks() =
        runTest {
            val client = createClient("sw_daily.json")
            client.index
                .getSwDaily(
                    SwDailyParams(
                        tradeDate = LocalDate(2023, 7, 5),
                        tsCode = TsCode("801012", "SI"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSzDailyInfoWorks() =
        runTest {
            val client = createClient("sz_daily_info.json")
            client.index
                .getSzDailyInfo(
                    SzDailyInfoParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testThsDailyWorks() =
        runTest {
            val client = createClient("ths_daily.json")
            client.index
                .getThsDaily(
                    ThsDailyParams(
                        tsCode = TsCode("865001", "TI"),
                        startDate = LocalDate(2020, 1, 1),
                        endDate = LocalDate(2020, 3, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testCiDailyWorks() =
        runTest {
            val client = createClient("ci_daily.json")
            client.index
                .getCiDaily(
                    CiDailyParams(
                        tradeDate = LocalDate(2023, 7, 5),
                        tsCode = TsCode("005002", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testIndexGlobalWorks() =
        runTest {
            val client = createClient("index_global.json")
            client.index
                .getIndexGlobal(
                    IndexGlobalParams(
                        tsCode = TsIndexCode.XIN9,
                        tradeDate = LocalDate(2023, 7, 5),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testDailyInfoWorks() =
        runTest {
            val client = createClient("daily_info.json")
            client.index
                .getDailyInfo(
                    DailyInfoParams(),
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
}
