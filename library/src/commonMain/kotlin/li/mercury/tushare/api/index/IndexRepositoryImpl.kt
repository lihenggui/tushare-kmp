package li.mercury.tushare.api.index

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.models.IndexBasic
import li.mercury.tushare.models.IndexDaily
import li.mercury.tushare.models.SwIndexMember
import li.mercury.tushare.models.SwIndustry
import li.mercury.tushare.utils.asDoubleOrNull
import li.mercury.tushare.utils.asString
import li.mercury.tushare.utils.asStringOrNull

/**
 * 指数相关API的实现类
 * 
 * @param tuShare TuShare API客户端实例
 */
internal class IndexRepositoryImpl(private val tuShare: TuShare) : IndexRepository {
    /**
     * 获取指数基本信息
     *
     * @param market 市场代码，如 "SSE"（上交所）, "SZSE"（深交所）, "CSI"（中证）等
     * @param publisher 发布方
     * @param category 指数类别
     * @return 返回包含指数基本信息的Flow流
     */
    override fun getIndexBasic(
        market: String?, 
        publisher: String?, 
        category: String?
    ): Flow<IndexBasic> = flow {
        val params = buildMap {
            market?.let { put("market", it) }
            publisher?.let { put("publisher", it) }
            category?.let { put("category", it) }
        }
        
        val response = tuShare.callApi(
            apiName = "index_basic",
            params = params
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        for (item in response.items) {
            emit(IndexBasic(
                tsCode = item[fieldMap["ts_code"] ?: 0].asString(),
                name = item[fieldMap["name"] ?: 1].asString(),
                fullName = item.getOrNull(fieldMap["fullname"] ?: -1)?.asStringOrNull(),
                market = item.getOrNull(fieldMap["market"] ?: -1)?.asStringOrNull(),
                publisher = item.getOrNull(fieldMap["publisher"] ?: -1)?.asStringOrNull(),
                indexType = item.getOrNull(fieldMap["index_type"] ?: -1)?.asStringOrNull(),
                category = item.getOrNull(fieldMap["category"] ?: -1)?.asStringOrNull(),
                baseDate = item.getOrNull(fieldMap["base_date"] ?: -1)?.asStringOrNull(),
                basePoint = item.getOrNull(fieldMap["base_point"] ?: -1)?.asDoubleOrNull(),
                listDate = item.getOrNull(fieldMap["list_date"] ?: -1)?.asStringOrNull(),
                weightRule = item.getOrNull(fieldMap["weight_rule"] ?: -1)?.asStringOrNull(),
                desc = item.getOrNull(fieldMap["desc"] ?: -1)?.asStringOrNull(),
                expDate = item.getOrNull(fieldMap["exp_date"] ?: -1)?.asStringOrNull()
            ))
        }
    }
    
    /**
     * 获取指数日线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含日线行情数据的Flow流
     */
    override fun getIndexDaily(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<IndexDaily> = flow {
        val dailyData = getMarketData(
            apiName = "index_daily",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        dailyData.forEach { emit(it) }
    }
    
    /**
     * 获取指数周线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含周线行情数据的Flow流
     */
    override fun getIndexWeekly(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<IndexDaily> = flow {
        val weeklyData = getMarketData(
            apiName = "index_weekly",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        weeklyData.forEach { emit(it) }
    }
    
    /**
     * 获取指数月线行情数据
     *
     * @param tsCode 指数代码（格式：代码.交易所），如 "000001.SH"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含月线行情数据的Flow流
     */
    override fun getIndexMonthly(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<IndexDaily> = flow {
        val monthlyData = getMarketData(
            apiName = "index_monthly",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        monthlyData.forEach { emit(it) }
    }
    
    /**
     * 获取申万行业分类
     * 
     * @param codeLevel 行业代码级别：L1/L2/L3
     * @return 返回包含申万行业分类的Flow流
     */
    override fun getSwIndustry(codeLevel: String?): Flow<SwIndustry> = flow {
        val params = buildMap {
            codeLevel?.let { put("level", it) }
        }
        
        val response = tuShare.callApi(
            apiName = "sw_industry",
            params = params
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        for (item in response.items) {
            emit(SwIndustry(
                indexCode = item[fieldMap["index_code"] ?: 0].asString(),
                industryName = item[fieldMap["industry_name"] ?: 1].asString(),
                industryCode = item.getOrNull(fieldMap["industry_code"] ?: -1)?.asStringOrNull(),
                level = item.getOrNull(fieldMap["level"] ?: -1)?.asStringOrNull(),
                industryType = item.getOrNull(fieldMap["industry_type"] ?: -1)?.asStringOrNull(),
                isPub = item.getOrNull(fieldMap["is_pub"] ?: -1)?.asStringOrNull(),
                parentCode = item.getOrNull(fieldMap["parent_code"] ?: -1)?.asStringOrNull(),
                startDate = item.getOrNull(fieldMap["start_date"] ?: -1)?.asStringOrNull(),
                endDate = item.getOrNull(fieldMap["end_date"] ?: -1)?.asStringOrNull()
            ))
        }
    }
    
    /**
     * 获取申万行业成分股
     * 
     * @param indexCode 指数代码
     * @param date 查询日期（格式：YYYYMMDD）
     * @return 返回包含申万行业成分股的Flow流
     */
    override fun getSwIndexMember(indexCode: String?, date: String?): Flow<SwIndexMember> = flow {
        val params = buildMap {
            indexCode?.let { put("index_code", it) }
            date?.let { put("date", it) }
        }
        
        val response = tuShare.callApi(
            apiName = "sw_member",
            params = params
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        for (item in response.items) {
            emit(SwIndexMember(
                indexCode = item[fieldMap["index_code"] ?: 0].asString(),
                conCode = item[fieldMap["con_code"] ?: 1].asString(),
                industryName = item.getOrNull(fieldMap["industry_name"] ?: -1)?.asStringOrNull(),
                industryCode = item.getOrNull(fieldMap["industry_code"] ?: -1)?.asStringOrNull(),
                industryLevel = item.getOrNull(fieldMap["industry_level"] ?: -1)?.asStringOrNull(),
                isNew = item.getOrNull(fieldMap["is_new"] ?: -1)?.asStringOrNull(),
                inDate = item.getOrNull(fieldMap["in_date"] ?: -1)?.asStringOrNull(),
                outDate = item.getOrNull(fieldMap["out_date"] ?: -1)?.asStringOrNull(),
                stockName = item.getOrNull(fieldMap["stock_name"] ?: -1)?.asStringOrNull()
            ))
        }
    }
    
    /**
     * 处理行情数据的共用方法
     * 
     * @param apiName API名称，如 "index_daily", "index_weekly", "index_monthly"
     * @param tsCode 指数代码
     * @param tradeDate 交易日期
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 行情数据列表
     */
    private suspend fun getMarketData(
        apiName: String,
        tsCode: String?,
        tradeDate: String?,
        startDate: String?,
        endDate: String?
    ): List<IndexDaily> {
        val params = buildMap {
            tsCode?.let { put("ts_code", it) }
            tradeDate?.let { put("trade_date", it) }
            startDate?.let { put("start_date", it) }
            endDate?.let { put("end_date", it) }
        }
        
        val response = tuShare.callApi(
            apiName = apiName,
            params = params
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        return response.items.map { item ->
            IndexDaily(
                tsCode = item[fieldMap["ts_code"] ?: 0].asString(),
                tradeDate = item[fieldMap["trade_date"] ?: 1].asString(),
                open = item.getOrNull(fieldMap["open"] ?: -1)?.asDoubleOrNull(),
                high = item.getOrNull(fieldMap["high"] ?: -1)?.asDoubleOrNull(),
                low = item.getOrNull(fieldMap["low"] ?: -1)?.asDoubleOrNull(),
                close = item.getOrNull(fieldMap["close"] ?: -1)?.asDoubleOrNull(),
                preClose = item.getOrNull(fieldMap["pre_close"] ?: -1)?.asDoubleOrNull(),
                change = item.getOrNull(fieldMap["change"] ?: -1)?.asDoubleOrNull(),
                pctChg = item.getOrNull(fieldMap["pct_chg"] ?: -1)?.asDoubleOrNull(),
                vol = item.getOrNull(fieldMap["vol"] ?: -1)?.asDoubleOrNull(),
                amount = item.getOrNull(fieldMap["amount"] ?: -1)?.asDoubleOrNull()
            )
        }
    }
} 