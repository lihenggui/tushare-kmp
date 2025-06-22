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

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
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
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.utils.toApiParams

/**
 * 股票行情数据相关API的实现类
 */
internal class StockMarketApi(
    private val requester: HttpRequester,
) : StockMarketApiInterface {
    /**
     * 获取股票日线行情数据
     * @param params 日线行情参数
     * @return 日线行情数据
     */
    override suspend fun getDaily(params: DailyParams): List<DailyResult> {
        val request =
            TuShareRequest(
                apiName = "daily",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票分钟行情数据
     * @param params 分钟行情参数
     * @return 分钟行情数据
     */
    override suspend fun getMins(params: MinsParams): List<MinsResult> {
        val request =
            TuShareRequest(
                apiName = "stk_mins",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取A股周线行情数据
     * @param params 周线行情参数
     * @return 周线行情数据
     */
    override suspend fun getWeekly(params: WeeklyParams): List<WeeklyResult> {
        val request =
            TuShareRequest(
                apiName = "weekly",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取A股月线行情数据
     * @param params 月线行情参数
     * @return 月线行情数据
     */
    override suspend fun getMonthly(params: MonthlyParams): List<MonthlyResult> {
        val request =
            TuShareRequest(
                apiName = "monthly",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票周/月线行情数据
     * @param params 周/月线行情参数
     * @return 周/月线行情数据
     */
    override suspend fun getWeeklyMonthly(params: WeeklyMonthlyParams): List<WeeklyMonthlyResult> {
        val request =
            TuShareRequest(
                apiName = "stk_weekly_monthly",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票复权因子数据
     * @param params 股票复权因子参数
     * @return 股票复权因子数据
     */
    override suspend fun getAdjFactor(params: AdjFactorParams): List<AdjFactorResult> {
        val request =
            TuShareRequest(
                apiName = "adj_factor",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票每日指标数据
     * @param params 股票每日指标参数
     * @return 股票每日指标数据
     */
    override suspend fun getDailyBasic(params: DailyBasicParams): List<DailyBasicResult> {
        val request =
            TuShareRequest(
                apiName = "daily_basic",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票涨跌停数据
     * @param params 股票涨跌停参数
     * @return 股票涨跌停数据
     */
    override suspend fun getStkLimit(params: StkLimitParams): List<StkLimitResult> {
        val request =
            TuShareRequest(
                apiName = "stk_limit",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取每日停复牌信息
     * @param params 每日停复牌信息参数
     * @return 每日停复牌信息数据
     */
    override suspend fun getSuspendD(params: SuspendDParams): List<SuspendDResult> {
        val request =
            TuShareRequest(
                apiName = "suspend_d",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取沪深股通十大成交股数据
     * @param params 沪深股通十大成交股参数
     * @return 沪深股通十大成交股数据
     */
    override suspend fun getHsgtTop10(params: HsgtTop10Params): List<HsgtTop10Result> {
        val request =
            TuShareRequest(
                apiName = "hsgt_top10",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取港股通十大成交股数据
     * @param params 港股通十大成交股参数
     * @return 港股通十大成交股数据
     */
    override suspend fun getGgtTop10(params: GgtTop10Params): List<GgtTop10Result> {
        val request =
            TuShareRequest(
                apiName = "ggt_top10",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取港股通每日成交统计
     * @param params 港股通每日成交统计参数
     * @return 港股通每日成交统计数据
     */
    override suspend fun getGgtDaily(params: GgtDailyParams): List<GgtDailyResult> {
        val request =
            TuShareRequest(
                apiName = "ggt_daily",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取港股通月度成交统计
     * @param params 港股通月度成交统计参数
     * @return 港股通月度成交统计数据
     */
    override suspend fun getGgtMonthly(params: GgtMonthlyParams): List<GgtMonthlyResult> {
        val request =
            TuShareRequest(
                apiName = "ggt_monthly",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取备用行情数据
     * @param params 备用行情数据参数
     * @return 备用行情数据
     */
    override suspend fun getBakDaily(params: BakDailyParams): List<BakDailyResult> {
        val request =
            TuShareRequest(
                apiName = "bak_daily",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
