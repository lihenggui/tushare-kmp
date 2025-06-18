package li.mercury.tushare.api.index

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
public interface IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回指数基本信息列表
     */
    public suspend fun getIndexBasic(params: IndexBasicParams): List<IndexBasicResult>

    /**
     * 获取指数日线行情
     *
     * @param params 指数日线行情查询参数
     * @return 返回指数日线行情列表
     */
    public suspend fun getIndexDaily(params: IndexDailyParams): List<IndexDailyResult>

    /**
     * 获取指数周线行情
     *
     * @param params 指数周线行情查询参数
     * @return 返回指数周线行情列表
     */
    public suspend fun getIndexWeekly(params: IndexWeeklyParams): List<IndexWeeklyResult>

    /**
     * 获取指数月线行情
     *
     * @param params 指数月线行情查询参数
     * @return 返回指数月线行情列表
     */
    public suspend fun getIndexMonthly(params: IndexMonthlyParams): List<IndexMonthlyResult>

    /**
     * 获取指数成分和权重
     *
     * @param params 指数成分和权重查询参数
     * @return 返回指数成分和权重列表
     */
    public suspend fun getIndexWeight(params: IndexWeightParams): List<IndexWeightResult>

    /**
     * 获取大盘指数每日指标
     * @param params 大盘指数每日指标查询参数
     * @return 返回每日指标列表
     */
    public suspend fun getIndexDailyBasic(params: IndexDailyBasicParams): List<IndexDailyBasicResult>

    /**
     * 获取申万行业分类数据
     * @param params 申万行业分类查询参数
     * @return 返回行业分类数据列表
     */
    public suspend fun getIndexClassify(params: IndexClassifyParams): List<IndexClassifyResult>

    /**
     * 申万行业成分构成接口
     *
     * @param params 申万行业成分构成查询参数
     * @return 返回行业成分构成列表
     */
    public suspend fun getIndexMemberAll(params: IndexMemberAllParams): List<IndexMemberAllResult>

    /**
     * 获取申万行业日线行情
     *
     * @param params 申万行业日线行情查询参数
     * @return 返回申万行业日线行情列表
     */
    public suspend fun getSwDaily(params: SwDailyParams): List<SwDailyResult>

    /**
     * 获取市场交易统计数据
     *
     * @param params 市场交易统计查询参数
     * @return 返回市场交易统计数据列表
     */
    public suspend fun getDailyInfo(params: DailyInfoParams): List<DailyInfoResult>

    /**
     * 获取深圳市场每日交易概况
     *
     * @param params 深圳市场交易概况查询参数
     * @return 返回交易概况数据列表
     */
    public suspend fun getSzDailyInfo(params: SzDailyInfoParams): List<SzDailyInfoResult>

    /**
     * 获取同花顺板块指数行情
     *
     * @param params 同花顺指数行情查询参数
     * @return 返回同花顺指数行情列表
     */
    public suspend fun getThsDaily(params: ThsDailyParams): List<ThsDailyResult>

    /**
     * 获取中信行业指数日线行情
     *
     * @param params 中信行业指数查询参数
     * @return 返回中信行业指数行情列表
     */
    public suspend fun getCiDaily(params: CiDailyParams): List<CiDailyResult>

    /**
     * 获取国际主要指数日线行情
     *
     * @param params 国际指数查询参数
     * @return 返回国际指数行情列表
     */
    public suspend fun getIndexGlobal(params: IndexGlobalParams): List<IndexGlobalResult>

    /**
     * 获取指数技术因子专业版数据
     * @param params 技术因子查询参数
     * @return 返回技术因子数据列表
     */
    public suspend fun getIdxFactorPro(params: IdxFactorProParams): List<IdxFactorProResult>
}
