package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股权质押统计数据返回对象类
 */
@Serializable
public data class PledgeStatResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 截止日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate,
    /** 质押次数 */
    @SerialName("pledge_count")
    val pledgeCount: Int,
    /** 无限售股质押数量(万股) */
    @SerialName("unrest_pledge")
    val unrestPledge: Float,
    /** 限售股份质押数量(万股) */
    @SerialName("rest_pledge")
    val restPledge: Float,
    /** 总股本(万股) */
    @SerialName("total_share")
    val totalShare: Float? = null,
    /** 质押比例(%) */
    @SerialName("pledge_ratio")
    val pledgeRatio: Float? = null,
)
