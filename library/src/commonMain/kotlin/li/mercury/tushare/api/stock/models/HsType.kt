package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 沪深港通类型
 */
@Serializable
enum class HsType {
    /** 沪股通 */
    SH,

    /** 深股通 */
    SZ,
}