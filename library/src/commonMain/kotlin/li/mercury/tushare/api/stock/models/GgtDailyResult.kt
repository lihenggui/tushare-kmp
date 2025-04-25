package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 港股通每日成交统计返回对象类
 */
@Serializable
data class GgtDailyResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 买入成交金额（亿元） */
    @SerialName("buy_amount")
    val buyAmount: Float,
    /** 买入成交笔数（万笔） */
    @SerialName("buy_volume")
    val buyVolume: Float,
    /** 卖出成交金额（亿元） */
    @SerialName("sell_amount")
    val sellAmount: Float,
    /** 卖出成交笔数（万笔） */
    @SerialName("sell_volume")
    val sellVolume: Float,
) 