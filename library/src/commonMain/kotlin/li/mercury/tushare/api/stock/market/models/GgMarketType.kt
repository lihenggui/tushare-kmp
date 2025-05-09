package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 港股通市场类型枚举
 */
@Serializable
enum class GgMarketType {
    /** 港股通（沪） */
    @SerialName("2")
    SH,

    /** 港股通（深） */
    @SerialName("4")
    SZ,
}