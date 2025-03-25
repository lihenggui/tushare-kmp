package li.mercury.tushare.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Basic stock information model.
 *
 * Maps to the 'stock_basic' API response.
 */
@Serializable
data class StockBasic(
    /** TS代码 */
    @SerialName("ts_code") val tsCode: String,
    /** 股票代码 */
    @SerialName("symbol") val symbol: String,
    /** 股票名称 */
    @SerialName("name") val name: String,
    /** 地域 */
    @SerialName("area") val area: String? = null,
    /** 所属行业 */
    @SerialName("industry") val industry: String? = null,
    /** 股票全称 */
    @SerialName("fullname") val fullName: String? = null,
    /** 英文全称 */
    @SerialName("enname") val enName: String? = null,
    /** 拼音缩写 */
    @SerialName("cnspell") val cnSpell: String? = null,
    /** 市场类型 (主板/创业板/科创板/CDR) */
    @SerialName("market") val market: String? = null,
    /** 交易所代码 */
    @SerialName("exchange") val exchange: String? = null,
    /** 交易货币 */
    @SerialName("curr_type") val currType: String? = null,
    /** 上市状态 L上市 D退市 P暂停上市 */
    @SerialName("list_status") val listStatus: String? = null,
    /** 上市日期 */
    @SerialName("list_date") val listDate: String? = null,
    /** 退市日期 */
    @SerialName("delist_date") val delistDate: String? = null,
    /** 是否沪深港通标的，N否 H沪股通 S深股通 */
    @SerialName("is_hs") val isHs: String? = null,
    /** 实控人名称 */
    @SerialName("act_name") val actName: String? = null,
    /** 实控人企业性质 */
    @SerialName("act_ent_type") val actEntType: String? = null
)

/**
 * Stock daily market data model.
 *
 * Maps to the 'daily' API response.
 */
@Serializable
data class StockDaily(
    /** TS代码 */
    @SerialName("ts_code") val tsCode: String,
    /** 交易日期 */
    @SerialName("trade_date") val tradeDate: String,
    /** 开盘价 */
    @SerialName("open") val open: Double? = null,
    /** 最高价 */
    @SerialName("high") val high: Double? = null,
    /** 最低价 */
    @SerialName("low") val low: Double? = null,
    /** 收盘价 */
    @SerialName("close") val close: Double? = null,
    /** 昨收价(除权) */
    @SerialName("pre_close") val preClose: Double? = null,
    /** 涨跌额 */
    @SerialName("change") val change: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_chg") val pctChg: Double? = null,
    /** 成交量(手) */
    @SerialName("vol") val vol: Double? = null,
    /** 成交额(千元) */
    @SerialName("amount") val amount: Double? = null
)

/**
 * Stock index basic information model.
 *
 * Maps to the 'index_basic' API response.
 */
@Serializable
data class IndexBasic(
    /** TS代码 */
    @SerialName("ts_code") val tsCode: String,
    /** 简称 */
    @SerialName("name") val name: String,
    /** 指数全称 */
    @SerialName("fullname") val fullName: String? = null,
    /** 市场 */
    @SerialName("market") val market: String? = null,
    /** 发布方 */
    @SerialName("publisher") val publisher: String? = null,
    /** 指数类别 */
    @SerialName("index_type") val indexType: String? = null,
    /** 指数风格 */
    @SerialName("category") val category: String? = null,
    /** 基期 */
    @SerialName("base_date") val baseDate: String? = null,
    /** 基点 */
    @SerialName("base_point") val basePoint: Double? = null,
    /** 发布日期 */
    @SerialName("list_date") val listDate: String? = null,
    /** 加权方式 */
    @SerialName("weight_rule") val weightRule: String? = null,
    /** 描述 */
    @SerialName("desc") val desc: String? = null,
    /** 终止日期 */
    @SerialName("exp_date") val expDate: String? = null
)

/**
 * Stock index daily market data model.
 *
 * Maps to the 'index_daily' API response.
 */
@Serializable
data class IndexDaily(
    /** TS代码 */
    @SerialName("ts_code") val tsCode: String,
    /** 交易日期 */
    @SerialName("trade_date") val tradeDate: String,
    /** 开盘点位 */
    @SerialName("open") val open: Double? = null,
    /** 最高点位 */
    @SerialName("high") val high: Double? = null,
    /** 最低点位 */
    @SerialName("low") val low: Double? = null,
    /** 收盘点位 */
    @SerialName("close") val close: Double? = null,
    /** 昨日收盘点位 */
    @SerialName("pre_close") val preClose: Double? = null,
    /** 涨跌点位 */
    @SerialName("change") val change: Double? = null,
    /** 涨跌幅 */
    @SerialName("pct_chg") val pctChg: Double? = null,
    /** 成交量(手) */
    @SerialName("vol") val vol: Double? = null,
    /** 成交额(千元) */
    @SerialName("amount") val amount: Double? = null
) 