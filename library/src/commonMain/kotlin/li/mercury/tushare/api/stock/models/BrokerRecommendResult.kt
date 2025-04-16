package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 券商每月荐股返回对象
 */
@Serializable
data class BrokerRecommendResult(
    /** 月度（YYYYMM） */
    val month: String,
    /** 券商名称 */
    val broker: String,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票简称 */
    val name: String
) 