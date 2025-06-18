package li.mercury.tushare.api.stock.flow

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.utils.toApiParams

/**
 * 股票资金流向相关API的实现类
 */
internal class StockFlowApi(
    private val requester: HttpRequester,
) : StockFlowApiInterface {
    /**
     * 获取个股资金流向
     * @param params 请求参数
     * @return 个股资金流向数据
     */
    override suspend fun getMoneyflow(params: MoneyflowParams): List<MoneyflowResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺个股资金流向
     * @param params 请求参数
     * @return 同花顺个股资金流向数据
     */
    override suspend fun getMoneyflowThs(params: MoneyflowThsParams): List<MoneyflowThsResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_ths",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取东方财富个股资金流向数据
     * @param params 请求参数
     * @return 东方财富个股资金流向数据
     */
    override suspend fun getMoneyflowDc(params: MoneyflowDcParams): List<MoneyflowDcResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_dc",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取东方财富大盘资金流向数据
     * @param params 请求参数
     * @return 东方财富大盘资金流向数据
     */
    override suspend fun getMoneyflowMktDc(params: MoneyflowMktDcParams): List<MoneyflowMktDcResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_mkt_dc",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取东方财富板块资金流向数据
     * @param params 请求参数
     * @return 东方财富板块资金流向数据
     */
    override suspend fun getMoneyflowIndDc(params: MoneyflowIndDcParams): List<MoneyflowIndDcResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_ind_dc",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺行业板块资金流向
     * @param params 请求参数
     * @return 同花顺行业板块资金流向数据
     */
    override suspend fun getMoneyflowIndThs(params: MoneyflowIndThsParams): List<MoneyflowIndThsResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_ind_ths",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取沪深港通资金流向
     * @param params 请求参数
     * @return 沪深港通资金流向数据
     */
    override suspend fun getMoneyflowHsgt(params: MoneyflowHsgtParams): List<MoneyflowHsgtResult> {
        val request =
            TuShareRequest(
                apiName = "moneyflow_hsgt",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
