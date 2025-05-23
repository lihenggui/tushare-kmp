package li.mercury.tushare.api.stock.basic

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockBasicApi(
    private val tuShare: TuShare,
) : StockBasicApiInterface {
    /**
     * 获取股票基本信息
     * @param params 股票基本信息参数
     * @return 股票基本信息数据流
     */
    override fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockBasicResult.serializer())
            emit(results)
        }

    /**
     * 获取沪深股通成份股数据
     * @param params 沪深股通成份股参数
     * @return 沪深股通成份股数据流
     */
    override fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "hs_const",
                    params = apiParams,
                )
            val results = response.getResponseItems(HsConstResult.serializer())
            emit(results)
        }

    /**
     * 获取股票曾用名信息
     * @param params 股票曾用名参数
     * @return 股票曾用名数据流
     */
    override fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "namechange",
                    params = apiParams,
                )
            val results = response.getResponseItems(NameChangeResult.serializer())
            emit(results)
        }

    /**
     * 获取上市公司基本信息
     * @param params 上市公司基本信息参数
     * @return 上市公司基本信息数据流
     */
    override fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_company",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockCompanyResult.serializer())
            emit(results)
        }

    override fun getStkPremarket(params: StkPremarketParams): Flow<List<StkPremarketResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_premarket",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkPremarketResult.serializer())
            emit(results)
        }

    override fun getTradeCal(params: TradeCalParams): Flow<List<TradeCalResult>> =
        flow {
            val apiParams = params.toApiParams()
            val response =
                tuShare.callApi(
                    apiName = "trade_cal",
                    params = apiParams,
                )
            val results = response.getResponseItems(TradeCalResult.serializer())
            emit(results)
        }

    override fun getStkManagers(params: StkManagersParams): Flow<List<StkManagersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_managers",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkManagersResult.serializer())
            emit(results)
        }

    override fun getStkRewards(params: StkRewardsParams): Flow<List<StkRewardsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_rewards",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkRewardsResult.serializer())
            emit(results)
        }

    override fun getNewShare(params: NewShareParams): Flow<List<NewShareResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "new_share",
                    params = apiParams,
                )
            val results = response.getResponseItems(NewShareResult.serializer())
            emit(results)
        }

    override fun getBakBasic(params: BakBasicParams): Flow<List<BakBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "bak_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(BakBasicResult.serializer())
            emit(results)
        }
}
