package li.mercury.tushare.api.stock.basic.models

import kotlinx.serialization.Serializable

/**
 * 上市状态
 */
@Serializable
public enum class ListStatus {
    /** 上市 */
    L,

    /** 退市 */
    D,

    /** 暂停上市 */
    P,
}
