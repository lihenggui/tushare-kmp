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
package li.mercury.tushare.plugins

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.contentType
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import li.mercury.tushare.client.JsonLenient
import li.mercury.tushare.models.TuShareRequest
import kotlin.test.Test
import kotlin.test.assertEquals

class AuthPluginTest {
    private val testToken = "test-token-123"
    private val testJson =
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }

    @Test
    fun testTokenAddedToRequest() =
        runTest {
            // Create a mock engine that captures the request body
            var capturedRequest: String? = null
            val mockEngine =
                MockEngine { request ->
                    // Capture the request body content
                    if (request.body is TextContent) {
                        capturedRequest = (request.body as TextContent).text
                    }
                    respond(
                        content = ByteReadChannel("""{"data": {"items": []}}"""),
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type", "application/json"),
                    )
                }

            // Create a client with the AuthPlugin installed
            val client =
                HttpClient(mockEngine) {
                    install(ContentNegotiation) {
                        register(ContentType.Application.Json, KotlinxSerializationConverter(JsonLenient))
                    }
                    install(AuthPlugin) {
                        token = testToken
                        json = testJson
                    }
                }

            // Create a request without a token
            val request =
                TuShareRequest(
                    apiName = "test_api",
                    token = "", // Empty token
                    params = mapOf("param1" to "value1"),
                    fields = "field1,field2",
                )

            // Send the request
            client.post("https://api.tushare.pro") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }

            // Verify that the token was added to the request
            val expectedRequestWithToken =
                testJson.encodeToString(
                    TuShareRequest.serializer(),
                    request.copy(token = testToken),
                )
            assertEquals(expectedRequestWithToken, capturedRequest)
        }

    @Test
    fun testTokenOverridesExistingToken() =
        runTest {
            // Create a mock engine that captures the request body
            var capturedRequest: String? = null
            val mockEngine =
                MockEngine { request ->
                    // Capture the request body content
                    if (request.body is TextContent) {
                        capturedRequest = (request.body as TextContent).text
                    }
                    respond(
                        content = ByteReadChannel("""{"data": {"items": []}}"""),
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type", "application/json"),
                    )
                }

            // Create a client with the AuthPlugin installed
            val client =
                HttpClient(mockEngine) {
                    install(ContentNegotiation) {
                        register(ContentType.Application.Json, KotlinxSerializationConverter(JsonLenient))
                    }
                    install(AuthPlugin) {
                        token = testToken
                        json = testJson
                    }
                }

            // Create a request with an existing token
            val existingToken = "existing-token"
            val request =
                TuShareRequest(
                    apiName = "test_api",
                    token = existingToken, // Existing token
                    params = mapOf("param1" to "value1"),
                    fields = "field1,field2",
                )

            // Send the request
            client.post("https://api.tushare.pro") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }

            // Verify that the token was overridden
            val expectedRequestWithToken =
                testJson.encodeToString(
                    TuShareRequest.serializer(),
                    request.copy(token = testToken),
                )
            assertEquals(expectedRequestWithToken, capturedRequest)
        }

    @Test
    fun testNonTuShareRequestNotModified() =
        runTest {
            // Create a mock engine that captures the request body
            var capturedRequest: String? = null
            val mockEngine =
                MockEngine { request ->
                    // Capture the request body content
                    if (request.body is TextContent) {
                        capturedRequest = (request.body as TextContent).text
                    }
                    respond(
                        content = ByteReadChannel("""{"result": "success"}"""),
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type", "application/json"),
                    )
                }

            // Create a client with the AuthPlugin installed
            val client =
                HttpClient(mockEngine) {
                    install(ContentNegotiation) {
                        register(ContentType.Application.Json, KotlinxSerializationConverter(JsonLenient))
                    }
                    install(AuthPlugin) {
                        token = testToken
                        json = testJson
                    }
                }

            // Create a non-TuShareRequest object
            @Serializable
            data class OtherRequest(
                val key: String,
            )
            val request = OtherRequest("value")

            // Send the request
            client.post("https://api.tushare.pro") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }

            // Verify that the request was not modified
            val expectedRequest =
                testJson.encodeToString(
                    OtherRequest.serializer(),
                    request,
                )
            assertEquals(expectedRequest, capturedRequest)
        }
}
