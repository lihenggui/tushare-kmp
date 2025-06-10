package li.mercury.tushare.api.stock.reference.models

import kotlinx.serialization.Serializable

/**
 * 概念股分类返回对象类
 */
@Serializable
public data class ConceptResult(
    /** 概念分类ID */
    val code: String,
    /** 概念分类名称 */
    val name: String,
    /** 数据来源（目前仅ts） */
    val src: String,
)
