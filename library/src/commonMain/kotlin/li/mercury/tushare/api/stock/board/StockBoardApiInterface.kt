package li.mercury.tushare.api.stock.board

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.DcMemberResult

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
}
