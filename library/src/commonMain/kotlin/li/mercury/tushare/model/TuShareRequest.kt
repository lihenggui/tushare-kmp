package li.mercury.tushare.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.TushareConfig

@Serializable
data class TushareRequest(
    @SerialName("api_name")
    val apiName: String,
    val fields: String,
    val params: Map<String, String>,
    val token: String = TushareConfig.TOKEN,
)
