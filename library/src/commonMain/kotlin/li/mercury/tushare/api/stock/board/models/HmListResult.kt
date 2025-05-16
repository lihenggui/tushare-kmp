package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.Serializable

@Serializable
data class HmListResult(
    /** 游资名称 */
    val name: String? = null,
    /** 说明 */
    val desc: String? = null,
    /** 关联机构 */
    val orgs: String? = null,
)
