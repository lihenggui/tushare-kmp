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
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.KplListResult
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsHotResult
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexResult
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.ThsMemberResult
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
}
