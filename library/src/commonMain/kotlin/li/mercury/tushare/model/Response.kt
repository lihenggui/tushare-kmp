package li.mercury.tushare.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Response(
    val code: Int,
    val `data`: Data,
    val msg: String,
    @SerialName("request_id")
    val requestId: String
)

@Serializable
data class Data(
    val count: Int,
    val fields: List<String>,
    @SerialName("has_more")
    val hasMore: Boolean,
    val items: List<List<String>>
)
