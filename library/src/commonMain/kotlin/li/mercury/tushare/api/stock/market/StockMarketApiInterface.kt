package li.mercury.tushare.api.stock.market

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.AdjFactorResult
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.BakDailyResult
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyBasicResult
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.DailyResult
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtDailyResult
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyResult
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.GgtTop10Result
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Result
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MinsResult
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.MonthlyResult
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.StkLimitResult
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.SuspendDResult
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.api.stock.market.models.WeeklyResult

/**
 * 股票相关API的存储库接口
 */
interface StockMarketApiInterface {
    /**
     * 获取股票日线行情数据
     */
    fun getDaily(params: DailyParams): Flow<List<DailyResult>>

    /**
     * 获取股票分钟行情数据
     */
    fun getMins(params: MinsParams): Flow<List<MinsResult>>

    /**
     * 获取A股周线行情数据
     */
    fun getWeekly(params: WeeklyParams): Flow<List<WeeklyResult>>

    /**
     * 获取A股月线行情数据
     */
    fun getMonthly(params: MonthlyParams): Flow<List<MonthlyResult>>

    /**
     * 获取股票周/月线行情数据(每日更新)
     */
    fun getWeeklyMonthly(params: WeeklyMonthlyParams): Flow<List<WeeklyMonthlyResult>>

    /**
     * 获取股票复权因子数据
     */
    fun getAdjFactor(params: AdjFactorParams): Flow<List<AdjFactorResult>>

    /**
     * 获取股票每日指标数据
     */
    fun getDailyBasic(params: DailyBasicParams): Flow<List<DailyBasicResult>>

    /**
     * 获取每日涨跌停价格数据
     */
    fun getStkLimit(params: StkLimitParams): Flow<List<StkLimitResult>>

    /**
     * 获取每日停复牌信息
     */
    fun getSuspendD(params: SuspendDParams): Flow<List<SuspendDResult>>

    /**
     * 获取沪深股通十大成交股数据
     */
    fun getHsgtTop10(params: HsgtTop10Params): Flow<List<HsgtTop10Result>>

    /**
     * 获取港股通十大成交股数据
     */
    fun getGgtTop10(params: GgtTop10Params): Flow<List<GgtTop10Result>>

    /**
     * 获取港股通每日成交统计
     */
    fun getGgtDaily(params: GgtDailyParams): Flow<List<GgtDailyResult>>

    /**
     * 获取港股通每月成交统计
     */
    fun getGgtMonthly(params: GgtMonthlyParams): Flow<List<GgtMonthlyResult>>

    /**
     * 获取备用行情数据
     */
    fun getBakDaily(params: BakDailyParams): Flow<List<BakDailyResult>>
}
