package li.mercury.tushare.api.stock.basic

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.BakBasicResult
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsConstResult
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NameChangeResult
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.NewShareResult
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkManagersResult
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketResult
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsResult
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockBasicResult
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyResult
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.api.stock.basic.models.TradeCalResult

/**
 * 股票相关API的存储库接口
 */
interface StockBasicApiInterface {
    /**
     * 获取股票基本信息
     */
    fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>>

    /**
     * 获取股本情况（盘前）数据
     */
    fun getStkPremarket(params: StkPremarketParams): Flow<List<StkPremarketResult>>

    /**
     * 获取交易日历数据
     */
    fun getTradeCal(params: TradeCalParams): Flow<List<TradeCalResult>>

    /**
     * 获取股票曾用名信息
     */
    fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>>

    /**
     * 获取沪深股通成份股数据
     */
    fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>>

    /**
     * 获取上市公司基本信息
     */
    fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>>

    /**
     * 获取上市公司管理层信息
     */
    fun getStkManagers(params: StkManagersParams): Flow<List<StkManagersResult>>

    /**
     * 获取上市公司管理层薪酬和持股情况
     */
    fun getStkRewards(params: StkRewardsParams): Flow<List<StkRewardsResult>>

    /**
     * 获取IPO新股列表数据
     */
    fun getNewShare(params: NewShareParams): Flow<List<NewShareResult>>

    /**
     * 备用基础列表（历史每天股票列表）
     */
    fun getBakBasic(params: BakBasicParams): Flow<List<BakBasicResult>>
}
