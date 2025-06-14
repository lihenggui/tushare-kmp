package li.mercury.tushare.api.stock.finance

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.BalanceSheetResult
import li.mercury.tushare.api.stock.finance.models.CashflowParams
import li.mercury.tushare.api.stock.finance.models.CashflowResult
import li.mercury.tushare.api.stock.finance.models.DisclosureDateParams
import li.mercury.tushare.api.stock.finance.models.DisclosureDateResult
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.DividendResult
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.ExpressResult
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditResult
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorResult
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzResult
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.ForecastResult
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.api.stock.finance.models.IncomeResult

/**
 * 股票相关API的存储库接口
 */
public interface StockFinanceApiInterface {
    /**
     * 获取利润表数据
     */
    public fun getIncome(params: IncomeParams): Flow<List<IncomeResult>>

    /**
     * 获取资产负债表数据
     */
    public fun getBalanceSheet(params: BalanceSheetParams): Flow<List<BalanceSheetResult>>

    /**
     * 获取现金流量表数据
     */
    public fun getCashflow(params: CashflowParams): Flow<List<CashflowResult>>

    /**
     * 获取业绩预告数据
     */
    public fun getForecast(params: ForecastParams): Flow<List<ForecastResult>>

    /**
     * 获取业绩快报数据
     */
    public fun getExpress(params: ExpressParams): Flow<List<ExpressResult>>

    /**
     * 获取分红送股数据
     */
    public fun getDividend(params: DividendParams): Flow<List<DividendResult>>

    /**
     * 获取财务指标数据
     */
    public fun getFinaIndicator(params: FinaIndicatorParams): Flow<List<FinaIndicatorResult>>

    /**
     * 获取财务审计意见数据
     */
    public fun getFinaAudit(params: FinaAuditParams): Flow<List<FinaAuditResult>>

    /**
     * 获取上市公司主营业务构成数据
     */
    public fun getFinaMainbz(params: FinaMainbzParams): Flow<List<FinaMainbzResult>>

    /**
     * 获取财报披露计划数据
     */
    public fun getDisclosureDate(params: DisclosureDateParams): Flow<List<DisclosureDateResult>>
}
