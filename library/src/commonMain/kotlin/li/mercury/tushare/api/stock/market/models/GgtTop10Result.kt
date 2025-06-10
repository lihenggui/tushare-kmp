package li.mercury.tushare.api.stock.market.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 港股通十大成交股返回对象类
 */
@Serializable
public data class GgtTop10Result(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String,
    /** 收盘价 */
    val close: Double,
    /** 涨跌幅 */
    @SerialName("p_change")
    val pChange: Double,
    /** 资金排名 */
    val rank: Int? = null,
    /** 市场类型 */
    @SerialName("market_type")
    val marketType: GgMarketType,
    /** 累计成交金额（元） */
    val amount: Double,
    /** 净买入金额（元） */
    @SerialName("net_amount")
    val netAmount: Double,
    /** 沪市成交金额（元） */
    @SerialName("sh_amount")
    val shAmount: Double? = null,
    /** 沪市净买入金额（元） */
    @SerialName("sh_net_amount")
    val shNetAmount: Double? = null,
    /** 沪市买入金额（元） */
    @SerialName("sh_buy")
    val shBuy: Double? = null,
    /** 沪市卖出金额（元） */
    @SerialName("sh_sell")
    val shSell: Double? = null,
    /** 深市成交金额（元） */
    @SerialName("sz_amount")
    val szAmount: Double? = null,
    /** 深市净买入金额（元） */
    @SerialName("sz_net_amount")
    val szNetAmount: Double? = null,
    /** 深市买入金额（元） */
    @SerialName("sz_buy")
    val szBuy: Double? = null,
    /** 深市卖出金额（元） */
    @SerialName("sz_sell")
    val szSell: Double? = null,
)
