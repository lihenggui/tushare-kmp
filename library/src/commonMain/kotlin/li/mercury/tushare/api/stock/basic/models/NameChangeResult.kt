package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票曾用名返回对象类
 */
@Serializable
data class NameChangeResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 证券名称 */
    val name: String,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 变更原因 */
    @SerialName("change_reason")
    val changeReason: String? = null,
)
