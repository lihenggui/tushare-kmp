package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 备用基础列表返回对象类
 */
@Serializable
data class BakBasicResult(
    /** 交易日期 */
    @SerialName("trade_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate,
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: String,
    /** 股票名称 */
    val name: String,
    /** 行业 */
    val industry: String? = null,
    /** 地域 */
    val area: String? = null,
    /** 市盈率（动） */
    val pe: Float? = null,
    /** 流通股本（亿） */
    @SerialName("float_share")
    val floatShare: Float? = null,
    /** 总股本（亿） */
    @SerialName("total_share")
    val totalShare: Float? = null,
    /** 总资产（亿） */
    @SerialName("total_assets")
    val totalAssets: Float? = null,
    /** 流动资产（亿） */
    @SerialName("liquid_assets")
    val liquidAssets: Float? = null,
    /** 固定资产（亿） */
    @SerialName("fixed_assets")
    val fixedAssets: Float? = null,
    /** 公积金 */
    val reserved: Float? = null,
    /** 每股公积金 */
    @SerialName("reserved_pershare")
    val reservedPershare: Float? = null,
    /** 每股收益 */
    val eps: Float? = null,
    /** 每股净资产 */
    val bvps: Float? = null,
    /** 市净率 */
    val pb: Float? = null,
    /** 上市日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("list_date")
    val listDate: LocalDate? = null,
    /** 未分配利润 */
    val undp: Float? = null,
    /** 每股未分配利润 */
    @SerialName("per_undp")
    val perUndp: Float? = null,
    /** 收入同比（%） */
    @SerialName("rev_yoy")
    val revYoy: Float? = null,
    /** 利润同比（%） */
    @SerialName("profit_yoy")
    val profitYoy: Float? = null,
    /** 毛利率（%） */
    val gpr: Float? = null,
    /** 净利润率（%） */
    val npr: Float? = null,
    /** 股东人数 */
    @SerialName("holder_num")
    val holderNum: Int? = null,
)
