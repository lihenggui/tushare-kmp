/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
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
        timeout = Timeout(socket = 1.minutes),
    )
}

private fun transport(config: TuShareConfig): HttpTransport {
    require(config.engine != null) { "测试必须提供 MockEngine，请使用 createConfigWithMockEngine 创建配置" }
    return HttpTransport(
        createHttpClient(config),
    )
}

abstract class TestTuShare {
    internal fun generateTuShare(config: TuShareConfig): TuShareApi =
        TuShareApi(
            requester = transport(config),
        )

    /**
     * 创建带有指定 mock 响应文件的配置
     */
    internal fun createConfigWithMockEngine(responseFileName: String): TuShareConfig =
        TuShareConfig(
            token = testConfig.token,
            engine = createMockEngine(responseFileName),
            httpClientConfig = testConfig.httpClientConfig,
        )

    fun test(testBody: suspend TestScope.() -> Unit) = runTest(timeout = 1.minutes, testBody = testBody)
}
