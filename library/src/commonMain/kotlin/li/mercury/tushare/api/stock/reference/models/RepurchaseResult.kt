package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股票回购返回对象类
 */
@Serializable
public data class RepurchaseResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 截止日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 进度（如实施、完成、股东大会通过） */
    val proc: RepurchaseProgress? = null,
    /** 过期日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("exp_date")
    val expDate: LocalDate? = null,
    /** 回购数量（股） */
    val vol: Float? = null,
    /** 回购金额（元） */
    val amount: Float? = null,
    /** 回购最高价（元） */
    @SerialName("high_limit")
    val highLimit: Float? = null,
    /** 回购最低价（元） */
    @SerialName("low_limit")
    val lowLimit: Float? = null,
)
