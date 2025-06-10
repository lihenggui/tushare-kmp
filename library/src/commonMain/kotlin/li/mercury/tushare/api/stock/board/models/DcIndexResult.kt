package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class DcIndexResult(
    /** 概念代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 概念名称 */
    val name: String? = null,
    /** 领涨股票名称 */
    val leading: String? = null,
    /** 领涨股票代码 */
    @SerialName("leading_code")
    val leadingCode: String? = null,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Float? = null,
    /** 领涨股票涨跌幅 */
    @SerialName("leading_pct")
    val leadingPct: Float? = null,
    /** 总市值（万元） */
    @SerialName("total_mv")
    val totalMv: Float? = null,
    /** 换手率 */
    @SerialName("turnover_rate")
    val turnoverRate: Float? = null,
    /** 上涨家数 */
    @SerialName("up_num")
    val upNum: Int? = null,
    /** 下降家数 */
    @SerialName("down_num")
    val downNum: Int? = null,
)
