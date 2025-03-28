package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange
import li.mercury.tushare.models.TsCode

/**
 * 上市公司基本信息API请求参数
 */
@Serializable
data class StockCompanyParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易所代码：SSE上交所，SZSE深交所，BSE北交所 */
    val exchange: Exchange? = null,
) 