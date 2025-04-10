package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 深圳市场每日交易概况API请求参数
 */
@Serializable
data class SzDailyInfoParams(
    /**
     * 交易日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    
    /**
     * 板块代码（参见SzTsCode枚举）
     */
    @SerialName("ts_code")
    val tsCode: SzTsCode? = null,
    
    /**
     * 开始日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    
    /**
     * 结束日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null
)
