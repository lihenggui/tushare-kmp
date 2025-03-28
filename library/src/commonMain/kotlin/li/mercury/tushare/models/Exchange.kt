package li.mercury.tushare.models

import kotlinx.serialization.Serializable

/**
 * 交易所代码
 */
@Serializable
enum class Exchange {
    /** 上交所 */
    SSE,

    /** 深交所 */
    SZSE,

    /** 北交所 */
    BSE,

    /** 港交所 */
    HKEX,
}
