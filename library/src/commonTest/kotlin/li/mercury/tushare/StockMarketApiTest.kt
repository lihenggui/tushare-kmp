package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.FreqMin
import li.mercury.tushare.api.stock.market.models.FreqWeekMonth
import li.mercury.tushare.api.stock.market.models.GgMarketType
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsMarketType
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.SuspendType
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class StockMarketApiTest {
    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

    @Test
    fun testDailyWorks() =
        runTest {
            val client = createClient("daily.json")
            client.stock.market
                .getDaily(
                    DailyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2023, 7, 18),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testMinsWorks() =
        runTest {
            val client = createClient("mins.json")
            client.stock.market
                .getMins(
                    MinsParams(
                        tsCode = TsCode("600000", "SH"),
                        freq = FreqMin.MIN_1,
                        startDate = LocalDateTime(2023, 8, 25, 9, 0, 0),
                        endDate = LocalDateTime(2023, 8, 25, 19, 0, 0),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testWeeklyWorks() =
        runTest {
            val client = createClient("weekly.json")
            client.stock.market
                .getWeekly(
                    WeeklyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = "20180101",
                        endDate = "20181101",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testMonthlyWorks() =
        runTest {
            val client = createClient("monthly.json")
            client.stock.market
                .getMonthly(
                    MonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 11, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testWeeklyMonthlyWorks() =
        runTest {
            val client = createClient("weekly_monthly.json")
            client.stock.market
                .getWeeklyMonthly(
                    WeeklyMonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2023, 1, 1),
                        endDate = LocalDate(2023, 7, 1),
                        freq = FreqWeekMonth.WEEK,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testAdjFactorWorks() =
        runTest {
            val client = createClient("adj_factor.json")
            client.stock.market
                .getAdjFactor(
                    AdjFactorParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2018, 10, 11),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testDailyBasicWorks() =
        runTest {
            val client = createClient("daily_basic.json")
            client.stock.market
                .getDailyBasic(
                    DailyBasicParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2018, 10, 11),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testStkLimitWorks() =
        runTest {
            val client = createClient("stk_limit.json")
            client.stock.market
                .getStkLimit(
                    StkLimitParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2019, 1, 15),
                        endDate = LocalDate(2019, 6, 18),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testSuspendDWorks() =
        runTest {
            val client = createClient("suspend_d.json")
            client.stock.market
                .getSuspendD(
                    SuspendDParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2020, 1, 1),
                        endDate = LocalDate(2020, 3, 12),
                        suspendType = SuspendType.SUSPEND,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testHsgtTop10Works() =
        runTest {
            val client = createClient("hsgt_top10.json")
            client.stock.market
                .getHsgtTop10(
                    HsgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 25),
                        hsMarketType = HsMarketType.SH,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testGgtTop10Works() =
        runTest {
            val client = createClient("ggt_top10.json")
            client.stock.market
                .getGgtTop10(
                    GgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 25),
                        marketType = GgMarketType.SZ,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testGgtDailyWorks() =
        runTest {
            val client = createClient("ggt_daily.json")
            client.stock.market
                .getGgtDaily(
                    GgtDailyParams(
                        startDate = LocalDate(2018, 9, 25),
                        endDate = LocalDate(2019, 9, 25),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testGgtMonthlyWorks() =
        runTest {
            val client = createClient("ggt_monthly.json")
            client.stock.market
                .getGgtMonthly(
                    GgtMonthlyParams(
                        startMonth = "201809",
                        endMonth = "201908",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testBakDailyWorks() =
        runTest {
            val client = createClient("bak_daily.json")
            client.stock.market
                .getBakDaily(
                    BakDailyParams(
                        tsCode = TsCode("300750", "SZ"),
                        startDate = LocalDate(2021, 1, 1),
                        endDate = LocalDate(2021, 10, 12),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }
}
