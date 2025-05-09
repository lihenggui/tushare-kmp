package li.mercury.tushare.api.stock.reference

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.BlockTradeResult
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailResult
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.ConceptResult
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailResult
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatResult
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseResult
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatResult
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeResult
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersResult

/**
 * 股票相关API的存储库接口
 */
interface StockReferenceApiInterface {
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

    /**
     * 获取限售股解禁数据
     */
    fun getShareFloat(params: ShareFloatParams): Flow<List<ShareFloatResult>>

    /**
     * 获取大宗交易数据
     */
    fun getBlockTrade(params: BlockTradeParams): Flow<List<BlockTradeResult>>

    /**
     * 获取股东人数
     */
    fun getStockHolderNumber(params: StockHolderNumberParams): Flow<List<StockHolderNumberResult>>

    /**
     * 获取股东增减持数据
     */
    fun getStockHolderTrade(params: StockHolderTradeParams): Flow<List<StockHolderTradeResult>>
}
