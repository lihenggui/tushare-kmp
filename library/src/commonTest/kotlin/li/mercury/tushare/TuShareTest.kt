package li.mercury.tushare

import app.cash.turbine.test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsType
import li.mercury.tushare.models.Market
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM

class TuShareTest {

    private fun createMockEngine(responseFileName: String) = MockEngine { _ ->
        val file = "src/commonTest/resources/responses/$responseFileName".toPath()
        val content = FileSystem.SYSTEM.read(file) {
            readUtf8()
        }
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private fun createClient(responseFileName: String) = TuShare(
        token = "",
        engine = createMockEngine(responseFileName),
    )

    @Test
    fun testIndexBasicWorks() = runTest {
        val client = createClient("index_basic.json")
        client.index.getIndexBasic(
            IndexBasicParams(
                market = Market.SW
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }

//    @Test
    // Test skipped, no permission
    fun testIndexDailyWorks() = runTest {
        val client = createClient("index_daily.json")
        client.index.getIndexDaily(
            IndexDailyParams(
                tsCode = "399300.SZ"
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
        }
    }

    @Test
    fun testHsConstWorks() = runTest {
        val client = createClient("hs_const.json")
        client.stock.getHsConst(
            HsConstParams(
                hsType = HsType.SH
            )
        ).test {
            val result = awaitItem()
            assertNotNull(result)
            awaitComplete()
        }
    }
}