package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中央结算系统持股明细请求参数
 */
@Serializable
public data class CcassHoldDetailParams(
    /** TS股票代码（支持A股和港股） */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 港交所股票代码（5位数字） */
    @SerialName("hk_code")
    val hkCode: String? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)
