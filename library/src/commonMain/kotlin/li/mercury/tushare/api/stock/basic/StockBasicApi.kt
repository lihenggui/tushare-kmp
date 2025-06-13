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
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
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
        val request = TuShareRequest(
            apiName = "stock_basic", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取沪深股通成份股数据
     * @param params 沪深股通成份股参数
     * @return 沪深股通成份股数据列表
     */
    override suspend fun getHsConst(params: HsConstParams): List<HsConstResult> {
        val request = TuShareRequest(
            apiName = "hs_const", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票曾用名信息
     * @param params 股票曾用名参数
     * @return 股票曾用名数据列表
     */
    override suspend fun getNameChange(params: NameChangeParams): List<NameChangeResult> {
        val request = TuShareRequest(
            apiName = "namechange", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取上市公司基本信息
     * @param params 上市公司基本信息参数
     * @return 上市公司基本信息数据列表
     */
    override suspend fun getStockCompany(params: StockCompanyParams): List<StockCompanyResult> {
        val request = TuShareRequest(
            apiName = "stock_company", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票预披露信息
     * @param params 股票预披露参数
     * @return 股票预披露数据列表
     */
    override suspend fun getStkPremarket(params: StkPremarketParams): List<StkPremarketResult> {
        val request = TuShareRequest(
            apiName = "stk_premarket", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取交易日历
     * @param params 交易日历参数
     * @return 交易日历数据列表
     */
    override suspend fun getTradeCal(params: TradeCalParams): List<TradeCalResult> {
        val request = TuShareRequest(
            apiName = "trade_cal", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取上市公司管理层信息
     * @param params 上市公司管理层参数
     * @return 上市公司管理层数据列表
     */
    override suspend fun getStkManagers(params: StkManagersParams): List<StkManagersResult> {
        val request = TuShareRequest(
            apiName = "stk_managers", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取上市公司分红送股信息
     * @param params 分红送股参数
     * @return 分红送股数据列表
     */
    override suspend fun getStkRewards(params: StkRewardsParams): List<StkRewardsResult> {
        val request = TuShareRequest(
            apiName = "stk_rewards", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取新股上市信息
     * @param params 新股上市参数
     * @return 新股上市数据列表
     */
    override suspend fun getNewShare(params: NewShareParams): List<NewShareResult> {
        val request = TuShareRequest(
            apiName = "new_share", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取备用股票基本信息
     * @param params 备用股票基本信息参数
     * @return 备用股票基本信息数据列表
     */
    override suspend fun getBakBasic(params: BakBasicParams): List<BakBasicResult> {
        val request = TuShareRequest(
            apiName = "bak_basic", params = params.toApiParams(),
        )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
