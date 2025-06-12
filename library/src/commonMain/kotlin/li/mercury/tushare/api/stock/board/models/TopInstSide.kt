package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.SerialName

public enum class TopInstSide {
    @SerialName("0")
    BUY_TOP_FIVE,

    @SerialName("1")
    SELL_TOP_FIVE,
}
