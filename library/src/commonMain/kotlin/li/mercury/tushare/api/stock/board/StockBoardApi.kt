package li.mercury.tushare.api.stock.board

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.DcMemberResult
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

}
