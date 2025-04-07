package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class IndexWeeklyParams(
    /**
     * TS 代码
     *
     * 可选参数，示例："000001.SH"
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 交易日期
     *
     * 可选参数，日期格式：YYYYMMDD，与开始/结束日期互斥
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期
     *
     * 可选参数，日期格式：YYYYMMDD，需与结束日期同时使用
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /**
     * 结束日期
     *
     * 可选参数，日期格式：YYYYMMDD，需与开始日期同时使用
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
