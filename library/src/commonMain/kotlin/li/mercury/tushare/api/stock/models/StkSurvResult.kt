package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 机构调研表返回对象类
 */
@Serializable
data class StkSurvResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String? = null,
    /** 调研日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("surv_date")
    val survDate: LocalDate? = null,
    /** 机构参与人员 */
    @SerialName("fund_visitors")
    val fundVisitors: String? = null,
    /** 接待地点 */
    @SerialName("rece_place")
    val recePlace: String? = null,
    /** 接待方式 */
    @SerialName("rece_mode")
    val receMode: String? = null,
    /** 接待的公司 */
    @SerialName("rece_org")
    val receOrg: String? = null,
    /** 接待公司类型 */
    @SerialName("org_type")
    val orgType: String? = null,
    /** 上市公司接待人员 */
    @SerialName("comp_rece")
    val compRece: String? = null,
    /** 调研内容 */
    val content: String? = null,
)
