package li.mercury.tushare.api.stock.board

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotResult
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcIndexResult
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.DcMemberResult
import li.mercury.tushare.api.stock.board.models.HmDetailParams
import li.mercury.tushare.api.stock.board.models.HmDetailResult
import li.mercury.tushare.api.stock.board.models.HmListParams
import li.mercury.tushare.api.stock.board.models.HmListResult
import li.mercury.tushare.api.stock.board.models.KplConceptConsParams
import li.mercury.tushare.api.stock.board.models.KplConceptConsResult
import li.mercury.tushare.api.stock.board.models.KplConceptParams
import li.mercury.tushare.api.stock.board.models.KplConceptResult
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.KplListResult
import li.mercury.tushare.api.stock.board.models.LimitCptListParams
import li.mercury.tushare.api.stock.board.models.LimitCptListResult
import li.mercury.tushare.api.stock.board.models.LimitListDParams
import li.mercury.tushare.api.stock.board.models.LimitListDResult
import li.mercury.tushare.api.stock.board.models.LimitListThsParams
import li.mercury.tushare.api.stock.board.models.LimitListThsResult
import li.mercury.tushare.api.stock.board.models.LimitStepParams
import li.mercury.tushare.api.stock.board.models.LimitStepResult
import li.mercury.tushare.api.stock.board.models.StkAuctionParams
import li.mercury.tushare.api.stock.board.models.StkAuctionResult
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsHotResult
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexResult
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.ThsMemberResult
import li.mercury.tushare.api.stock.board.models.TopInstParams
import li.mercury.tushare.api.stock.board.models.TopInstResult
import li.mercury.tushare.api.stock.board.models.TopListParams
import li.mercury.tushare.api.stock.board.models.TopListResult
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.createRequest
import li.mercury.tushare.http.perform
import li.mercury.tushare.utils.toApiParams

/**
 * 股票打版专题数据相关API的实现类
 */
internal class StockBoardApi(
    private val requester: HttpRequester
) : StockBoardApiInterface {
    /**
     * 获取东方财富板块成分
     * @param params 请求参数
     * @return 东方财富板块成分数据
     */
    override suspend fun getDcMember(params: DcMemberParams): List<DcMemberResult> {
        val request = requester.createRequest("dc_member", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取东方财富概念板块数据
     * @param params 请求参数
     * @return 东方财富概念板块数据
     */
    override suspend fun getDcIndex(params: DcIndexParams): List<DcIndexResult> {
        val request = requester.createRequest("dc_index", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取东方财富热板数据
     * @param params 请求参数
     * @return 东方财富热板数据
     */
    override suspend fun getDcHot(params: DcHotParams): List<DcHotResult> {
        val request = requester.createRequest("dc_hot", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺概念和行业指数
     * @param params 请求参数
     * @return 同花顺概念和行业指数数据
     */
    override suspend fun getThsIndex(params: ThsIndexParams): List<ThsIndexResult> {
        val request = requester.createRequest("ths_index", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺概念板块成分
     * @param params 请求参数
     * @return 同花顺概念板块成分数据
     */
    override suspend fun getThsMember(params: ThsMemberParams): List<ThsMemberResult> {
        val request = requester.createRequest("ths_member", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺热榜数据
     * @param params 请求参数
     * @return 同花顺热榜数据
     */
    override suspend fun getThsHot(params: ThsHotParams): List<ThsHotResult> {
        val request = requester.createRequest("ths_hot", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取开盘啦榜单数据
     * @param params 请求参数
     * @return 开盘啦榜单数据
     */
    override suspend fun getKplList(params: KplListParams): List<KplListResult> {
        val request = requester.createRequest("kpl_list", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取开盘啦题材库数据
     * @param params 请求参数
     * @return 开盘啦题材库数据
     */
    override suspend fun getKplConcept(params: KplConceptParams): List<KplConceptResult> {
        val request = requester.createRequest("kpl_concept", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取开盘啦题材成分数据
     * @param params 请求参数
     * @return 开盘啦题材成分数据
     */
    override suspend fun getKplConceptCons(params: KplConceptConsParams): List<KplConceptConsResult> {
        val request = requester.createRequest("kpl_concept_cons", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取当日集合竞价数据
     * @param params 请求参数
     * @return 当日集合竞价数据
     */
    override suspend fun getStkAuction(params: StkAuctionParams): List<StkAuctionResult> {
        val request = requester.createRequest("stk_auction", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取最强板块统计数据
     * @param params 请求参数
     * @return 最强板块统计数据
     */
    override suspend fun getLimitCptList(params: LimitCptListParams): List<LimitCptListResult> {
        val request = requester.createRequest("limit_cpt_list", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取涨跌停列表数据（新）
     * @param params 请求参数
     * @return 涨跌停列表数据
     */
    override suspend fun getLimitListD(params: LimitListDParams): List<LimitListDResult> {
        val request = requester.createRequest("limit_list_d", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取同花顺每日涨跌停榜单数据
     * @param params 请求参数
     * @return 同花顺涨跌停榜单数据
     */
    override suspend fun getLimitListThs(params: LimitListThsParams): List<LimitListThsResult> {
        val request = requester.createRequest("limit_list_ths", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取游资名录数据
     * @param params 请求参数
     * @return 游资名录数据
     */
    override suspend fun getHmList(params: HmListParams): List<HmListResult> {
        val request = requester.createRequest("hm_list", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取游资每日明细数据
     * @param params 请求参数
     * @return 游资每日明细数据
     */
    override suspend fun getHmDetail(params: HmDetailParams): List<HmDetailResult> {
        val request = requester.createRequest("hm_detail", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取连板天梯数据
     * @param params 请求参数
     * @return 连板天梯数据
     */
    override suspend fun getLimitStep(params: LimitStepParams): List<LimitStepResult> {
        val request = requester.createRequest("limit_step", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取龙虎榜机构成交明细
     * @param params 请求参数
     * @return 龙虎榜机构成交明细数据
     */
    override suspend fun getTopInst(params: TopInstParams): List<TopInstResult> {
        val request = requester.createRequest("top_inst", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 获取龙虎榜每日交易明细
     * @param params 请求参数
     * @return 龙虎榜每日交易明细数据
     */
    override suspend fun getTopList(params: TopListParams): List<TopListResult> {
        val request = requester.createRequest("top_list", params.toApiParams())
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
