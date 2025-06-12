package li.mercury.tushare.api.stock.reference

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.BlockTradeResult
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailResult
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.ConceptResult
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailResult
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatResult
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseResult
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatResult
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeResult
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.createRequest
import li.mercury.tushare.http.perform
import li.mercury.tushare.utils.toApiParams

/**
 * 股票参考数据相关API的实现类
 */
internal class StockReferenceApi(
    private val requester: HttpRequester
) : StockReferenceApiInterface {
    /**
     * 获取前十大股东
     * @param params 请求参数
     * @return 前十大股东数据
     */
    override suspend fun getTop10Holders(params: Top10HoldersParams): List<Top10HoldersResult> {
        val request = requester.createRequest("top10_holders", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取前十大流通股东
     * @param params 请求参数
     * @return 前十大流通股东数据
     */
    override suspend fun getTop10FloatHolders(params: Top10FloatHoldersParams): List<Top10FloatHoldersResult> {
        val request = requester.createRequest("top10_floatholders", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股权质押统计数据
     * @param params 请求参数
     * @return 股权质押统计数据
     */
    override suspend fun getPledgeStat(params: PledgeStatParams): List<PledgeStatResult> {
        val request = requester.createRequest("pledge_stat", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股权质押明细数据
     * @param params 请求参数
     * @return 股权质押明细数据
     */
    override suspend fun getPledgeDetail(params: PledgeDetailParams): List<PledgeDetailResult> {
        val request = requester.createRequest("pledge_detail", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股票回购信息
     * @param params 请求参数
     * @return 股票回购信息数据
     */
    override suspend fun getRepurchase(params: RepurchaseParams): List<RepurchaseResult> {
        val request = requester.createRequest("repurchase", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取概念股分类
     * @param params 请求参数
     * @return 概念股分类数据
     */
    override suspend fun getConcept(params: ConceptParams): List<ConceptResult> {
        val request = requester.createRequest("concept", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取概念股列表
     * @param params 请求参数
     * @return 概念股列表数据
     */
    override suspend fun getConceptDetail(params: ConceptDetailParams): List<ConceptDetailResult> {
        val request = requester.createRequest("concept_detail", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取限售股解禁数据
     * @param params 请求参数
     * @return 限售股解禁数据
     */
    override suspend fun getShareFloat(params: ShareFloatParams): List<ShareFloatResult> {
        val request = requester.createRequest("share_float", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取大宗交易数据
     * @param params 请求参数
     * @return 大宗交易数据
     */
    override suspend fun getBlockTrade(params: BlockTradeParams): List<BlockTradeResult> {
        val request = requester.createRequest("block_trade", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股东人数
     * @param params 请求参数
     * @return 股东人数数据
     */
    override suspend fun getStockHolderNumber(params: StockHolderNumberParams): List<StockHolderNumberResult> {
        val request = requester.createRequest("stk_holdernumber", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取股东增减持数据
     * @param params 请求参数
     * @return 股东增减持数据
     */
    override suspend fun getStockHolderTrade(params: StockHolderTradeParams): List<StockHolderTradeResult> {
        val request = requester.createRequest("stk_holdertrade", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
