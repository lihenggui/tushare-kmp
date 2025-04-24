package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 限售股解禁返回对象类
 */
@Serializable
data class ShareFloatResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 解禁日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("float_date")
    val floatDate: LocalDate,
    /** 解禁股份数量（股） */
    @SerialName("float_share")
    val floatShare: Float,
    /** 解禁股份占总股本比例（%） */
    @SerialName("float_ratio")
    val floatRatio: Float,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String,
    /** 股份类型（如定增股份、首发原股东限售股份） */
    @SerialName("share_type")
    val shareType: String,
)
