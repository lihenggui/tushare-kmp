package li.mercury.tushare.api.stock.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
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
    override fun getMoneyflowThs(params: MoneyflowThsParams): Flow<List<MoneyflowThsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "moneyflow",
                    params = apiParams,
                )
            val results = response.getResponseItems(MoneyflowThsResult.serializer())
            emit(results)
        }
}
