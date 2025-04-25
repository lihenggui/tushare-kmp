package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 转融券交易明细返回对象类
 */
@Serializable
data class SlbSecDetailResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    val name: String? = null,
    /** 期限(天) */
    val tenor: String? = null,
    /** 融出费率(%) */
    @SerialName("fee_rate")
    val feeRate: Double? = null,
    /** 转融券融出数量(万股) */
    @SerialName("lent_qnt")
    val lentQnt: Double? = null,
)
