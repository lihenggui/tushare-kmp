package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 周/月行情频率枚举类
 */
@Serializable
enum class FreqWeekMonth {
    /** 周频率 */
    @SerialName("week")
    WEEK,

    /** 月频率 */
    @SerialName("month")
    MONTH,
}