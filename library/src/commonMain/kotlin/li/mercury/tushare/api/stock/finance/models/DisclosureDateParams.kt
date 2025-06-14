package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 财报披露计划API请求参数
 */
@Serializable
public data class DisclosureDateParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 财报周期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 计划披露日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("pre_date")
    val preDate: LocalDate? = null,
    /** 实际披露日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("actual_date")
    val actualDate: LocalDate? = null,
)
