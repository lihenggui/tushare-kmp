package li.mercury.tushare.models

import kotlinx.serialization.Serializable

/**
 * 交易所代码
 */
@Serializable
public enum class Exchange {
    /** 上交所 */
    SSE,

    /** 深交所 */
    SZSE,

    /** 北交所 */
    BSE,

    /** 港交所 */
    HKEX,

    /** 沪股通（北向） */
    SH,

    /** 深股通（北向） */
    SZ,

    /** 港股通（南向持股） */
    HK,
}
