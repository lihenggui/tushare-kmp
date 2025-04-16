package li.mercury.tushare.api.stock.models

import kotlinx.serialization.Serializable

/**
 * 概念股分类API请求参数
 */
@Serializable
data class ConceptParams(
    /** 来源，默认为ts */
    val src: String? = null,
) 