package li.mercury.tushare.http

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.typeInfo
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.models.TuShareRequest

/**
 * HTTP请求器接口
 * 提供类型安全的HTTP请求抽象
 */
public interface HttpRequester : AutoCloseable {

    /**
     * 获取TuShare配置
     */
    public val config: TuShareConfig

    /**
     * 执行HTTP请求并返回指定类型的结果
     * @param info 类型信息，用于反序列化
     * @param block HTTP请求构建器
     * @return 反序列化后的响应对象
     */
    public suspend fun <T : Any> perform(info: TypeInfo, block: suspend (HttpClient) -> HttpResponse): T

    /**
     * 执行HTTP请求并处理响应
     * @param builder HTTP请求构建器
     * @param block 响应处理器
     * @return 处理后的结果
     */
    public suspend fun <T : Any> perform(
        builder: HttpRequestBuilder,
        block: suspend (response: HttpResponse) -> T
    )
}

/**
 * 内联函数，提供类型安全的HTTP请求
 */
public suspend inline fun <reified T> HttpRequester.perform(noinline block: suspend (HttpClient) -> HttpResponse): T {
    return perform(typeInfo<T>(), block)
}

/**
 * 创建TuShare请求的便利方法
 * 自动从配置中获取token
 */
fun HttpRequester.createRequest(
    apiName: String,
    params: Map<String, String> = emptyMap(),
    fields: String = ""
): TuShareRequest {
    return TuShareRequest(
        apiName = apiName,
        token = config.token,
        params = params,
        fields = fields
    )
}
