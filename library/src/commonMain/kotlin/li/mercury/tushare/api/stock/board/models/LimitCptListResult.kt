package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class LimitCptListResult(
    /** 板块代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 板块名称 */
    val name: String? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 上榜天数 */
    val days: Int? = null,
    /** 连板高度 */
    @SerialName("up_stat")
    val upStat: String? = null,
    /** 连板家数 */
    @SerialName("cons_nums")
    val consNums: Int? = null,
    /** 涨停家数 */
    @SerialName("up_nums")
    val upNums: String? = null,
    /** 涨跌幅% */
    @SerialName("pct_chg")
    val pctChg: Float? = null,
    /** 板块热点排名 */
    val rank: String? = null,
)
