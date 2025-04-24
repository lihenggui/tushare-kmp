package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 分红送股API请求参数
 */
@Serializable
data class DividendParams(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 股权登记日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("record_date")
    val recordDate: LocalDate? = null,
    /** 除权除息日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ex_date")
    val exDate: LocalDate? = null,
    /** 实施公告日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("imp_ann_date")
    val impAnnDate: LocalDate? = null,
)
