package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.models.IndexBasicParams
import li.mercury.tushare.models.IndexBasicResult

/**
 * 指数相关API的存储库接口
 * 
 * 提供对指数基本信息和行情数据的访问
 */
interface IndexRepository {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回包含指数基本信息的Flow流
     */
    fun getIndexBasic(params: IndexBasicParams): Flow<IndexBasicResult>
} 