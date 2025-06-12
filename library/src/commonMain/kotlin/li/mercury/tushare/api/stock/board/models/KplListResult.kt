package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

@Serializable
public data class KplListResult(
    /** 代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 名称 */
    val name: String? = null,
    /** 交易时间 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 涨停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("lu_time")
    val luTime: LocalDateTime? = null,
    /** 跌停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("ld_time")
    val ldTime: LocalDateTime? = null,
    /** 开板时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("open_time")
    val openTime: LocalDateTime? = null,
    /** 最后涨停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("last_time")
    val lastTime: LocalDateTime? = null,
    /** 涨停原因 */
    @SerialName("lu_desc")
    val luDesc: String? = null,
    /** 标签 */
    val tag: String? = null,
    /** 板块 */
    val theme: String? = null,
    /** 主力净额（元） */
    @SerialName("net_change")
    val netChange: Double? = null,
    /** 竞价成交额（元） */
    @SerialName("bid_amount")
    val bidAmount: Double? = null,
    /** 状态（N 连板） */
    val status: String? = null,
    /** 竞价净额 */
    @SerialName("bid_change")
    val bidChange: Double? = null,
    /** 竞价换手% */
    @SerialName("bid_turnover")
    val bidTurnover: Double? = null,
    /** 涨停委买额 */
    @SerialName("lu_bid_vol")
    val luBidVol: Double? = null,
    /** 涨跌幅% */
    @SerialName("pct_chg")
    val pctChg: Double? = null,
    /** 竞价涨幅% */
    @SerialName("bid_pct_chg")
    val bidPctChg: Double? = null,
    /** 实时涨幅% */
    @SerialName("rt_pct_chg")
    val rtPctChg: Double? = null,
    /** 封单 */
    @SerialName("limit_order")
    val limitOrder: Double? = null,
    /** 成交额 */
    val amount: Double? = null,
    /** 换手率% */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,
    /** 实际流通 */
    @SerialName("free_float")
    val freeFloat: Double? = null,
    /** 最大封单 */
    @SerialName("lu_limit_order")
    val luLimitOrder: Double? = null,
)
