package li.mercury.tushare.api.stock.basic.models

import kotlinx.serialization.Serializable

/**
 * 沪深港通类型
 */
@Serializable
public enum class HsType {
    /** 沪股通 */
    SH,

    /** 深股通 */
    SZ,
}
