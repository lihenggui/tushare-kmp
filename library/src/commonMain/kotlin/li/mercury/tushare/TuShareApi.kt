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
 * Implementation of [TuShare]
 *
 * @param requester http transport layer
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
