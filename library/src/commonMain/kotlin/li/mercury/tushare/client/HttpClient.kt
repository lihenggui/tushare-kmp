package li.mercury.tushare.client

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.ProxyBuilder
import io.ktor.client.engine.http
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.util.appendIfNameAbsent
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import li.mercury.tushare.internal.extension.toKtorLogLevel
import li.mercury.tushare.internal.extension.toKtorLogger
import kotlin.time.DurationUnit

/**
 * Default Http Client.
 */
@OptIn(InternalAPI::class)
internal fun createHttpClient(config: TuShareConfig): HttpClient {
    val customerBodyPlugin =
        createClientPlugin("CustomHeaderPlugin") {
            onRequest { request, _ ->
                val originalBody = request.body
                if (originalBody is JsonObject) {
                    val newBody =
                        buildJsonObject {
                            put("token", config.token)
                            originalBody.forEach { (k, v) -> put(k, v) }
                        }
                    request.body = newBody
                }
            }
        }

    val configuration: HttpClientConfig<*>.() -> Unit = {
        engine {
            config.proxy?.let { proxyConfig ->
                proxy =
                    when (proxyConfig) {
                        is ProxyConfig.Http -> ProxyBuilder.http(proxyConfig.url)
                        is ProxyConfig.Socks -> ProxyBuilder.socks(proxyConfig.host, proxyConfig.port)
                    }
            }
        }

        install(ContentNegotiation) {
            register(ContentType.Application.Json, KotlinxSerializationConverter(JsonLenient))
        }

        install(customerBodyPlugin)

        install(Logging) {
            val logging = config.logging
            logger = logging.logger.toKtorLogger()
            level = logging.logLevel.toKtorLogLevel()
            if (logging.sanitize) {
                sanitizeHeader { header -> header == HttpHeaders.Authorization }
            }
        }

        install(HttpTimeout) {
            config.timeout.socket?.let { socketTimeout ->
                socketTimeoutMillis = socketTimeout.toLong(DurationUnit.MILLISECONDS)
            }
            config.timeout.connect?.let { connectTimeout ->
                connectTimeoutMillis = connectTimeout.toLong(DurationUnit.MILLISECONDS)
            }
            config.timeout.request?.let { requestTimeout ->
                requestTimeoutMillis = requestTimeout.toLong(DurationUnit.MILLISECONDS)
            }
        }

        install(HttpRequestRetry) {
            maxRetries = config.retry.maxRetries
            // retry on rate limit error.
            retryIf { _, response -> response.status.value.let { it == 429 } }
            exponentialDelay(config.retry.base, config.retry.maxDelay.inWholeMilliseconds)
        }

        defaultRequest {
            url(config.host.baseUrl)
            config.host.queryParams.onEach { (key, value) -> url.parameters.appendIfNameAbsent(key, value) }
            config.headers.onEach { (key, value) -> headers.appendIfNameAbsent(key, value) }
            contentType(ContentType.Application.Json)
        }

        expectSuccess = true

        config.httpClientConfig(this)
    }

    return if (config.engine != null) {
        HttpClient(config.engine, configuration)
    } else {
        HttpClient(configuration)
    }
}

/**
 * Internal Json Serializer.
 */
internal val JsonLenient =
    Json {
        isLenient = true
        ignoreUnknownKeys = true
    }
