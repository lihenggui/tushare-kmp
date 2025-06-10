package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中央结算系统持股明细返回对象
 */
@Serializable
public data class CcassHoldDetailResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    @SerialName("name")
    val name: String? = null,
    /** 参与者编号 */
    @SerialName("col_participant_id")
    val participantId: String? = null,
    /** 机构名称 */
    @SerialName("col_participant_name")
    val participantName: String? = null,
    /** 持股量（股） */
    @SerialName("col_shareholding")
    val shareholding: Long? = null,
    /** 占已发行股份百分比（%） */
    @SerialName("col_shareholding_percent")
    val shareholdingPercent: Double? = null,
)
