package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 指数技术因子专业版API请求参数
 */
@Serializable
data class IdxFactorProParams(
    /**
     * 指数代码（大盘指数、申万指数、中信指数）
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
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
    /**
     * 交易日期（格式：YYYYMMDD）
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null
)
