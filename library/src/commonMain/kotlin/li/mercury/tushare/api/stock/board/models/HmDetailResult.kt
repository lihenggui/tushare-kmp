package li.mercury.tushare.api.stock.board.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class HmDetailResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 股票名称 */
    @SerialName("ts_name")
    val tsName: String? = null,
    /** 买入金额（元） */
    @SerialName("buy_amount")
    val buyAmount: Float? = null,
    /** 卖出金额（元） */
    @SerialName("sell_amount")
    val sellAmount: Float? = null,
    /** 净买卖（元） */
    @SerialName("net_amount")
    val netAmount: Float? = null,
    /** 游资名称 */
    @SerialName("hm_name")
    val hmName: String? = null,
    /** 关联机构（一般为营业部或机构专用） */
    @SerialName("hm_orgs")
    val hmOrgs: String? = null,
    /** 标签 */
    val tag: String? = null,
)
