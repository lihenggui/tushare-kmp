package li.mercury.tushare.api.stock.margin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginDetailResult
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginResult
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsResult
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmResult
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbLenResult
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailResult
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.stock.margin.models.SlbSecResult
import li.mercury.tushare.utils.toApiParams

/**
 * 股票相关API的实现类
 */
internal class StockMarginApi(
    private val tuShare: TuShare,
) : StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     * @param params 请求参数
     * @return 融资融券交易汇总数据流
     */
    override fun getMargin(params: MarginParams): Flow<List<MarginResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "margin",
                    params = apiParams,
                )
            val results = response.getResponseItems(MarginResult.serializer())
            emit(results)
        }

    /**
     * 获取融资融券交易明细数据
     * @param params 请求参数
     * @return 融资融券交易明细数据流
     */
    override fun getMarginDetail(params: MarginDetailParams): Flow<List<MarginDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "margin_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(MarginDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取融资融券标的（盘前更新）
     * @param params 请求参数
     * @return 融资融券标的数据流
     */
    override fun getMarginSecs(params: MarginSecsParams): Flow<List<MarginSecsResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "margin_secs",
                    params = apiParams,
                )
            val results = response.getResponseItems(MarginSecsResult.serializer())
            emit(results)
        }

    /**
     * 获取转融券交易汇总数据
     * @param params 请求参数
     * @return 转融券交易汇总数据流
     */
    override fun getSlbSec(params: SlbSecParams): Flow<List<SlbSecResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "slb_sec",
                    params = apiParams,
                )
            val results = response.getResponseItems(SlbSecResult.serializer())
            emit(results)
        }

    /**
     * 获取转融资交易汇总数据
     * @param params 请求参数
     * @return 转融资交易汇总数据流
     */
    override fun getSlbLen(params: SlbLenParams): Flow<List<SlbLenResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "slb_len",
                    params = apiParams,
                )
            val results = response.getResponseItems(SlbLenResult.serializer())
            emit(results)
        }

    /**
     * 获取转融券交易明细数据
     * @param params 请求参数
     * @return 转融券交易明细数据流
     */
    override fun getSlbSecDetail(params: SlbSecDetailParams): Flow<List<SlbSecDetailResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "slb_sec_detail",
                    params = apiParams,
                )
            val results = response.getResponseItems(SlbSecDetailResult.serializer())
            emit(results)
        }

    /**
     * 获取做市借券交易汇总数据
     * @param params 请求参数
     * @return 做市借券交易汇总数据流
     */
    override fun getSlbLenMm(params: SlbLenMmParams): Flow<List<SlbLenMmResult>> =
        flow {
            val apiParams = params.toApiParams()

            val response =
                tuShare.callApi(
                    apiName = "slb_len_mm",
                    params = apiParams,
                )
            val results = response.getResponseItems(SlbLenMmResult.serializer())
            emit(results)
        }

}
