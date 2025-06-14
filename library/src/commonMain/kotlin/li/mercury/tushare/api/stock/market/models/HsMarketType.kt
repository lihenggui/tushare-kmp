package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 市场类型枚举
 */
@Serializable
public enum class HsMarketType {
    /** 沪市 */
    @SerialName("1")
    SH,

    /** 深市 */
    @SerialName("3")
    SZ,
}
