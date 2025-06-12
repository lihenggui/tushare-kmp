package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

@Serializable
public data class LimitListDResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 所属行业 */
    val industry: String? = null,
    /** 股票名称 */
    val name: String? = null,
    /** 收盘价 */
    val close: Float? = null,
    /** 涨跌幅 */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 成交额 */
    val amount: Float? = null,
    /** 板上成交金额（涨停无此数据） */
    @SerialName("limit_amount")
    val limitAmount: Float? = null,
    /** 流通市值 */
    @SerialName("float_mv")
    val floatMv: Float? = null,
    /** 总市值 */
    @SerialName("total_mv")
    val totalMv: Float? = null,
    /** 换手率 */
    @SerialName("turnover_ratio")
    val turnoverRatio: Float? = null,
    /** 封单金额 */
    @SerialName("fd_amount")
    val fdAmount: Float? = null,
    /** 首次封板时间（跌停无此数据） */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("first_time")
    val firstTime: LocalDateTime? = null,
    /** 最后封板时间 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("last_time")
    val lastTime: LocalDateTime? = null,
    /** 炸板次数（跌停为开板次数） */
    @SerialName("open_times")
    val openTimes: Int? = null,
    /** 涨停统计（N/T，T天有N次涨停） */
    @SerialName("up_stat")
    val upStat: String? = null,
    /** 连板数 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("limit_times")
    val limitTimes: LocalDateTime? = null,
    /** D跌停，U涨停，Z炸板 */
    val limit: String? = null,
)
