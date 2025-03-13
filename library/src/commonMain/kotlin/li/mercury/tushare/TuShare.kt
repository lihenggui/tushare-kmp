package li.mercury.tushare

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.model.Fields
import li.mercury.tushare.model.ParamBuilder
import li.mercury.tushare.model.Response
import li.mercury.tushare.model.TushareApiConfig
import li.mercury.tushare.model.TushareRequest
import kotlin.time.Duration.Companion.seconds

class TuShare {

    private val client = HttpClient(CIO) {
        defaultRequest {
            url("http://api.tushare.pro")
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 60.seconds.inWholeMilliseconds
            connectTimeoutMillis = 60.seconds.inWholeMilliseconds
            socketTimeoutMillis = 60.seconds.inWholeMilliseconds
        }
    }

    private suspend fun apiRequest(
        request: TushareRequest,
    ): Response {
        return client.post {
            setBody(
                request
            )
        }.body()
    }

    suspend fun requestAnnD(
        fields: List<Fields>,
        block: ParamBuilder.() -> Unit
    ): Response {
        val config = TushareApiConfig.AnnsD
        val paramBuilder = ParamBuilder().apply(block)

        return apiRequest(
            TushareRequest(
                apiName = config.apiName,
                fields = fields.joinToString(","),
                params = paramBuilder.build(config)
            )
        )
    }
}
