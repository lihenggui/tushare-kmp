package li.mercury.tushare.api.stock.margin

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginDetailResult
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginResult
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsResult
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmResult
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbLenResult
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailResult
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.stock.margin.models.SlbSecResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.utils.toApiParams

/**
 * 股票融资融券相关API的实现类
 */
internal class StockMarginApi(
    private val requester: HttpRequester,
) : StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     * @param params 请求参数
     * @return 融资融券交易汇总数据
     */
    override suspend fun getMargin(params: MarginParams): List<MarginResult> {
        val request =
            TuShareRequest(
                apiName = "margin",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取融资融券交易明细数据
     * @param params 请求参数
     * @return 融资融券交易明细数据
     */
    override suspend fun getMarginDetail(params: MarginDetailParams): List<MarginDetailResult> {
        val request =
            TuShareRequest(
                apiName = "margin_detail",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取融资融券标的（盘前更新）
     * @param params 请求参数
     * @return 融资融券标的数据
     */
    override suspend fun getMarginSecs(params: MarginSecsParams): List<MarginSecsResult> {
        val request =
            TuShareRequest(
                apiName = "margin_secs",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取转融券交易汇总数据
     * @param params 请求参数
     * @return 转融券交易汇总数据
     */
    override suspend fun getSlbSec(params: SlbSecParams): List<SlbSecResult> {
        val request =
            TuShareRequest(
                apiName = "slb_sec",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取转融资交易汇总数据
     * @param params 请求参数
     * @return 转融资交易汇总数据
     */
    override suspend fun getSlbLen(params: SlbLenParams): List<SlbLenResult> {
        val request =
            TuShareRequest(
                apiName = "slb_len",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取转融券交易明细数据
     * @param params 请求参数
     * @return 转融券交易明细数据
     */
    override suspend fun getSlbSecDetail(params: SlbSecDetailParams): List<SlbSecDetailResult> {
        val request =
            TuShareRequest(
                apiName = "slb_sec_detail",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取做市借券交易汇总数据
     * @param params 请求参数
     * @return 做市借券交易汇总数据
     */
    override suspend fun getSlbLenMm(params: SlbLenMmParams): List<SlbLenMmResult> {
        val request =
            TuShareRequest(
                apiName = "slb_len_mm",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
