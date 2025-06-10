package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 市场交易统计返回结果
 */
@Serializable
public data class DailyInfoResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 市场代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 市场名称 */
    @SerialName("ts_name")
    val tsName: String,
    /** 挂牌数 */
    @SerialName("com_count")
    val comCount: Int,
    /** 总股本（亿股） */
    @SerialName("total_share")
    val totalShare: Double,
    /** 流通股本（亿股） */
    @SerialName("float_share")
    val floatShare: Double,
    /** 总市值（亿元） */
    @SerialName("total_mv")
    val totalMv: Double,
    /** 流通市值（亿元） */
    @SerialName("float_mv")
    val floatMv: Double,
    /** 交易金额（亿元） */
    val amount: Double,
    /** 成交量（亿股） */
    val vol: Double? = null,
    /** 成交笔数（万笔） */
    @SerialName("trans_count")
    val transCount: Int,
    /** 平均市盈率 */
    val pe: Double,
    /** 换手率（%） */
    val tr: Double? = null,
    /** 交易所代码 */
    val exchange: Exchange,
)
