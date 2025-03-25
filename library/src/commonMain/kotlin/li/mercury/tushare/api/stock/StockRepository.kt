package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.models.StockBasic
import li.mercury.tushare.models.StockDaily

/**
 * 股票相关API的存储库接口
 * 
 * 提供对股票基本信息和行情数据的访问
 */
interface StockRepository {
    /**
     * 获取股票基本信息
     *
     * @param exchange 交易所代码，如 "SSE"（上交所）, "SZSE"（深交所）, "BSE"（北交所）
     * @param listStatus 上市状态：L（上市）, D（退市）, P（暂停上市），默认为L
     * @param fields 需要返回的字段列表，以逗号分隔，如 "ts_code,name,area,industry,list_date"
     * @return 返回包含股票基本信息的Flow流
     */
    fun getStockBasic(
        exchange: String? = null, 
        listStatus: String? = null, 
        fields: String? = null
    ): Flow<StockBasic>
    
    /**
     * 获取股票日线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD），如 "20230101"
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含日线行情数据的Flow流
     */
    fun getStockDaily(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<StockDaily>
    
    /**
     * 获取股票周线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含周线行情数据的Flow流
     */
    fun getStockWeekly(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<StockDaily>
    
    /**
     * 获取股票月线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含月线行情数据的Flow流
     */
    fun getStockMonthly(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<StockDaily>
} 