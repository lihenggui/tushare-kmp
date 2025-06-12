package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票曾用名API请求参数
 */
@Serializable
public data class NameChangeParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告开始日期 */
    @SerialName("start_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /** 公告结束日期 */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
