package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.models.IndexBasicParams
import li.mercury.tushare.models.IndexBasicResult
import li.mercury.tushare.utils.asDoubleOrNull
import li.mercury.tushare.utils.asString
import li.mercury.tushare.utils.asStringOrNull
import li.mercury.tushare.utils.toApiParams

/**
 * 指数相关API的实现类
 * 
 * @param tuShare TuShare API客户端实例
 */
internal class IndexRepositoryImpl(private val tuShare: TuShare) : IndexRepository {
    /**
     * 获取指数基本信息
     *
     * @param params 指数基本信息查询参数
     * @return 返回包含指数基本信息的Flow流
     */
    override fun getIndexBasic(params: IndexBasicParams): Flow<IndexBasicResult> = flow {
        val apiParams = params.toApiParams()
        
        val response = tuShare.callApi(
            apiName = "index_basic",
            params = apiParams
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        for (item in response.items) {
            emit(
                IndexBasicResult(
                tsCode = item[fieldMap["ts_code"] ?: 0].asString(),
                name = item[fieldMap["name"] ?: 1].asString(),
                fullName = item.getOrNull(fieldMap["fullname"] ?: -1)?.asStringOrNull(),
                market = item.getOrNull(fieldMap["market"] ?: -1)?.asStringOrNull(),
                publisher = item.getOrNull(fieldMap["publisher"] ?: -1)?.asStringOrNull(),
                indexType = item.getOrNull(fieldMap["index_type"] ?: -1)?.asStringOrNull(),
                category = item.getOrNull(fieldMap["category"] ?: -1)?.asStringOrNull(),
                baseDate = item.getOrNull(fieldMap["base_date"] ?: -1)?.asStringOrNull(),
                basePoint = item.getOrNull(fieldMap["base_point"] ?: -1)?.asDoubleOrNull(),
                listDate = item.getOrNull(fieldMap["list_date"] ?: -1)?.asStringOrNull(),
                weightRule = item.getOrNull(fieldMap["weight_rule"] ?: -1)?.asStringOrNull(),
                desc = item.getOrNull(fieldMap["desc"] ?: -1)?.asStringOrNull(),
                expDate = item.getOrNull(fieldMap["exp_date"] ?: -1)?.asStringOrNull()
            )
            )
        }
    }
} 