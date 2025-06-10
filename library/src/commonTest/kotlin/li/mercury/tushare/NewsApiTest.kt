package li.mercury.tushare

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.CctvNewsParams
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaSzParams
import li.mercury.tushare.api.news.models.MajorNewsParams
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.api.util.createMockEngine
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class NewsApiTest {
    private fun createClient(responseFileName: String) =
        TuShare(
            token = "",
            engine = createMockEngine(responseFileName),
        )

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
                        endDate = LocalDateTime(2025, 2, 12, 9, 10, 0),
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
}
