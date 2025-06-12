package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 指数成分和权重API请求参数
 */
@Serializable
public data class IndexWeightParams(
    /**
     * 指数代码
     *
     * 必选参数，来源指数基础信息接口
     */
    @SerialName("index_code")
    val indexCode: TsCode,
    /**
     * 交易日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /**
     * 结束日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
