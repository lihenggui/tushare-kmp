package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LimitTypeEnum {
    @SerialName("涨停池")
    LIMIT_UP_POOL,

    @SerialName("连扳池")
    CONSECUTIVE_LIMIT_POOL,

    @SerialName("冲刺涨停")
    SPRINT_LIMIT_UP,

    @SerialName("炸板池")
    BREAK_LIMIT_POOL,

    @SerialName("跌停池")
    LIMIT_DOWN_POOL,
}
