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

import io.ktor.client.HttpClientConfig
import li.mercury.tushare.api.index.IndexApiInterface
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.api.stock.basic.StockBasicApiInterface
import li.mercury.tushare.api.stock.board.StockBoardApiInterface
import li.mercury.tushare.api.stock.character.StockCharacterApiInterface
import li.mercury.tushare.api.stock.finance.StockFinanceApiInterface
import li.mercury.tushare.api.stock.flow.StockFlowApiInterface
import li.mercury.tushare.api.stock.margin.StockMarginApiInterface
import li.mercury.tushare.api.stock.market.StockMarketApiInterface
import li.mercury.tushare.api.stock.reference.StockReferenceApiInterface
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.client.ProxyConfig
import li.mercury.tushare.client.RetryStrategy
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.client.TuShareHost
import li.mercury.tushare.client.createHttpClient
import li.mercury.tushare.http.HttpTransport
import li.mercury.tushare.internal.extension.Timeout
import kotlin.time.Duration.Companion.seconds

/**
 * TuShare API客户端接口，提供对TuShare金融数据API的访问。
 * 
 * TuShare是一个提供中国金融市场数据的开放平台，包括股票、期货、基金、宏观经济等各类金融数据。
 * 该接口整合了所有API模块，支持Kotlin多平台，可在JVM、Android、iOS、JS等平台使用。
 *
 * ## 支持的功能模块
 * - **新闻快讯** - 实时新闻、公告信息
 * - **指数行情** - 各类指数的基本信息和行情数据
 * - **股票基础数据** - 股票基本信息、交易日历、股本情况等
 * - **股票行情** - 日线、周线、月线、分钟行情等
 * - **股票财务** - 财务报表、财务指标等
 * - **参考数据** - 股东信息、概念股分类、大宗交易等
 * - **特色数据** - 龙虎榜、机构调研、筹码分布等
 * - **两融数据** - 融资融券、转融通数据
 * - **资金流向** - 个股、板块资金流向数据
 *
 * ```kotlin
 * // 创建客户端实例
 * val tuShare = TuShare(
 *     token = "your-api-token",
 *     timeout = Timeout(socket = 60.seconds)
 * )
 * 
 * // 获取股票基本信息
 * val stockList = tuShare.stockBasic(
 *     StockBasicParams(isHs = "N", listStatus = "L")
 * )
 * 
 * // 获取日线行情
 * val dailyData = tuShare.daily(
 *     DailyParams(tsCode = "000001.SZ", startDate = "20240101")
 * )
 * 
 * // 记得关闭客户端
 * tuShare.close()
 * ```
 *
 * @see NewsApiInterface 新闻快讯接口
 * @see IndexApiInterface 指数行情接口
 * @see StockBasicApiInterface 股票基础数据接口
 * @see StockMarketApiInterface 股票行情接口
 * @see StockFinanceApiInterface 股票财务接口
 */
public interface TuShare :
    NewsApiInterface,
    IndexApiInterface,
    StockBasicApiInterface,
    StockBoardApiInterface,
    StockCharacterApiInterface,
    StockFinanceApiInterface,
    StockFlowApiInterface,
    StockMarginApiInterface,
    StockMarketApiInterface,
    StockReferenceApiInterface,
    AutoCloseable

/**
 * 创建TuShare API客户端实例
 *
 * @param token TuShare API访问令牌，可从 [TuShare官网](https://tushare.pro/) 获取
 * @param host TuShare API服务器地址，默认为官方服务器
 * @param timeout HTTP客户端超时配置，包括连接、读取和请求超时
 * @param header 额外的HTTP请求头，可用于添加自定义请求头
 * @param loggingConfig 客户端日志配置，控制日志级别和输出
 * @param proxy HTTP代理配置，支持HTTP、HTTPS、SOCKS代理
 * @param retry 请求重试策略配置，包括重试次数和重试条件
 * @param httpClientConfig 额外的HTTP客户端配置，用于高级定制
 * 
 * @return 配置好的TuShare客户端实例
 * 
 * ```kotlin
 * val tuShare = TuShare(
 *     token = "your-api-token",
 *     timeout = Timeout(
 *         socket = 60.seconds,
 *         connect = 30.seconds,
 *         request = 120.seconds
 *     ),
 *     loggingConfig = LoggingConfig(level = LogLevel.INFO),
 *     retry = RetryStrategy(maxRetries = 3),
 *     proxy = Socks(host = "proxy.example.com", port = 8080)
 * )
 * ```
 * 
 * @see TuShareConfig 详细配置选项
 * @see Timeout 超时配置
 * @see LoggingConfig 日志配置
 * @see RetryStrategy 重试策略
 * @see ProxyConfig 代理配置
 */
public fun TuShare(
    token: String,
    loggingConfig: LoggingConfig = LoggingConfig(),
    header: Map<String, String> = emptyMap(),
    host: TuShareHost = TuShareHost.TuShare,
    timeout: Timeout = Timeout(socket = 30.seconds),
    proxy: ProxyConfig? = null,
    retry: RetryStrategy = RetryStrategy(),
    httpClientConfig: HttpClientConfig<*>.() -> Unit = {},
): TuShare =
    TuShare(
        config =
            TuShareConfig(
                token = token,
                logging = loggingConfig,
                headers = header,
                host = host,
                timeout = timeout,
                proxy = proxy,
                retry = retry,
                httpClientConfig = httpClientConfig,
            ),
    )

/**
 * 使用预配置的[TuShareConfig]创建TuShare API客户端实例
 *
 * 此方法适用于需要复杂配置或配置重用的场景。通过预先创建配置对象，
 * 可以更好地管理配置参数，特别是在多环境部署或配置共享的情况下。
 *
 * @param config 完整的客户端配置对象，包含所有必要的参数
 * 
 * @return 配置好的TuShare客户端实例
 * 
 * ```kotlin
 * val config = TuShareConfig(
 *     token = System.getenv("TUSHARE_API_TOKEN") ?: error("Token required"),
 *     timeout = Timeout(socket = 60.seconds),
 *     logging = LoggingConfig(level = LogLevel.DEBUG),
 *     host = TuShareHost.TuShare,
 *     retry = RetryStrategy(maxRetries = 5, baseDelay = 1000)
 * )
 * 
 * val tuShare = TuShare(config)
 * ```
 * 
 * @see TuShareConfig 配置对象详细说明
 */
public fun TuShare(config: TuShareConfig): TuShare {
    val httpClient = createHttpClient(config)
    val transport = HttpTransport(httpClient)
    return TuShareApi(transport)
}
