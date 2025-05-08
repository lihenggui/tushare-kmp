package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 周线行情API请求参数
 */
@Serializable
data class WeeklyParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易日期（每周最后一个交易日） */
    @SerialName("trade_date")
    val tradeDate: String? = null,
    /** 开始日期 */
    @SerialName("start_date")
    val startDate: String? = null,
    /** 结束日期 */
    @SerialName("end_date")
    val endDate: String? = null,
)
