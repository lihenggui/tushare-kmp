package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.models.DailyParams
import li.mercury.tushare.api.stock.models.DailyResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.MinsParams
import li.mercury.tushare.api.stock.models.MinsResult
import li.mercury.tushare.api.stock.models.MonthlyParams
import li.mercury.tushare.api.stock.models.MonthlyResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult
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
}
