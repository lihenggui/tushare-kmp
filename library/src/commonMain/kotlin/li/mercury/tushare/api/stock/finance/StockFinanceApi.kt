package li.mercury.tushare.api.stock.finance

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.BalanceSheetResult
import li.mercury.tushare.api.stock.finance.models.CashflowParams
import li.mercury.tushare.api.stock.finance.models.CashflowResult
import li.mercury.tushare.api.stock.finance.models.DisclosureDateParams
import li.mercury.tushare.api.stock.finance.models.DisclosureDateResult
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.DividendResult
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.ExpressResult
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditResult
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorResult
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzResult
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.ForecastResult
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.api.stock.finance.models.IncomeResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.createRequest
import li.mercury.tushare.http.perform
import li.mercury.tushare.utils.toApiParams

/**
 * 股票财务数据相关API的实现类
 */
internal class StockFinanceApi(
    private val requester: HttpRequester
) : StockFinanceApiInterface {
    /**
     * 获取利润表数据
     * @param params 请求参数
     * @return 利润表数据
     */
    override suspend fun getIncome(params: IncomeParams): List<IncomeResult> {
        val request = requester.createRequest("income", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取资产负债表数据
     * @param params 请求参数
     * @return 资产负债表数据
     */
    override suspend fun getBalanceSheet(params: BalanceSheetParams): List<BalanceSheetResult> {
        val request = requester.createRequest("balancesheet", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取现金流量表数据
     * @param params 请求参数
     * @return 现金流量表数据
     */
    override suspend fun getCashflow(params: CashflowParams): List<CashflowResult> {
        val request = requester.createRequest("cashflow", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取业绩预告数据
     * @param params 请求参数
     * @return 业绩预告数据
     */
    override suspend fun getForecast(params: ForecastParams): List<ForecastResult> {
        val request = requester.createRequest("forecast", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取业绩快报数据
     * @param params 请求参数
     * @return 业绩快报数据
     */
    override suspend fun getExpress(params: ExpressParams): List<ExpressResult> {
        val request = requester.createRequest("express", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取分红送股数据
     * @param params 请求参数
     * @return 分红送股数据
     */
    override suspend fun getDividend(params: DividendParams): List<DividendResult> {
        val request = requester.createRequest("dividend", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取财务指标数据
     * @param params 请求参数
     * @return 财务指标数据
     */
    override suspend fun getFinaIndicator(params: FinaIndicatorParams): List<FinaIndicatorResult> {
        val request = requester.createRequest("fina_indicator", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取财务审计意见数据
     * @param params 请求参数
     * @return 财务审计意见数据
     */
    override suspend fun getFinaAudit(params: FinaAuditParams): List<FinaAuditResult> {
        val request = requester.createRequest("fina_audit", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取上市公司主营业务构成数据
     * @param params 请求参数
     * @return 主营业务构成数据
     */
    override suspend fun getFinaMainbz(params: FinaMainbzParams): List<FinaMainbzResult> {
        val request = requester.createRequest("fina_mainbz", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取财报披露计划数据
     * @param params 请求参数
     * @return 财报披露计划数据
     */
    override suspend fun getDisclosureDate(params: DisclosureDateParams): List<DisclosureDateResult> {
        val request = requester.createRequest("disclosure_date", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
