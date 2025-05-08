package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.api.stock.finance.models.MainbzType
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 主营业务构成API请求参数
 */
@Serializable
data class FinaMainbzParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 报告期(每个季度最后一天的日期，如20171231表示年报，20170630表示半年报) */
    val period: String? = null,
    /** 类型：P按产品、D按地区、I按行业 */
    val type: MainbzType? = null,
    /** 报告期开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 报告期结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)
