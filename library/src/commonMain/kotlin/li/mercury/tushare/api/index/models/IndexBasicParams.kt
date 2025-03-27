package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Market

/**
 * 指数基本信息API请求参数
 */
@Serializable
data class IndexBasicParams(
    /** 指数代码 */
    val tsCode: String? = null,
    /** 指数简称 */
    val name: String? = null,
    /** 交易所或服务商，如SSE（上交所）, SZSE（深交所）等，默认SSE */
    val market: Market? = null,
    /** 发布商，如申万、中证等 */
    val publisher: String? = null,
    /** 指数类别，如主题指数、行业指数等 */
    val category: String? = null
) 