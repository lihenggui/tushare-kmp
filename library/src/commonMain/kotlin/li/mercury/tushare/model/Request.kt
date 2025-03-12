package li.mercury.tushare.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Request(
    @SerialName("api_name")
    val apiName: String,
    val fields: String = "ts_code,symbol,name,area,industry,list_date",
    val params: Params,
    val token: String,
)

@Serializable
data class Params(
    @SerialName("end_date")
    val endDate: String = "",
    @SerialName("start_date")
    val startDate: String = "",
    @SerialName("trade_date")
    val tradeDate: String = "",
    @SerialName("ts_code")
    val tsCode: String = "",
)
