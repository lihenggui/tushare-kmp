package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.models.BalanceSheetParams
import li.mercury.tushare.api.stock.models.BalanceSheetResult
import li.mercury.tushare.api.stock.models.CashflowParams
import li.mercury.tushare.api.stock.models.CashflowResult
import li.mercury.tushare.api.stock.models.DividendParams
import li.mercury.tushare.api.stock.models.DividendResult
import li.mercury.tushare.api.stock.models.ExpressParams
import li.mercury.tushare.api.stock.models.ExpressResult
import li.mercury.tushare.api.stock.models.ForecastParams
import li.mercury.tushare.api.stock.models.ForecastResult
import li.mercury.tushare.api.stock.models.HsConstParams
import li.mercury.tushare.api.stock.models.HsConstResult
import li.mercury.tushare.api.stock.models.IncomeParams
import li.mercury.tushare.api.stock.models.IncomeResult
import li.mercury.tushare.api.stock.models.NameChangeParams
import li.mercury.tushare.api.stock.models.NameChangeResult
import li.mercury.tushare.api.stock.models.StockBasicParams
import li.mercury.tushare.api.stock.models.StockBasicResult
import li.mercury.tushare.api.stock.models.StockCompanyParams
import li.mercury.tushare.api.stock.models.StockCompanyResult

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
     * 获取利润表数据
     */
    fun getIncome(params: IncomeParams): Flow<List<IncomeResult>>

    /**
     * 获取资产负债表数据
     */
    fun getBalanceSheet(params: BalanceSheetParams): Flow<List<BalanceSheetResult>>

    /**
     * 获取现金流量表数据
     */
    fun getCashflow(params: CashflowParams): Flow<List<CashflowResult>>

    /**
     * 获取业绩预告数据
     */
    fun getForecast(params: ForecastParams): Flow<List<ForecastResult>>

    /**
     * 获取业绩快报数据
     */
    fun getExpress(params: ExpressParams): Flow<List<ExpressResult>>

    /**
     * 获取分红送股数据
     */
    fun getDividend(params: DividendParams): Flow<List<DividendResult>>

}
