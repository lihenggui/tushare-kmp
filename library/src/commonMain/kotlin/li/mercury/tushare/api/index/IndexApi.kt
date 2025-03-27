package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexBasicResult
import li.mercury.tushare.utils.toApiParams

/**
 * 指数相关API的实现类
 * 
 * @param tuShare TuShare API客户端实例
 */
internal class IndexApi(private val tuShare: TuShare) : IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回包含指数基本信息的Flow流
     */
    override fun getIndexBasic(params: IndexBasicParams): Flow<List<IndexBasicResult>> = flow {
        val apiParams = params.toApiParams()
        
        val response = tuShare.callApi(
            apiName = "index_basic",
            params = apiParams
        )
        val results = response.getResponseItems(IndexBasicResult.serializer())
        emit(results)
    }
} 