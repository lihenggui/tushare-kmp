package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 上市公司管理层API请求参数
 */
@Serializable
public data class StkManagersParams(
    /** TS股票代码（支持多个代码，用逗号分隔） */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 公告开始日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 公告结束日期（YYYYMMDD格式） */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)
