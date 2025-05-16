package li.mercury.tushare.api.stock.board

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票资金流向相关API的实现类
 */
internal class StockBoardApi(
    private val tuShare: TuShare,
) : StockBoardApiInterface {
    /**
     * 获取东方财富板块成分
     * @param params 请求参数
     * @return 东方财富板块成分数据流
     */
    override fun getDcMember(params: DcMemberParams): Flow<List<DcMemberResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "dc_member",
                    params = apiParams,
                )
            val results = response.getResponseItems(DcMemberResult.serializer())
            emit(results)
        }

    /**
     * 获取东方财富概念板块数据
     * @param params 请求参数
     * @return 东方财富概念板块数据流
     */
    override fun getDcIndex(params: DcIndexParams): Flow<List<DcIndexResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "dc_index",
                    params = apiParams,
                )
            val results = response.getResponseItems(DcIndexResult.serializer())
            emit(results)
        }

    /**
     * 获取东方财富热板数据
     * @param params 请求参数
     * @return 东方财富热板数据流
     */
    override fun getDcHot(params: DcHotParams): Flow<List<DcHotResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "dc_hot",
                    params = apiParams,
                )
            val results = response.getResponseItems(DcHotResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺概念和行业指数
     * @param params 请求参数
     * @return 同花顺概念和行业指数数据流
     */
    override fun getThsIndex(params: ThsIndexParams): Flow<List<ThsIndexResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ths_index",
                    params = apiParams,
                )
            val results = response.getResponseItems(ThsIndexResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺概念板块成分
     * @param params 请求参数
     * @return 同花顺概念板块成分数据流
     */
    override fun getThsMember(params: ThsMemberParams): Flow<List<ThsMemberResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ths_member",
                    params = apiParams,
                )
            val results = response.getResponseItems(ThsMemberResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺热榜数据
     * @param params 请求参数
     * @return 同花顺热榜数据流
     */
    override fun getThsHot(params: ThsHotParams): Flow<List<ThsHotResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "ths_hot",
                    params = apiParams,
                )
            val results = response.getResponseItems(ThsHotResult.serializer())
            emit(results)
        }

    /**
     * 获取开盘啦榜单数据
     * @param params 请求参数
     * @return 开盘啦榜单数据流
     */
    override fun getKplList(params: KplListParams): Flow<List<KplListResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "kpl_list",
                    params = apiParams,
                )
            val results = response.getResponseItems(KplListResult.serializer())
            emit(results)
        }

    /**
     * 获取开盘啦题材库数据
     * @param params 请求参数
     * @return 开盘啦题材库数据流
     */
    override fun getKplConcept(params: KplListParams): Flow<List<KplConceptResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "kpl_concept",
                    params = apiParams,
                )
            val results = response.getResponseItems(KplConceptResult.serializer())
            emit(results)
        }

    /**
     * 获取开盘啦题材成分数据
     * @param params 请求参数
     * @return 开盘啦题材成分数据流
     */
    override fun getKplConceptCons(params: KplConceptConsParams): Flow<List<KplConceptConsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "kpl_concept_cons",
                    params = apiParams,
                )
            val results = response.getResponseItems(KplConceptConsResult.serializer())
            emit(results)
        }

    /**
     * 获取当日集合竞价数据
     * @param params 请求参数
     * @return 当日集合竞价数据流
     */
    override fun getStkAuction(params: StkAuctionParams): Flow<List<StkAuctionResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stk_auction",
                    params = apiParams,
                )
            val results = response.getResponseItems(StkAuctionResult.serializer())
            emit(results)
        }

    /**
     * 获取最强板块统计数据
     * @param params 请求参数
     * @return 最强板块统计数据流
     */
    override fun getLimitCptList(params: LimitCptListParams): Flow<List<LimitCptListResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "limit_cpt_list",
                    params = apiParams,
                )
            val results = response.getResponseItems(LimitCptListResult.serializer())
            emit(results)
        }

    /**
     * 获取涨跌停列表数据（新）
     * @param params 请求参数
     * @return 涨跌停列表数据流
     */
    override fun getLimitListD(params: LimitListDParams): Flow<List<LimitListDResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "limit_list_d",
                    params = apiParams,
                )
            val results = response.getResponseItems(LimitListDResult.serializer())
            emit(results)
        }

    /**
     * 获取同花顺每日涨跌停榜单数据
     * @param params 请求参数
     * @return 同花顺涨跌停榜单数据流
     */
    override fun getLimitListThs(params: LimitListThsParams): Flow<List<LimitListThsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "limit_list_ths",
                    params = apiParams,
                )
            val results = response.getResponseItems(LimitListThsResult.serializer())
            emit(results)
        }

    /**
     * 获取游资名录数据
     * @param params 请求参数
     * @return 游资名录数据流
     */
    override fun getHmList(params: HmListParams): Flow<List<HmListResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "hm_list",
                    params = apiParams,
                )
            val results = response.getResponseItems(HmListResult.serializer())
            emit(results)
        }

    /**
     * 获取游资每日明细数据
     * @param params 请求参数
     * @return 游资每日明细数据流
     */
    override fun getHmDetail(params: HmDetailParams): Flow<List<HmDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "hm_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(HmDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取连板天梯数据
     * @param params 请求参数
     * @return 连板天梯数据流
     */
    override fun getLimitStep(params: LimitStepParams): Flow<List<LimitStepResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "limit_step",
                    params = apiParams,
                )
            val results = response.getResponseItems(LimitStepResult.serializer())
            emit(results)
        }

    /**
     * 获取龙虎榜机构成交明细
     * @param params 请求参数
     * @return 龙虎榜机构成交明细数据流
     */
    override fun getTopInst(params: TopInstParams): Flow<List<TopInstResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "top_inst",
                    params = apiParams,
                )
            val results = response.getResponseItems(TopInstResult.serializer())
            emit(results)
        }
}
