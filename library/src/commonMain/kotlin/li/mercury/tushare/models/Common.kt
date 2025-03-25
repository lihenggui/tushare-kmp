package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

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
    @SerialName("fields") val fields: String = ""
)

/**
 * 表示TuShare API响应
 *
 * @property code 响应代码，0表示成功
 * @property msg 错误信息（如果有）
 * @property data 成功时的响应数据
 */
@Serializable
data class TuShareResponse<T>(
    @SerialName("code") val code: Int,
    @SerialName("msg") val msg: String? = null,
    @SerialName("data") val data: T? = null
)

/**
 * 表示TuShare API数据结构
 *
 * @property fields 字段名列表
 * @property items 数据行列表
 */
@Serializable
data class TuShareData(
    @SerialName("fields") val fields: List<String>,
    @SerialName("items") val items: List<List<JsonElement>>
)

/**
 * TuShare API调用失败时抛出的异常
 */
class TuShareException(message: String, val code: Int) : Exception(message)

/**
 * TuShare API返回的错误代码
 */
object TuShareErrorCodes {
    const val SUCCESS = 0
    const val AUTH_FAILED = 2002
    const val RATE_LIMIT_EXCEEDED = 2003
    const val PERMISSION_DENIED = 2004
    const val INVALID_PARAMS = 2005
    const val INTERNAL_ERROR = 5000
} 