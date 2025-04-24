package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 现金流量表返回对象类
 */
@Serializable
data class CashflowResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 实际公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("f_ann_date")
    val fAnnDate: LocalDate? = null,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 公司类型 */
    @SerialName("comp_type")
    val compType: CompanyType? = null,
    /** 报表类型 */
    @SerialName("report_type")
    val reportType: ReportType? = null,
    /** 净利润 */
    @SerialName("net_profit")
    val netProfit: Double? = null,
    /** 财务费用 */
    @SerialName("finan_exp")
    val finanExp: Double? = null,
    /** 销售商品、提供劳务收到的现金 */
    @SerialName("c_fr_sale_sg")
    val cFrSaleSg: Double? = null,
    /** 收到的税费返还 */
    @SerialName("recp_tax_rends")
    val recpTaxRends: Double? = null,
    /** 经营活动现金流入小计 */
    @SerialName("c_inf_fr_operate_a")
    val cInfFrOperateA: Double? = null,
    /** 购买商品、接受劳务支付的现金 */
    @SerialName("c_paid_goods_s")
    val cPaidGoodsS: Double? = null,
    /** 支付给职工以及为职工支付的现金 */
    @SerialName("c_paid_to_for_empl")
    val cPaidToForEmpl: Double? = null,
    /** 支付的各项税费 */
    @SerialName("c_paid_for_taxes")
    val cPaidForTaxes: Double? = null,
    /** 经营活动现金流出小计 */
    @SerialName("st_cash_out_act")
    val stCashOutAct: Double? = null,
    /** 经营活动产生的现金流量净额 */
    @SerialName("n_cashflow_act")
    val nCashflowAct: Double? = null,
    /** 投资活动现金流入小计 */
    @SerialName("stot_inflows_inv_act")
    val stotInflowsInvAct: Double? = null,
    /** 投资活动现金流出小计 */
    @SerialName("stot_out_inv_act")
    val stotOutInvAct: Double? = null,
    /** 投资活动产生的现金流量净额 */
    @SerialName("n_cashflow_inv_act")
    val nCashflowInvAct: Double? = null,
    /** 筹资活动现金流入小计 */
    @SerialName("stot_cash_in_fnc_act")
    val stotCashInFncAct: Double? = null,
    /** 筹资活动现金流出小计 */
    @SerialName("stot_cashout_fnc_act")
    val stotCashoutFncAct: Double? = null,
    /** 筹资活动产生的现金流量净额 */
    @SerialName("n_cash_flows_fnc_act")
    val nCashFlowsFncAct: Double? = null,
    /** 汇率变动对现金的影响 */
    @SerialName("eff_fx_flu_cash")
    val effFxFluCash: Double? = null,
    /** 现金及现金等价物净增加额 */
    @SerialName("n_incr_cash_cash_equ")
    val nIncrCashCashEqu: Double? = null,
    /** 期初现金及现金等价物余额 */
    @SerialName("c_cash_equ_beg_period")
    val cCashEquBegPeriod: Double? = null,
    /** 期末现金及现金等价物余额 */
    @SerialName("c_cash_equ_end_period")
    val cCashEquEndPeriod: Double? = null,
)
