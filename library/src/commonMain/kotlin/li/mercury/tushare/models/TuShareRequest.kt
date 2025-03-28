package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 表示TuShare API请求
 *
 * @property apiName 要调用的API名称
 * @property token TuShare API认证令牌
 * @property params API调用的附加参数
 * @property fields 需要获取的特定字段列表，以逗号分隔
 */
@Serializable
data class TuShareRequest(
    @SerialName("api_name") val apiName: String,
    @SerialName("token") val token: String,
    @SerialName("params") val params: Map<String, String> = emptyMap(),
    @SerialName("fields") val fields: String = "",
)
