package li.mercury.tushare.api.stock.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 资产负债表返回结果
 */
@Serializable
data class BalanceSheetResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,

    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,

    /** 实际公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("f_ann_date")
    val fAnnDate: LocalDate,

    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate,

    /** 报表类型 */
    @SerialName("report_type")
    val reportType: ReportType,

    /** 公司类型 */
    @SerialName("comp_type")
    val compType: CompType,

    /** 资产总计 */
    @SerialName("total_assets")
    val totalAssets: Double? = null,

    /** 负债合计 */
    @SerialName("total_liab")
    val totalLiab: Double? = null,

    /** 股东权益合计（不含少数股东权益） */
    @SerialName("total_hldr_eqy_exc_min_int")
    val totalHldrEqyExcMinInt: Double? = null,

    /** 股东权益合计（含少数股东权益） */
    @SerialName("total_hldr_eqy_inc_min_int")
    val totalHldrEqyIncMinInt: Double? = null,

    /** 负债及股东权益总计 */
    @SerialName("total_liab_hldr_eqy")
    val totalLiabHldrEqy: Double? = null,

    /** 资本公积金 */
    @SerialName("cap_rese")
    val capRese: Double? = null,

    /** 未分配利润 */
    @SerialName("undistr_porfit")
    val undistrPorfit: Double? = null,

    /** 盈余公积金 */
    @SerialName("surplus_rese")
    val surplusRese: Double? = null,

    /** 货币资金 */
    @SerialName("money_cap")
    val moneyCap: Double? = null,

    /** 应收账款 */
    @SerialName("accounts_receiv")
    val accountsReceiv: Double? = null,

    /** 存货 */
    val inventories: Double? = null,

    /** 固定资产 */
    @SerialName("fix_assets")
    val fixAssets: Double? = null,

    /** 商誉 */
    val goodwill: Double? = null,

    /** 流动资产合计 */
    @SerialName("total_cur_assets")
    val totalCurAssets: Double? = null,

    /** 非流动资产合计 */
    @SerialName("total_nca")
    val totalNca: Double? = null,

    /** 流动负债合计 */
    @SerialName("total_cur_liab")
    val totalCurLiab: Double? = null,

    /** 非流动负债合计 */
    @SerialName("total_ncl")
    val totalNcl: Double? = null,
) 