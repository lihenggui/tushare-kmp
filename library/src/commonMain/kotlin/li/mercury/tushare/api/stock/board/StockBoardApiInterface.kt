package li.mercury.tushare.api.stock.board

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotResult
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcIndexResult
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.DcMemberResult
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexResult
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.ThsMemberResult

/**
 * 股票打版专题数据相关API接口
 */
interface StockBoardApiInterface {
    /**
     * 获取东方财富板块成分
     * @param params 请求参数
     * @return 东方财富板块成分数据流
     */
    fun getDcMember(params: DcMemberParams): Flow<List<DcMemberResult>>

    /**
     * 获取东方财富概念板块数据
     * @param params 请求参数
     * @return 东方财富概念板块数据流
     */
    fun getDcIndex(params: DcIndexParams): Flow<List<DcIndexResult>>

    /**
     * 获取东方财富热板数据
     * @param params 请求参数
     * @return 东方财富热板数据流
     */
    fun getDcHot(params: DcHotParams): Flow<List<DcHotResult>>

    /**
     * 获取同花顺概念和行业指数
     * @param params 请求参数
     * @return 同花顺概念和行业指数数据流
     */
    fun getThsIndex(params: ThsIndexParams): Flow<List<ThsIndexResult>>

    /**
     * 获取同花顺概念板块成分
     * @param params 请求参数
     * @return 同花顺概念板块成分数据流
     */
    fun getThsMember(params: ThsMemberParams): Flow<List<ThsMemberResult>>
}
