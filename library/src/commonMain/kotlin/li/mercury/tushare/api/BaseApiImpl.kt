package li.mercury.tushare.api

import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.KSerializer
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.models.TuShareResponse
import li.mercury.tushare.utils.toApiParams

/**
 * TuShare API的基础实现类
 * 提供通用的API调用逻辑
 */
abstract class BaseApiImpl(
    protected val requester: HttpRequester,
    protected val config: TuShareConfig
) {
    /**
     * 调用TuShare API并返回解析后的结果
     * @param apiName API名称
     * @param params 请求参数对象
     * @param serializer 结果序列化器
     * @param fields 指定返回字段
     * @return 解析后的结果列表
     */
    protected suspend inline fun <reified T, reified R> callApi(
        apiName: String,
        params: T,
        serializer: KSerializer<R>,
        fields: List<String>? = null
    ): List<R> {
        val apiParams = params.toApiParams()
        val fieldsStr = fields?.joinToString(",") ?: ""

        val request = TuShareRequest(
            apiName = apiName,
            token = config.token,
            params = apiParams,
            fields = fieldsStr
        )

        val response: TuShareResponse = requester.perform { client ->
            client.post {
                setBody(request)
                contentType(ContentType.Application.Json)
            }
        }

        return response.data?.getResponseItems(serializer) ?: emptyList()
    }
}