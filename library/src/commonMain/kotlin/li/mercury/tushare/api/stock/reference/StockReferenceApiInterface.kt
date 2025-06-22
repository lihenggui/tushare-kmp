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
package li.mercury.tushare.api.stock.reference

import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.BlockTradeResult
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailResult
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.ConceptResult
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailResult
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatResult
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseResult
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatResult
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeResult
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersResult

/**
 * 股票参考数据相关API接口
 */
public interface StockReferenceApiInterface {
    /**
     * 获取前十大股东
     */
    public suspend fun getTop10Holders(params: Top10HoldersParams): List<Top10HoldersResult>

    /**
     * 获取前十大流通股东
     */
    public suspend fun getTop10FloatHolders(params: Top10FloatHoldersParams): List<Top10FloatHoldersResult>

    /**
     * 获取股权质押统计数据
     */
    public suspend fun getPledgeStat(params: PledgeStatParams): List<PledgeStatResult>

    /**
     * 获取股权质押明细数据
     */
    public suspend fun getPledgeDetail(params: PledgeDetailParams): List<PledgeDetailResult>

    /**
     * 获取股票回购信息
     */
    public suspend fun getRepurchase(params: RepurchaseParams): List<RepurchaseResult>

    /**
     * 获取概念股分类
     */
    public suspend fun getConcept(params: ConceptParams): List<ConceptResult>

    /**
     * 获取概念股列表
     */
    public suspend fun getConceptDetail(params: ConceptDetailParams): List<ConceptDetailResult>

    /**
     * 获取限售股解禁数据
     */
    public suspend fun getShareFloat(params: ShareFloatParams): List<ShareFloatResult>

    /**
     * 获取大宗交易数据
     */
    public suspend fun getBlockTrade(params: BlockTradeParams): List<BlockTradeResult>

    /**
     * 获取股东人数
     */
    public suspend fun getStockHolderNumber(params: StockHolderNumberParams): List<StockHolderNumberResult>

    /**
     * 获取股东增减持数据
     */
    public suspend fun getStockHolderTrade(params: StockHolderTradeParams): List<StockHolderTradeResult>
}
