package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股东增减持API请求参数
 */
@Serializable
public data class StockHolderTradeParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 公告开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 公告结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 交易类型 */
    @SerialName("trade_type")
    val tradeType: TradeType? = null,
    /** 股东类型 */
    @SerialName("holder_type")
    val holderType: HolderType? = null,
)

/**
 * 交易类型枚举
 */
@Serializable
public enum class TradeType {
    /** 增持 */
    @SerialName("IN")
    IN,

    /** 减持 */
    @SerialName("DE")
    DE,
}

/**
 * 股东类型枚举
 */
@Serializable
public enum class HolderType {
    /** 公司 */
    @SerialName("C")
    C,

    /** 个人 */
    @SerialName("P")
    P,

    /** 高管 */
    @SerialName("G")
    G,
}
