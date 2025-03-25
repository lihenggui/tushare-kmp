package li.mercury.tushare.api.stock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.models.StockBasic
import li.mercury.tushare.models.StockDaily
import li.mercury.tushare.utils.asDoubleOrNull
import li.mercury.tushare.utils.asString
import li.mercury.tushare.utils.asStringOrNull

/**
 * 股票相关API的实现类
 * 
 * @param tuShare TuShare API客户端实例
 */
internal class StockRepositoryImpl(private val tuShare: TuShare) : StockRepository {
    /**
     * 获取股票基本信息
     *
     * @param exchange 交易所代码，如 "SSE"（上交所）, "SZSE"（深交所）, "BSE"（北交所）
     * @param listStatus 上市状态：L（上市）, D（退市）, P（暂停上市），默认为L
     * @param fields 需要返回的字段列表，以逗号分隔，如 "ts_code,name,area,industry,list_date"
     * @return 返回包含股票基本信息的Flow流
     */
    override fun getStockBasic(
        exchange: String?, 
        listStatus: String?, 
        fields: String?
    ): Flow<StockBasic> = flow {
        val params = buildMap {
            exchange?.let { put("exchange", it) }
            listStatus?.let { put("list_status", it) }
        }
        
        val response = tuShare.callApi(
            apiName = "stock_basic",
            params = params,
            fields = fields ?: ""
        )
        
        val fieldMap = response.fields.withIndex().associate { it.value to it.index }
        
        for (item in response.items) {
            emit(StockBasic(
                tsCode = item[fieldMap["ts_code"] ?: 0].asString(),
                symbol = item[fieldMap["symbol"] ?: 1].asString(),
                name = item[fieldMap["name"] ?: 2].asString(),
                area = item.getOrNull(fieldMap["area"] ?: -1)?.asStringOrNull(),
                industry = item.getOrNull(fieldMap["industry"] ?: -1)?.asStringOrNull(),
                fullName = item.getOrNull(fieldMap["fullname"] ?: -1)?.asStringOrNull(),
                enName = item.getOrNull(fieldMap["enname"] ?: -1)?.asStringOrNull(),
                cnSpell = item.getOrNull(fieldMap["cnspell"] ?: -1)?.asStringOrNull(),
                market = item.getOrNull(fieldMap["market"] ?: -1)?.asStringOrNull(),
                exchange = item.getOrNull(fieldMap["exchange"] ?: -1)?.asStringOrNull(),
                currType = item.getOrNull(fieldMap["curr_type"] ?: -1)?.asStringOrNull(),
                listStatus = item.getOrNull(fieldMap["list_status"] ?: -1)?.asStringOrNull(),
                listDate = item.getOrNull(fieldMap["list_date"] ?: -1)?.asStringOrNull(),
                delistDate = item.getOrNull(fieldMap["delist_date"] ?: -1)?.asStringOrNull(),
                isHs = item.getOrNull(fieldMap["is_hs"] ?: -1)?.asStringOrNull(),
                actName = item.getOrNull(fieldMap["act_name"] ?: -1)?.asStringOrNull(),
                actEntType = item.getOrNull(fieldMap["act_ent_type"] ?: -1)?.asStringOrNull()
            ))
        }
    }
    
    /**
     * 获取股票日线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD），如 "20230101"
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含日线行情数据的Flow流
     */
    override fun getStockDaily(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<StockDaily> = flow {
        val dailyData = getMarketData(
            apiName = "daily",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        dailyData.forEach { emit(it) }
    }
    
    /**
     * 获取股票周线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含周线行情数据的Flow流
     */
    override fun getStockWeekly(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<StockDaily> = flow {
        val weeklyData = getMarketData(
            apiName = "weekly",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        weeklyData.forEach { emit(it) }
    }
    
    /**
     * 获取股票月线行情数据
     *
     * @param tsCode 股票代码（格式：代码.交易所），如 "000001.SZ"
     * @param tradeDate 交易日期（格式：YYYYMMDD）
     * @param startDate 开始日期（格式：YYYYMMDD）
     * @param endDate 结束日期（格式：YYYYMMDD）
     * @return 返回包含月线行情数据的Flow流
     */
    override fun getStockMonthly(
        tsCode: String?, 
        tradeDate: String?, 
        startDate: String?, 
        endDate: String?
    ): Flow<StockDaily> = flow {
        val monthlyData = getMarketData(
            apiName = "monthly",
            tsCode = tsCode, 
            tradeDate = tradeDate, 
            startDate = startDate, 
            endDate = endDate
        )
        
        monthlyData.forEach { emit(it) }
    }
    
    /**
     * 处理行情数据的共用方法
     * 
     * @param apiName API名称，如 "daily", "weekly", "monthly"
     * @param tsCode 股票代码
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
    ): List<StockDaily> {
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
            StockDaily(
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