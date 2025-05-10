package li.mercury.tushare.api.stock.finance.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 公司类型枚举
 */
@Serializable
enum class CompType {
    /** 一般工商业 */
    @SerialName("1")
    GENERAL,

    /** 银行 */
    @SerialName("2")
    BANK,

    /** 保险 */
    @SerialName("3")
    INSURANCE,

    /** 证券 */
    @SerialName("4")
    SECURITIES,
}
