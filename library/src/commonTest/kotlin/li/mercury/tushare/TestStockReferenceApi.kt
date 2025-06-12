package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockReferenceApi : TestTuShare() {

    @Test
    fun testTop10HoldersWorks() = test {
        val config = createConfigWithMockEngine("top10_holders.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getTop10Holders(
            Top10HoldersParams(
                tsCode = TsCode("600000", "SH"),
                startDate = LocalDate(2017, 1, 1),
                endDate = LocalDate(2017, 12, 31),
            )
        )
        assertNotNull(result, "前十大股东数据不应为空")
    }

    @Test
    fun testTop10FloatHoldersWorks() = test {
        val config = createConfigWithMockEngine("top10_floatholders.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getTop10FloatHolders(
            Top10FloatHoldersParams(
                tsCode = TsCode("600000", "SH"),
                startDate = LocalDate(2017, 1, 1),
                endDate = LocalDate(2017, 12, 31),
            )
        )
        assertNotNull(result, "前十大流通股东数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testPledgeStatWorks() = test {
        val config = createConfigWithMockEngine("pledge_stat.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getPledgeStat(
            PledgeStatParams(
                tsCode = TsCode("000014", "SZ"),
            )
        )
        assertNotNull(result, "股权质押统计数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testPledgeDetailWorks() = test {
        val config = createConfigWithMockEngine("pledge_detail.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getPledgeDetail(
            PledgeDetailParams(
                tsCode = TsCode("000014", "SZ"),
            )
        )
        assertNotNull(result, "股权质押明细数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testRepurchaseWorks() = test {
        val config = createConfigWithMockEngine("repurchase.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getRepurchase(
            RepurchaseParams(
                startDate = LocalDate(2018, 1, 1),
                endDate = LocalDate(2018, 5, 10),
            )
        )
        assertNotNull(result, "股票回购信息数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testConceptWorks() = test {
        val config = createConfigWithMockEngine("concept.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getConcept(
            ConceptParams(
                src = "ts",
            )
        )
        assertNotNull(result, "概念股分类数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testConceptDetailWorks() = test {
        val config = createConfigWithMockEngine("concept_detail.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getConceptDetail(
            ConceptDetailParams(
                id = "TS2",
            )
        )
        assertNotNull(result, "概念股列表数据不应为空")
    }

    @Test
    fun testShareFloatWorks() = test {
        val config = createConfigWithMockEngine("share_float.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getShareFloat(
            ShareFloatParams(
                tsCode = TsCode("000998", "SZ"),
                annDate = LocalDate(2018, 12, 20),
            )
        )
        assertNotNull(result, "限售股解禁数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testBlockTradeWorks() = test {
        val config = createConfigWithMockEngine("block_trade.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getBlockTrade(
            BlockTradeParams(
                tsCode = TsCode("600436", "SH"),
                tradeDate = LocalDate(2018, 12, 27),
            )
        )
        assertNotNull(result, "大宗交易数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testStockHolderNumberWorks() = test {
        val config = createConfigWithMockEngine("stk_holdernumber.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getStockHolderNumber(
            StockHolderNumberParams(
                tsCode = TsCode("300199", "SZ"),
                startDate = LocalDate(2016, 1, 1),
                endDate2 = LocalDate(2018, 12, 31),
            )
        )
        assertNotNull(result, "股东人数数据不应为空")
    }

    // Test skipped, no permission
    // @Test
    fun testStockHolderTradeWorks() = test {
        val config = createConfigWithMockEngine("stk_holdertrade.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getStockHolderTrade(
            StockHolderTradeParams(
                tsCode = TsCode("002149", "SZ"),
                startDate = LocalDate(2022, 1, 1),
                endDate = LocalDate(2022, 12, 31),
            )
        )
        assertNotNull(result, "股东增减持数据不应为空")
    }
} 