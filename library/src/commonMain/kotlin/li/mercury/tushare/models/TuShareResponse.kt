package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 表示TuShare API响应
 *
 * @property code 响应代码，0表示成功
 * @property msg 错误信息（如果有）
 * @property data 成功时的响应数据
 * @property requestId 请求ID
 */
@Serializable
public data class TuShareResponse(
    @SerialName("code") val code: Int,
    @SerialName("msg") val msg: String? = null,
    @SerialName("data") val data: TuShareData? = null,
    @SerialName("request_id") val requestId: String? = null,
)
