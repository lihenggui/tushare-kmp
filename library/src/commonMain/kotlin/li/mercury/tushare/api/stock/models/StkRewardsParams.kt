package li.mercury.tushare.api.stock.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 管理层薪酬和持股API请求参数
 */
@Serializable
data class StkRewardsParams(
    /** TS股票代码（必填） */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 报告期（格式：YYYYMMDD） */
    @SerialName("end_date")
    val endDate: String? = null,
)
