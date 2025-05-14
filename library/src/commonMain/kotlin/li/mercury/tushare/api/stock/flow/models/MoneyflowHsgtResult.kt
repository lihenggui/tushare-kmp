package li.mercury.tushare.api.stock.flow.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

@Serializable
data class MoneyflowHsgtResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,

    /** 港股通（上海）*/
    @SerialName("ggt_ss")
    val ggtSs: Double,

    /** 港股通（深圳）*/
    @SerialName("ggt_sz")
    val ggtSz: Double,

    /** 沪股通（百万元）*/
    @SerialName("hgt")
    val hgt: Double,

    /** 深股通（百万元）*/
    @SerialName("sgt")
    val sgt: Double,

    /** 北向资金（百万元）*/
    @SerialName("north_money")
    val northMoney: Double,

    /** 南向资金（百万元）*/
    @SerialName("south_money")
    val southMoney: Double,
) 