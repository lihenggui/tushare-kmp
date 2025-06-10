package li.mercury.tushare.api.stock.reference.models

import kotlinx.serialization.SerialName

/**
 * 股票回购进度枚举
 */
public enum class RepurchaseProgress {
    @SerialName("实施")
    IMPLEMENTING,

    @SerialName("完成")
    COMPLETED,

    @SerialName("股东大会通过")
    SHAREHOLDER_APPROVED,
}
