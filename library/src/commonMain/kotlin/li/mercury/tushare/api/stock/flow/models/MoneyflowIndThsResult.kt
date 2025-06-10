package li.mercury.tushare.api.stock.flow.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
public data class MoneyflowIndThsResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 板块代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 板块名称 */
    @SerialName("industry")
    val industry: String,
    /** 领涨股票名称 */
    @SerialName("lead_stock")
    val leadStock: String,
    /** 收盘指数 */
    @SerialName("close")
    val close: Double,
    /** 指数涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 公司数量 */
    @SerialName("company_num")
    val companyNum: Int,
    /** 领涨股涨跌幅 */
    @SerialName("pct_change_stock")
    val pctChangeStock: Double,
    /** 领涨股最新价 */
    @SerialName("close_price")
    val closePrice: Double,
    /** 流入资金(亿元) */
    @SerialName("net_buy_amount")
    val netBuyAmount: Double,
    /** 流出资金(亿元) */
    @SerialName("net_sell_amount")
    val netSellAmount: Double,
    /** 净额(元) */
    @SerialName("net_amount")
    val netAmount: Double,
)
