package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.Serializable

@Serializable
data class HmListParams(
    /** 游资名称 */
    val name: String? = null,
)
