package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.board.models.DcHotMarket
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotType
import li.mercury.tushare.api.stock.board.models.LimitListDParams
import li.mercury.tushare.api.stock.board.models.LimitType
import li.mercury.tushare.api.stock.board.models.StkAuctionParams
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.TopInstParams
import li.mercury.tushare.api.stock.board.models.TopListParams
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockBoardApi : TestTuShare() {

    @Test
    fun testDcHotWorks() = test {
        val config = createConfigWithMockEngine("dc_hot.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getDcHot(
            DcHotParams(
                tradeDate = LocalDate(2024, 3, 15),
                market = DcHotMarket.HK_MARKET,
                hotType = DcHotType.POPULARITY,
            )
        )
        assertNotNull(result, "东财热门股票数据不应为空")
    }

    @Test
    fun testThsHotWorks() = test {
        val config = createConfigWithMockEngine("ths_hot.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getThsHot(
            ThsHotParams(
                tradeDate = LocalDate(2024, 3, 15),
                market = "热股",
            )
        )
        assertNotNull(result, "同花顺热门股票数据不应为空")
    }

    @Test
    fun testTopListWorks() = test {
        val config = createConfigWithMockEngine("top_list.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getTopList(
            TopListParams(
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "龙虎榜每日明细数据不应为空")
    }

    @Test
    fun testTopInstWorks() = test {
        val config = createConfigWithMockEngine("top_inst.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getTopInst(
            TopInstParams(
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "龙虎榜机构明细数据不应为空")
    }

    @Test
    fun testLimitListDWorks() = test {
        val config = createConfigWithMockEngine("limit_list_d.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getLimitListD(
            LimitListDParams(
                tradeDate = LocalDate(2018, 7, 16),
                limitType = LimitType.U
            )
        )
        assertNotNull(result, "每日涨跌停统计数据不应为空")
    }

    @Test
    fun testStkAuctionWorks() = test {
        val config = createConfigWithMockEngine("stk_auction.json")
        val tuShareInstance = generateTuShare(config)

        val result = tuShareInstance.getStkAuction(
            StkAuctionParams(
                tradeDate = LocalDate(2018, 7, 16)
            )
        )
        assertNotNull(result, "股票竞价交易数据不应为空")
    }

    // 其他测试方法可以根据需要添加
    // 由于权限限制，很多方法被注释掉了
} 