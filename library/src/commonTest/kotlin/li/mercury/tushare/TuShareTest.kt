package li.mercury.tushare

import io.ktor.client.engine.mock.*
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import li.mercury.tushare.models.IndexBasicParams
import li.mercury.tushare.models.Market
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.test.Test

class TuShareTest {
    @Test
    fun testFunctionalityWorks() {
        val file = "src/commonTest/resources/responses/index_basic.json".toPath()
        val content = FileSystem.SYSTEM.read(file) {
            readUtf8()
        }
        val mockEngine = MockEngine { _ ->
            respond(
                content = content,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )

        }
        val client = TuShare(
            token = "5fa9cc7c4f513093745e84597aac90f3249d82ec1567e6aec6442348",
            engine = mockEngine,
        )
        runBlocking {
            client.index.getIndexBasic(
                IndexBasicParams(
                    market = Market.SW
                )
            ).collect {
                println(it)
            }
        }
    }
}