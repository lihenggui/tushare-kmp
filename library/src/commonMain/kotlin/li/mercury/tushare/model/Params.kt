package li.mercury.tushare.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Params(
    @SerialName("end_date")
    val endDate: String = "",
    @SerialName("start_date")
    val startDate: String = "",
    @SerialName("ann_date")
    val annDate: String = "",
    @SerialName("trade_date")
    val tradeDate: String = "",
    @SerialName("ts_code")
    val tsCode: String = "",
)