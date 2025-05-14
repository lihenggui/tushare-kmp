package li.mercury.tushare.api.stock.flow.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class MoneyflowIndDcResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 数据类型 */
    @SerialName("content_type")
    val contentType: String,
    /** DC板块代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 板块名称 */
    @SerialName("name")
    val name: String,
    /** 板块涨跌幅（%） */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 板块最新指数 */
    @SerialName("close")
    val close: Double,
    /** 今日主力净流入净额（元） */
    @SerialName("net_amount")
    val netAmount: Double,
    /** 今日主力净流入净占比（%） */
    @SerialName("net_amount_rate")
    val netAmountRate: Double,
    /** 今日超大单净流入净额（元） */
    @SerialName("buy_elg_amount")
    val buyElgAmount: Double,
    /** 今日超大单净流入净占比（%） */
    @SerialName("buy_elg_amount_rate")
    val buyElgAmountRate: Double,
    /** 今日大单净流入净额（元） */
    @SerialName("buy_lg_amount")
    val buyLgAmount: Double,
    /** 今日大单净流入净占比（%） */
    @SerialName("buy_lg_amount_rate")
    val buyLgAmountRate: Double,
    /** 今日中单净流入净额（元） */
    @SerialName("buy_md_amount")
    val buyMdAmount: Double,
    /** 今日中单净流入净占比（%） */
    @SerialName("buy_md_amount_rate")
    val buyMdAmountRate: Double,
    /** 今日小单净流入净额（元） */
    @SerialName("buy_sm_amount")
    val buySmAmount: Double,
    /** 今日小单净流入净占比（%） */
    @SerialName("buy_sm_amount_rate")
    val buySmAmountRate: Double,
    /** 今日主力净流入最大股 */
    @SerialName("buy_sm_amount_stock")
    val buySmAmountStock: String,
    /** 序号 */
    @SerialName("rank")
    val rank: Int,
)
