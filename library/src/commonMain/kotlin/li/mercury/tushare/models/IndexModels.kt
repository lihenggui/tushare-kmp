package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 申万行业分类模型
 *
 * 对应 'sw_industry' API 响应
 */
@Serializable
data class SwIndustry(
    /** 指数代码 */
    @SerialName("index_code") val indexCode: String,
    /** 行业名称 */
    @SerialName("industry_name") val industryName: String,
    /** 行业代码 */
    @SerialName("industry_code") val industryCode: String? = null,
    /** 行业级别 (L1/L2/L3) */
    @SerialName("level") val level: String? = null,
    /** 行业类别 */
    @SerialName("industry_type") val industryType: String? = null,
    /** 是否有效 */
    @SerialName("is_pub") val isPub: String? = null,
    /** 上级代码 */
    @SerialName("parent_code") val parentCode: String? = null,
    /** 开始日期 */
    @SerialName("start_date") val startDate: String? = null,
    /** 结束日期 */
    @SerialName("end_date") val endDate: String? = null
)

/**
 * 申万行业成分股模型
 *
 * 对应 'sw_member' API 响应
 */
@Serializable
data class SwIndexMember(
    /** 指数代码 */
    @SerialName("index_code") val indexCode: String,
    /** 成分股代码 */
    @SerialName("con_code") val conCode: String,
    /** 行业名称 */
    @SerialName("industry_name") val industryName: String? = null,
    /** 行业代码 */
    @SerialName("industry_code") val industryCode: String? = null,
    /** 行业级别 */
    @SerialName("industry_level") val industryLevel: String? = null,
    /** 是否是指数成分股 */
    @SerialName("is_new") val isNew: String? = null,
    /** 纳入日期 */
    @SerialName("in_date") val inDate: String? = null,
    /** 剔除日期 */
    @SerialName("out_date") val outDate: String? = null,
    /** 股票名称 */
    @SerialName("stock_name") val stockName: String? = null
) 