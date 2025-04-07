package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexBasicResult
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexDailyResult
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeeklyResult

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
}
