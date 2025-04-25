package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
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
import li.mercury.tushare.api.stock.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.models.BrokerRecommendResult
import li.mercury.tushare.api.stock.models.CashflowParams
import li.mercury.tushare.api.stock.models.CashflowResult
import li.mercury.tushare.api.stock.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.models.CcassHoldDetailResult
import li.mercury.tushare.api.stock.models.CcassHoldParams
import li.mercury.tushare.api.stock.models.CcassHoldResult
import li.mercury.tushare.api.stock.models.ConceptDetailParams
import li.mercury.tushare.api.stock.models.ConceptDetailResult
import li.mercury.tushare.api.stock.models.ConceptParams
import li.mercury.tushare.api.stock.models.ConceptResult
import li.mercury.tushare.api.stock.models.CyqChipsParams
import li.mercury.tushare.api.stock.models.CyqChipsResult
import li.mercury.tushare.api.stock.models.CyqPerfParams
import li.mercury.tushare.api.stock.models.CyqPerfResult
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
import li.mercury.tushare.api.stock.models.ReportRcParams
import li.mercury.tushare.api.stock.models.ReportRcResult
import li.mercury.tushare.api.stock.models.RepurchaseParams
import li.mercury.tushare.api.stock.models.RepurchaseResult
import li.mercury.tushare.api.stock.models.ShareFloatParams
import li.mercury.tushare.api.stock.models.ShareFloatResult
import li.mercury.tushare.api.stock.models.StkAuctionCParams
import li.mercury.tushare.api.stock.models.StkAuctionCResult
import li.mercury.tushare.api.stock.models.StkAuctionOParams
import li.mercury.tushare.api.stock.models.StkAuctionOResult
import li.mercury.tushare.api.stock.models.StkFactorParams
import li.mercury.tushare.api.stock.models.StkFactorProParams
import li.mercury.tushare.api.stock.models.StkFactorProResult
import li.mercury.tushare.api.stock.models.StkFactorResult
import li.mercury.tushare.api.stock.models.StkLimitParams
import li.mercury.tushare.api.stock.models.StkLimitResult
import li.mercury.tushare.api.stock.models.StkManagersParams
import li.mercury.tushare.api.stock.models.StkManagersResult
import li.mercury.tushare.api.stock.models.StkNineturnParams
import li.mercury.tushare.api.stock.models.StkNineturnResult
import li.mercury.tushare.api.stock.models.StkPremarketParams
import li.mercury.tushare.api.stock.models.StkPremarketResult
import li.mercury.tushare.api.stock.models.StkRewardsParams
import li.mercury.tushare.api.stock.models.StkRewardsResult
import li.mercury.tushare.api.stock.models.StkSurvParams
import li.mercury.tushare.api.stock.models.StkSurvResult
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockApi(
    private val tuShare: TuShare,
) : StockApiInterface {
    /**
     * 获取股票基本信息
     * @param params 股票基本信息参数
     * @return 股票基本信息数据流
     */
    override fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深股通成份股数据
     * @param params 沪深股通成份股参数
     * @return 沪深股通成份股数据流
     */
    override fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "hs_const",
                    params = apiParams,
                )
            val results = response.getResponseItems(HsConstResult.serializer())
            emit(results)
        }

    /**
     * 获取股票曾用名信息
     * @param params 股票曾用名参数
     * @return 股票曾用名数据流
     */
    override fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "namechange",
                    params = apiParams,
                )
            val results = response.getResponseItems(NameChangeResult.serializer())
            emit(results)
        }

    /**
     * 获取上市公司基本信息
     * @param params 上市公司基本信息参数
     * @return 上市公司基本信息数据流
     */
    override fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_company",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockCompanyResult.serializer())
            emit(results)
        }

    /**
     * 获取卖方盈利预测数据
     * @param params 卖方盈利预测数据请求参数
     * @return 卖方盈利预测数据返回对象列表
     */
    override fun getReportRc(params: ReportRcParams): Flow<List<ReportRcResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "report_rc",
                    params = apiParams,
                )
            val results = response.getResponseItems(ReportRcResult.serializer())
            emit(results)
        }

    /**
     * 获取股票日线行情数据
     * @param params 日线行情参数
     * @return 日线行情数据流
     */
    override fun getDaily(params: DailyParams): Flow<List<DailyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "daily",
                params = apiParams
            )
            val results = response.getResponseItems(DailyResult.serializer())
            emit(results)
        }

    /**
     * 获取股票分钟行情数据
     * @param params 分钟行情参数
     * @return 分钟行情数据流
     */
    override fun getMins(params: MinsParams): Flow<List<MinsResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_mins",
                params = apiParams
            )
            val results = response.getResponseItems(MinsResult.serializer())
            emit(results)
        }

    /**
     * 获取A股周线行情数据
     * @param params 周线行情参数
     * @return 周线行情数据流
     */
    override fun getWeekly(params: WeeklyParams): Flow<List<WeeklyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "weekly",
                params = apiParams
            )
            val results = response.getResponseItems(WeeklyResult.serializer())
            emit(results)
        }

    /**
     * 获取A股月线行情数据
     * @param params 月线行情参数
     * @return 月线行情数据流
     */
    override fun getMonthly(params: MonthlyParams): Flow<List<MonthlyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "monthly",
                params = apiParams
            )
            val results = response.getResponseItems(MonthlyResult.serializer())
            emit(results)
        }

    /**
     * 获取股票周/月线行情数据
     * @param params 周/月线行情参数
     * @return 周/月线行情数据流
     */
    override fun getWeeklyMonthly(params: WeeklyMonthlyParams): Flow<List<WeeklyMonthlyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_weekly_monthly",
                params = apiParams
            )
            val results = response.getResponseItems(WeeklyMonthlyResult.serializer())
            emit(results)
        }

    /**
     * 获取股票周月线行情（复权）
     * @param params 股票周月线行情（复权）参数
     * @return 股票周月线行情（复权）数据流
     */
    override fun getWeeklyMonthlyAdj(params: WeeklyMonthlyAdjParams): Flow<List<WeeklyMonthlyAdjResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_week_month_adj",
                params = apiParams
            )
            val results = response.getResponseItems(WeeklyMonthlyAdjResult.serializer())
            emit(results)
        }

    /**
     * 股票复权因子
     * @param params 股票复权因子参数
     * @return 股票复权因子数据流
     */
    override fun getAdjFactor(params: AdjFactorParams): Flow<List<AdjFactorResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "adj_factor",
                params = apiParams
            )
            val results = response.getResponseItems(AdjFactorResult.serializer())
            emit(results)
        }

    /**
     * 获取股票每日指标数据
     * @param params 股票每日指标参数
     * @return 股票每日指标数据流
     */
    override fun getDailyBasic(params: DailyBasicParams): Flow<List<DailyBasicResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "daily_basic",
                params = apiParams
            )
            val results = response.getResponseItems(DailyBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取股票涨跌停数据
     * @param params 股票涨跌停参数
     * @return 股票涨跌停数据流
     */
    override fun getStkLimit(params: StkLimitParams): Flow<List<StkLimitResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_limit",
                params = apiParams
            )
            val results = response.getResponseItems(StkLimitResult.serializer())
            emit(results)
        }

    /**
     * 获取每日停复牌信息
     * @param params 每日停复牌信息参数
     * @return 每日停复牌信息数据流
     */
    override fun getSuspendD(params: SuspendDParams): Flow<List<SuspendDResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "suspend_d",
                params = apiParams
            )
            val results = response.getResponseItems(SuspendDResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深股通十大成交股数据
     * @param params 沪深股通十大成交股参数
     * @return 沪深股通十大成交股数据流
     */
    override fun getHsgtTop10(params: HsgtTop10Params): Flow<List<HsgtTop10Result>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "hsgt_top10",
                params = apiParams
            )
            val results = response.getResponseItems(HsgtTop10Result.serializer())
            emit(results)
        }

    /**
     * 获取港股通十大成交股数据
     * @param params 港股通十大成交股参数
     */
    override fun getGgtTop10(params: GgtTop10Params): Flow<List<GgtTop10Result>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "ggt_top10",
                params = apiParams
            )
            val results = response.getResponseItems(GgtTop10Result.serializer())
            emit(results)
        }

    /**
     * 获取港股通每日成交统计
     * @param params 港股通每日成交统计参数
     * @return 港股通每日成交统计数据流
     */
    override fun getGgtDaily(params: GgtDailyParams): Flow<List<GgtDailyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "ggt_daily",
                params = apiParams
            )
            val results = response.getResponseItems(GgtDailyResult.serializer())
            emit(results)
        }

    /**
     * 获取港股通月度成交统计
     * @param params 港股通月度成交统计参数
     * @return 港股通月度成交统计数据流
     */
    override fun getGgtMonthly(params: GgtMonthlyParams): Flow<List<GgtMonthlyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "ggt_monthly",
                params = apiParams
            )
            val results = response.getResponseItems(GgtMonthlyResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深股通每日成交统计
     * @param params 沪深股通每日成交统计参数
     * @return 沪深股通每日成交统计数据流
     */
    override fun getBakDaily(params: BakDailyParams): Flow<List<BakDailyResult>> = flow {
        val apiParams = params.toApiParams()
        val response = tuShare.callApi(
            apiName = "bak_daily",
            params = apiParams
        )
        val results = response.getResponseItems(BakDailyResult.serializer())
        emit(results)
    }

    /*
     * 获取利润表数据
     * @param params 请求参数
     * @return 利润表数据流
     */
    override fun getIncome(params: IncomeParams): Flow<List<IncomeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "income",
                    params = apiParams,
                )
            val results = response.getResponseItems(IncomeResult.serializer())
            emit(results)
        }

    /*
     * 获取资产负债表数据
     * @param params 请求参数
     * @return 资产负债表数据流
     */
    override fun getBalanceSheet(params: BalanceSheetParams): Flow<List<BalanceSheetResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "balancesheet",
                    params = apiParams,
                )
            val results = response.getResponseItems(BalanceSheetResult.serializer())
            emit(results)
        }

    /**
     * 获取现金流量表数据
     * @param params 请求参数
     * @return 现金流量表数据流
     */
    override fun getCashflow(params: CashflowParams): Flow<List<CashflowResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cashflow",
                    params = apiParams,
                )
            val results = response.getResponseItems(CashflowResult.serializer())
            emit(results)
        }

    /**
     * 获取业绩预告数据
     * @param params 请求参数
     * @return 业绩预告数据流
     */
    override fun getForecast(params: ForecastParams): Flow<List<ForecastResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "forecast",
                    params = apiParams,
                )
            val results = response.getResponseItems(ForecastResult.serializer())
            emit(results)
        }

    /**
     * 获取业绩快报数据
     * @param params 请求参数
     * @return 业绩快报数据流
     */
    override fun getExpress(params: ExpressParams): Flow<List<ExpressResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "express",
                    params = apiParams,
                )
            val results = response.getResponseItems(ExpressResult.serializer())
            emit(results)
        }

    /**
     * 获取分红送股数据
     * @param params 请求参数
     * @return 分红送股数据流
     */
    override fun getDividend(params: DividendParams): Flow<List<DividendResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "dividend",
                    params = apiParams,
                )
            val results = response.getResponseItems(DividendResult.serializer())
            emit(results)
        }

    /**
     * 获取财务指标数据
     * @param params 请求参数
     * @return 财务指标数据流
     */
    override fun getFinaIndicator(params: FinaIndicatorParams): Flow<List<FinaIndicatorResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "fina_indicator",
                    params = apiParams,
                )
            val results = response.getResponseItems(FinaIndicatorResult.serializer())
            emit(results)
        }

    /**
     * 获取财务审计意见数据
     * @param params 请求参数
     * @return 财务审计意见数据流
     */
    override fun getFinaAudit(params: FinaAuditParams): Flow<List<FinaAuditResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "fina_audit",
                    params = apiParams,
                )
            val results = response.getResponseItems(FinaAuditResult.serializer())
            emit(results)
        }

    /**
     * 获取上市公司主营业务构成数据
     * @param params 请求参数
     * @return 主营业务构成数据流
     */
    override fun getFinaMainbz(params: FinaMainbzParams): Flow<List<FinaMainbzResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "fina_mainbz",
                    params = apiParams,
                )
            val results = response.getResponseItems(FinaMainbzResult.serializer())
            emit(results)
        }

    /**
     * 获取财报披露计划数据
     * @param params 请求参数
     * @return 财报披露计划数据流
     */
    override fun getDisclosureDate(params: DisclosureDateParams): Flow<List<DisclosureDateResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "disclosure_date",
                    params = apiParams,
                )
            val results = response.getResponseItems(DisclosureDateResult.serializer())
            emit(results)
        }

    override fun getStkPremarket(params: StkPremarketParams): Flow<List<StkPremarketResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_premarket",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkPremarketResult.serializer())
            emit(results)
        }

    override fun getTradeCal(params: TradeCalParams): Flow<List<TradeCalResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "trade_cal",
                    params = apiParams,
                )
            val results = response.getResponseItems(TradeCalResult.serializer())
            emit(results)
        }

    override fun getStkManagers(params: StkManagersParams): Flow<List<StkManagersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_managers",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkManagersResult.serializer())
            emit(results)
        }

    override fun getStkRewards(params: StkRewardsParams): Flow<List<StkRewardsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_rewards",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkRewardsResult.serializer())
            emit(results)
        }

    override fun getNewShare(params: NewShareParams): Flow<List<NewShareResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "new_share",
                    params = apiParams,
                )
            val results = response.getResponseItems(NewShareResult.serializer())
            emit(results)
        }

    override fun getBakBasic(params: BakBasicParams): Flow<List<BakBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "bak_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(BakBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取前十大股东
     * @param params 请求参数
     * @return 前十大股东数据流
     */
    override fun getTop10Holders(params: Top10HoldersParams): Flow<List<Top10HoldersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "top10_holders",
                    params = apiParams,
                )
            val results = response.getResponseItems(Top10HoldersResult.serializer())
            emit(results)
        }

    /**
     * 获取前十大流通股东
     * @param params 请求参数
     * @return 前十大流通股东数据流
     */
    override fun getTop10FloatHolders(params: Top10FloatHoldersParams): Flow<List<Top10FloatHoldersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "top10_floatholders",
                    params = apiParams,
                )
            val results = response.getResponseItems(Top10FloatHoldersResult.serializer())
            emit(results)
        }

    /**
     * 获取股权质押统计数据
     * @param params 请求参数
     * @return 股权质押统计数据流
     */
    override fun getPledgeStat(params: PledgeStatParams): Flow<List<PledgeStatResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "pledge_stat",
                    params = apiParams,
                )
            val results = response.getResponseItems(PledgeStatResult.serializer())
            emit(results)
        }

    /**
     * 获取股权质押明细数据
     * @param params 请求参数
     * @return 股权质押明细数据流
     */
    override fun getPledgeDetail(params: PledgeDetailParams): Flow<List<PledgeDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "pledge_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(PledgeDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取股票回购信息
     * @param params 请求参数
     * @return 股票回购信息数据流
     */
    override fun getRepurchase(params: RepurchaseParams): Flow<List<RepurchaseResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "repurchase",
                    params = apiParams,
                )
            val results = response.getResponseItems(RepurchaseResult.serializer())
            emit(results)
        }

    /**
     * 获取概念股分类
     * @param params 请求参数
     * @return 概念股分类数据流
     */
    override fun getConcept(params: ConceptParams): Flow<List<ConceptResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "concept",
                    params = apiParams,
                )
            val results = response.getResponseItems(ConceptResult.serializer())
            emit(results)
        }

    /**
     * 获取概念股列表
     * @param params 请求参数
     * @return 概念股列表数据流
     */
    override fun getConceptDetail(params: ConceptDetailParams): Flow<List<ConceptDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "concept_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(ConceptDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取限售股解禁数据
     * @param params 请求参数
     * @return 限售股解禁数据流
     */
    override fun getShareFloat(params: ShareFloatParams): Flow<List<ShareFloatResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "share_float",
                    params = apiParams,
                )
            val results = response.getResponseItems(ShareFloatResult.serializer())
            emit(results)
        }

    /**
     * 获取大宗交易数据
     * @param params 请求参数
     * @return 大宗交易数据流
     */
    override fun getBlockTrade(params: BlockTradeParams): Flow<List<BlockTradeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "block_trade",
                    params = apiParams,
                )
            val results = response.getResponseItems(BlockTradeResult.serializer())
            emit(results)
        }

    /**
     * 获取股东人数
     * @param params 请求参数
     * @return 股东人数数据流
     */
    override fun getStockHolderNumber(params: StockHolderNumberParams): Flow<List<StockHolderNumberResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_holdernumber",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockHolderNumberResult.serializer())
            emit(results)
        }

    /**
     * 获取股东增减持数据
     * @param params 请求参数
     * @return 股东增减持数据流
     */
    override fun getStockHolderTrade(params: StockHolderTradeParams): Flow<List<StockHolderTradeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_holdertrade",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockHolderTradeResult.serializer())
            emit(results)
        }

    /**
     * 获取每日筹码及胜率数据
     * @param params 请求参数
     * @return 每日筹码及胜率数据流
     */
    override fun getCyqPerf(params: CyqPerfParams): Flow<List<CyqPerfResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cyq_perf",
                    params = apiParams,
                )
            val results = response.getResponseItems(CyqPerfResult.serializer())
            emit(results)
        }

    /**
     * 获取每日筹码分布数据
     * @param params 请求参数
     * @return 每日筹码分布数据流
     */
    override fun getCyqChips(params: CyqChipsParams): Flow<List<CyqChipsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cyq_chips",
                    params = apiParams,
                )
            val results = response.getResponseItems(CyqChipsResult.serializer())
            emit(results)
        }

    /**
     * 获取股票技术因子数据
     * @param params 请求参数
     * @return 股票技术因子数据流
     */
    override fun getStkFactor(params: StkFactorParams): Flow<List<StkFactorResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_factor",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkFactorResult.serializer())
            emit(results)
        }

    /**
     * 获取股票技术面因子（专业版）数据
     * @param params 请求参数
     * @return 股票技术面因子数据流
     */
    override fun getStkFactorPro(params: StkFactorProParams): Flow<List<StkFactorProResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_factor_pro",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkFactorProResult.serializer())
            emit(results)
        }

    /**
     * 获取中央结算系统持股汇总数据
     * @param params 请求参数
     * @return 中央结算系统持股汇总数据流
     */
    override fun getCcassHold(params: CcassHoldParams): Flow<List<CcassHoldResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "ccass_hold",
                params = apiParams
            )
            val results = response.getResponseItems(CcassHoldResult.serializer())
            emit(results)
        }

    /**
     * 获取中央结算系统持股明细数据
     * @param params 请求参数
     * @return 中央结算系统持股明细数据流
     */
    override fun getCcassHoldDetail(params: CcassHoldDetailParams): Flow<List<CcassHoldDetailResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "ccass_hold_detail",
                params = apiParams
            )
            val results = response.getResponseItems(CcassHoldDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取股票开盘集合竞价数据
     * @param params 请求参数
     * @return 股票开盘集合竞价数据流
     */
    override fun getStkAuctionO(params: StkAuctionOParams): Flow<List<StkAuctionOResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_auction_o",
                params = apiParams
            )
            val results = response.getResponseItems(StkAuctionOResult.serializer())
            emit(results)
        }

    /**
     * 获取股票收盘集合竞价数据
     * @param params 请求参数
     * @return 股票收盘集合竞价数据流
     */
    override fun getStkAuctionC(params: StkAuctionCParams): Flow<List<StkAuctionCResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_auction_c",
                params = apiParams
            )
            val results = response.getResponseItems(StkAuctionCResult.serializer())
            emit(results)
        }

    /**
     * 获取神奇九转指标数据
     * @param params 请求参数
     * @return 神奇九转指标数据流
     */
    override fun getStkNineturn(params: StkNineturnParams): Flow<List<StkNineturnResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_nineturn",
                params = apiParams
            )
            val results = response.getResponseItems(StkNineturnResult.serializer())
            emit(results)
        }

    /**
     * 获取股票调研数据
     * @param params 请求参数
     * @return 股票调研数据流
     */
    override fun getStkSurv(params: StkSurvParams): Flow<List<StkSurvResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "stk_surv",
                params = apiParams
            )
            val results = response.getResponseItems(StkSurvResult.serializer())
            emit(results)
        }

    /**
     * 获取券商每月荐股数据
     * @param params 请求参数
     * @return 券商每月荐股数据流
     */
    override fun getBrokerRecommend(params: BrokerRecommendParams): Flow<List<BrokerRecommendResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "broker_recommend",
                params = apiParams
            )
            val results = response.getResponseItems(BrokerRecommendResult.serializer())
            emit(results)
        }
}
