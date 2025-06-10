package li.mercury.tushare.api.stock.flow

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult

/**
 * 股票资金流向相关API接口
 */
public interface StockFlowApiInterface {
    /**
     * 获取个股资金流向
     * @param params 请求参数
     * @return 个股资金流向数据流
     */
    public fun getMoneyflowThs(params: MoneyflowParams): Flow<List<MoneyflowResult>>

    /**
     * 获取同花顺个股资金流向
     * @param params 请求参数
     * @return 同花顺个股资金流向数据流
     */
    public fun getMoneyflowThs(params: MoneyflowThsParams): Flow<List<MoneyflowThsResult>>

    /**
     * 获取东方财富个股资金流向数据
     * @param params 请求参数
     * @return 东方财富个股资金流向数据流
     */
    public fun getMoneyflowDc(params: MoneyflowDcParams): Flow<List<MoneyflowDcResult>>

    /**
     * 获取东方财富大盘资金流向数据
     * @param params 请求参数
     * @return 东方财富大盘资金流向数据流
     */
    public fun getMoneyflowMktDc(params: MoneyflowMktDcParams): Flow<List<MoneyflowMktDcResult>>

    /**
     * 获取东方财富板块资金流向数据
     * @param params 请求参数
     * @return 东方财富板块资金流向数据流
     */
    public fun getMoneyflowIndDc(params: MoneyflowIndDcParams): Flow<List<MoneyflowIndDcResult>>

    /**
     * 获取同花顺行业板块资金流向
     * @param params 请求参数
     * @return 同花顺行业板块资金流向数据流
     */
    public fun getMoneyflowIndThs(params: MoneyflowIndThsParams): Flow<List<MoneyflowIndThsResult>>

    /**
     * 获取沪深港通资金流向
     * @param params 请求参数
     * @return 沪深港通资金流向数据流
     */
    public fun getMoneyflowHsgt(params: MoneyflowHsgtParams): Flow<List<MoneyflowHsgtResult>>
}
