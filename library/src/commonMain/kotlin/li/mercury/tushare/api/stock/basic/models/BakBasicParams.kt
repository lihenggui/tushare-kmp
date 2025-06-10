package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 备用基础列表API请求参数
 */
@Serializable
public data class BakBasicParams(
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
)
