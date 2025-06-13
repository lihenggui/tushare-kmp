package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.internal.extension.TuShareDsl

/**
 * 表示TuShare API请求
 *
 * @property apiName 要调用的API名称
 * @property token TuShare API认证令牌
 * @property params API调用的附加参数
 * @property fields 需要获取的特定字段列表，以逗号分隔
 */
@Serializable
public data class TuShareRequest(
    @SerialName("api_name") val apiName: String,
    @SerialName("token") val token: String,
    @SerialName("params") val params: Map<String, String> = emptyMap(),
    @SerialName("fields") val fields: String = "",
)

public fun tuShareRequest(block: TuShareRequestBuilder.() -> Unit): TuShareRequest =
    TuShareRequestBuilder().apply(block).build()

@TuShareDsl
public class TuShareRequestBuilder {
    public var token: String? = null
    public var apiName: String? = null
    public var fields: List<String>? = null
    public var params: Map<String, String> = emptyMap()

    public fun build(): TuShareRequest = TuShareRequest(
        apiName = requireNotNull(apiName) { "API name must be specified" },
        token = requireNotNull(token) { "API token must be specified" },
        params = params,
        fields = fields?.joinToString(",") ?: ""
    )
}
