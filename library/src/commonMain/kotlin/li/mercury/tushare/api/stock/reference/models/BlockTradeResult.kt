package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 大宗交易返回对象类
 */
@Serializable
data class BlockTradeResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 成交价 */
    val price: Float,
    /** 成交量（万股） */
    val vol: Float,
    /** 成交金额（万元） */
    val amount: Float,
    /** 买方营业部 */
    val buyer: String,
    /** 卖方营业部 */
    val seller: String,
)
