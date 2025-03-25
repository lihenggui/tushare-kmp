package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.models.IndexBasic
import li.mercury.tushare.models.IndexDaily
import li.mercury.tushare.models.SwIndexMember
import li.mercury.tushare.models.SwIndustry

/**
 * 指数相关API的存储库接口
 * 
 * 提供对指数基本信息和行情数据的访问
 */
interface IndexRepository {
    /**
     * 获取指数基本信息
     *
     * @param market 市场代码，如 "SSE"（上交所）, "SZSE"（深交所）, "CSI"（中证）等
     * @param publisher 发布方
     * @param category 指数类别
     * @return 返回包含指数基本信息的Flow流
     */
    fun getIndexBasic(
        market: String? = null, 
        publisher: String? = null, 
        category: String? = null
    ): Flow<IndexBasic>
    
    /**
     * 获取指数日线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含日线行情数据的Flow流
     */
    fun getIndexDaily(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<IndexDaily>
    
    /**
     * 获取指数周线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含周线行情数据的Flow流
     */
    fun getIndexWeekly(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<IndexDaily>
    
    /**
     * 获取指数月线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含月线行情数据的Flow流
     */
    fun getIndexMonthly(
        tsCode: String? = null, 
        tradeDate: String? = null, 
        startDate: String? = null, 
        endDate: String? = null
    ): Flow<IndexDaily>
    
    /**
     * 获取申万行业分类
     * 
     * @param codeLevel 行业代码级别：L1/L2/L3
     * @return 返回包含申万行业分类的Flow流
     */
    fun getSwIndustry(codeLevel: String? = null): Flow<SwIndustry>
    
    /**
     * 获取申万行业成分股
     * 
     * @param indexCode 指数代码
     * @param date 查询日期（格式：YYYYMMDD）
     * @return 返回包含申万行业成分股的Flow流
     */
    fun getSwIndexMember(indexCode: String? = null, date: String? = null): Flow<SwIndexMember>
} 