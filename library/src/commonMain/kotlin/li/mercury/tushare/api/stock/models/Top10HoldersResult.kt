package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 前十大股东返回对象类
 */
@Serializable
data class Top10HoldersResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String? = null,
    /** 持有数量（股） */
    @SerialName("hold_amount")
    val holdAmount: Double? = null,
    /** 占总股本比例（%） */
    @SerialName("hold_ratio")
    val holdRatio: Double? = null,
    /** 占流通股本比例（%） */
    @SerialName("hold_float_ratio")
    val holdFloatRatio: Double? = null,
    /** 持股变动 */
    @SerialName("hold_change")
    val holdChange: Double? = null,
    /** 股东类型 */
    @SerialName("holder_type")
    val holderType: String? = null,
)
