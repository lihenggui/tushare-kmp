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
package li.mercury.tushare.api.stock.margin

import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginDetailResult
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginResult
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsResult
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmResult
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbLenResult
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailResult
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.stock.margin.models.SlbSecResult

/**
 * 股票融资融券相关API接口
 */
public interface StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     */
    public suspend fun getMargin(params: MarginParams): List<MarginResult>

    /**
     * 获取融资融券交易明细数据
     */
    public suspend fun getMarginDetail(params: MarginDetailParams): List<MarginDetailResult>

    /**
     * 获取融资融券标的（盘前更新）
     */
    public suspend fun getMarginSecs(params: MarginSecsParams): List<MarginSecsResult>

    /**
     * 获取转融券交易汇总数据
     */
    public suspend fun getSlbSec(params: SlbSecParams): List<SlbSecResult>

    /**
     * 获取转融资交易汇总数据
     */
    public suspend fun getSlbLen(params: SlbLenParams): List<SlbLenResult>

    /**
     * 获取转融券交易明细数据
     */
    public suspend fun getSlbSecDetail(params: SlbSecDetailParams): List<SlbSecDetailResult>

    /**
     * 获取做市借券交易汇总数据
     */
    public suspend fun getSlbLenMm(params: SlbLenMmParams): List<SlbLenMmResult>
}
