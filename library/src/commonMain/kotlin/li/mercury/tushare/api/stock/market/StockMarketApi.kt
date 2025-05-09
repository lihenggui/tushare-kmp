package li.mercury.tushare.api.stock.market

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.AdjFactorResult
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.BakDailyResult
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyBasicResult
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.DailyResult
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtDailyResult
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyResult
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.GgtTop10Result
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Result
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MinsResult
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.MonthlyResult
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.StkLimitResult
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.SuspendDResult
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.api.stock.market.models.WeeklyResult
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockMarketApi(
    private val tuShare: TuShare,
) : StockMarketApiInterface {
    /**
     * 获取股票日线行情数据
     * @param params 日线行情参数
     * @return 日线行情数据流
     */
    override fun getDaily(params: DailyParams): Flow<List<DailyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "daily",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "stk_mins",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "weekly",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "monthly",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "stk_weekly_monthly",
                    params = apiParams,
                )
            val results = response.getResponseItems(WeeklyMonthlyResult.serializer())
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
            val response =
                tuShare.callApi(
                    apiName = "adj_factor",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "daily_basic",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "stk_limit",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "suspend_d",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "hsgt_top10",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "ggt_top10",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "ggt_daily",
                    params = apiParams,
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
            val response =
                tuShare.callApi(
                    apiName = "ggt_monthly",
                    params = apiParams,
                )
            val results = response.getResponseItems(GgtMonthlyResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深股通每日成交统计
     * @param params 沪深股通每日成交统计参数
     * @return 沪深股通每日成交统计数据流
     */
    override fun getBakDaily(params: BakDailyParams): Flow<List<BakDailyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "bak_daily",
                    params = apiParams,
                )
            val results = response.getResponseItems(BakDailyResult.serializer())
            emit(results)
        }
}
