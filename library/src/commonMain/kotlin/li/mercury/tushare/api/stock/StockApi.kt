package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.models.BalanceSheetParams
import li.mercury.tushare.api.stock.models.BalanceSheetResult
import li.mercury.tushare.api.stock.models.CashflowParams
import li.mercury.tushare.api.stock.models.CashflowResult
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
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockApi(
    private val tuShare: TuShare,
) : StockApiInterface {
    override fun getStockBasic(params: StockBasicParams): Flow<List<StockBasicResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_basic",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockBasicResult.serializer())
            emit(results)
        }

    override fun getHsConst(params: HsConstParams): Flow<List<HsConstResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "hs_const",
                    params = apiParams,
                )
            val results = response.getResponseItems(HsConstResult.serializer())
            emit(results)
        }

    override fun getNameChange(params: NameChangeParams): Flow<List<NameChangeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "namechange",
                    params = apiParams,
                )
            val results = response.getResponseItems(NameChangeResult.serializer())
            emit(results)
        }

    override fun getStockCompany(params: StockCompanyParams): Flow<List<StockCompanyResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "stock_company",
                    params = apiParams,
                )
            val results = response.getResponseItems(StockCompanyResult.serializer())
            emit(results)
        }

    /*
     * 获取利润表数据
     * @param params 请求参数
     * @return 利润表数据流
     */
    override fun getIncome(params: IncomeParams): Flow<List<IncomeResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "income",
                    params = apiParams,
                )
            val results = response.getResponseItems(IncomeResult.serializer())
            emit(results)
        }

    /*
    * 获取资产负债表数据
    * @param params 请求参数
    * @return 资产负债表数据流
    */
    override fun getBalanceSheet(params: BalanceSheetParams): Flow<List<BalanceSheetResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "balancesheet",
                    params = apiParams,
                )
            val results = response.getResponseItems(BalanceSheetResult.serializer())
            emit(results)
        }

    /**
     * 获取现金流量表数据
     * @param params 请求参数
     * @return 现金流量表数据流
     */
    override fun getCashflow(params: CashflowParams): Flow<List<CashflowResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "cashflow",
                    params = apiParams,
                )
            val results = response.getResponseItems(CashflowResult.serializer())
            emit(results)
        }

    /**
     * 获取业绩预告数据
     * @param params 请求参数
     * @return 业绩预告数据流
     */
    override fun getForecast(params: ForecastParams): Flow<List<ForecastResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "forecast",
                    params = apiParams,
                )
            val results = response.getResponseItems(ForecastResult.serializer())
            emit(results)
        }

    /**
     * 获取业绩快报数据
     * @param params 请求参数
     * @return 业绩快报数据流
     */
    override fun getExpress(params: ExpressParams): Flow<List<ExpressResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "express",
                    params = apiParams,
                )
            val results = response.getResponseItems(ExpressResult.serializer())
            emit(results)
        }
}
