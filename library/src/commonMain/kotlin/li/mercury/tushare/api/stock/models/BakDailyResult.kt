package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class BakDailyResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票名称 */
    val name: String,
    /** 涨跌幅 */
    @SerialName("pct_change")
    val pctChange: Float,
    /** 收盘价 */
    val close: Float,
    /** 涨跌额 */
    val change: Float,
    /** 开盘价 */
    val open: Float,
    /** 最高价 */
    val high: Float,
    /** 最低价 */
    val low: Float,
    /** 昨收价 */
    @SerialName("pre_close")
    val preClose: Float,
    /** 量比 */
    @SerialName("vol_ratio")
    val volRatio: Float,
    /** 换手率 */
    @SerialName("turn_over")
    val turnOver: Float,
    /** 振幅 */
    val swing: Float,
    /** 成交量 */
    val vol: Float,
    /** 成交额 */
    val amount: Float,
    /** 内盘（主动卖，手） */
    val selling: Float,
    /** 外盘（主动买，手） */
    val buying: Float,
    /** 总股本（亿） */
    @SerialName("total_share")
    val totalShare: Float,
    /** 流通股本（亿） */
    @SerialName("float_share")
    val floatShare: Float,
    /** 市盈率（动态） */
    val pe: Float,
    /** 所属行业 */
    val industry: String,
    /** 所属地域 */
    val area: String,
    /** 流通市值 */
    @SerialName("float_mv")
    val floatMv: Float,
    /** 总市值 */
    @SerialName("total_mv")
    val totalMv: Float,
    /** 平均价 */
    @SerialName("avg_price")
    val avgPrice: Float,
    /** 强弱度（%） */
    val strength: Float,
    /** 活跃度（%） */
    val activity: Float,
    /** 笔换手 */
    @SerialName("avg_turnover")
    val avgTurnover: Float,
    /** 攻击波（%） */
    val attack: Float,
    /** 近3月涨幅 */
    @SerialName("interval_3")
    val interval3: Float,
    /** 近6月涨幅 */
    @SerialName("interval_6")
    val interval6: Float
) 