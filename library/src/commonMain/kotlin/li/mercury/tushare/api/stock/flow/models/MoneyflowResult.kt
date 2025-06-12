package li.mercury.tushare.api.stock.flow.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class MoneyflowResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 股票名称 */
    @SerialName("name")
    val name: String,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 最新价 */
    @SerialName("latest")
    val latest: Double,
    /** 资金净流入(万元) */
    @SerialName("net_amount")
    val netAmount: Double,
    /** 5日主力净额(万元) */
    @SerialName("net_d5_amount")
    val netD5Amount: Double,
    /** 今日大单净流入额(万元) */
    @SerialName("buy_lg_amount")
    val buyLgAmount: Double,
    /** 今日大单净流入占比(%) */
    @SerialName("buy_lg_amount_rate")
    val buyLgAmountRate: Double,
    /** 今日中单净流入额(万元) */
    @SerialName("buy_md_amount")
    val buyMdAmount: Double,
    /** 今日中单净流入占比(%) */
    @SerialName("buy_md_amount_rate")
    val buyMdAmountRate: Double,
    /** 今日小单净流入额(万元) */
    @SerialName("buy_sm_amount")
    val buySmAmount: Double,
    /** 今日小单净流入占比(%) */
    @SerialName("buy_sm_amount_rate")
    val buySmAmountRate: Double,
)
