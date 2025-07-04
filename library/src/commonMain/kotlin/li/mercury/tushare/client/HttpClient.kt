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
package li.mercury.tushare.client

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.ProxyBuilder
import io.ktor.client.engine.http
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.util.appendIfNameAbsent
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import li.mercury.tushare.internal.extension.toKtorLogLevel
import li.mercury.tushare.internal.extension.toKtorLogger
import li.mercury.tushare.plugins.AuthPlugin
import kotlin.time.DurationUnit

/**
 * Default Http Client.
 */
@OptIn(InternalAPI::class, ExperimentalSerializationApi::class)
internal fun createHttpClient(config: TuShareConfig): HttpClient {
    val configuration: HttpClientConfig<*>.() -> Unit = {
        engine {
            config.proxy?.let { proxyConfig ->
                proxy =
                    when (proxyConfig) {
                        is ProxyConfig.Http -> ProxyBuilder.http(proxyConfig.url)
                        is ProxyConfig.Socks -> ProxyBuilder.socks(proxyConfig.host, proxyConfig.port)
                    }
            }
        }

        install(ContentNegotiation) {
            register(ContentType.Application.Json, KotlinxSerializationConverter(JsonLenient))
        }

        install(AuthPlugin) {
            token = config.token
            json = JsonLenient
        }

        install(Logging) {
            val logging = config.logging
            logger = logging.logger.toKtorLogger()
            level = logging.logLevel.toKtorLogLevel()
            if (logging.sanitize) {
                sanitizeHeader { header -> header == HttpHeaders.Authorization }
            }
        }

        install(HttpTimeout) {
            config.timeout.socket?.let { socketTimeout ->
                socketTimeoutMillis = socketTimeout.toLong(DurationUnit.MILLISECONDS)
            }
            config.timeout.connect?.let { connectTimeout ->
                connectTimeoutMillis = connectTimeout.toLong(DurationUnit.MILLISECONDS)
            }
            config.timeout.request?.let { requestTimeout ->
                requestTimeoutMillis = requestTimeout.toLong(DurationUnit.MILLISECONDS)
            }
        }

        install(HttpRequestRetry) {
            maxRetries = config.retry.maxRetries
            // retry on rate limit error.
            retryIf { _, response -> response.status.value.let { it == 429 } }
            exponentialDelay(config.retry.base, config.retry.maxDelay.inWholeMilliseconds)
        }

        defaultRequest {
            url(config.host.baseUrl)
            config.host.queryParams.onEach { (key, value) -> url.parameters.appendIfNameAbsent(key, value) }
            config.headers.onEach { (key, value) -> headers.appendIfNameAbsent(key, value) }
            contentType(ContentType.Application.Json)
        }

        expectSuccess = true

        config.httpClientConfig(this)
    }

    return if (config.engine != null) {
        HttpClient(config.engine, configuration)
    } else {
        HttpClient(configuration)
    }
}

/**
 * Internal Json Serializer.
 */
internal val JsonLenient =
    Json {
        isLenient = true
        ignoreUnknownKeys = true
    }
