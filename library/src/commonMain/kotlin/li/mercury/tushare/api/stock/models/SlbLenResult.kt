package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 转融资交易汇总返回对象类
 */
@Serializable
data class SlbLenResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 期初余额(亿元) */
    val ob: Double? = null,
    /** 竞价成交金额(亿元) */
    @SerialName("auc_amount")
    val aucAmount: Double? = null,
    /** 再借成交金额(亿元) */
    @SerialName("repo_amount")
    val repoAmount: Double? = null,
    /** 偿还金额(亿元) */
    @SerialName("repay_amount")
    val repayAmount: Double? = null,
    /** 期末余额(亿元) */
    val cb: Double? = null,
)
