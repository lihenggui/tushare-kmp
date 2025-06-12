package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 国际指数日线行情请求参数
 */
@Serializable
public data class IndexGlobalParams(
    /**
     * TS指数代码
     *
     * 可选参数，支持的国际指数代码如XIN9、HSI等
     */
    @SerialName("ts_code")
    val tsCode: TsIndexCode? = null,
    /**
     * 交易日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /**
     * 结束日期（YYYYMMDD格式）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
