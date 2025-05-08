package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.api.stock.finance.models.CompanyType
import li.mercury.tushare.api.stock.finance.models.ReportType
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 利润表API请求参数
 */
@Serializable
data class IncomeParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 实际公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("f_ann_date")
    val fAnnDate: LocalDate? = null,
    /** 公告开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 公告结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
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
)
