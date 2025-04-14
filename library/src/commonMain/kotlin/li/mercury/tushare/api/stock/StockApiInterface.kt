package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.StkManagersParams
import li.mercury.tushare.api.stock.models.StkManagersResult
import li.mercury.tushare.api.stock.models.StkPremarketParams
import li.mercury.tushare.api.stock.models.StkPremarketResult
import li.mercury.tushare.api.stock.models.StkRewardsParams
import li.mercury.tushare.api.stock.models.StkRewardsResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult
import li.mercury.tushare.api.stock.models.TradeCalParams
import li.mercury.tushare.api.stock.models.TradeCalResult

/**
 * 股票相关API的存储库接口
 */
interface StockApiInterface {
    /**
     * 获取股票基本信息
     */
    fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>>

    /**
     * 获取沪深股通成份股数据
     */
    fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>>

    /**
     * 获取股票曾用名信息
     */
    fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>>

    /**
     * 获取上市公司基本信息
     */
    fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>>

    /**
     * 获取股本情况（盘前）数据
     */
    fun getStkPremarket(params: StkPremarketParams): Flow<List<StkPremarketResult>>

    /**
     * 获取交易日历数据
     */
    fun getTradeCal(params: TradeCalParams): Flow<List<TradeCalResult>>

    /**
     * 获取上市公司管理层信息
     */
    fun getStkManagers(params: StkManagersParams): Flow<List<StkManagersResult>>

    /**
     * 获取上市公司管理层薪酬和持股情况
     */
    fun getStkRewards(params: StkRewardsParams): Flow<List<StkRewardsResult>>
}
