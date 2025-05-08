package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 管理层薪酬和持股返回对象类
 */
@Serializable
data class StkRewardsResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 公告日期 */
    @SerialName("ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val annDate: LocalDate? = null,
    /** 截止日期 */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
    /** 姓名 */
    val name: String? = null,
    /** 职务 */
    val title: String? = null,
    /** 报酬（单位：万元） */
    val reward: Double? = null,
    /** 持股数（单位：股） */
    @SerialName("hold_vol")
    val holdVol: Double? = null,
)
