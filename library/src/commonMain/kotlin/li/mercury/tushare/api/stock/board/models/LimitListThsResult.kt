package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

@Serializable
data class LimitListThsResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,

    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,

    /** 股票名称 */
    val name: String? = null,

    /** 收盘价（元） */
    val price: Double? = null,

    /** 涨跌幅% */
    @SerialName("pct_chg")
    val pctChg: Double? = null,

    /** 打开次数 */
    @SerialName("open_num")
    val openNum: Int? = null,

    /** 涨停原因 */
    @SerialName("lu_desc")
    val luDesc: String? = null,

    /** 板单类别 */
    @SerialName("limit_type")
    val limitType: String? = null,

    /** 涨停标签 */
    val tag: String? = null,

    /** 涨停状态（N连板、一字板） */
    val status: String? = null,

    /** 首次涨停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("first_lu_time")
    val firstLuTime: LocalDateTime? = null,

    /** 最后涨停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("last_lu_time")
    val lastLuTime: LocalDateTime? = null,

    /** 首次跌停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("first_ld_time")
    val firstLdTime: LocalDateTime? = null,

    /** 最后涨停时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("last_ld_time")
    val lastLdTime: LocalDateTime? = null,

    /** 封单量（元） */
    @SerialName("limit_order")
    val limitOrder: Double? = null,

    /** 封单额（元） */
    @SerialName("limit_amount")
    val limitAmount: Double? = null,

    /** 换手率% */
    @SerialName("turnover_rate")
    val turnoverRate: Double? = null,

    /** 实际流通（元） */
    @SerialName("free_float")
    val freeFloat: Double? = null,

    /** 最大封单（元） */
    @SerialName("lu_limit_order")
    val luLimitOrder: Double? = null,

    /** 近一年涨停封板率 */
    @SerialName("limit_up_suc_rate")
    val limitUpSuccRate: Double? = null,

    /** 成交额 */
    val turnover: Double? = null,

    /** 涨速 */
    @SerialName("rise_rate")
    val riseRate: Double? = null,

    /** 总市值（亿元） */
    @SerialName("sum_float")
    val sumFloat: Double? = null,

    /** 股票类型 */
    @SerialName("market_type")
    val marketType: String? = null
)
