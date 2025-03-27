package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 沪深股通成分股信息
 */
@Serializable
data class HsConstResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: String,

    /** 沪深港通类型 */
    @SerialName("hs_type")
    val hsType: HsType,

    /** 纳入日期 */
    @SerialName("in_date")
    val inDate: String,

    /** 剔除日期 */
    @SerialName("out_date")
    val outDate: String? = null,

    /** 是否最新 */
    @SerialName("is_new")
    private val isNewStr: String
)