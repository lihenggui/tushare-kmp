package li.mercury.tushare

import HsMarketType
import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
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
import li.mercury.tushare.api.stock.models.AdjFactorParams
import li.mercury.tushare.api.stock.models.DailyBasicParams
import li.mercury.tushare.api.stock.models.DailyParams
import li.mercury.tushare.api.stock.models.FreqMin
import li.mercury.tushare.api.stock.models.FreqWeekMonth
import li.mercury.tushare.api.stock.models.GgMarketType
import li.mercury.tushare.api.stock.models.GgtDailyParams
import li.mercury.tushare.api.stock.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.models.GgtTop10Params
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsType
import li.mercury.tushare.api.stock.models.HsgtTop10Params
import li.mercury.tushare.api.stock.models.MinsParams
import li.mercury.tushare.api.stock.models.MonthlyParams
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.StkLimitParams
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.SuspendDParams
import li.mercury.tushare.api.stock.models.SuspendType
import li.mercury.tushare.api.stock.models.WeeklyMonthlyAdjParams
import li.mercury.tushare.api.stock.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.models.WeeklyParams
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
                    )
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

    @Test
    fun testHsConstWorks() =
        runTest {
            val client = createClient("hs_const.json")
            client.stock
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

    @Test
    fun testDailyWorks() = runTest {
        val client = createClient("daily.json")
        client.stock.getDaily(
            DailyParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 7, 1),
                endDate = LocalDate(2023, 7, 18)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testMinsWorks() = runTest {
        val client = createClient("mins.json")
        client.stock.getMins(
            MinsParams(
                tsCode = TsCode("600000", "SH"),
                freq = FreqMin.MIN_1,
                startDate = LocalDateTime(2023, 8, 25, 9, 0, 0),
                endDate = LocalDateTime(2023, 8, 25, 19, 0, 0)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testWeeklyWorks() = runTest {
        val client = createClient("weekly.json")
        client.stock.getWeekly(
            WeeklyParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = "20180101",
                endDate = "20181101"
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testMonthlyWorks() = runTest {
        val client = createClient("monthly.json")
        client.stock.getMonthly(
            MonthlyParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 11, 1),
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
    // Test skipped, no permission
    fun testWeeklyMonthlyWorks() = runTest {
        val client = createClient("weekly_monthly.json")
        client.stock.getWeeklyMonthly(
            WeeklyMonthlyParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2023, 1, 1),
                endDate = LocalDate(2023, 7, 1),
                freq = FreqWeekMonth.WEEK,
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
    // Test skipped, no permission
    fun testWeeklyMonthlyAdjWorks() = runTest {
        val client = createClient("weekly_monthly_adj.json")
        client.stock.getWeeklyMonthlyAdj(
            WeeklyMonthlyAdjParams(
                tsCode = TsCode("000001", "SZ"),
                freq = FreqWeekMonth.WEEK,
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testAdjFactorWorks() = runTest {
        val client = createClient("adj_factor.json")
        client.stock.getAdjFactor(
            AdjFactorParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 7, 1),
                endDate = LocalDate(2018, 10, 11),
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testDailyBasicWorks() = runTest {
        val client = createClient("daily_basic.json")
        client.stock.getDailyBasic(
            DailyBasicParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2018, 7, 1),
                endDate = LocalDate(2018, 10, 11),
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testStkLimitWorks() = runTest {
        val client = createClient("stk_limit.json")
        client.stock.getStkLimit(
            StkLimitParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2019, 1, 15),
                endDate = LocalDate(2019, 6, 18),
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testSuspendDWorks() = runTest {
        val client = createClient("suspend_d.json")
        client.stock.getSuspendD(
            SuspendDParams(
                tsCode = TsCode("000001", "SZ"),
                startDate = LocalDate(2020, 1, 1),
                endDate = LocalDate(2020, 3, 12),
                suspendType = SuspendType.SUSPEND
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testHsgtTop10Works() = runTest {
        val client = createClient("hsgt_top10.json")
        client.stock.getHsgtTop10(
            HsgtTop10Params(
                tradeDate = LocalDate(2018, 7, 25),
                hsMarketType = HsMarketType.SH
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    @Test
    fun testGgtTop10Works() = runTest {
        val client = createClient("ggt_top10.json")
        client.stock.getGgtTop10(
            GgtTop10Params(
                tradeDate = LocalDate(2018, 7, 25),
                marketType = GgMarketType.SZ,
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testGgtDailyWorks() = runTest {
        val client = createClient("ggt_daily.json")
        client.stock.getGgtDaily(
            GgtDailyParams(
                startDate = LocalDate(2018, 9, 25),
                endDate = LocalDate(2019, 9, 25)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testGgtMonthlyWorks() = runTest {
        val client = createClient("ggt_monthly.json")
        client.stock.getGgtMonthly(
            GgtMonthlyParams(
                startMonth = "201809",
                endMonth = "201908"
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }
}
