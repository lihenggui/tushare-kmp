package li.mercury.tushare.util

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.io.buffered
import kotlinx.io.readString
import li.mercury.tushare.internal.TestFileSystem
import li.mercury.tushare.internal.testResponsePath

fun createMockEngine(responseFileName: String) =
    MockEngine { _ ->
        val content = readResponseFromResources(responseFileName)
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
    }

fun readResponseFromResources(fileName: String): String {
    val fs = FileSource(path = testResponsePath(fileName), fileSystem = TestFileSystem)
    return fs.source.buffered().readString()
}
