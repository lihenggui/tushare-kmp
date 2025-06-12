package li.mercury.tushare.api.stock.basic

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.BakBasicResult
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsConstResult
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NameChangeResult
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.NewShareResult
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkManagersResult
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketResult
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsResult
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockBasicResult
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyResult
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.api.stock.basic.models.TradeCalResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.createRequest
import li.mercury.tushare.http.perform
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockBasicApi(
    private val requester: HttpRequester,
) : StockBasicApiInterface {
    /**
     * 获取股票基本信息
     * @param params 股票基本信息参数
     * @return 股票基本信息列表
     */
    override suspend fun getStockBasic(params: StockBasicParams): List<StockBasicResult> {
        val request = requester.createRequest("stock_basic", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取沪深股通成份股数据
     * @param params 沪深股通成份股参数
     * @return 沪深股通成份股数据列表
     */
    override suspend fun getHsConst(params: HsConstParams): List<HsConstResult> {
        val request = requester.createRequest("hs_const", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票曾用名信息
     * @param params 股票曾用名参数
     * @return 股票曾用名数据列表
     */
    override suspend fun getNameChange(params: NameChangeParams): List<NameChangeResult> {
        val request = requester.createRequest("namechange", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取上市公司基本信息
     * @param params 上市公司基本信息参数
     * @return 上市公司基本信息数据列表
     */
    override suspend fun getStockCompany(params: StockCompanyParams): List<StockCompanyResult> {
        val request = requester.createRequest("stock_company", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getStkPremarket(params: StkPremarketParams): List<StkPremarketResult> {
        val request = requester.createRequest("stk_premarket", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getTradeCal(params: TradeCalParams): List<TradeCalResult> {
        val request = requester.createRequest("trade_cal", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getStkManagers(params: StkManagersParams): List<StkManagersResult> {
        val request = requester.createRequest("stk_managers", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getStkRewards(params: StkRewardsParams): List<StkRewardsResult> {
        val request = requester.createRequest("stk_rewards", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getNewShare(params: NewShareParams): List<NewShareResult> {
        val request = requester.createRequest("new_share", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    override suspend fun getBakBasic(params: BakBasicParams): List<BakBasicResult> {
        val request = requester.createRequest("bak_basic", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
