package li.mercury.tushare.api.stock.margin

import kotlinx.coroutines.flow.Flow
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

/**
 * 股票相关API的存储库接口
 */
public interface StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     */
    public fun getMargin(params: MarginParams): Flow<List<MarginResult>>

    /**
     * 获取融资融券交易明细数据
     */
    public fun getMarginDetail(params: MarginDetailParams): Flow<List<MarginDetailResult>>

    /**
     * 获取融资融券标的（盘前更新）
     */
    public fun getMarginSecs(params: MarginSecsParams): Flow<List<MarginSecsResult>>

    /**
     * 获取转融券交易汇总数据
     */
    public fun getSlbSec(params: SlbSecParams): Flow<List<SlbSecResult>>

    /**
     * 获取转融资交易汇总数据
     */
    public fun getSlbLen(params: SlbLenParams): Flow<List<SlbLenResult>>

    /**
     * 获取转融券交易明细数据
     */
    public fun getSlbSecDetail(params: SlbSecDetailParams): Flow<List<SlbSecDetailResult>>

    /**
     * 获取做市借券交易汇总数据
     */
    public fun getSlbLenMm(params: SlbLenMmParams): Flow<List<SlbLenMmResult>>
}
