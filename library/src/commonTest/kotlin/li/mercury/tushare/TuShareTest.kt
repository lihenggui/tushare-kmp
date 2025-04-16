package li.mercury.tushare

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
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.CctvNewsParams
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaSzParams
import li.mercury.tushare.api.news.models.MajorNewsParams
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.api.stock.models.BakBasicParams
import li.mercury.tushare.api.stock.models.BalanceSheetParams
import li.mercury.tushare.api.stock.models.BlockTradeParams
import li.mercury.tushare.api.stock.models.CashflowParams
import li.mercury.tushare.api.stock.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.models.CcassHoldParams
import li.mercury.tushare.api.stock.models.ConceptDetailParams
import li.mercury.tushare.api.stock.models.ConceptParams
import li.mercury.tushare.api.stock.models.CyqChipsParams
import li.mercury.tushare.api.stock.models.CyqPerfParams
import li.mercury.tushare.api.stock.models.DisclosureDateParams
import li.mercury.tushare.api.stock.models.DividendParams
import li.mercury.tushare.api.stock.models.ExpressParams
import li.mercury.tushare.api.stock.models.FinaAuditParams
import li.mercury.tushare.api.stock.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.models.FinaMainbzParams
import li.mercury.tushare.api.stock.models.ForecastParams
import li.mercury.tushare.api.stock.models.FreqEnum
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsType
import li.mercury.tushare.api.stock.models.IncomeParams
import li.mercury.tushare.api.stock.models.MainbzType
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NewShareParams
import li.mercury.tushare.api.stock.models.PledgeDetailParams
import li.mercury.tushare.api.stock.models.PledgeStatParams
import li.mercury.tushare.api.stock.models.ReportRcParams
import li.mercury.tushare.api.stock.models.RepurchaseParams
import li.mercury.tushare.api.stock.models.ShareFloatParams
import li.mercury.tushare.api.stock.models.StkAuctionCParams
import li.mercury.tushare.api.stock.models.StkAuctionOParams
import li.mercury.tushare.api.stock.models.StkFactorParams
import li.mercury.tushare.api.stock.models.StkFactorProParams
import li.mercury.tushare.api.stock.models.StkManagersParams
import li.mercury.tushare.api.stock.models.StkNineturnParams
import li.mercury.tushare.api.stock.models.StkPremarketParams
import li.mercury.tushare.api.stock.models.StkRewardsParams
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.models.Top10HoldersParams
import li.mercury.tushare.api.stock.models.TradeCalParams
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
    fun testReportRcWorks() =
        runTest {
            val client = createClient("report_rc.json")
            client.stock
                .getReportRc(
                    ReportRcParams(
                        reportDate = LocalDate(2022, 4, 29),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testAnnsDWorks() =
        runTest {
            val client = createClient("anns_d.json")
            client.news
                .getAnnsD(
                    AnnouncementParams(),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testIrmQaShWorks() =
        runTest {
            val client = createClient("irm_qa_sh.json")
            client.news
                .getIrmQaSh(
                    IrmQaShParams(
                        tradeDate = LocalDate(2025, 2, 12),
                        tsCode = TsCode("601121", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testNewsWorks() =
        runTest {
            val client = createClient("news.json")
            client.news
                .getNews(
                    NewsParams(
                        startDate = LocalDateTime(2025, 2, 12, 9, 0, 0),
                        endDate = LocalDateTime(2025, 2, 12, 9, 10, 0)
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testCctvNewsWorks() =
        runTest {
            val client = createClient("cctv_news.json")
            client.news
                .getCctvNews(
                    CctvNewsParams(date = LocalDate(2025, 2, 12)),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testMajorNewsWorks() =
        runTest {
            val client = createClient("major_news.json")
            client.news
                .getMajorNews(
                    MajorNewsParams(
                        startDate = LocalDateTime(2018, 11, 21, 9, 0, 0),
                        endDate = LocalDateTime(2018, 11, 22, 10, 10, 0),
                        src = "人民网",
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testIrmQaSzWorks() =
        runTest {
            val client = createClient("irm_qa_sz.json")
            client.news
                .getIrmQaSz(
                    IrmQaSzParams(
                        tradeDate = LocalDate(2025, 2, 12),
                        tsCode = TsCode("002254", "SZ"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
//  Test skipped, no permission
    fun testIncomeWorks() =
        runTest {
            val client = createClient("income.json")
            client.stock
                .getIncome(
                    IncomeParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testBalanceSheetWorks() =
        runTest {
            val client = createClient("balancesheet.json")
            client.stock
                .getBalanceSheet(
                    BalanceSheetParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testCashflowWorks() =
        runTest {
            val client = createClient("cashflow.json")
            client.stock
                .getCashflow(
                    CashflowParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 30),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testForecastWorks() =
        runTest {
            val client = createClient("forecast.json")
            client.stock
                .getForecast(
                    ForecastParams(
                        annDate = LocalDate(2019, 1, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testExpressWorks() =
        runTest {
            val client = createClient("express.json")
            client.stock
                .getExpress(
                    ExpressParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testDividendWorks() =
        runTest {
            val client = createClient("dividend.json")
            client.stock
                .getDividend(
                    DividendParams(
                        tsCode = TsCode("600848", "SH"),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
    // Test skipped, no permission
    fun testFinaIndicatorWorks() =
        runTest {
            val client = createClient("fina_indicator.json")
            client.stock
                .getFinaIndicator(
                    FinaIndicatorParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2017, 1, 1),
                        endDate = LocalDate(2018, 8, 1),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testFinaAuditWorks() =
        runTest {
            val client = createClient("fina_audit.json")
            client.stock
                .getFinaAudit(
                    FinaAuditParams(
                        tsCode = TsCode("600000", "SH"),
                        startDate = LocalDate(2010, 1, 1),
                        endDate = LocalDate(2018, 8, 8),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testFinaMainbzWorks() =
        runTest {
            val client = createClient("fina_mainbz.json")
            client.stock
                .getFinaMainbz(
                    FinaMainbzParams(
                        tsCode = TsCode("000627", "SZ"),
                        type = MainbzType.P,
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    //    @Test
// Test skipped, no permission
    fun testDisclosureDateWorks() =
        runTest {
            val client = createClient("disclosure_date.json")
            client.stock
                .getDisclosureDate(
                    DisclosureDateParams(
                        endDate = LocalDate(2018, 12, 31),
                    ),
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    // @Test
    // Test skipped, no permission
    fun testStkPremarketWorks() = runTest {
        val client = createClient("stk_premarket.json")
        client.stock
            .getStkPremarket(
                StkPremarketParams(
                    tradeDate = LocalDate(2025, 1, 1),
                )
            ).test {
                val result = awaitItem()
                assertNotNull(result)
                awaitComplete()
            }
    }

    //    @Test
    // Test skipped, no permission
    fun testTradeCalWorks() = runTest {
        val client = createClient("trade_cal.json")
        client.stock.getTradeCal(
            TradeCalParams(
                exchange = Exchange.SSE,
                startDate = LocalDate(2023, 1, 31),
                endDate = LocalDate(2023, 2, 1),
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
//    Test skipped, no permission
    fun testStkManagersWorks() = runTest {
        val client = createClient("stk_managers.json")
        client.stock
            .getStkManagers(
                StkManagersParams(
                    tsCode = TsCode("000001", "SZ")
                )
            ).test {
                val result = awaitItem()
                assertNotNull(result)
                awaitComplete()
            }
    }

    //    @Test
//    Test skipped, no permission
    fun testStkRewardsWorks() = runTest {
        val client = createClient("stk_rewards.json")
        client.stock
            .getStkRewards(
                StkRewardsParams(
                    tsCode = TsCode("000001", "SZ")
                )
            ).test {
                val result = awaitItem()
                assertNotNull(result)
                awaitComplete()
            }
    }

    @Test
    fun testNewShareWorks() = runTest {
        val client = createClient("new_share.json")
        client.stock
            .getNewShare(
                NewShareParams(
                    startDate = LocalDate(2018, 9, 1),
                    endDate = LocalDate(2018, 10, 18)
                )
            ).test {
                val result = awaitItem()
                assertNotNull(result)
                awaitComplete()
            }
    }

    @Test
    fun testBakBasicWorks() = runTest {
        val client = createClient("bak_basic.json")
        client.stock
            .getBakBasic(
                BakBasicParams(
                    tradeDate = LocalDate(2021, 10, 12),
                    tsCode = TsCode("300605", "SZ")
                )
            ).test {
                val result = awaitItem()
                assertNotNull(result)
                awaitComplete()
            }
    }

    @Test
    fun testTop10HoldersWorks() =
        runTest {
            val client = createClient("top10_holders.json")
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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
            client.stock
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

    @Test
    fun testCyqPerfWorks() =
        runTest {
            val client = createClient("cyq_perf.json")
            client.stock
                .getCyqPerf(
                    CyqPerfParams(
                        tsCode = TsCode("600000", "SH"),
                        tradeDate = LocalDate(2022, 4, 29)
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
            client.stock
                .getCyqChips(
                    CyqChipsParams(
                        tsCode = TsCode("600000", "SH"),
                        tradeDate = LocalDate(2022, 4, 29)
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
            client.stock
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
            client.stock
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
            client.stock
                .getCcassHold(
                    CcassHoldParams(
                        tsCode = TsCode.hk("00960"),
                        tradeDate = LocalDate(2022, 5, 19)
                    )
                ).test {
                    val result = awaitItem()
                    assertNotNull(result)
                    awaitComplete()
                }
        }

    @Test
    fun testCcassHoldDetailWorks() = runTest {
        val client = createClient("ccass_hold_detail.json")
        client.stock.getCcassHoldDetail(
            CcassHoldDetailParams(
                tsCode = TsCode.hk("00960"),
                tradeDate = LocalDate(2022, 5, 19)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testStkAuctionOWorks() = runTest {
        val client = createClient("stk_auction_o.json")
        client.stock.getStkAuctionO(
            StkAuctionOParams(
                tradeDate = LocalDate(2024, 11, 22)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testStkAuctionCWorks() = runTest {
        val client = createClient("stk_auction_c.json")
        client.stock.getStkAuctionC(
            StkAuctionCParams(
                tradeDate = LocalDate(2024, 11, 22)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

    //    @Test
// Test skipped, no permission
    fun testStkNineturnWorks() = runTest {
        val client = createClient("stk_nineturn.json")
        client.stock.getStkNineturn(
            StkNineturnParams(
                tsCode = TsCode("000001", "SZ"),
                freq = FreqEnum.DAILY,
                startDate = LocalDate(2023, 1, 1),
                endDate = LocalDate(2025, 1, 17)
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }
}
