package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 财务审计意见返回结果
 */
@Serializable
data class FinaAuditResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 审计结果 */
    @SerialName("audit_result")
    val auditResult: String? = null,
    /** 审计总费用（元） */
    @SerialName("audit_fees")
    val auditFees: Double? = null,
    /** 会计事务所 */
    @SerialName("audit_agency")
    val auditAgency: String? = null,
    /** 签字会计师 */
    @SerialName("audit_sign")
    val auditSign: String? = null,
) 