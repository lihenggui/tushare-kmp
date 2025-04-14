package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 分钟行情频率枚举类
 */
@Serializable
enum class Freq {
    /** 1分钟频率 */
    @SerialName("1min")
    MIN_1,

    /** 5分钟频率 */
    @SerialName("5min")
    MIN_5,

    /** 15分钟频率 */
    @SerialName("15min")
    MIN_15,

    /** 30分钟频率 */
    @SerialName("30min")
    MIN_30,

    /** 60分钟频率 */
    @SerialName("60min")
    MIN_60;
}
