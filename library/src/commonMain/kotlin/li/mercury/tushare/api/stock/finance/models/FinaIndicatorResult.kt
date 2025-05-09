package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 财务指标数据返回结果
 */
@Serializable
data class FinaIndicatorResult(
    /** TS代码 */
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
    /** 基本每股收益 */
    val eps: Double? = null,
    /** 稀释每股收益 */
    @SerialName("dt_eps")
    val dtEps: Double? = null,
    /** 每股营业收入 */
    @SerialName("revenue_ps")
    val revenuePs: Double? = null,
    /** 每股未分配利润 */
    @SerialName("undist_profit_ps")
    val undistProfitPs: Double? = null,
    /** 扣除非经常性损益后的净利润 */
    @SerialName("profit_dedt")
    val profitDedt: Double? = null,
    /** 毛利率 */
    @SerialName("gross_margin")
    val grossMargin: Double? = null,
    /** 流动比率 */
    @SerialName("current_ratio")
    val currentRatio: Double? = null,
    /** 速动比率 */
    @SerialName("quick_ratio")
    val quickRatio: Double? = null,
    /** 保守速动比率 */
    @SerialName("cash_ratio")
    val cashRatio: Double? = null,
    /** 应收账款周转率 */
    @SerialName("ar_turn")
    val arTurn: Double? = null,
    /** 固定资产周转率 */
    @SerialName("fa_turn")
    val faTurn: Double? = null,
    /** 总资产周转率 */
    @SerialName("assets_turn")
    val assetsTurn: Double? = null,
    /** 息税前利润 */
    val ebit: Double? = null,
    /** 息税折旧摊销前利润 */
    val ebitda: Double? = null,
    /** 企业自由现金流量 */
    val fcff: Double? = null,
    /** 股权自由现金流量 */
    val fcfe: Double? = null,
    /** 有形资产 */
    @SerialName("tangible_asset")
    val tangibleAsset: Double? = null,
    /** 营运资金 */
    @SerialName("working_capital")
    val workingCapital: Double? = null,
    /** 留存收益 */
    @SerialName("retained_earnings")
    val retainedEarnings: Double? = null,
    /** 每股净资产 */
    val bps: Double? = null,
    /** 每股经营活动产生的现金流量净额 */
    val ocfps: Double? = null,
    /** 每股现金流量净额 */
    val cfps: Double? = null,
    /** 销售净利率 */
    @SerialName("netprofit_margin")
    val netprofitMargin: Double? = null,
    /** 销售毛利率 */
    @SerialName("grossprofit_margin")
    val grossprofitMargin: Double? = null,
    /** 净资产收益率 */
    val roe: Double? = null,
    /** 总资产报酬率 */
    val roa: Double? = null,
    /** 投入资本回报率 */
    val roic: Double? = null,
    /** 资产负债率 */
    @SerialName("debt_to_assets")
    val debtToAssets: Double? = null,
    /** 权益乘数 */
    @SerialName("assets_to_eqt")
    val assetsToEqt: Double? = null,
    /** 经营活动产生的现金流量净额/负债合计 */
    @SerialName("ocf_to_debt")
    val ocfToDebt: Double? = null,
    /** 净资产同比增长率 */
    @SerialName("equity_yoy")
    val equityYoy: Double? = null,
    /** 基本每股收益同比增长率(%) */
    @SerialName("basic_eps_yoy")
    val basicEpsYoy: Double? = null,
    /** 归属母公司股东的净利润同比增长率(%) */
    @SerialName("netprofit_yoy")
    val netprofitYoy: Double? = null,
    /** 营业总收入同比增长率(%) */
    @SerialName("tr_yoy")
    val trYoy: Double? = null,
    /** 营业收入同比增长率(%) */
    @SerialName("or_yoy")
    val orYoy: Double? = null,
)
