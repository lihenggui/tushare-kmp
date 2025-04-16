package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 中央结算系统持股汇总返回对象类
 */
@Serializable
data class CcassHoldResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate? = null,

    /** 股票代号 */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /** 股票名称 */
    val name: String,

    /** 于中央结算系统的持股量(股) */
    val shareholding: String? = null,

    /** 参与者数目（个） */
    @SerialName("hold_nums")
    val holdNums: String? = null,

    /** 占于上交所上市及交易的A股总数的百分比（%） */
    @SerialName("hold_ratio")
    val holdRatio: String? = null,
) 