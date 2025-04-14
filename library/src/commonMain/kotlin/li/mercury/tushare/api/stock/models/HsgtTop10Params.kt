package li.mercury.tushare.api.stock.models

import MarketType
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 沪深股通十大成交股API请求参数
 */
@Serializable
data class HsgtTop10Params(
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,

    /** 交易日期（格式：YYYYMMDD） */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,

    /** 开始日期（格式：YYYYMMDD） */
    @SerialName("start_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,

    /** 结束日期（格式：YYYYMMDD） */
    @SerialName("end_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,

    /** 市场类型（1：沪市，3：深市） */
    @SerialName("market_type")
    val marketType: MarketType? = null
)