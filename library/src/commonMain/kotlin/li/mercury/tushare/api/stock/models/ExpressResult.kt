package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 业绩快报返回对象类
 */
@Serializable
data class ExpressResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate,
    /** 营业收入（元） */
    val revenue: Double? = null,
    /** 营业利润（元） */
    @SerialName("operate_profit")
    val operateProfit: Double? = null,
    /** 利润总额（元） */
    @SerialName("total_profit")
    val totalProfit: Double? = null,
    /** 净利润（元） */
    @SerialName("n_income")
    val nIncome: Double? = null,
    /** 总资产（元） */
    @SerialName("total_assets")
    val totalAssets: Double? = null,
    /** 股东权益合计（不含少数股东权益）（元） */
    @SerialName("total_hldr_eqy_exc_min_int")
    val totalHldrEqyExcMinInt: Double? = null,
    /** 每股收益（摊薄）（元） */
    @SerialName("diluted_eps")
    val dilutedEps: Double? = null,
    /** 净资产收益率（摊薄）（%） */
    @SerialName("diluted_roe")
    val dilutedRoe: Double? = null,
    /** 去年同期修正后净利润 */
    @SerialName("yoy_net_profit")
    val yoyNetProfit: Double? = null,
    /** 每股净资产 */
    val bps: Double? = null,
    /** 同比增长率：营业收入 */
    @SerialName("yoy_sales")
    val yoySales: Double? = null,
    /** 同比增长率：营业利润 */
    @SerialName("yoy_op")
    val yoyOp: Double? = null,
    /** 同比增长率：利润总额 */
    @SerialName("yoy_tp")
    val yoyTp: Double? = null,
    /** 同比增长率：归属母公司股东的净利润 */
    @SerialName("yoy_dedu_np")
    val yoyDeduNp: Double? = null,
    /** 同比增长率：基本每股收益 */
    @SerialName("yoy_eps")
    val yoyEps: Double? = null,
    /** 同比增减：加权平均净资产收益率 */
    @SerialName("yoy_roe")
    val yoyRoe: Double? = null,
    /** 比年初增长率：总资产 */
    @SerialName("growth_assets")
    val growthAssets: Double? = null,
    /** 比年初增长率：归属母公司的股东权益 */
    @SerialName("yoy_equity")
    val yoyEquity: Double? = null,
    /** 比年初增长率：归属于母公司股东的每股净资产 */
    @SerialName("growth_bps")
    val growthBps: Double? = null,
    /** 去年同期营业收入 */
    @SerialName("or_last_year")
    val orLastYear: Double? = null,
    /** 去年同期营业利润 */
    @SerialName("op_last_year")
    val opLastYear: Double? = null,
    /** 去年同期利润总额 */
    @SerialName("tp_last_year")
    val tpLastYear: Double? = null,
    /** 去年同期净利润 */
    @SerialName("np_last_year")
    val npLastYear: Double? = null,
    /** 去年同期每股收益 */
    @SerialName("eps_last_year")
    val epsLastYear: Double? = null,
    /** 期初净资产 */
    @SerialName("open_net_assets")
    val openNetAssets: Double? = null,
    /** 期初每股净资产 */
    @SerialName("open_bps")
    val openBps: Double? = null,
    /** 业绩简要说明 */
    @SerialName("perf_summary")
    val perfSummary: String? = null,
    /** 是否审计（1 是，0 否） */
    @SerialName("is_audit")
    val isAudit: Int? = null,
    /** 备注 */
    val remark: String? = null,
) 