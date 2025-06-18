package li.mercury.tushare.api.stock.margin

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
 * 股票融资融券相关API接口
 */
public interface StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     */
    public suspend fun getMargin(params: MarginParams): List<MarginResult>

    /**
     * 获取融资融券交易明细数据
     */
    public suspend fun getMarginDetail(params: MarginDetailParams): List<MarginDetailResult>

    /**
     * 获取融资融券标的（盘前更新）
     */
    public suspend fun getMarginSecs(params: MarginSecsParams): List<MarginSecsResult>

    /**
     * 获取转融券交易汇总数据
     */
    public suspend fun getSlbSec(params: SlbSecParams): List<SlbSecResult>

    /**
     * 获取转融资交易汇总数据
     */
    public suspend fun getSlbLen(params: SlbLenParams): List<SlbLenResult>

    /**
     * 获取转融券交易明细数据
     */
    public suspend fun getSlbSecDetail(params: SlbSecDetailParams): List<SlbSecDetailResult>

    /**
     * 获取做市借券交易汇总数据
     */
    public suspend fun getSlbLenMm(params: SlbLenMmParams): List<SlbLenMmResult>
}
