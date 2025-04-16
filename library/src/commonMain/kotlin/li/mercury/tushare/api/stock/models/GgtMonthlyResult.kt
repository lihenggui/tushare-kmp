package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 港股通每月成交统计返回对象类
 */
@Serializable
data class GgtMonthlyResult(
    /** 交易月份（格式：YYYYMM） */
    val month: String,
    /** 当月日均买入成交金额（亿元） */
    @SerialName("day_buy_amt")
    val dayBuyAmt: Double,
    /** 当月日均买入成交笔数（万笔） */
    @SerialName("day_buy_vol")
    val dayBuyVol: Double,
    /** 当月日均卖出成交金额（亿元） */
    @SerialName("day_sell_amt")
    val daySellAmt: Double,
    /** 当月日均卖出成交笔数（万笔） */
    @SerialName("day_sell_vol")
    val daySellVol: Double,
    /** 总买入成交金额（亿元） */
    @SerialName("total_buy_amt")
    val totalBuyAmt: Double,
    /** 总买入成交笔数（万笔） */
    @SerialName("total_buy_vol")
    val totalBuyVol: Double,
    /** 总卖出成交金额（亿元） */
    @SerialName("total_sell_amt")
    val totalSellAmt: Double,
    /** 总卖出成交笔数（万笔） */
    @SerialName("total_sell_vol")
    val totalSellVol: Double
) 