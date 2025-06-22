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
package li.mercury.tushare.api.stock.market

import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.AdjFactorResult
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.BakDailyResult
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyBasicResult
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.DailyResult
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtDailyResult
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyResult
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.GgtTop10Result
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Result
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MinsResult
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.MonthlyResult
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.StkLimitResult
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.SuspendDResult
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.api.stock.market.models.WeeklyResult

/**
 * 股票行情数据相关API接口
 */
public interface StockMarketApiInterface {
    /**
     * 获取股票日线行情数据
     */
    public suspend fun getDaily(params: DailyParams): List<DailyResult>

    /**
     * 获取股票分钟行情数据
     */
    public suspend fun getMins(params: MinsParams): List<MinsResult>

    /**
     * 获取A股周线行情数据
     */
    public suspend fun getWeekly(params: WeeklyParams): List<WeeklyResult>

    /**
     * 获取A股月线行情数据
     */
    public suspend fun getMonthly(params: MonthlyParams): List<MonthlyResult>

    /**
     * 获取股票周/月线行情数据(每日更新)
     */
    public suspend fun getWeeklyMonthly(params: WeeklyMonthlyParams): List<WeeklyMonthlyResult>

    /**
     * 获取股票复权因子数据
     */
    public suspend fun getAdjFactor(params: AdjFactorParams): List<AdjFactorResult>

    /**
     * 获取股票每日指标数据
     */
    public suspend fun getDailyBasic(params: DailyBasicParams): List<DailyBasicResult>

    /**
     * 获取每日涨跌停价格数据
     */
    public suspend fun getStkLimit(params: StkLimitParams): List<StkLimitResult>

    /**
     * 获取每日停复牌信息
     */
    public suspend fun getSuspendD(params: SuspendDParams): List<SuspendDResult>

    /**
     * 获取沪深股通十大成交股数据
     */
    public suspend fun getHsgtTop10(params: HsgtTop10Params): List<HsgtTop10Result>

    /**
     * 获取港股通十大成交股数据
     */
    public suspend fun getGgtTop10(params: GgtTop10Params): List<GgtTop10Result>

    /**
     * 获取港股通每日成交统计
     */
    public suspend fun getGgtDaily(params: GgtDailyParams): List<GgtDailyResult>

    /**
     * 获取港股通每月成交统计
     */
    public suspend fun getGgtMonthly(params: GgtMonthlyParams): List<GgtMonthlyResult>

    /**
     * 获取备用行情数据
     */
    public suspend fun getBakDaily(params: BakDailyParams): List<BakDailyResult>
}
