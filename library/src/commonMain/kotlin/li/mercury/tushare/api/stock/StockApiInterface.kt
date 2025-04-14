package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.AdjFactorParams
import li.mercury.tushare.api.stock.models.AdjFactorResult
import li.mercury.tushare.api.stock.models.DailyBasicParams
import li.mercury.tushare.api.stock.models.DailyBasicResult
import li.mercury.tushare.api.stock.models.DailyParams
import li.mercury.tushare.api.stock.models.DailyResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.MinsParams
import li.mercury.tushare.api.stock.models.MinsResult
import li.mercury.tushare.api.stock.models.MonthlyParams
import li.mercury.tushare.api.stock.models.MonthlyResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult
import li.mercury.tushare.api.stock.models.WeeklyMonthlyAdjParams
import li.mercury.tushare.api.stock.models.WeeklyMonthlyAdjResult
import li.mercury.tushare.api.stock.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.models.WeeklyParams
import li.mercury.tushare.api.stock.models.WeeklyResult

/**
 * 股票相关API的存储库接口
 */
interface StockApiInterface {
    /**
     * 获取股票基本信息
     */
    fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>>

    /**
     * 获取沪深股通成份股数据
     */
    fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>>

    /**
     * 获取股票曾用名信息
     */
    fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>>

    /**
     * 获取上市公司基本信息
     */
    fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>>

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
     * 获取股票周/月线行情数据
     */
    fun getWeeklyMonthly(params: WeeklyMonthlyParams): Flow<List<WeeklyMonthlyResult>>

    /**
     * 获取股票周/月线行情（复权，每日更新）
     */
    fun getWeeklyMonthlyAdj(params: WeeklyMonthlyAdjParams): Flow<List<WeeklyMonthlyAdjResult>>

    /**
     * 获取股票复权因子数据
     */
    fun getAdjFactor(params: AdjFactorParams): Flow<List<AdjFactorResult>>

    /**
     * 获取股票每日指标数据
     */
    fun getDailyBasic(params: DailyBasicParams): Flow<List<DailyBasicResult>>
}
