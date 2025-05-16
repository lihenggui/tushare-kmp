package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

@Serializable
data class DcHotResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 数据类型 */
    @SerialName("data_type")
    val dataType: String? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 股票名称 */
    @SerialName("ts_name")
    val tsName: String? = null,
    /** 排行或者热度 */
    val rank: Int? = null,
    /** 涨跌幅% */
    @SerialName("pct_change")
    val pctChange: Float? = null,
    /** 当前价 */
    @SerialName("current_price")
    val currentPrice: Float? = null,
    /** 排行榜获取时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("rank_time")
    val rankTime: LocalDateTime? = null,
)
