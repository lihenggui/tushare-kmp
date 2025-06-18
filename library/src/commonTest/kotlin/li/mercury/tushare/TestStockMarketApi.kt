package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.FreqMin
import li.mercury.tushare.api.stock.market.models.FreqWeekMonth
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockMarketApi : TestTuShare() {
    @Test
    fun testDailyWorks() =
        test {
            val config = createConfigWithMockEngine("daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDaily(
                    DailyParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "日线行情数据不应为空")
        }

    @Test
    fun testMinsWorks() =
        test {
            val config = createConfigWithMockEngine("mins.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMins(
                    MinsParams(
                        tsCode = TsCode("000001", "SZ"),
                        freq = FreqMin.MIN_60,
                    ),
                )
            assertNotNull(result, "分钟行情数据不应为空")
        }

    @Test
    fun testWeeklyWorks() =
        test {
            val config = createConfigWithMockEngine("weekly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getWeekly(
                    WeeklyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 7, 1),
                        endDate = LocalDate(2018, 7, 31),
                    ),
                )
            assertNotNull(result, "周线行情数据不应为空")
        }

    @Test
    fun testMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMonthly(
                    MonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 7, 31),
                    ),
                )
            assertNotNull(result, "月线行情数据不应为空")
        }

    @Test
    fun testWeeklyMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("weekly_monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getWeeklyMonthly(
                    WeeklyMonthlyParams(
                        tsCode = TsCode("000001", "SZ"),
                        freq = FreqWeekMonth.MONTH,
                    ),
                )
            assertNotNull(result, "股票周/月线行情数据不应为空")
        }

    @Test
    fun testAdjFactorWorks() =
        test {
            val config = createConfigWithMockEngine("adj_factor.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getAdjFactor(
                    AdjFactorParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "复权因子数据不应为空")
        }

    @Test
    fun testSuspendDWorks() =
        test {
            val config = createConfigWithMockEngine("suspend_d.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getSuspendD(
                    SuspendDParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "停复牌信息数据不应为空")
        }

    @Test
    fun testDailyBasicWorks() =
        test {
            val config = createConfigWithMockEngine("daily_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDailyBasic(
                    DailyBasicParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "每日指标数据不应为空")
        }

    @Test
    fun testMoneyflowWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflow(
                    MoneyflowParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "个股资金流向数据不应为空")
        }

    @Test
    fun testStkLimitWorks() =
        test {
            val config = createConfigWithMockEngine("stk_limit.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkLimit(
                    StkLimitParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "每日涨跌停价格数据不应为空")
        }

    @Test
    fun testGgtDailyWorks() =
        test {
            val config = createConfigWithMockEngine("ggt_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtDaily(
                    GgtDailyParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "港股通每日成交统计数据不应为空")
        }

    @Test
    fun testGgtMonthlyWorks() =
        test {
            val config = createConfigWithMockEngine("ggt_monthly.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtMonthly(
                    GgtMonthlyParams(
                        month = "201807",
                    ),
                )
            assertNotNull(result, "港股通每月成交统计数据不应为空")
        }

    @Test
    fun testBakDailyWorks() =
        test {
            val config = createConfigWithMockEngine("bak_daily.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBakDaily(
                    BakDailyParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "备用行情数据不应为空")
        }

    @Test
    fun testHsgtTop10Works() =
        test {
            val config = createConfigWithMockEngine("hsgt_top10.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHsgtTop10(
                    HsgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "沪深股通十大成交股数据不应为空")
        }

    @Test
    fun testGgtTop10Works() =
        test {
            val config = createConfigWithMockEngine("ggt_top10.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getGgtTop10(
                    GgtTop10Params(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "港股通十大成交股数据不应为空")
        }
}
