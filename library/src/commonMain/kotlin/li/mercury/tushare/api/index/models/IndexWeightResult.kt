package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 指数成分和权重返回结果
 */
@Serializable
data class IndexWeightResult(
    /** 指数代码 */
    @SerialName("index_code")
    val indexCode: String,
    /** 成分代码 */
    @SerialName("con_code")
    val conCode: String,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 权重（单位：%） */
    val weight: Double,
)
