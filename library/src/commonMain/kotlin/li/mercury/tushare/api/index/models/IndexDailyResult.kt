package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 指数日线行情返回结果
 *
 * | 名称        | 类型  | 描述 |
 * |------------|------|------|
 * | ts_code    | str  | TS 指数代码 |
 * | trade_date | str  | 交易日 |
 * | close      | float | 收盘点位 |
 * | open       | float | 开盘点位 |
 * | high       | float | 最高点位 |
 * | low        | float | 最低点位 |
 * | pre_close  | float | 昨日收盘点 |
 * | change     | float | 涨跌点 |
 * | pct_chg    | float | 涨跌幅（%） |
 * | vol        | float | 成交量（手） |
 * | amount     | float | 成交额（千元） |
 */
@Serializable
data class IndexDailyResult(
    @SerialName("ts_code") val tsCode: String,
    @SerialName("trade_date") val tradeDate: String,
    val close: Double,
    val open: Double,
    val high: Double,
    val low: Double,
    @SerialName("pre_close") val preClose: Double? = null,
    val change: Double? = null,
    @SerialName("pct_chg") val pctChg: Double? = null,
    val vol: Double? = null,
    val amount: Double? = null,
)
