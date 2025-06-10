package li.mercury.tushare

import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestNews : TestTuShare() {

    @Test
    fun testAnnsDWorks() = test {
        val annsConfig = createConfigWithMockEngine("anns_d.json")
        val tuShareInstance = generateTuShare(annsConfig)

        tuShareInstance.getAnnsD(
            AnnouncementParams(
                tsCode = TsCode("000001", "SZ")
            )
        ).let { result ->
            assertNotNull(result, "公告数据不应为空")
        }
    }
}