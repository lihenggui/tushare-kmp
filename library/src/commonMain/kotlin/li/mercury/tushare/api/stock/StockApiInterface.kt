package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.ConceptDetailParams
import li.mercury.tushare.api.stock.models.ConceptDetailResult
import li.mercury.tushare.api.stock.models.ConceptParams
import li.mercury.tushare.api.stock.models.ConceptResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.PledgeDetailParams
import li.mercury.tushare.api.stock.models.PledgeDetailResult
import li.mercury.tushare.api.stock.models.PledgeStatParams
import li.mercury.tushare.api.stock.models.PledgeStatResult
import li.mercury.tushare.api.stock.models.RepurchaseParams
import li.mercury.tushare.api.stock.models.RepurchaseResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult
import li.mercury.tushare.api.stock.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.models.Top10HoldersParams
import li.mercury.tushare.api.stock.models.Top10HoldersResult

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
     * 获取前十大股东
     */
    fun getTop10Holders(params: Top10HoldersParams): Flow<List<Top10HoldersResult>>

    /**
     * 获取前十大流通股东
     */
    fun getTop10FloatHolders(params: Top10FloatHoldersParams): Flow<List<Top10FloatHoldersResult>>

    /**
     * 获取股权质押统计数据
     */
    fun getPledgeStat(params: PledgeStatParams): Flow<List<PledgeStatResult>>

    /**
     * 获取股权质押明细数据
     */
    fun getPledgeDetail(params: PledgeDetailParams): Flow<List<PledgeDetailResult>>

    /**
     * 获取股票回购信息
     */
    fun getRepurchase(params: RepurchaseParams): Flow<List<RepurchaseResult>>

    /**
     * 获取概念股分类
     */
    fun getConcept(params: ConceptParams): Flow<List<ConceptResult>>

    /**
     * 获取概念股列表
     */
    fun getConceptDetail(params: ConceptDetailParams): Flow<List<ConceptDetailResult>>
}
