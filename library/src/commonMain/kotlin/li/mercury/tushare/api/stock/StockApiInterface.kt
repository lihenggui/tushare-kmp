package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.AdjFactorParams
import li.mercury.tushare.api.stock.models.AdjFactorResult
import li.mercury.tushare.api.stock.models.BakBasicParams
import li.mercury.tushare.api.stock.models.BakBasicResult
import li.mercury.tushare.api.stock.models.BakDailyParams
import li.mercury.tushare.api.stock.models.BakDailyResult
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
import li.mercury.tushare.api.stock.models.DailyBasicParams
import li.mercury.tushare.api.stock.models.DailyBasicResult
import li.mercury.tushare.api.stock.models.DailyParams
import li.mercury.tushare.api.stock.models.DailyResult
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
import li.mercury.tushare.api.stock.models.GgtDailyParams
import li.mercury.tushare.api.stock.models.GgtDailyResult
import li.mercury.tushare.api.stock.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.models.GgtMonthlyResult
import li.mercury.tushare.api.stock.models.GgtTop10Params
import li.mercury.tushare.api.stock.models.GgtTop10Result
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.HsgtTop10Params
import li.mercury.tushare.api.stock.models.HsgtTop10Result
import li.mercury.tushare.api.stock.models.IncomeParams
import li.mercury.tushare.api.stock.models.IncomeResult
import li.mercury.tushare.api.stock.models.MarginDetailParams
import li.mercury.tushare.api.stock.models.MarginDetailResult
import li.mercury.tushare.api.stock.models.MarginParams
import li.mercury.tushare.api.stock.models.MarginResult
import li.mercury.tushare.api.stock.models.MarginSecsParams
import li.mercury.tushare.api.stock.models.MarginSecsResult
import li.mercury.tushare.api.stock.models.MinsParams
import li.mercury.tushare.api.stock.models.MinsResult
import li.mercury.tushare.api.stock.models.MonthlyParams
import li.mercury.tushare.api.stock.models.MonthlyResult
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
import li.mercury.tushare.api.stock.models.SlbLenMmParams
import li.mercury.tushare.api.stock.models.SlbLenMmResult
import li.mercury.tushare.api.stock.models.SlbLenParams
import li.mercury.tushare.api.stock.models.SlbLenResult
import li.mercury.tushare.api.stock.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.models.SlbSecDetailResult
import li.mercury.tushare.api.stock.models.SlbSecParams
import li.mercury.tushare.api.stock.models.SlbSecResult
import li.mercury.tushare.api.stock.models.StkLimitParams
import li.mercury.tushare.api.stock.models.StkLimitResult
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
import li.mercury.tushare.api.stock.models.SuspendDParams
import li.mercury.tushare.api.stock.models.SuspendDResult
import li.mercury.tushare.api.stock.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.models.Top10HoldersParams
import li.mercury.tushare.api.stock.models.Top10HoldersResult
import li.mercury.tushare.api.stock.models.TradeCalParams
import li.mercury.tushare.api.stock.models.TradeCalResult
import li.mercury.tushare.api.stock.models.WeeklyMonthlyAdjParams
import li.mercury.tushare.api.stock.models.WeeklyMonthlyAdjResult
import li.mercury.tushare.api.stock.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.models.WeeklyParams
import li.mercury.tushare.api.stock.models.WeeklyResult

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
     * 获取股票日线行情数据
     */
    fun getDaily(params: DailyParams): Flow<List<DailyResult>>

    /**
     * 获取股票分钟行情数据
     */
    fun getMins(params: MinsParams): Flow<List<MinsResult>>

    /**
     * 获取A股周线行情数据
     */
    fun getWeekly(params: WeeklyParams): Flow<List<WeeklyResult>>

    /**
     * 获取A股月线行情数据
     */
    fun getMonthly(params: MonthlyParams): Flow<List<MonthlyResult>>

    /**
     * 获取股票周/月线行情数据
     */
    fun getWeeklyMonthly(params: WeeklyMonthlyParams): Flow<List<WeeklyMonthlyResult>>

    /**
     * 获取股票周/月线行情（复权，每日更新）
     */
    fun getWeeklyMonthlyAdj(params: WeeklyMonthlyAdjParams): Flow<List<WeeklyMonthlyAdjResult>>

    /**
     * 获取股票复权因子数据
     */
    fun getAdjFactor(params: AdjFactorParams): Flow<List<AdjFactorResult>>

    /**
     * 获取股票每日指标数据
     */
    fun getDailyBasic(params: DailyBasicParams): Flow<List<DailyBasicResult>>

    /**
     * 获取每日涨跌停价格数据
     */
    fun getStkLimit(params: StkLimitParams): Flow<List<StkLimitResult>>

    /**
     * 获取每日停复牌信息
     */
    fun getSuspendD(params: SuspendDParams): Flow<List<SuspendDResult>>

    /**
     * 获取沪深股通十大成交股数据
     */
    fun getHsgtTop10(params: HsgtTop10Params): Flow<List<HsgtTop10Result>>

    /**
     * 获取港股通十大成交股数据
     */
    fun getGgtTop10(params: GgtTop10Params): Flow<List<GgtTop10Result>>

    /**
     * 获取港股通每日成交统计
     */
    fun getGgtDaily(params: GgtDailyParams): Flow<List<GgtDailyResult>>

    /**
     * 获取港股通每月成交统计
     */
    fun getGgtMonthly(params: GgtMonthlyParams): Flow<List<GgtMonthlyResult>>

    /**
     * 获取备用行情数据
     */
    fun getBakDaily(params: BakDailyParams): Flow<List<BakDailyResult>>

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

    /**
     * 获取融资融券交易汇总数据
     */
    fun getMargin(params: MarginParams): Flow<List<MarginResult>>

    /**
     * 获取融资融券交易明细数据
     */
    fun getMarginDetail(params: MarginDetailParams): Flow<List<MarginDetailResult>>

    /**
     * 获取融资融券标的（盘前更新）
     */
    fun getMarginSecs(params: MarginSecsParams): Flow<List<MarginSecsResult>>

    /**
     * 获取转融券交易汇总数据
     */
    fun getSlbSec(params: SlbSecParams): Flow<List<SlbSecResult>>

    /**
     * 获取转融资交易汇总数据
     */
    fun getSlbLen(params: SlbLenParams): Flow<List<SlbLenResult>>

    /**
     * 获取转融券交易明细数据
     */
    fun getSlbSecDetail(params: SlbSecDetailParams): Flow<List<SlbSecDetailResult>>

    /**
     * 获取做市借券交易汇总数据
     */
    fun getSlbLenMm(params: SlbLenMmParams): Flow<List<SlbLenMmResult>>
}
