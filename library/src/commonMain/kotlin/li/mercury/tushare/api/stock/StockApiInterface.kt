package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.BakBasicParams
import li.mercury.tushare.api.stock.models.BakBasicResult
import li.mercury.tushare.api.stock.models.BalanceSheetParams
import li.mercury.tushare.api.stock.models.BalanceSheetResult
import li.mercury.tushare.api.stock.models.BlockTradeParams
import li.mercury.tushare.api.stock.models.BlockTradeResult
import li.mercury.tushare.api.stock.models.CashflowParams
import li.mercury.tushare.api.stock.models.CashflowResult
import li.mercury.tushare.api.stock.models.ConceptDetailParams
import li.mercury.tushare.api.stock.models.ConceptDetailResult
import li.mercury.tushare.api.stock.models.ConceptParams
import li.mercury.tushare.api.stock.models.ConceptResult
import li.mercury.tushare.api.stock.models.DisclosureDateParams
import li.mercury.tushare.api.stock.models.DisclosureDateResult
import li.mercury.tushare.api.stock.models.DividendParams
import li.mercury.tushare.api.stock.models.DividendResult
import li.mercury.tushare.api.stock.models.ExpressParams
import li.mercury.tushare.api.stock.models.ExpressResult
import li.mercury.tushare.api.stock.models.FinaAuditParams
import li.mercury.tushare.api.stock.models.FinaAuditResult
import li.mercury.tushare.api.stock.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.models.FinaIndicatorResult
import li.mercury.tushare.api.stock.models.FinaMainbzParams
import li.mercury.tushare.api.stock.models.FinaMainbzResult
import li.mercury.tushare.api.stock.models.ForecastParams
import li.mercury.tushare.api.stock.models.ForecastResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.IncomeParams
import li.mercury.tushare.api.stock.models.IncomeResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.NewShareParams
import li.mercury.tushare.api.stock.models.NewShareResult
import li.mercury.tushare.api.stock.models.PledgeDetailParams
import li.mercury.tushare.api.stock.models.PledgeDetailResult
import li.mercury.tushare.api.stock.models.PledgeStatParams
import li.mercury.tushare.api.stock.models.PledgeStatResult
import li.mercury.tushare.api.stock.models.RepurchaseParams
import li.mercury.tushare.api.stock.models.RepurchaseResult
import li.mercury.tushare.api.stock.models.ShareFloatParams
import li.mercury.tushare.api.stock.models.ShareFloatResult
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
import li.mercury.tushare.api.stock.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.models.StockHolderTradeResult
import li.mercury.tushare.api.stock.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.models.Top10HoldersParams
import li.mercury.tushare.api.stock.models.Top10HoldersResult
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
     * 获取利润表数据
     */
    fun getIncome(params: IncomeParams): Flow<List<IncomeResult>>

    /**
     * 获取资产负债表数据
     */
    fun getBalanceSheet(params: BalanceSheetParams): Flow<List<BalanceSheetResult>>

    /**
     * 获取现金流量表数据
     */
    fun getCashflow(params: CashflowParams): Flow<List<CashflowResult>>

    /**
     * 获取业绩预告数据
     */
    fun getForecast(params: ForecastParams): Flow<List<ForecastResult>>

    /**
     * 获取业绩快报数据
     */
    fun getExpress(params: ExpressParams): Flow<List<ExpressResult>>

    /**
     * 获取分红送股数据
     */
    fun getDividend(params: DividendParams): Flow<List<DividendResult>>

    /**
     * 获取财务指标数据
     */
    fun getFinaIndicator(params: FinaIndicatorParams): Flow<List<FinaIndicatorResult>>

    /**
     * 获取财务审计意见数据
     */
    fun getFinaAudit(params: FinaAuditParams): Flow<List<FinaAuditResult>>

    /**
     * 获取上市公司主营业务构成数据
     */
    fun getFinaMainbz(params: FinaMainbzParams): Flow<List<FinaMainbzResult>>

    /**
     * 获取财报披露计划数据
     */
    fun getDisclosureDate(params: DisclosureDateParams): Flow<List<DisclosureDateResult>>


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

    /**
     * 获取IPO新股列表数据
     */
    fun getNewShare(params: NewShareParams): Flow<List<NewShareResult>>

    /**
     * 备用基础列表（历史每天股票列表）
     */
    fun getBakBasic(params: BakBasicParams): Flow<List<BakBasicResult>>

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
