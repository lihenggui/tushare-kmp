package li.mercury.tushare.api.stock.basic.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 沪深股通成分股查询参数
 */
@Serializable
public data class HsConstParams(
    /** 类型：沪股通，深股通 */
    @SerialName("hs_type")
    val hsType: HsType,
    /** 是否最新：1是，0否 */
    @SerialName("is_new")
    val isNew: String = "1",
)
