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
package li.mercury.tushare.api.stock.basic

import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.BakBasicResult
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsConstResult
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NameChangeResult
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.NewShareResult
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkManagersResult
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketResult
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsResult
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockBasicResult
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyResult
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.api.stock.basic.models.TradeCalResult

/**
 * 股票相关API的存储库接口
 */
public interface StockBasicApiInterface {
    /**
     * 获取股票基本信息
     */
    public suspend fun getStockBasic(params: StockBasicParams): List<StockBasicResult>

    /**
     * 获取股本情况（盘前）数据
     */
    public suspend fun getStkPremarket(params: StkPremarketParams): List<StkPremarketResult>

    /**
     * 获取交易日历数据
     */
    public suspend fun getTradeCal(params: TradeCalParams): List<TradeCalResult>

    /**
     * 获取股票曾用名信息
     */
    public suspend fun getNameChange(params: NameChangeParams): List<NameChangeResult>

    /**
     * 获取沪深股通成份股数据
     */
    public suspend fun getHsConst(params: HsConstParams): List<HsConstResult>

    /**
     * 获取上市公司基本信息
     */
    public suspend fun getStockCompany(params: StockCompanyParams): List<StockCompanyResult>

    /**
     * 获取上市公司管理层信息
     */
    public suspend fun getStkManagers(params: StkManagersParams): List<StkManagersResult>

    /**
     * 获取上市公司管理层薪酬和持股情况
     */
    public suspend fun getStkRewards(params: StkRewardsParams): List<StkRewardsResult>

    /**
     * 获取IPO新股列表数据
     */
    public suspend fun getNewShare(params: NewShareParams): List<NewShareResult>

    /**
     * 备用基础列表（历史每天股票列表）
     */
    public suspend fun getBakBasic(params: BakBasicParams): List<BakBasicResult>
}
