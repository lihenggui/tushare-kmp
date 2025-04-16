package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 公司类型枚举
 */
@Serializable
enum class CompanyType {
    @SerialName("1")
    /** 一般工商业 */
    GENERAL_INDUSTRY,

    @SerialName("2")
    /** 银行 */
    BANK,

    @SerialName("3")
    /** 保险 */
    INSURANCE,

    @SerialName("4")
    /** 证券 */
    SECURITIES;
}
