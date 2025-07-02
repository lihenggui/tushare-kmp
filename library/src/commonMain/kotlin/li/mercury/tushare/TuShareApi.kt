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

import li.mercury.tushare.api.index.IndexApi
import li.mercury.tushare.api.index.IndexApiInterface
import li.mercury.tushare.api.news.NewsApi
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.api.stock.basic.StockBasicApi
import li.mercury.tushare.api.stock.basic.StockBasicApiInterface
import li.mercury.tushare.api.stock.board.StockBoardApi
import li.mercury.tushare.api.stock.board.StockBoardApiInterface
import li.mercury.tushare.api.stock.character.StockCharacterApi
import li.mercury.tushare.api.stock.character.StockCharacterApiInterface
import li.mercury.tushare.api.stock.finance.StockFinanceApi
import li.mercury.tushare.api.stock.finance.StockFinanceApiInterface
import li.mercury.tushare.api.stock.flow.StockFlowApi
import li.mercury.tushare.api.stock.flow.StockFlowApiInterface
import li.mercury.tushare.api.stock.margin.StockMarginApi
import li.mercury.tushare.api.stock.margin.StockMarginApiInterface
import li.mercury.tushare.api.stock.market.StockMarketApi
import li.mercury.tushare.api.stock.market.StockMarketApiInterface
import li.mercury.tushare.api.stock.reference.StockReferenceApi
import li.mercury.tushare.api.stock.reference.StockReferenceApiInterface
import li.mercury.tushare.http.HttpRequester

/**
 * [TuShare] 接口的默认实现类
 * 
 * 该类通过委托模式整合所有API模块的具体实现，提供统一的接口访问点。
 * 使用 Kotlin 的委托特性，将各个功能模块的实现委托给相应的API类。
 * 
 * ## 实现方式
 * - 使用委托模式整合各个API模块
 * - 共享HTTP传输层，提高性能和资源利用率
 * - 实现 [AutoCloseable] 接口，支持资源自动释放
 * 
 * ## API模块组织
 * - **新闻模块** ([NewsApi]) - 新闻快讯、公告等信息
 * - **指数模块** ([IndexApi]) - 各类指数数据
 * - **股票基础** ([StockBasicApi]) - 股票基本信息
 * - **股票行情** ([StockMarketApi]) - 行情数据
 * - **股票财务** ([StockFinanceApi]) - 财务数据
 * - **参考数据** ([StockReferenceApi]) - 股东、概念股等
 * - **特色数据** ([StockCharacterApi]) - 龙虎榜、机构调研等
 * - **两融数据** ([StockMarginApi]) - 融资融券数据
 * - **资金流向** ([StockFlowApi]) - 资金流向数据
 * - **打板数据** ([StockBoardApi]) - 涨跌停、连板等数据
 *
 * @param requester HTTP请求传输层，负责与TuShare API服务器的通信
 * 
 * @constructor 创建TuShare API实现实例
 * 
 * @see TuShare 主接口定义
 * @see HttpRequester HTTP传输层接口
 */
internal class TuShareApi(
    private val requester: HttpRequester,
) : TuShare,
    NewsApiInterface by NewsApi(requester),
    IndexApiInterface by IndexApi(requester),
    StockBasicApiInterface by StockBasicApi(requester),
    StockBoardApiInterface by StockBoardApi(requester),
    StockCharacterApiInterface by StockCharacterApi(requester),
    StockFlowApiInterface by StockFlowApi(requester),
    StockFinanceApiInterface by StockFinanceApi(requester),
    StockMarginApiInterface by StockMarginApi(requester),
    StockMarketApiInterface by StockMarketApi(requester),
    StockReferenceApiInterface by StockReferenceApi(requester),
    AutoCloseable by requester
