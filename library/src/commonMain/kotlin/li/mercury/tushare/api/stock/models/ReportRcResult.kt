package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 卖方盈利预测数据返回对象类
 */
@Serializable
data class ReportRcResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String,
    /** 研报日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("report_date")
    val reportDate: LocalDate,
    /** 报告标题 */
    @SerialName("report_title")
    val reportTitle: String? = null,
    /** 报告类型 */
    @SerialName("report_type")
    val reportType: String? = null,
    /** 报告分类 */
    val classify: String? = null,
    /** 机构名称 */
    @SerialName("org_name")
    val orgName: String? = null,
    /** 作者 */
    @SerialName("author_name")
    val authorName: String? = null,
    /** 预测报告期 */
    val quarter: String? = null,
    /** 预测营业收入(万元) */
    @SerialName("op_rt")
    val opRt: Float? = null,
    /** 预测营业利润(万元) */
    @SerialName("op_pr")
    val opPr: Float? = null,
    /** 预测利润总额(万元) */
    val tp: Float? = null,
    /** 预测净利润(万元) */
    val np: Float? = null,
    /** 预测每股收益(元) */
    val eps: Float? = null,
    /** 预测市盈率 */
    val pe: Float? = null,
    /** 预测股息率 */
    val rd: Float? = null,
    /** 预测净资产收益率 */
    val roe: Float? = null,
    /** 预测EV/EBITDA */
    @SerialName("ev_ebitda")
    val evEbitda: Float? = null,
    /** 卖方评级 */
    val rating: String? = null,
    /** 预测最高目标价 */
    @SerialName("max_price")
    val maxPrice: Float? = null,
    /** 预测最低目标价 */
    @SerialName("min_price")
    val minPrice: Float? = null,
    /** 机构关注度 */
    @SerialName("imp_dg")
    val impDg: String? = null,
    /** TS数据更新时间 */
    @SerialName("create_time")
    val createTime: String? = null,
) 