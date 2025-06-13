package li.mercury.tushare

import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.client.createHttpClient
import li.mercury.tushare.http.HttpTransport
import li.mercury.tushare.internal.extension.Timeout
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.util.createMockEngine
import kotlin.time.Duration.Companion.minutes

// 测试用的默认配置，使用固定的测试 token
internal val testConfig: TuShareConfig by lazy {
    TuShareConfig(
        token = "test-token", // 测试中使用固定的 token
        logging = LoggingConfig(logLevel = LogLevel.All),
        timeout = Timeout(socket = 1.minutes)
    )
}

private fun transport(config: TuShareConfig): HttpTransport {
    require(config.engine != null) { "测试必须提供 MockEngine，请使用 createConfigWithMockEngine 创建配置" }
    return HttpTransport(
        createHttpClient(config)
    )
}

abstract class TestTuShare {

    internal fun generateTuShare(
        config: TuShareConfig
    ): TuShareApi {
        return TuShareApi(
            requester = transport(config)
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
