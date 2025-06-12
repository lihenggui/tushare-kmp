package li.mercury.tushare.api.index

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
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
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.createRequest
import li.mercury.tushare.http.perform
import li.mercury.tushare.utils.toApiParams

/**
 * 指数相关API的实现类
 */
internal class IndexApi(
    private val requester: HttpRequester
) : IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回指数基本信息列表
     */
    override suspend fun getIndexBasic(params: IndexBasicParams): List<IndexBasicResult> {
        val request = requester.createRequest("index_basic", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取指数日线行情
     *
     * @param params 指数日线行情查询参数
     * @return 返回指数日线行情列表
     */
    override suspend fun getIndexDaily(params: IndexDailyParams): List<IndexDailyResult> {
        val request = requester.createRequest("index_daily", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取指数周线行情
     *
     * @param params 指数周线行情查询参数
     * @return 返回指数周线行情列表
     */
    override suspend fun getIndexWeekly(params: IndexWeeklyParams): List<IndexWeeklyResult> {
        val request = requester.createRequest("index_weekly", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取指数月线行情
     *
     * @param params 指数月线行情查询参数
     * @return 返回指数月线行情列表
     */
    override suspend fun getIndexMonthly(params: IndexMonthlyParams): List<IndexMonthlyResult> {
        val request = requester.createRequest("index_monthly", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取指数成分和权重，月度数据
     *
     * @param params 指数成分和权重查询参数
     * @return 返回指数成分和权重列表
     */
    override suspend fun getIndexWeight(params: IndexWeightParams): List<IndexWeightResult> {
        val request = requester.createRequest("index_weight", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取大盘指数每日指标
     * @param params 大盘指数每日指标查询参数
     * @return 返回每日指标列表
     */
    override suspend fun getIndexDailyBasic(params: IndexDailyBasicParams): List<IndexDailyBasicResult> {
        val request = requester.createRequest("index_dailybasic", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取申万行业分类数据
     * @param params 申万行业分类查询参数
     * @return 返回行业分类数据列表
     */
    override suspend fun getIndexClassify(params: IndexClassifyParams): List<IndexClassifyResult> {
        val request = requester.createRequest("index_classify", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取申万行业成分构成
     *
     * @param params 申万行业成分构成查询参数
     * @return 返回行业成分构成列表
     */
    override suspend fun getIndexMemberAll(params: IndexMemberAllParams): List<IndexMemberAllResult> {
        val request = requester.createRequest("index_member_all", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取申万行业日线行情
     *
     * @param params 申万行业日线行情查询参数
     * @return 返回申万行业日线行情列表
     */
    override suspend fun getSwDaily(params: SwDailyParams): List<SwDailyResult> {
        val request = requester.createRequest("sw_daily", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取市场交易统计数据
     *
     * @param params 市场交易统计查询参数
     * @return 返回市场交易统计数据列表
     */
    override suspend fun getDailyInfo(params: DailyInfoParams): List<DailyInfoResult> {
        val request = requester.createRequest("daily_info", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取深圳市场每日交易概况
     *
     * @param params 深圳市场交易概况查询参数
     * @return 返回交易概况数据列表
     */
    override suspend fun getSzDailyInfo(params: SzDailyInfoParams): List<SzDailyInfoResult> {
        val request = requester.createRequest("sz_daily_info", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺板块指数行情
     *
     * @param params 同花顺指数行情查询参数
     * @return 返回同花顺指数行情列表
     */
    override suspend fun getThsDaily(params: ThsDailyParams): List<ThsDailyResult> {
        val request = requester.createRequest("ths_daily", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取中信行业指数日线行情
     *
     * @param params 中信行业指数查询参数
     * @return 返回中信行业指数行情列表
     */
    override suspend fun getCiDaily(params: CiDailyParams): List<CiDailyResult> {
        val request = requester.createRequest("ci_daily", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取国际主要指数日线行情
     *
     * @param params 国际指数查询参数
     * @return 返回国际指数行情列表
     */
    override suspend fun getIndexGlobal(params: IndexGlobalParams): List<IndexGlobalResult> {
        val request = requester.createRequest("index_global", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取指数技术因子专业版数据
     * @param params 技术因子查询参数
     * @return 返回技术因子数据列表
     */
    override suspend fun getIdxFactorPro(params: IdxFactorProParams): List<IdxFactorProResult> {
        val request = requester.createRequest("idx_factor_pro", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
