package li.mercury.tushare.api.stock.reference.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 股权质押明细API请求参数
 */
@Serializable
data class PledgeDetailParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
)
