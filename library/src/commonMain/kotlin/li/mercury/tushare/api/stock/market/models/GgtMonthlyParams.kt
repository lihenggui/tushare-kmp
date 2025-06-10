package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 港股通每月成交统计API请求参数
 */
@Serializable
public data class GgtMonthlyParams(
    /** 月度（格式：YYYYMM，支持多个输入） */
    val month: String? = null,
    /** 开始月度（格式：YYYYMM） */
    @SerialName("start_month")
    val startMonth: String? = null,
    /** 结束月度（格式：YYYYMM） */
    @SerialName("end_month")
    val endMonth: String? = null,
)
