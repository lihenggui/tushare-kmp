package li.mercury.tushare.api.stock.basic.models

import kotlinx.serialization.Serializable

/**
 * 沪深港通标的
 */
@Serializable
public enum class HsTarget {
    /** 否 */
    N,

    /** 沪股通 */
    H,

    /** 深股通 */
    S,
}
