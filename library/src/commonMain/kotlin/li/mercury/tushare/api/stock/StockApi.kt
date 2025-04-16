package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.models.BlockTradeParams
import li.mercury.tushare.api.stock.models.BlockTradeResult
import li.mercury.tushare.api.stock.models.ConceptDetailParams
import li.mercury.tushare.api.stock.models.ConceptDetailResult
import li.mercury.tushare.api.stock.models.ConceptParams
import li.mercury.tushare.api.stock.models.ConceptResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.PledgeDetailParams
import li.mercury.tushare.api.stock.models.PledgeDetailResult
import li.mercury.tushare.api.stock.models.PledgeStatParams
import li.mercury.tushare.api.stock.models.PledgeStatResult
import li.mercury.tushare.api.stock.models.RepurchaseParams
import li.mercury.tushare.api.stock.models.RepurchaseResult
import li.mercury.tushare.api.stock.models.ShareFloatParams
import li.mercury.tushare.api.stock.models.ShareFloatResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult
import li.mercury.tushare.api.stock.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.models.Top10HoldersParams
import li.mercury.tushare.api.stock.models.Top10HoldersResult
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockApi(
    private val tuShare: TuShare,
) : StockApiInterface {
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

    /**
     * 获取前十大股东
     * @param params 请求参数
     * @return 前十大股东数据流
     */
    override fun getTop10Holders(params: Top10HoldersParams): Flow<List<Top10HoldersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "top10_holders",
                    params = apiParams,
                )
            val results = response.getResponseItems(Top10HoldersResult.serializer())
            emit(results)
        }

    /**
     * 获取前十大流通股东
     * @param params 请求参数
     * @return 前十大流通股东数据流
     */
    override fun getTop10FloatHolders(params: Top10FloatHoldersParams): Flow<List<Top10FloatHoldersResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "top10_floatholders",
                    params = apiParams,
                )
            val results = response.getResponseItems(Top10FloatHoldersResult.serializer())
            emit(results)
        }

    /**
     * 获取股权质押统计数据
     * @param params 请求参数
     * @return 股权质押统计数据流
     */
    override fun getPledgeStat(params: PledgeStatParams): Flow<List<PledgeStatResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "pledge_stat",
                    params = apiParams,
                )
            val results = response.getResponseItems(PledgeStatResult.serializer())
            emit(results)
        }

    /**
     * 获取股权质押明细数据
     * @param params 请求参数
     * @return 股权质押明细数据流
     */
    override fun getPledgeDetail(params: PledgeDetailParams): Flow<List<PledgeDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "pledge_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(PledgeDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取股票回购信息
     * @param params 请求参数
     * @return 股票回购信息数据流
     */
    override fun getRepurchase(params: RepurchaseParams): Flow<List<RepurchaseResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "repurchase",
                    params = apiParams,
                )
            val results = response.getResponseItems(RepurchaseResult.serializer())
            emit(results)
        }

    /**
     * 获取概念股分类
     * @param params 请求参数
     * @return 概念股分类数据流
     */
    override fun getConcept(params: ConceptParams): Flow<List<ConceptResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "concept",
                    params = apiParams,
                )
            val results = response.getResponseItems(ConceptResult.serializer())
            emit(results)
        }

    /**
     * 获取概念股列表
     * @param params 请求参数
     * @return 概念股列表数据流
     */
    override fun getConceptDetail(params: ConceptDetailParams): Flow<List<ConceptDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "concept_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(ConceptDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取限售股解禁数据
     * @param params 请求参数
     * @return 限售股解禁数据流
     */
    override fun getShareFloat(params: ShareFloatParams): Flow<List<ShareFloatResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "share_float",
                    params = apiParams,
                )
            val results = response.getResponseItems(ShareFloatResult.serializer())
            emit(results)
        }

    /**
     * 获取大宗交易数据
     * @param params 请求参数
     * @return 大宗交易数据流
     */
    override fun getBlockTrade(params: BlockTradeParams): Flow<List<BlockTradeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "block_trade",
                    params = apiParams,
                )
            val results = response.getResponseItems(BlockTradeResult.serializer())
            emit(results)
        }

    /**
     * 获取股东人数
     * @param params 请求参数
     * @return 股东人数数据流
     */
    override fun getStockHolderNumber(params: StockHolderNumberParams): Flow<List<StockHolderNumberResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_holdernumber",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockHolderNumberResult.serializer())
            emit(results)
        }
}
