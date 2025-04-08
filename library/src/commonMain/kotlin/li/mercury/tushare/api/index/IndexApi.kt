package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexBasicResult
import li.mercury.tushare.api.index.models.IndexDailyBasicParams
import li.mercury.tushare.api.index.models.IndexDailyBasicResult
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexDailyResult
import li.mercury.tushare.api.index.models.IndexMonthlyParams
import li.mercury.tushare.api.index.models.IndexMonthlyResult
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeeklyResult
import li.mercury.tushare.api.index.models.IndexWeightParams
import li.mercury.tushare.api.index.models.IndexWeightResult
import li.mercury.tushare.utils.toApiParams

/**
 * 指数相关API的实现类
 *
 * @param tuShare TuShare API客户端实例
 */
internal class IndexApi(
    private val tuShare: TuShare,
) : IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回包含指数基本信息的Flow流
     */
    override fun getIndexBasic(params: IndexBasicParams): Flow<List<IndexBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取指数日线行情
     *
     * @param params 指数日线行情查询参数
     * @return 返回包含指数日线行情的Flow流
     */
    override fun getIndexDaily(params: IndexDailyParams): Flow<List<IndexDailyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_daily",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexDailyResult.serializer())
            emit(results)
        }

    /**
     * 获取指数周线行情
     *
     * @param params 指数周线行情查询参数
     * @return 返回包含指数周线行情的Flow流
     */
    override fun getIndexWeekly(params: IndexWeeklyParams): Flow<List<IndexWeeklyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "index_weekly",
                params = apiParams,
            )
            val results = response.getResponseItems(IndexWeeklyResult.serializer())
            emit(results)
        }

    /**
     * 获取指数月线行情
     *
     * @param params 指数月线行情查询参数
     * @return 返回包含指数月线行情的Flow流
     */
    override fun getIndexMonthly(params: IndexMonthlyParams): Flow<List<IndexMonthlyResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response = tuShare.callApi(
                apiName = "index_monthly",
                params = apiParams,
            )
            val results = response.getResponseItems(IndexMonthlyResult.serializer())
            emit(results)
        }

    /**
     * 获取指数成分和权重，月度数据
     *
     * @param params 指数成分和权重查询参数
     * @return 返回包含指数成分和权重的Flow流
     */
    override fun getIndexWeight(params: IndexWeightParams): Flow<List<IndexWeightResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_weight",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexWeightResult.serializer())
            emit(results)
        }

    /**
     * 获取大盘指数每日指标
     * @param params 大盘指数每日指标查询参数
     * @return 返回包含每日指标的Flow流
     */
    override fun getIndexDailyBasic(params: IndexDailyBasicParams): Flow<List<IndexDailyBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response = tuShare.callApi(
                apiName = "index_dailybasic",
                params = apiParams
            )
            val results = response.getResponseItems(IndexDailyBasicResult.serializer())
            emit(results)
        }
}
