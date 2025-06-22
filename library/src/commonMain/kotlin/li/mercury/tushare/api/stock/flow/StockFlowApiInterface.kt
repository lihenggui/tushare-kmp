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
package li.mercury.tushare.api.stock.flow

import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult

/**
 * 股票资金流向相关API接口
 */
public interface StockFlowApiInterface {
    /**
     * 获取个股资金流向
     * @param params 请求参数
     * @return 个股资金流向数据
     */
    public suspend fun getMoneyflow(params: MoneyflowParams): List<MoneyflowResult>

    /**
     * 获取同花顺个股资金流向
     * @param params 请求参数
     * @return 同花顺个股资金流向数据
     */
    public suspend fun getMoneyflowThs(params: MoneyflowThsParams): List<MoneyflowThsResult>

    /**
     * 获取东方财富个股资金流向数据
     * @param params 请求参数
     * @return 东方财富个股资金流向数据
     */
    public suspend fun getMoneyflowDc(params: MoneyflowDcParams): List<MoneyflowDcResult>

    /**
     * 获取东方财富大盘资金流向数据
     * @param params 请求参数
     * @return 东方财富大盘资金流向数据
     */
    public suspend fun getMoneyflowMktDc(params: MoneyflowMktDcParams): List<MoneyflowMktDcResult>

    /**
     * 获取东方财富板块资金流向数据
     * @param params 请求参数
     * @return 东方财富板块资金流向数据
     */
    public suspend fun getMoneyflowIndDc(params: MoneyflowIndDcParams): List<MoneyflowIndDcResult>

    /**
     * 获取同花顺行业板块资金流向
     * @param params 请求参数
     * @return 同花顺行业板块资金流向数据
     */
    public suspend fun getMoneyflowIndThs(params: MoneyflowIndThsParams): List<MoneyflowIndThsResult>

    /**
     * 获取沪深港通资金流向
     * @param params 请求参数
     * @return 沪深港通资金流向数据
     */
    public suspend fun getMoneyflowHsgt(params: MoneyflowHsgtParams): List<MoneyflowHsgtResult>
}
