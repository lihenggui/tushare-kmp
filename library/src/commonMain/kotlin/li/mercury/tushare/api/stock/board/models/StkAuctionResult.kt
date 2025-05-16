package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class StkAuctionResult(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 数据日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 成交量（股） */
    val vol: Int? = null,
    /** 成交均价（元） */
    val price: Double? = null,
    /** 成交金额（元） */
    val amount: Double? = null,
    /** 昨收价（元） */
    @SerialName("pre_close")
    val preClose: Double? = null,
    /** 换手率（%） */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 量比 */
    @SerialName("volume_ratio")
    val volumeRatio: Double? = null,
    /** 流通股本（万股） */
    @SerialName("float_share")
    val floatShare: Double? = null,
)
