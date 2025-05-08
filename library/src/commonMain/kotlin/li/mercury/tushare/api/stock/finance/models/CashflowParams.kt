package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.api.stock.models.CompanyType
import li.mercury.tushare.api.stock.models.ReportType
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 现金流量表API请求参数
 */
@Serializable
data class CashflowParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告日期 */
    @SerialName("ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val annDate: LocalDate? = null,
    /** 实际公告日期 */
    @SerialName("f_ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val fAnnDate: LocalDate? = null,
    /** 公告开始日期 */
    @SerialName("start_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /** 公告结束日期 */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val period: LocalDate? = null,
    /** 报告类型 */
    @SerialName("report_type")
    val reportType: ReportType? = null,
    /** 公司类型 */
    @SerialName("comp_type")
    val compType: CompanyType? = null,
    /** 是否计算报表 */
    @SerialName("is_calc")
    val isCalc: Int? = null,
)
