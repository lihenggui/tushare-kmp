package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.index.models.CiDailyParams
import li.mercury.tushare.api.index.models.CiDailyResult
import li.mercury.tushare.api.index.models.DailyInfoParams
import li.mercury.tushare.api.index.models.DailyInfoResult
import li.mercury.tushare.api.index.models.IdxFactorProParams
import li.mercury.tushare.api.index.models.IdxFactorProResult
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexBasicResult
import li.mercury.tushare.api.index.models.IndexClassifyParams
import li.mercury.tushare.api.index.models.IndexClassifyResult
import li.mercury.tushare.api.index.models.IndexDailyBasicParams
import li.mercury.tushare.api.index.models.IndexDailyBasicResult
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexDailyResult
import li.mercury.tushare.api.index.models.IndexGlobalParams
import li.mercury.tushare.api.index.models.IndexGlobalResult
import li.mercury.tushare.api.index.models.IndexMemberAllParams
import li.mercury.tushare.api.index.models.IndexMemberAllResult
import li.mercury.tushare.api.index.models.IndexMonthlyParams
import li.mercury.tushare.api.index.models.IndexMonthlyResult
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeeklyResult
import li.mercury.tushare.api.index.models.IndexWeightParams
import li.mercury.tushare.api.index.models.IndexWeightResult
import li.mercury.tushare.api.index.models.SwDailyParams
import li.mercury.tushare.api.index.models.SwDailyResult
import li.mercury.tushare.api.index.models.SzDailyInfoParams
import li.mercury.tushare.api.index.models.SzDailyInfoResult
import li.mercury.tushare.api.index.models.ThsDailyParams
import li.mercury.tushare.api.index.models.ThsDailyResult
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
            val response =
                tuShare.callApi(
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
            val response =
                tuShare.callApi(
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

            val response =
                tuShare.callApi(
                    apiName = "index_dailybasic",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexDailyBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取申万行业分类数据
     * @param params 申万行业分类查询参数
     * @return 返回包含行业分类数据的Flow流
     */
    override fun getIndexClassify(params: IndexClassifyParams): Flow<List<IndexClassifyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_classify",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexClassifyResult.serializer())
            emit(results)
        }

    /**
     * 获取申万行业成分构成
     *
     * @param params 申万行业成分构成查询参数
     * @return 返回包含行业成分构成的Flow流
     */
    override fun getIndexMemberAll(params: IndexMemberAllParams): Flow<List<IndexMemberAllResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_member_all",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexMemberAllResult.serializer())
            emit(results)
        }

    /**
     * 获取申万行业日线行情
     *
     * @param params 申万行业日线行情查询参数
     * @return 返回包含申万行业日线行情的Flow流
     */
    override fun getSwDaily(params: SwDailyParams): Flow<List<SwDailyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "sw_daily",
                    params = apiParams,
                )
            val results = response.getResponseItems(SwDailyResult.serializer())
            emit(results)
        }

    /**
     * 获取市场交易统计数据
     *
     * @param params 市场交易统计查询参数
     * @return 返回包含市场交易统计数据的Flow流
     */
    override fun getDailyInfo(params: DailyInfoParams): Flow<List<DailyInfoResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "daily_info",
                    params = apiParams,
                )
            val results = response.getResponseItems(DailyInfoResult.serializer())
            emit(results)
        }

    /**
     * 获取深圳市场每日交易概况
     *
     * @param params 深圳市场交易概况查询参数
     * @return 返回包含交易概况数据的Flow流
     */
    override fun getSzDailyInfo(params: SzDailyInfoParams): Flow<List<SzDailyInfoResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "sz_daily_info",
                    params = apiParams,
                )
            val results = response.getResponseItems(SzDailyInfoResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺板块指数行情
     *
     * @param params 同花顺指数行情查询参数
     * @return 返回包含同花顺指数行情的Flow流
     */
    override fun getThsDaily(params: ThsDailyParams): Flow<List<ThsDailyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ths_daily",
                    params = apiParams,
                )
            val results = response.getResponseItems(ThsDailyResult.serializer())
            emit(results)
        }

    /**
     * 获取中信行业指数日线行情
     *
     * @param params 中信行业指数查询参数
     * @return 返回包含中信行业指数行情的Flow流
     */
    override fun getCiDaily(params: CiDailyParams): Flow<List<CiDailyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ci_daily",
                    params = apiParams,
                )
            val results = response.getResponseItems(CiDailyResult.serializer())
            emit(results)
        }

    /**
     * 获取国际主要指数日线行情
     *
     * @param params 国际指数查询参数
     * @return 返回包含国际指数行情的Flow流
     */
    override fun getIndexGlobal(params: IndexGlobalParams): Flow<List<IndexGlobalResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "index_global",
                    params = apiParams,
                )
            val results = response.getResponseItems(IndexGlobalResult.serializer())
            emit(results)
        }

    /**
     * 获取指数技术因子专业版数据
     * @param params 技术因子查询参数
     * @return 返回包含技术因子数据的Flow流
     */
    override fun getIdxFactorPro(params: IdxFactorProParams): Flow<List<IdxFactorProResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "idx_factor_pro",
                    params = apiParams,
                )
            val results = response.getResponseItems(IdxFactorProResult.serializer())
            emit(results)
        }
}
