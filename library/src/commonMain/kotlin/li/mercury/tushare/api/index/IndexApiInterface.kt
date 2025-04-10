package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
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

/**
 * 指数相关API的存储库接口
 *
 * 提供对指数基本信息和行情数据的访问
 */
interface IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回包含指数基本信息的Flow流
     */
    fun getIndexBasic(params: IndexBasicParams): Flow<List<IndexBasicResult>>

    /**
     * 获取指数日线行情
     *
     * @param params 指数日线行情查询参数
     * @return 返回包含指数日线行情的Flow流
     */
    fun getIndexDaily(params: IndexDailyParams): Flow<List<IndexDailyResult>>

    /**
     * 获取指数周线行情
     *
     * @param params 指数周线行情查询参数
     * @return 返回包含指数周线行情的Flow流
     */
    fun getIndexWeekly(params: IndexWeeklyParams): Flow<List<IndexWeeklyResult>>

    /**
     * 获取指数月线行情
     *
     * @param params 指数月线行情查询参数
     * @return 返回包含指数月线行情的Flow流
     */
    fun getIndexMonthly(params: IndexMonthlyParams): Flow<List<IndexMonthlyResult>>

    /**
     * 获取指数成分和权重
     *
     * @param params 指数成分和权重查询参数
     * @return 返回包含指数成分和权重的Flow流
     */
    fun getIndexWeight(params: IndexWeightParams): Flow<List<IndexWeightResult>>

    /**
     * 获取大盘指数每日指标
     * @param params 大盘指数每日指标查询参数
     * @return 返回包含每日指标的Flow流
     */
    fun getIndexDailyBasic(params: IndexDailyBasicParams): Flow<List<IndexDailyBasicResult>>

    /**
     * 获取申万行业分类数据
     * @param params 申万行业分类查询参数
     * @return 返回包含行业分类数据的Flow流
     */
    fun getIndexClassify(params: IndexClassifyParams): Flow<List<IndexClassifyResult>>

    /**
     * 申万行业成分构成接口
     *
     * @param params 申万行业成分构成查询参数
     * @return 返回包含行业成分构成的Flow流
     */
    fun getIndexMemberAll(params: IndexMemberAllParams): Flow<List<IndexMemberAllResult>>

    /**
     * 获取申万行业日线行情
     *
     * @param params 申万行业日线行情查询参数
     * @return 返回包含申万行业日线行情的Flow流
     */
    fun getSwDaily(params: SwDailyParams): Flow<List<SwDailyResult>>

    /**
     * 获取市场交易统计数据
     *
     * @param params 市场交易统计查询参数
     * @return 返回包含市场交易统计数据的Flow流
     */
    fun getDailyInfo(params: DailyInfoParams): Flow<List<DailyInfoResult>>

    /**
     * 获取深圳市场每日交易概况
     *
     * @param params 深圳市场交易概况查询参数
     * @return 返回包含交易概况数据的Flow流
     */
    fun getSzDailyInfo(params: SzDailyInfoParams): Flow<List<SzDailyInfoResult>>

    /**
     * 获取同花顺板块指数行情
     *
     * @param params 同花顺指数行情查询参数
     * @return 返回包含同花顺指数行情的Flow流
     */
    fun getThsDaily(params: ThsDailyParams): Flow<List<ThsDailyResult>>

    /**
     * 获取中信行业指数日线行情
     *
     * @param params 中信行业指数查询参数
     * @return 返回包含中信行业指数行情的Flow流
     */
    fun getCiDaily(params: CiDailyParams): Flow<List<CiDailyResult>>

    /**
     * 获取国际主要指数日线行情
     *
     * @param params 国际指数查询参数
     * @return 返回包含国际指数行情的Flow流
     */
    fun getIndexGlobal(params: IndexGlobalParams): Flow<List<IndexGlobalResult>>

    /**
     * 获取指数技术因子专业版数据
     * @param params 技术因子查询参数
     * @return 返回包含技术因子数据的Flow流
     */
    fun getIdxFactorPro(params: IdxFactorProParams): Flow<List<IdxFactorProResult>>

}
