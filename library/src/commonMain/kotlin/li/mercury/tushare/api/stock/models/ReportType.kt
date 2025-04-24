package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 报告类型枚举
 */
@Serializable
enum class ReportType {
    /** 合并报表 */
    @SerialName("1")
    CONSOLIDATED,

    /** 单季合并 */
    @SerialName("2")
    SINGLE_QUARTER_CONSOLIDATED,

    /** 调整单季合并表 */
    @SerialName("3")
    ADJUSTED_SINGLE_QUARTER_CONSOLIDATED,

    /** 调整合并报表 */
    @SerialName("4")
    ADJUSTED_CONSOLIDATED,

    /** 调整前合并报表 */
    @SerialName("5")
    PRE_ADJUSTMENT_CONSOLIDATED,

    /** 母公司报表 */
    @SerialName("6")
    PARENT_COMPANY,

    /** 母公司单季表 */
    @SerialName("7")
    PARENT_COMPANY_SINGLE_QUARTER,

    /** 母公司调整单季表 */
    @SerialName("8")
    PARENT_COMPANY_ADJUSTED_SINGLE_QUARTER,

    /** 母公司调整表 */
    @SerialName("9")
    PARENT_COMPANY_ADJUSTED,

    /** 母公司调整前报表 */
    @SerialName("10")
    PARENT_COMPANY_PRE_ADJUSTMENT,

    /** 母公司调整前合并报表 */
    @SerialName("11")
    PARENT_COMPANY_PRE_ADJUSTMENT_CONSOLIDATED,

    /** 母公司调整前报表 */
    @SerialName("12")
    PARENT_COMPANY_PRE_ADJUSTMENT_REPORT,
}
