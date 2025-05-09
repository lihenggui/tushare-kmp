package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 财报披露计划返回对象类
 */
@Serializable
data class DisclosureDateResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 最新披露公告日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 预计披露日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("pre_date")
    val preDate: LocalDate? = null,
    /** 实际披露日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("actual_date")
    val actualDate: LocalDate? = null,
    /** 披露日期修正记录 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("modify_date")
    val modifyDate: LocalDate? = null,
)
