package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsType
import li.mercury.tushare.api.stock.basic.models.ListStatus
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockBasicApi : TestTuShare() {
    @Test
    fun testStockBasicWorks() =
        test {
            val config = createConfigWithMockEngine("stock_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockBasic(
                    StockBasicParams(
                        listStatus = ListStatus.L,
                        exchange = Exchange.SZSE,
                    ),
                )
            assertNotNull(result, "股票基本信息数据不应为空")
        }

    @Test
    fun testHsConstWorks() =
        test {
            val config = createConfigWithMockEngine("hs_const.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHsConst(
                    HsConstParams(
                        hsType = HsType.SZ,
                    ),
                )
            assertNotNull(result, "沪深股通成分股数据不应为空")
        }

    @Test
    fun testNameChangeWorks() =
        test {
            val config = createConfigWithMockEngine("name_change.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getNameChange(
                    NameChangeParams(
                        tsCode = TsCode("600519", "SH"),
                    ),
                )
            assertNotNull(result, "股票曾用名数据不应为空")
        }

    @Test
    fun testStockCompanyWorks() =
        test {
            val config = createConfigWithMockEngine("stock_company.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStockCompany(
                    StockCompanyParams(
                        exchange = Exchange.SZSE,
                    ),
                )
            assertNotNull(result, "上市公司基本信息数据不应为空")
        }

    // Test skipped, no permission
    // @Test
    fun testStkPremarketWorks() =
        test {
            val config = createConfigWithMockEngine("stk_premarket.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkPremarket(
                    StkPremarketParams(
                        tradeDate = LocalDate(2025, 1, 1),
                    ),
                )
            assertNotNull(result, "股票盘前数据不应为空")
        }

    // Test skipped, no permission
    // @Test
    fun testTradeCalWorks() =
        test {
            val config = createConfigWithMockEngine("trade_cal.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getTradeCal(
                    TradeCalParams(
                        exchange = Exchange.SSE,
                        startDate = LocalDate(2023, 1, 31),
                        endDate = LocalDate(2023, 2, 1),
                    ),
                )
            assertNotNull(result, "交易日历数据不应为空")
        }

    // Test skipped, no permission
    // @Test
    fun testStkManagersWorks() =
        test {
            val config = createConfigWithMockEngine("stk_managers.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkManagers(
                    StkManagersParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "上市公司管理层数据不应为空")
        }

    // Test skipped, no permission
    // @Test
    fun testStkRewardsWorks() =
        test {
            val config = createConfigWithMockEngine("stk_rewards.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkRewards(
                    StkRewardsParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "管理层薪酬和持股数据不应为空")
        }

    @Test
    fun testNewShareWorks() =
        test {
            val config = createConfigWithMockEngine("new_share.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getNewShare(
                    NewShareParams(
                        startDate = LocalDate(2018, 9, 1),
                        endDate = LocalDate(2018, 10, 18),
                    ),
                )
            assertNotNull(result, "IPO新股列表数据不应为空")
        }

    @Test
    fun testBakBasicWorks() =
        test {
            val config = createConfigWithMockEngine("bak_basic.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBakBasic(
                    BakBasicParams(
                        tradeDate = LocalDate(2021, 10, 12),
                        tsCode = TsCode("300605", "SZ"),
                    ),
                )
            assertNotNull(result, "备用列表数据不应为空")
        }
}
