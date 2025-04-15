package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 报告类型枚举
 */
@Serializable
enum class ReportType {
    @SerialName("1")
    /** 合并报表 */
    CONSOLIDATED,

    @SerialName("2")
    /** 单季合并 */
    SINGLE_QUARTER_CONSOLIDATED,

    @SerialName("3")
    /** 调整单季合并表 */
    ADJUSTED_SINGLE_QUARTER_CONSOLIDATED,

    @SerialName("4")
    /** 调整合并报表 */
    ADJUSTED_CONSOLIDATED,

    @SerialName("5")
    /** 调整前合并报表 */
    PRE_ADJUSTMENT_CONSOLIDATED,

    @SerialName("6")
    /** 母公司报表 */
    PARENT_COMPANY,

    @SerialName("7")
    /** 母公司单季表 */
    PARENT_COMPANY_SINGLE_QUARTER,

    @SerialName("8")
    /** 母公司调整单季表 */
    PARENT_COMPANY_ADJUSTED_SINGLE_QUARTER,

    @SerialName("9")
    /** 母公司调整表 */
    PARENT_COMPANY_ADJUSTED,

    @SerialName("10")
    /** 母公司调整前报表 */
    PARENT_COMPANY_PRE_ADJUSTMENT,

    @SerialName("11")
    /** 母公司调整前合并报表 */
    PARENT_COMPANY_PRE_ADJUSTMENT_CONSOLIDATED,

    @SerialName("12")
    /** 母公司调整前报表 */
    PARENT_COMPANY_PRE_ADJUSTMENT_REPORT;
} 