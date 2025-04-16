package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.models.BakBasicParams
import li.mercury.tushare.api.stock.models.BakBasicResult
import li.mercury.tushare.api.stock.models.BalanceSheetParams
import li.mercury.tushare.api.stock.models.BalanceSheetResult
import li.mercury.tushare.api.stock.models.BlockTradeParams
import li.mercury.tushare.api.stock.models.BlockTradeResult
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockApi(
    private val tuShare: TuShare,
) : StockApiInterface {
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

            val response = tuShare.callApi(
                apiName = "stk_premarket",
                params = apiParams
            )
            val results = response.getResponseItems(StkPremarketResult.serializer())
            emit(results)
        }

    override fun getTradeCal(params: TradeCalParams): Flow<List<TradeCalResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "trade_cal",
                params = apiParams
            )
            val results = response.getResponseItems(TradeCalResult.serializer())
            emit(results)
        }

    override fun getStkManagers(params: StkManagersParams): Flow<List<StkManagersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "stk_managers",
                params = apiParams
            )
            val results = response.getResponseItems(StkManagersResult.serializer())
            emit(results)
        }

    override fun getStkRewards(params: StkRewardsParams): Flow<List<StkRewardsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "stk_rewards",
                params = apiParams
            )
            val results = response.getResponseItems(StkRewardsResult.serializer())
            emit(results)
        }

    override fun getNewShare(params: NewShareParams): Flow<List<NewShareResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "new_share",
                params = apiParams
            )
            val results = response.getResponseItems(NewShareResult.serializer())
            emit(results)
        }

    override fun getBakBasic(params: BakBasicParams): Flow<List<BakBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "bak_basic",
                params = apiParams
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
}
