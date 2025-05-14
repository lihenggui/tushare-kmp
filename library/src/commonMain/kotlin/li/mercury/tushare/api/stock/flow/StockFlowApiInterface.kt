package li.mercury.tushare.api.stock.flow

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult

/**
 * 股票资金流向相关API的存储库接口
 */
interface StockFlowApiInterface {
    /**
     * 获取个股资金流向
     */
    fun getMoneyflowThs(params: MoneyflowThsParams): Flow<List<MoneyflowThsResult>>
}
