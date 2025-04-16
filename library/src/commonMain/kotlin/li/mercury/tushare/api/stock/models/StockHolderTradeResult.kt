package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股东增减持返回对象类
 */
@Serializable
data class StockHolderTradeResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String,
    /** 股东类型 */
    @SerialName("holder_type")
    val holderType: HolderType,
    /** 类型 */
    @SerialName("in_de")
    val inDe: TradeType,
    /** 变动数量（股） */
    @SerialName("change_vol")
    val changeVol: Float,
    /** 占流通比例（%） */
    @SerialName("change_ratio")
    val changeRatio: Float,
    /** 变动后持股（股） */
    @SerialName("after_share")
    val afterShare: Float,
    /** 变动后占流通比例（%） */
    @SerialName("after_ratio")
    val afterRatio: Float? = null,
    /** 平均价格（元） */
    @SerialName("avg_price")
    val avgPrice: Float? = null,
    /** 持股总数（股） */
    @SerialName("total_share")
    val totalShare: Float,
    /** 增减持开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("begin_date")
    val beginDate: LocalDate? = null,
    /** 增减持结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("close_date")
    val closeDate: LocalDate? = null,
) 