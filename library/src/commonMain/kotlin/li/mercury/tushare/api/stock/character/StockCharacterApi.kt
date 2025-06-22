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
package li.mercury.tushare.api.stock.character

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.BrokerRecommendResult
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailResult
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.CcassHoldResult
import li.mercury.tushare.api.stock.character.models.CyqChipsParams
import li.mercury.tushare.api.stock.character.models.CyqChipsResult
import li.mercury.tushare.api.stock.character.models.CyqPerfParams
import li.mercury.tushare.api.stock.character.models.CyqPerfResult
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.HkHoldResult
import li.mercury.tushare.api.stock.character.models.ReportRcParams
import li.mercury.tushare.api.stock.character.models.ReportRcResult
import li.mercury.tushare.api.stock.character.models.StkAuctionCParams
import li.mercury.tushare.api.stock.character.models.StkAuctionCResult
import li.mercury.tushare.api.stock.character.models.StkAuctionOParams
import li.mercury.tushare.api.stock.character.models.StkAuctionOResult
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkFactorProParams
import li.mercury.tushare.api.stock.character.models.StkFactorProResult
import li.mercury.tushare.api.stock.character.models.StkFactorResult
import li.mercury.tushare.api.stock.character.models.StkNineturnParams
import li.mercury.tushare.api.stock.character.models.StkNineturnResult
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.api.stock.character.models.StkSurvResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.utils.toApiParams

/**
 * 股票特色数据相关API的实现类
 */
internal class StockCharacterApi(
    private val requester: HttpRequester,
) : StockCharacterApiInterface {
    /**
     * 获取卖方盈利预测数据
     * @param params 卖方盈利预测数据请求参数
     * @return 卖方盈利预测数据返回对象列表
     */
    override suspend fun getReportRc(params: ReportRcParams): List<ReportRcResult> {
        val request =
            TuShareRequest(
                apiName = "report_rc",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取每日筹码及胜率数据
     * @param params 请求参数
     * @return 每日筹码及胜率数据
     */
    override suspend fun getCyqPerf(params: CyqPerfParams): List<CyqPerfResult> {
        val request =
            TuShareRequest(
                apiName = "cyq_perf",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取每日筹码分布数据
     * @param params 请求参数
     * @return 每日筹码分布数据
     */
    override suspend fun getCyqChips(params: CyqChipsParams): List<CyqChipsResult> {
        val request =
            TuShareRequest(
                apiName = "cyq_chips",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票技术因子数据
     * @param params 请求参数
     * @return 股票技术因子数据
     */
    override suspend fun getStkFactor(params: StkFactorParams): List<StkFactorResult> {
        val request =
            TuShareRequest(
                apiName = "stk_factor",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票技术面因子（专业版）数据
     * @param params 请求参数
     * @return 股票技术面因子数据
     */
    override suspend fun getStkFactorPro(params: StkFactorProParams): List<StkFactorProResult> {
        val request =
            TuShareRequest(
                apiName = "stk_factor_pro",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取中央结算系统持股汇总数据
     * @param params 请求参数
     * @return 中央结算系统持股汇总数据
     */
    override suspend fun getCcassHold(params: CcassHoldParams): List<CcassHoldResult> {
        val request =
            TuShareRequest(
                apiName = "ccass_hold",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取中央结算系统持股明细数据
     * @param params 请求参数
     * @return 中央结算系统持股明细数据
     */
    override suspend fun getCcassHoldDetail(params: CcassHoldDetailParams): List<CcassHoldDetailResult> {
        val request =
            TuShareRequest(
                apiName = "ccass_hold_detail",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取沪深港股通持股明细
     * @param params 请求参数
     * @return 沪深港股通持股明细数据
     */
    override suspend fun getHkHold(params: HkHoldParams): List<HkHoldResult> {
        val request =
            TuShareRequest(
                apiName = "hk_hold",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票开盘集合竞价数据
     * @param params 请求参数
     * @return 股票开盘集合竞价数据
     */
    override suspend fun getStkAuctionO(params: StkAuctionOParams): List<StkAuctionOResult> {
        val request =
            TuShareRequest(
                apiName = "stk_auction_o",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票收盘集合竞价数据
     * @param params 请求参数
     * @return 股票收盘集合竞价数据
     */
    override suspend fun getStkAuctionC(params: StkAuctionCParams): List<StkAuctionCResult> {
        val request =
            TuShareRequest(
                apiName = "stk_auction_c",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取神奇九转指标数据
     * @param params 请求参数
     * @return 神奇九转指标数据
     */
    override suspend fun getStkNineturn(params: StkNineturnParams): List<StkNineturnResult> {
        val request =
            TuShareRequest(
                apiName = "stk_nineturn",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票调研数据
     * @param params 请求参数
     * @return 股票调研数据
     */
    override suspend fun getStkSurv(params: StkSurvParams): List<StkSurvResult> {
        val request =
            TuShareRequest(
                apiName = "stk_surv",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取券商每月荐股数据
     * @param params 请求参数
     * @return 券商每月荐股数据
     */
    override suspend fun getBrokerRecommend(params: BrokerRecommendParams): List<BrokerRecommendResult> {
        val request =
            TuShareRequest(
                apiName = "broker_recommend",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
