package li.mercury.tushare.api.stock.board

import kotlinx.coroutines.flow.Flow
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

/**
 * 股票打版专题数据相关API接口
 */
public interface StockBoardApiInterface {
    /**
     * 获取东方财富板块成分
     * @param params 请求参数
     * @return 东方财富板块成分数据流
     */
    public fun getDcMember(params: DcMemberParams): Flow<List<DcMemberResult>>

    /**
     * 获取东方财富概念板块数据
     * @param params 请求参数
     * @return 东方财富概念板块数据流
     */
    public fun getDcIndex(params: DcIndexParams): Flow<List<DcIndexResult>>

    /**
     * 获取东方财富热板数据
     * @param params 请求参数
     * @return 东方财富热板数据流
     */
    public fun getDcHot(params: DcHotParams): Flow<List<DcHotResult>>

    /**
     * 获取同花顺概念和行业指数
     * @param params 请求参数
     * @return 同花顺概念和行业指数数据流
     */
    public fun getThsIndex(params: ThsIndexParams): Flow<List<ThsIndexResult>>

    /**
     * 获取同花顺概念板块成分
     * @param params 请求参数
     * @return 同花顺概念板块成分数据流
     */
    public fun getThsMember(params: ThsMemberParams): Flow<List<ThsMemberResult>>

    /**
     * 获取同花顺热榜数据
     * @param params 请求参数
     * @return 同花顺热榜数据流
     */
    public fun getThsHot(params: ThsHotParams): Flow<List<ThsHotResult>>

    /**
     * 获取开盘啦榜单数据
     * @param params 请求参数
     * @return 开盘啦榜单数据流
     */
    public fun getKplList(params: KplListParams): Flow<List<KplListResult>>

    /**
     * 获取开盘啦题材库数据
     * @param params 请求参数
     * @return 开盘啦题材库数据流
     */
    public fun getKplConcept(params: KplConceptParams): Flow<List<KplConceptResult>>

    /**
     * 获取开盘啦题材成分数据
     * @param params 请求参数
     * @return 开盘啦题材成分数据流
     */
    public fun getKplConceptCons(params: KplConceptConsParams): Flow<List<KplConceptConsResult>>

    /**
     * 获取当日集合竞价数据
     * @param params 请求参数
     * @return 当日集合竞价数据流
     */
    public fun getStkAuction(params: StkAuctionParams): Flow<List<StkAuctionResult>>

    /**
     * 获取最强板块统计数据
     * @param params 请求参数
     * @return 最强板块统计数据流
     */
    public fun getLimitCptList(params: LimitCptListParams): Flow<List<LimitCptListResult>>

    /**
     * 获取涨跌停列表数据（新）
     * @param params 请求参数
     * @return 涨跌停列表数据流
     */
    public fun getLimitListD(params: LimitListDParams): Flow<List<LimitListDResult>>

    /**
     * 获取同花顺每日涨跌停榜单数据
     * @param params 请求参数
     * @return 同花顺涨跌停榜单数据流
     */
    public fun getLimitListThs(params: LimitListThsParams): Flow<List<LimitListThsResult>>

    /**
     * 获取游资名录数据
     * @param params 请求参数
     * @return 游资名录数据流
     */
    public fun getHmList(params: HmListParams): Flow<List<HmListResult>>

    /**
     * 获取游资每日明细数据
     * @param params 请求参数
     * @return 游资每日明细数据流
     */
    public fun getHmDetail(params: HmDetailParams): Flow<List<HmDetailResult>>

    /**
     * 获取连板天梯数据
     * @param params 请求参数
     * @return 连板天梯数据流
     */
    public fun getLimitStep(params: LimitStepParams): Flow<List<LimitStepResult>>

    /**
     * 获取龙虎榜机构成交明细
     * @param params 请求参数
     * @return 龙虎榜机构成交明细数据流
     */
    public fun getTopInst(params: TopInstParams): Flow<List<TopInstResult>>

    /**
     * 获取龙虎榜每日交易明细
     * @param params 请求参数
     * @return 龙虎榜每日交易明细数据流
     */
    public fun getTopList(params: TopListParams): Flow<List<TopListResult>>
}
