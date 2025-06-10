package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司管理层返回对象类
 */
@Serializable
public data class StkManagersResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 姓名 */
    val name: String,
    /** 性别 */
    val gender: String,
    /** 岗位类别 */
    val lev: String,
    /** 岗位 */
    val title: String,
    /** 学历 */
    val edu: String? = null,
    /** 国籍 */
    val national: String? = null,
    /** 出生年月 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val birthday: LocalDate? = null,
    /** 上任日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("begin_date")
    val beginDate: LocalDate? = null,
    /** 离任日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 个人简历 */
    val resume: String? = null,
)
