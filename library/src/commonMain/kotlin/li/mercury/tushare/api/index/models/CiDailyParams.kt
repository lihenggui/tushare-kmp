package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中信行业指数日线行情请求参数
 */
@Serializable
public data class CiDailyParams(
    /**
     * 行业代码
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 交易日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /**
     * 结束日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
