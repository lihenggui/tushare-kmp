package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Exchange

/**
 * 股票基本信息API请求参数
 */
@Serializable
data class StockBasicParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: String? = null,
    /** 股票名称 */
    val name: String? = null,
    /** 市场类别（主板/创业板/科创板/CDR/北交所） */
    val market: String? = null,
    /** 上市状态：L上市 D退市 P暂停上市，默认L */
    @SerialName("list_status")
    val listStatus: ListStatus? = null,
    /** 交易所代码：SSE上交所 SZSE深交所 BSE北交所 */
    val exchange: Exchange? = null,
    /** 是否沪深港通标的：N否 H沪股通 S深股通 */
    @SerialName("is_hs")
    val isHs: HsTarget? = null,
)
