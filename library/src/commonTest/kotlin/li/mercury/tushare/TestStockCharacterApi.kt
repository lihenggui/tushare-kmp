package li.mercury.tushare

import kotlinx.datetime.LocalDate
import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockCharacterApi : TestTuShare() {
    @Test
    fun testStkSurvWorks() =
        test {
            val config = createConfigWithMockEngine("stk_surv.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkSurv(
                    StkSurvParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "股票技术面统计数据不应为空")
        }

    @Test
    fun testBrokerRecommendWorks() =
        test {
            val config = createConfigWithMockEngine("broker_recommend.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBrokerRecommend(
                    BrokerRecommendParams(
                        month = "201801",
                    ),
                )
            assertNotNull(result, "券商推荐池数据不应为空")
        }

    @Test
    fun testStkFactorWorks() =
        test {
            val config = createConfigWithMockEngine("stk_factor.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getStkFactor(
                    StkFactorParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "股票技术因子数据不应为空")
        }

    @Test
    fun testCcassHoldWorks() =
        test {
            val config = createConfigWithMockEngine("ccass_hold.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCcassHold(
                    CcassHoldParams(
                        tsCode = TsCode("00700", "HK"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "中央结算系统持股汇总数据不应为空")
        }

    @Test
    fun testCcassHoldDetailWorks() =
        test {
            val config = createConfigWithMockEngine("ccass_hold_detail.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCcassHoldDetail(
                    CcassHoldDetailParams(
                        tsCode = TsCode("00700", "HK"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "中央结算系统持股明细数据不应为空")
        }

    @Test
    fun testHkHoldWorks() =
        test {
            val config = createConfigWithMockEngine("hk_hold.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getHkHold(
                    HkHoldParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "沪深港股通持股明细数据不应为空")
        }
}
