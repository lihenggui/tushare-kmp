package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 做市借券交易汇总返回对象类
 */
@Serializable
data class SlbLenMmResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 股票名称 */
    @SerialName("name")
    val name: String? = null,
    /** 期初余量(万股) */
    @SerialName("ope_inv")
    val opeInv: Double? = null,
    /** 融出数量(万股) */
    @SerialName("lent_qnt")
    val lentQnt: Double? = null,
    /** 期末余量(万股) */
    @SerialName("cls_inv")
    val clsInv: Double? = null,
    /** 期末余额(万元) */
    @SerialName("end_bal")
    val endBal: Double? = null,
)
