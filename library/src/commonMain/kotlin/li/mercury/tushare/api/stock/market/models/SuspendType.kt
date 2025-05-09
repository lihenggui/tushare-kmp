package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 停复牌类型枚举
 */
@Serializable
enum class SuspendType {
    /** 停牌 */
    @SerialName("S")
    SUSPEND,

    /** 复牌 */
    @SerialName("R")
    RESUME,
}