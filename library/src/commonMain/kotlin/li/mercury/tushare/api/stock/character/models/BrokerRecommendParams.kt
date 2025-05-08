package li.mercury.tushare.api.stock.character.models

import kotlinx.serialization.Serializable

/**
 * 券商每月荐股请求参数
 */
@Serializable
data class BrokerRecommendParams(
    /** 月度（YYYYMM） */
    val month: String,
)
