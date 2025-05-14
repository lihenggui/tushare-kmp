package li.mercury.tushare.api.stock.flow

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult

/**
 * 股票资金流向相关API接口
 */
interface StockFlowApiInterface {
    /**
     * 获取个股资金流向
     * @param params 请求参数
     * @return 个股资金流向数据流
     */
    fun getMoneyflowThs(params: MoneyflowParams): Flow<List<MoneyflowResult>>

    /**
     * 获取同花顺个股资金流向
     * @param params 请求参数
     * @return 同花顺个股资金流向数据流
     */
    fun getMoneyflowThs(params: MoneyflowThsParams): Flow<List<MoneyflowThsResult>>
}
