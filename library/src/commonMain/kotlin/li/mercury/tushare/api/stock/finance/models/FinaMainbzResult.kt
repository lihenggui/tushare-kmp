package li.mercury.tushare.api.stock.finance.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 主营业务构成返回对象类
 */
@Serializable
data class FinaMainbzResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 报告期 */
    @SerialName("end_date")
    val endDate: String,
    /** 主营业务来源 */
    @SerialName("bz_item")
    val bzItem: String? = null,
    /** 主营业务收入（元） */
    @SerialName("bz_sales")
    val bzSales: Double? = null,
    /** 主营业务利润（元） */
    @SerialName("bz_profit")
    val bzProfit: Double? = null,
    /** 主营业务成本（元） */
    @SerialName("bz_cost")
    val bzCost: Double? = null,
    /** 货币代码 */
    @SerialName("curr_type")
    val currType: String? = null,
    /** 是否更新 */
    @SerialName("update_flag")
    val updateFlag: String? = null,
)
