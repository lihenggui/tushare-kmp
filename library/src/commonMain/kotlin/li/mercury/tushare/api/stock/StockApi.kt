package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.models.*
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockApi(private val tuShare: TuShare) : StockApiInterface {
    override fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>> = flow {
        val apiParams = params.toApiParams()
        
        val response = tuShare.callApi(
            apiName = "stock_basic",
            params = apiParams
        )
        val results = response.getResponseItems(StockBasicResult.serializer())
        emit(results)
    }

    override fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>> = flow {
        val apiParams = params.toApiParams()
        
        val response = tuShare.callApi(
            apiName = "hs_const",
            params = apiParams
        )
        val results = response.getResponseItems(HsConstResult.serializer())
        emit(results)
    }
}