package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

@Serializable
data class ThsMemberParams(
    /** 板块指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 股票代码 */
    @SerialName("con_code")
    val conCode: String? = null,
)
