package li.mercury.tushare.api.stock.character

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockCharacterApi(
    private val tuShare: TuShare,
) : StockCharacterApiInterface {
    /**
     * 获取卖方盈利预测数据
     * @param params 卖方盈利预测数据请求参数
     * @return 卖方盈利预测数据返回对象列表
     */
    override fun getReportRc(params: ReportRcParams): Flow<List<ReportRcResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "report_rc",
                    params = apiParams,
                )
            val results = response.getResponseItems(ReportRcResult.serializer())
            emit(results)
        }

    /**
     * 获取每日筹码及胜率数据
     * @param params 请求参数
     * @return 每日筹码及胜率数据流
     */
    override fun getCyqPerf(params: CyqPerfParams): Flow<List<CyqPerfResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cyq_perf",
                    params = apiParams,
                )
            val results = response.getResponseItems(CyqPerfResult.serializer())
            emit(results)
        }

    /**
     * 获取每日筹码分布数据
     * @param params 请求参数
     * @return 每日筹码分布数据流
     */
    override fun getCyqChips(params: CyqChipsParams): Flow<List<CyqChipsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cyq_chips",
                    params = apiParams,
                )
            val results = response.getResponseItems(CyqChipsResult.serializer())
            emit(results)
        }

    /**
     * 获取股票技术因子数据
     * @param params 请求参数
     * @return 股票技术因子数据流
     */
    override fun getStkFactor(params: StkFactorParams): Flow<List<StkFactorResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_factor",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkFactorResult.serializer())
            emit(results)
        }

    /**
     * 获取股票技术面因子（专业版）数据
     * @param params 请求参数
     * @return 股票技术面因子数据流
     */
    override fun getStkFactorPro(params: StkFactorProParams): Flow<List<StkFactorProResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_factor_pro",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkFactorProResult.serializer())
            emit(results)
        }

    /**
     * 获取中央结算系统持股汇总数据
     * @param params 请求参数
     * @return 中央结算系统持股汇总数据流
     */
    override fun getCcassHold(params: CcassHoldParams): Flow<List<CcassHoldResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ccass_hold",
                    params = apiParams,
                )
            val results = response.getResponseItems(CcassHoldResult.serializer())
            emit(results)
        }

    /**
     * 获取中央结算系统持股明细数据
     * @param params 请求参数
     * @return 中央结算系统持股明细数据流
     */
    override fun getCcassHoldDetail(params: CcassHoldDetailParams): Flow<List<CcassHoldDetailResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "ccass_hold_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(CcassHoldDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深港股通持股明细
     * @param params 请求参数
     * @return 沪深港股通持股明细数据流
     */
    override fun getHkHold(params: HkHoldParams): Flow<List<HkHoldResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "hk_hold",
                    params = apiParams,
                )
            val results = response.getResponseItems(HkHoldResult.serializer())
            emit(results)
        }

    /**
     * 获取股票开盘集合竞价数据
     * @param params 请求参数
     * @return 股票开盘集合竞价数据流
     */
    override fun getStkAuctionO(params: StkAuctionOParams): Flow<List<StkAuctionOResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "stk_auction_o",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkAuctionOResult.serializer())
            emit(results)
        }

    /**
     * 获取股票收盘集合竞价数据
     * @param params 请求参数
     * @return 股票收盘集合竞价数据流
     */
    override fun getStkAuctionC(params: StkAuctionCParams): Flow<List<StkAuctionCResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "stk_auction_c",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkAuctionCResult.serializer())
            emit(results)
        }

    /**
     * 获取神奇九转指标数据
     * @param params 请求参数
     * @return 神奇九转指标数据流
     */
    override fun getStkNineturn(params: StkNineturnParams): Flow<List<StkNineturnResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "stk_nineturn",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkNineturnResult.serializer())
            emit(results)
        }

    /**
     * 获取股票调研数据
     * @param params 请求参数
     * @return 股票调研数据流
     */
    override fun getStkSurv(params: StkSurvParams): Flow<List<StkSurvResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "stk_surv",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkSurvResult.serializer())
            emit(results)
        }

    /**
     * 获取券商每月荐股数据
     * @param params 请求参数
     * @return 券商每月荐股数据流
     */
    override fun getBrokerRecommend(params: BrokerRecommendParams): Flow<List<BrokerRecommendResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "broker_recommend",
                    params = apiParams,
                )
            val results = response.getResponseItems(BrokerRecommendResult.serializer())
            emit(results)
        }
}
