package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 东方财富热板市场类型
 */
enum class DcHotMarket {
    /** A股市场 */
    A_MARKET,

    /** ETF基金 */
    ETF_FUND,

    /** 港股市场 */
    HK_MARKET,

    /** 美股市场 */
    US_MARKET
}

/**
 * 东方财富热板热点类型
 */
enum class DcHotType {
    /** 人气榜 */
    POPULARITY,

    /** 飙升榜 */
    RISING
}

@Serializable
data class DcHotParams(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 类型（A股市场、ETF基金、港股市场、美股市场） */
    val market: String? = null,
    /** 热点类型（人气榜、飙升榜） */
    @SerialName("hot_type")
    val hotType: String? = null,
    /** 是否最新（默认Y，如果为N则为盘中和盘后阶段采集） */
    @SerialName("is_new")
    val isNew: String? = null,
)
