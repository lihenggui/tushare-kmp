package li.mercury.tushare

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.client.createHttpClient
import li.mercury.tushare.http.HttpTransport
import li.mercury.tushare.internal.extension.Timeout
import li.mercury.tushare.internal.logging.LogLevel
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import kotlin.time.Duration.Companion.minutes

// 测试用的默认配置，使用固定的测试 token
internal val testConfig: TuShareConfig by lazy {
    TuShareConfig(
        token = "test-token", // 测试中使用固定的 token
        logging = LoggingConfig(logLevel = LogLevel.All),
        timeout = Timeout(socket = 1.minutes)
        // engine 不在这里设置，由具体测试通过 createConfigWithMockEngine 方法指定
    )
}

private fun transport(config: TuShareConfig? = null): HttpTransport {
    return HttpTransport(
        createHttpClient(
            config ?: testConfig
        )
    )
}

fun createMockEngine(responseFileName: String) =
    MockEngine { _ ->
        val file = "src/commonTest/resources/responses/$responseFileName".toPath()
        val content =
            FileSystem.SYSTEM.read(file) {
                readUtf8()
            }
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
    }

abstract class TestTuShare {

    internal fun generateTuShare(
        config: TuShareConfig
    ): TuShareApi {
        return TuShareApi(
            requester = transport(config),
            config = config
        )
    }

    /**
     * 创建带有指定 mock 响应文件的配置
     */
    internal fun createConfigWithMockEngine(responseFileName: String): TuShareConfig {
        return TuShareConfig(
            token = testConfig.token,
            engine = createMockEngine(responseFileName),
            httpClientConfig = testConfig.httpClientConfig
        )
    }

    fun test(testBody: suspend TestScope.() -> Unit) = runTest(timeout = 1.minutes, testBody = testBody)
}
