package li.mercury.tushare.api.stock.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult
import li.mercury.tushare.utils.toApiParams

/**
 * 股票资金流向相关API的实现类
 */
internal class StockFlowApi(
    private val tuShare: TuShare,
) : StockFlowApiInterface {
    /**
     * 获取个股资金流向
     * @param params 请求参数
     * @return 个股资金流向数据流
     */
    override fun getMoneyflowThs(params: MoneyflowParams): Flow<List<MoneyflowResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "moneyflow",
                    params = apiParams,
                )
            val results = response.getResponseItems(MoneyflowResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺个股资金流向
     * @param params 请求参数
     * @return 同花顺个股资金流向数据流
     */
    override fun getMoneyflowThs(params: MoneyflowThsParams): Flow<List<MoneyflowThsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "moneyflow_ths",
                    params = apiParams,
                )
            val results = response.getResponseItems(MoneyflowThsResult.serializer())
            emit(results)
        }

    /**
     * 获取东方财富个股资金流向数据
     * @param params 请求参数
     * @return 东方财富个股资金流向数据流
     */
    override fun getMoneyflowDc(params: MoneyflowDcParams): Flow<List<MoneyflowDcResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "moneyflow_dc",
                    params = apiParams,
                )
            val results = response.getResponseItems(MoneyflowDcResult.serializer())
            emit(results)
        }

    /**
     * 获取东方财富大盘资金流向数据
     * @param params 请求参数
     * @return 东方财富大盘资金流向数据流
     */
    override fun getMoneyflowMktDc(params: MoneyflowMktDcParams): Flow<List<MoneyflowMktDcResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "moneyflow_mkt_dc",
                    params = apiParams,
                )
            val results = response.getResponseItems(MoneyflowMktDcResult.serializer())
            emit(results)
        }
}
