package li.mercury.tushare.api.index.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 指数技术因子专业版返回结果
 */
@Serializable
data class IdxFactorProResult(
    /** TS指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    
    /** 交易日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    
    // 基础行情字段
    /** 开盘价 */
    val open: Double,
    /** 最高价 */
    val high: Double,
    /** 最低价 */
    val low: Double,
    /** 收盘价 */
    val close: Double,
    /** 昨收价 */
    @SerialName("pre_close")
    val preClose: Double,
    /** 涨跌额 */
    val change: Double,
    /** 涨跌幅（未复权） */
    @SerialName("pct_change")
    val pctChange: Double,
    /** 成交量（手） */
    val vol: Double,
    /** 成交额（千元） */
    val amount: Double,

    // 技术指标字段
    /** 振动升降指标 */
    @SerialName("asi_bfq")
    val asiBfq: Double,
    /** 振动升降指标 */
    @SerialName("asit_bfq")
    val asitBfq: Double,
    /** 真实波动N日平均值 */
    @SerialName("atr_bfq")
    val atrBfq: Double,
    /** BBI多空指标 */
    @SerialName("bbi_bfq")
    val bbiBfq: Double,
    /** BIAS乖离率 */
    @SerialName("bias1_bfq")
    val bias1Bfq: Double,
    @SerialName("bias2_bfq")
    val bias2Bfq: Double,
    @SerialName("bias3_bfq")
    val bias3Bfq: Double,
    /** BOLL指标下轨 */
    @SerialName("boll_lower_bfq")
    val bollLowerBfq: Double,
    /** BOLL指标中轨 */
    @SerialName("boll_mid_bfq")
    val bollMidBfq: Double,
    /** BOLL指标上轨 */
    @SerialName("boll_upper_bfq")
    val bollUpperBfq: Double,
    /** BRAR情绪指标 */
    @SerialName("brar_ar_bfq")
    val brarArBfq: Double,
    @SerialName("brar_br_bfq")
    val brarBrBfq: Double,
    /** CCI顺势指标 */
    @SerialName("cci_bfq")
    val cciBfq: Double,
    /** CR价格动量指标 */
    @SerialName("cr_bfq")
    val crBfq: Double,
    /** 平行线差指标 */
    @SerialName("dfma_dif_bfq")
    val dfmaDifBfq: Double,
    @SerialName("dfma_difma_bfq")
    val dfmaDifmaBfq: Double,
    /** 动向指标 */
    @SerialName("dmi_adx_bfq")
    val dmiAdxBfq: Double,
    @SerialName("dmi_adxr_bfq")
    val dmiAdxrBfq: Double,
    @SerialName("dmi_mdi_bfq")
    val dmiMdiBfq: Double,
    @SerialName("dmi_pdi_bfq")
    val dmiPdiBfq: Double,
    /** 连跌天数 */
    val downdays: Double,
    /** 连涨天数 */
    val updays: Double,
    /** 区间震荡线 */
    @SerialName("dpo_bfq")
    val dpoBfq: Double,
    @SerialName("madpo_bfq")
    val madpoBfq: Double,
    /** 指数移动平均 */
    @SerialName("ema_bfq_10")
    val emaBfq10: Double,
    @SerialName("ema_bfq_20")
    val emaBfq20: Double,
    @SerialName("ema_bfq_250")
    val emaBfq250: Double,
    @SerialName("ema_bfq_30")
    val emaBfq30: Double,
    @SerialName("ema_bfq_5")
    val emaBfq5: Double,
    @SerialName("ema_bfq_60")
    val emaBfq60: Double,
    @SerialName("ema_bfq_90")
    val emaBfq90: Double,
    /** 简易波动指标 */
    @SerialName("emv_bfq")
    val emvBfq: Double,
    @SerialName("maemv_bfq")
    val maemvBfq: Double,
    /** EMA指数平均数指标 */
    @SerialName("expma_12_bfq")
    val expma12Bfq: Double,
    @SerialName("expma_50_bfq")
    val expma50Bfq: Double,
    /** KDJ指标 */
    @SerialName("kdj_bfq")
    val kdjBfq: Double,
    @SerialName("kdj_d_bfq")
    val kdjDBfq: Double,
    @SerialName("kdj_k_bfq")
    val kdjKBfq: Double,
    /** 肯特纳交易通道 */
    @SerialName("ktn_down_bfq")
    val ktnDownBfq: Double,
    @SerialName("ktn_mid_bfq")
    val ktnMidBfq: Double,
    @SerialName("ktn_upper_bfq")
    val ktnUpperBfq: Double,
    /** 周期极值 */
    val lowdays: Double,
    val topdays: Double,
    /** 简单移动平均 */
    @SerialName("ma_bfq_10")
    val maBfq10: Double,
    @SerialName("ma_bfq_20")
    val maBfq20: Double,
    @SerialName("ma_bfq_250")
    val maBfq250: Double,
    @SerialName("ma_bfq_30")
    val maBfq30: Double,
    @SerialName("ma_bfq_5")
    val maBfq5: Double,
    @SerialName("ma_bfq_60")
    val maBfq60: Double,
    @SerialName("ma_bfq_90")
    val maBfq90: Double,
    /** MACD指标 */
    @SerialName("macd_bfq")
    val macdBfq: Double,
    @SerialName("macd_dea_bfq")
    val macdDeaBfq: Double,
    @SerialName("macd_dif_bfq")
    val macdDifBfq: Double,
    /** 梅斯线 */
    @SerialName("mass_bfq")
    val massBfq: Double,
    @SerialName("ma_mass_bfq")
    val maMassBfq: Double,
    /** MFI指标 */
    @SerialName("mfi_bfq")
    val mfiBfq: Double,
    /** 动量指标 */
    @SerialName("mtm_bfq")
    val mtmBfq: Double,
    @SerialName("mtmma_bfq")
    val mtmmaBfq: Double,
    /** 能量潮指标 */
    @SerialName("obv_bfq")
    val obvBfq: Double,
    /** 投资者情绪指标 */
    @SerialName("psy_bfq")
    val psyBfq: Double,
    @SerialName("psyma_bfq")
    val psymaBfq: Double,
    /** 变动率指标 */
    @SerialName("roc_bfq")
    val rocBfq: Double,
    @SerialName("maroc_bfq")
    val marocBfq: Double,
    /** RSI指标 */
    @SerialName("rsi_bfq_12")
    val rsiBfq12: Double,
    @SerialName("rsi_bfq_24")
    val rsiBfq24: Double,
    @SerialName("rsi_bfq_6")
    val rsiBfq6: Double
)
