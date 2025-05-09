package li.mercury.tushare.api.stock.reference.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 概念股列表API请求参数
 */
@Serializable
data class ConceptDetailParams(
    /** 概念分类ID（来自concept接口） */
    val id: String? = null,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
)
