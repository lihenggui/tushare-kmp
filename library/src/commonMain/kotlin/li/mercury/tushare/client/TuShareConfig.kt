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
 * TuShare API客户端配置类
 * 
 * 该类包含创建和配置TuShare API客户端所需的所有参数。
 * 支持灵活的配置选项，包括网络超时、日志记录、代理设置、重试策略等。
 * 
 * ## 基本配置
 * - **token** - TuShare API访问令牌（必需）
 * - **host** - API服务器地址配置
 * - **timeout** - 网络超时设置
 * 
 * ## 高级配置
 * - **logging** - 日志记录配置
 * - **proxy** - 代理服务器配置
 * - **retry** - 请求重试策略
 * - **engine** - HTTP客户端引擎
 * 
 * @param token TuShare API访问令牌，可从官网获取
 * @param host API服务器主机配置，默认使用官方服务器
 * @param logging 日志记录配置，控制日志级别和输出
 * @param headers 附加的HTTP请求头，用于自定义请求
 * @param timeout 网络超时配置，包括连接和读取超时
 * @param engine HTTP客户端引擎，用于底层网络通信
 * @param retry 请求重试策略配置
 * @param proxy 代理服务器配置，支持HTTP和SOCKS代理
 * @param httpClientConfig 额外的HTTP客户端配置函数
 * 
 * ```kotlin
 * val config = TuShareConfig(
 *     token = "your-api-token",
 *     host = TuShareHost.TuShare,
 *     timeout = Timeout(socket = 60.seconds),
 *     logging = LoggingConfig(level = LogLevel.INFO),
 *     retry = RetryStrategy(maxRetries = 5),
 *     proxy = ProxyConfig.Http("http://proxy.example.com:8080")
 * )
 * ```
 * 
 * @see TuShareHost 主机配置
 * @see LoggingConfig 日志配置
 * @see RetryStrategy 重试策略
 * @see ProxyConfig 代理配置
 * @see Timeout 超时配置
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
    /**
     * 简化的构造函数，提供更直接的配置方式
     * 
     * @param token TuShare API访问令牌
     * @param logLevel 日志级别，默认为Headers级别
     * @param logger 日志记录器，默认为简单控制台输出
     * @param host API服务器主机配置
     * @param headers 附加的HTTP请求头
     * @param timeout 网络超时配置
     * @param engine HTTP客户端引擎，默认使用CIO引擎
     * @param retry 请求重试策略
     * @param httpClientConfig 额外的HTTP客户端配置
     */
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
 * TuShare API服务器主机配置类
 * 
 * 该类用于配置TuShare API的服务器地址和相关参数。
 * 支持自定义API服务器地址，以及为所有请求添加通用的查询参数。
 * 
 * @param baseUrl API服务器的基础URL地址，必须以"/"结尾
 * @param queryParams 附加到所有API请求的通用查询参数
 * 
 * ```kotlin
 * // 使用官方服务器
 * val officialHost = TuShareHost.TuShare
 * 
 * // 自定义服务器
 * val customHost = TuShareHost(
 *     baseUrl = "https://your-custom-api.com/",
 *     queryParams = mapOf("version" to "v1", "format" to "json")
 * )
 * ```
 */
public class TuShareHost(
    /**
     * API服务器基础URL地址
     * 
     * 这是所有API请求的根URL。URL可以包含基础路径，
     * 但基础路径必须以"/"结尾。
     * 
     * 例如：`https://api.tushare.pro/`
     */
    public val baseUrl: String,
    /**
     * 附加到所有API请求的通用查询参数
     * 
     * 这些参数会自动添加到每个API请求中，
     * 可用于提供额外的配置或上下文信息。
     */
    public val queryParams: Map<String, String> = emptyMap(),
) {
    public companion object {
        /**
         * 预配置的官方TuShare服务器实例
         * 
         * 基础URL设置为 `https://api.tushare.pro/`
         */
        public val TuShare: TuShareHost = TuShareHost(baseUrl = "https://api.tushare.pro/")
    }
}

/**
 * HTTP代理配置接口
 * 
 * 支持多种类型的代理服务器配置，包括HTTP代理和SOCKS代理。
 * 
 * ```kotlin
 * // HTTP代理
 * val httpProxy = ProxyConfig.Http("http://proxy.example.com:8080")
 * 
 * // SOCKS代理
 * val socksProxy = ProxyConfig.Socks("proxy.example.com", 1080)
 * ```
 */
public sealed interface ProxyConfig {
    /**
     * HTTP代理配置
     * 
     * @param url 代理服务器的完整URL地址，包括协议、主机和端口
     * 
     * ```kotlin
     * val proxy = ProxyConfig.Http("http://proxy.example.com:8080")
     * ```
     */
    public class Http(
        public val url: String,
    ) : ProxyConfig

    /**
     * SOCKS代理配置
     * 
     * @param host 代理服务器主机地址
     * @param port 代理服务器端口号
     * 
     * ```kotlin
     * val proxy = ProxyConfig.Socks("proxy.example.com", 1080)
     * ```
     */
    public class Socks(
        public val host: String,
        public val port: Int,
    ) : ProxyConfig
}

/**
 * API请求重试策略配置
 * 
 * 当API请求失败时，客户端会根据此策略进行重试。
 * 支持指数退避算法，确保重试间隔逐渐增长。
 *
 * @param maxRetries 最大重试次数，超过此次数将抛出异常
 * @param base 退避算法的基数，用于计算重试间隔
 * @param maxDelay 最大重试延迟时间，防止重试间隔过长
 * 
 * ```kotlin
 * // 基本重试策略：最多重试3次
 * val basicRetry = RetryStrategy(maxRetries = 3)
 * 
 * // 高级重试策略：自定义退避参数
 * val advancedRetry = RetryStrategy(
 *     maxRetries = 5,
 *     base = 1.5,
 *     maxDelay = 30.seconds
 * )
 * ```
 */
public class RetryStrategy(
    public val maxRetries: Int = 3,
    public val base: Double = 2.0,
    public val maxDelay: Duration = 60.seconds,
)

/**
 * 日志记录配置类
 * 
 * 控制HTTP客户端的日志输出行为，包括日志级别、输出目标和敏感信息处理。
 *
 * @property logLevel HTTP客户端使用的日志级别
 * @property logger 日志记录器实例，负责实际的日志输出
 * @property sanitize 是否对敏感信息（如授权头）进行脱敏处理
 * 
 * ```kotlin
 * // 基本日志配置
 * val basicLogging = LoggingConfig()
 * 
 * // 详细日志配置
 * val detailedLogging = LoggingConfig(
 *     logLevel = LogLevel.ALL,
 *     logger = Logger.Simple,
 *     sanitize = true
 * )
 * ```
 * 
 * @see LogLevel 日志级别枚举
 * @see Logger 日志记录器接口
 */
public class LoggingConfig(
    public val logLevel: LogLevel = LogLevel.Headers,
    public val logger: Logger = Logger.Simple,
    public val sanitize: Boolean = true,
)
