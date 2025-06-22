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
package li.mercury.tushare.misc

import kotlinx.coroutines.test.runTest
import li.mercury.tushare.TestTuShare
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.internal.exception.AuthenticationException
import li.mercury.tushare.internal.exception.PermissionException
import li.mercury.tushare.internal.exception.TuShareAPIException
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class TestException : TestTuShare() {
    @Test
    fun apiError() =
        runTest {
            // 使用mock响应来模拟认证错误
            val config = createConfigWithMockEngine("api_error_40001.json")
            val tuShare = generateTuShare(config)

            val response =
                runCatching {
                    tuShare.getAnnsD(
                        params =
                            AnnouncementParams(
                                tsCode = TsCode("000001", "SZ"),
                            ),
                    )
                }
            assertTrue(response.isFailure)
            val exception = response.exceptionOrNull() as TuShareAPIException

            // 验证异常类型正确识别为认证错误
            assertIs<AuthenticationException>(exception)

            // 验证我们的异常处理为认证错误映射了合适的状态码
            assertEquals(401, exception.statusCode)

            // 验证错误信息包含API错误代码
            assertTrue(
                exception.error.detail
                    ?.code
                    ?.startsWith("api_error_") == true,
                "Error code should start with 'api_error_', but was: ${exception.error.detail?.code}",
            )

            // 验证错误信息不为空
            assertTrue(
                !exception.error.detail.msg
                    .isNullOrBlank(),
                "Error message should not be empty",
            )

            // 验证错误信息包含预期内容
            assertTrue(
                exception.error.detail.msg
                    .contains("invalid api key"),
                "Error message should contain 'invalid api key', but was: ${exception.error.detail.msg}",
            )
        }

    @Test
    fun permissionError() =
        runTest {
            // 使用基于真实响应的mock数据来模拟权限错误
            val config = createConfigWithMockEngine("api_error_40203.json")
            val tuShare = generateTuShare(config)

            val response =
                runCatching {
                    tuShare.getAnnsD(
                        params =
                            AnnouncementParams(
                                tsCode = TsCode("000001", "SZ"),
                            ),
                    )
                }
            assertTrue(response.isFailure)
            val exception = response.exceptionOrNull() as TuShareAPIException

            // 验证异常类型正确识别为权限错误
            assertIs<PermissionException>(exception)

            // 验证我们的异常处理为权限错误映射了合适的状态码
            assertEquals(403, exception.statusCode)

            // 验证错误信息包含API错误代码
            assertTrue(
                exception.error.detail
                    ?.code
                    ?.startsWith("api_error_") == true,
                "Error code should start with 'api_error_', but was: ${exception.error.detail?.code}",
            )

            // 验证错误信息不为空
            assertTrue(
                !exception.error.detail.msg
                    .isNullOrBlank(),
                "Error message should not be empty",
            )

            // 验证错误信息包含中文权限关键词
            assertTrue(
                exception.error.detail.msg
                    .contains("权限"),
                "Error message should contain '权限', but was: ${exception.error.detail.msg}",
            )

            // 验证请求ID被正确保留
            assertEquals(
                "f047f212-91b3-4c4b-a06c-611313e7f69d",
                exception.error.detail.requestId,
                "Request ID should be preserved",
            )
        }
}
