package li.mercury.tushare

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import li.mercury.tushare.api.index.IndexApi
import li.mercury.tushare.api.index.IndexApiInterface
import li.mercury.tushare.api.news.NewsApi
import li.mercury.tushare.api.news.NewsApiInterface
import li.mercury.tushare.api.stock.StockApi
import li.mercury.tushare.api.stock.StockApiInterface
import li.mercury.tushare.models.TuShareData
import li.mercury.tushare.models.TuShareErrorCodes
import li.mercury.tushare.models.TuShareException
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.models.TuShareResponse

/**
 * TuShare API客户端的主入口点
 *
 * 该类以结构化和类型安全的方式提供对所有TuShare API端点的访问
 *
 * @property token TuShare API认证令牌
 * @property apiUrl TuShare API端点URL
 * @property client 自定义HTTP客户端（可选，默认为配置好的HttpClient）
 */
class TuShare(
    private val token: String,
    private val apiUrl: String = "https://api.tushare.pro",
    private val engine: HttpClientEngine = CIO.create(),
    private val client: HttpClient =
        HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    },
                )
            }
        },
) {
    /** 访问指数相关API */
    val index: IndexApiInterface by lazy { IndexApi(this) }

    /** 股票信息相关API */
    val stock: StockApiInterface by lazy { StockApi(this) }

    /** 新闻相关API */
    val news: NewsApiInterface by lazy { NewsApi(this) }

    /**
     * 向TuShare发起原始API调用
     *
     * @param apiName 要调用的API名称
     * @param params API调用的附加参数
     * @param fields 需要获取的特定字段列表，以逗号分隔
     * @return 包含字段和数据项的响应数据
     * @throws TuShareException 如果API调用失败
     */
    internal suspend fun callApi(
        apiName: String,
        params: Map<String, String> = emptyMap(),
        fields: String = "",
    ): TuShareData {
        val request =
            TuShareRequest(
                apiName = apiName,
                token = token,
                params = params,
                fields = fields,
            )

        val response =
            client
                .post(apiUrl) {
                    contentType(ContentType.Application.Json)
                    setBody(request)
                }.body<TuShareResponse>()

        if (response.code != TuShareErrorCodes.SUCCESS) {
            throw TuShareException(
                message = response.msg ?: "Unknown error occurred",
                code = response.code,
            )
        }

        return response.data ?: throw TuShareException(
            message = "No data returned from API",
            code = TuShareErrorCodes.INTERNAL_ERROR,
        )
    }
}
