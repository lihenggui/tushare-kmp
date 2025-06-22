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

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import li.mercury.tushare.internal.extension.Timeout
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.internal.logging.Logger
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * TuShare客户端配置
 */
public class TuShareConfig(
    public val token: String,
    public val host: TuShareHost = TuShareHost.TuShare,
    public val logging: LoggingConfig = LoggingConfig(),
    public val headers: Map<String, String> = emptyMap(),
    public val timeout: Timeout = Timeout(socket = 30.seconds),
    public val engine: HttpClientEngine? = null,
    public val retry: RetryStrategy = RetryStrategy(),
    public val proxy: ProxyConfig? = null,
    public val httpClientConfig: HttpClientConfig<*>.() -> Unit = {},
) {
    public constructor(
        token: String,
        logLevel: LogLevel = LogLevel.Headers,
        logger: Logger = Logger.Simple,
        host: TuShareHost = TuShareHost.TuShare,
        headers: Map<String, String> = emptyMap(),
        timeout: Timeout = Timeout(socket = 30.seconds),
        engine: HttpClientEngine = CIO.create(),
        retry: RetryStrategy = RetryStrategy(),
        httpClientConfig: HttpClientConfig<*>.() -> Unit = {},
    ) : this(
        token = token,
        host = host,
        logging = LoggingConfig(logLevel, logger),
        headers = headers,
        timeout = timeout,
        engine = engine,
        retry = retry,
        httpClientConfig = httpClientConfig,
    )
}

/**
 * A class to configure the TuShare host.
 * It provides a mechanism to customize the base URL and additional query parameters used in TuShare API requests.
 */
public class TuShareHost(
    /**
     * Base URL configuration.
     * This is the root URL that will be used for all API requests to TuShare.
     * The URL can include a base path, but in that case, the base path should always end with a `/`.
     * For example, a valid base URL would be "https://api.tushare.pro/".
     */
    public val baseUrl: String,
    /**
     * Additional query parameters to be appended to all API requests to TuShare.
     * These can be used to provide additional configuration or context for the API requests.
     */
    public val queryParams: Map<String, String> = emptyMap(),
) {
    public companion object {
        /**
         * A pre-configured instance of [TuShareHost] with the base URL set as `https://api.tushare.pro/`.
         */
        public val TuShare: TuShareHost = TuShareHost(baseUrl = "https://api.tushare.pro/")
    }
}

/** Proxy configuration. */
public sealed interface ProxyConfig {
    /** Creates an HTTP proxy from [url]. */
    public class Http(
        public val url: String,
    ) : ProxyConfig

    /** Create socks proxy from [host] and [port]. */
    public class Socks(
        public val host: String,
        public val port: Int,
    ) : ProxyConfig
}

/**
 * Specifies the retry strategy
 *
 * @param maxRetries the maximum number of retries to perform for a request
 * @param base retry base value
 * @param maxDelay max retry delay
 */
public class RetryStrategy(
    public val maxRetries: Int = 3,
    public val base: Double = 2.0,
    public val maxDelay: Duration = 60.seconds,
)

/**
 * Defines the configuration parameters for logging.
 *
 * @property logLevel the level of logging to be used by the HTTP client.
 * @property logger the logger instance to be used by the HTTP client.
 * @property sanitize flag indicating whether to sanitize sensitive information (i.e., authorization header) in the logs
 */
public class LoggingConfig(
    public val logLevel: LogLevel = LogLevel.Headers,
    public val logger: Logger = Logger.Simple,
    public val sanitize: Boolean = true,
)
