/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package li.mercury.tushare.api.stock.finance

import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.BalanceSheetResult
import li.mercury.tushare.api.stock.finance.models.CashflowParams
import li.mercury.tushare.api.stock.finance.models.CashflowResult
import li.mercury.tushare.api.stock.finance.models.DisclosureDateParams
import li.mercury.tushare.api.stock.finance.models.DisclosureDateResult
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.DividendResult
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.ExpressResult
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditResult
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorResult
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzResult
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.ForecastResult
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.api.stock.finance.models.IncomeResult

/**
 * 股票财务数据相关API接口
 * 
 * 提供上市公司财务报表数据，包括利润表、资产负债表、现金流量表、
 * 业绩预告、分红送股、财务指标等核心财务信息的访问接口
 */
public interface StockFinanceApiInterface {
    /**
     * 获取利润表数据
     * 
     * 调用TuShare API: `income`
     * 
     * **权限要求**: 2000积分以上用户可调用，5000积分以上可使用VIP接口
     * **数据限制**: 单次最大提取1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司财务利润表数据，支持历史数据查询
     * 
     * **公司类型**:
     * - `1`: 一般工商业
     * - `2`: 银行
     * - `3`: 保险
     * - `4`: 证券
     * 
     * @param params 利润表查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `f_ann_date`: 实际公告日期（可选）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选，如20171231表示年报）
     *   - `report_type`: 报告类型（可选，1合并报表/2单季合并等）
     *   - `comp_type`: 公司类型（可选，1-4对应不同类型）
     * 
     * @return 返回利润表数据列表，包含以下字段：
     *   - `ts_code`: TS代码
     *   - `ann_date`: 公告日期
     *   - `f_ann_date`: 实际公告日期
     *   - `end_date`: 报告期
     *   - `report_type`: 报告类型
     *   - `comp_type`: 公司类型
     *   - `basic_eps`: 基本每股收益
     *   - `diluted_eps`: 稀释每股收益
     *   - `total_revenue`: 营业总收入
     *   - `revenue`: 营业收入
     *   - `total_profit`: 利润总额
     *   - `n_income`: 净利润（含少数股东损益）
     *   - `n_income_attr_p`: 净利润（不含少数股东损益）
     * 
     * @see [利润表文档](https://tushare.pro/document/2?doc_id=33)
     */
    public suspend fun getIncome(params: IncomeParams): List<IncomeResult>

    /**
     * 获取资产负债表数据
     * 
     * 调用TuShare API: `balancesheet`
     * 
     * **权限要求**: 2000积分以上用户可调用，5000积分以上可使用VIP接口
     * **数据限制**: 单次最大提取1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司资产负债表数据，支持历史数据查询
     * 
     * @param params 资产负债表查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     *   - `report_type`: 报告类型（可选）
     *   - `comp_type`: 公司类型（可选）
     * 
     * @return 返回资产负债表数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `f_ann_date`: 实际公告日期
     *   - `end_date`: 报告期
     *   - `total_assets`: 资产总计
     *   - `total_liab`: 负债合计
     *   - `total_hldr_eqy_exc_min_int`: 股东权益合计（不含少数股东权益）
     *   - `total_hldr_eqy_inc_min_int`: 股东权益合计（含少数股东权益）
     *   - `money_cap`: 货币资金
     *   - `accounts_receiv`: 应收账款
     *   - `inventories`: 存货
     *   - `fix_assets`: 固定资产
     * 
     * @see [资产负债表文档](https://tushare.pro/document/2?doc_id=36)
     */
    public suspend fun getBalanceSheet(params: BalanceSheetParams): List<BalanceSheetResult>

    /**
     * 获取现金流量表数据
     * 
     * 调用TuShare API: `cashflow`
     * 
     * **权限要求**: 2000积分以上用户可调用，5000积分以上可使用VIP接口
     * **数据限制**: 单次最大提取1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司现金流量表数据，支持历史数据查询
     * 
     * @param params 现金流量表查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     *   - `report_type`: 报告类型（可选）
     *   - `comp_type`: 公司类型（可选）
     * 
     * @return 返回现金流量表数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `f_ann_date`: 实际公告日期
     *   - `end_date`: 报告期
     *   - `net_profit`: 净利润
     *   - `finan_exp`: 财务费用
     *   - `c_fr_sale_sg`: 销售商品、提供劳务收到的现金
     *   - `recp_tax_rends`: 收到的税费返还
     *   - `n_depos_incr_fi`: 客户存款和同业存放款项净增加额
     *   - `n_incr_loans_cb`: 向中央银行借款净增加额
     *   - `n_inc_borr_oth_fi`: 向其他金融机构拆入资金净增加额
     * 
     * @see [现金流量表文档](https://tushare.pro/document/2?doc_id=44)
     */
    public suspend fun getCashflow(params: CashflowParams): List<CashflowResult>

    /**
     * 获取业绩预告数据
     * 
     * 调用TuShare API: `forecast`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大2000条数据，可根据日期参数循环获取
     * **数据说明**: 获取业绩预告数据，包括预告类型、预告摘要等
     * 
     * @param params 业绩预告查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     * 
     * @return 返回业绩预告数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `type`: 业绩预告类型（预增/预减/扭亏/首亏等）
     *   - `p_change_min`: 预告净利润变动幅度下限（%）
     *   - `p_change_max`: 预告净利润变动幅度上限（%）
     *   - `net_profit_min`: 预告净利润下限（万元）
     *   - `net_profit_max`: 预告净利润上限（万元）
     *   - `last_parent_net`: 上年同期归属母公司净利润
     *   - `first_ann_date`: 首次公告日
     *   - `summary`: 业绩预告摘要
     * 
     * @see [业绩预告文档](https://tushare.pro/document/2?doc_id=45)
     */
    public suspend fun getForecast(params: ForecastParams): List<ForecastResult>

    /**
     * 获取业绩快报数据
     * 
     * 调用TuShare API: `express`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司业绩快报，数据相对于年报、半年报等更及时
     * 
     * @param params 业绩快报查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     * 
     * @return 返回业绩快报数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `revenue`: 营业收入（万元）
     *   - `operate_profit`: 营业利润（万元）
     *   - `total_profit`: 利润总额（万元）
     *   - `n_income`: 净利润（万元）
     *   - `total_assets`: 总资产（万元）
     *   - `total_hldr_eqy_exc_min_int`: 股东权益合计（不含少数股东权益）（万元）
     *   - `diluted_eps`: 每股收益（摊薄）（元）
     *   - `diluted_roe`: 净资产收益率（摊薄）（%）
     *   - `yoy_net_profit`: 去年同期修正后净利润
     *   - `bps`: 每股净资产
     *   - `yoy_sales`: 同比增长率:营业收入
     *   - `yoy_op`: 同比增长率:营业利润
     *   - `yoy_tp`: 同比增长率:利润总额
     *   - `yoy_dedu_np`: 同比增长率:归属母公司股东的净利润
     *   - `yoy_eps`: 同比增长率:基本每股收益
     *   - `yoy_roe`: 同比增减:加权平均净资产收益率
     *   - `growth_assets`: 比年初增长率:总资产
     *   - `yoy_equity`: 比年初增长率:归属母公司的股东权益
     *   - `growth_bps`: 比年初增长率:归属于母公司股东的每股净资产
     *   - `or_last_year`: 去年同期营业收入
     *   - `op_last_year`: 去年同期营业利润
     *   - `tp_last_year`: 去年同期利润总额
     *   - `np_last_year`: 去年同期净利润
     *   - `eps_last_year`: 去年同期每股收益
     *   - `open_net_assets`: 期初净资产
     *   - `open_bps`: 期初每股净资产
     * 
     * @see [业绩快报文档](https://tushare.pro/document/2?doc_id=46)
     */
    public suspend fun getExpress(params: ExpressParams): List<ExpressResult>

    /**
     * 获取分红送股数据
     * 
     * 调用TuShare API: `dividend`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大1000条数据，可根据日期参数循环获取
     * **数据说明**: 分红送股是上市公司对股东的投资回报，获取历史分红送股信息
     * 
     * @param params 分红送股查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `record_date`: 股权登记日（可选，格式：YYYYMMDD）
     *   - `ex_date`: 除权除息日（可选，格式：YYYYMMDD）
     *   - `imp_ann_date`: 实施公告日（可选，格式：YYYYMMDD）
     * 
     * @return 返回分红送股数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `end_date`: 分红年度
     *   - `ann_date`: 公告日期
     *   - `div_proc`: 实施进度
     *   - `stk_div`: 每股送转
     *   - `stk_bo_rate`: 每股送股比例
     *   - `stk_co_rate`: 每股转增比例
     *   - `cash_div`: 每股分红（税后）
     *   - `cash_div_tax`: 每股分红（税前）
     *   - `record_date`: 股权登记日
     *   - `ex_date`: 除权除息日
     *   - `pay_date`: 派息日
     *   - `div_listdate`: 红股上市日
     *   - `imp_ann_date`: 实施公告日
     *   - `base_date`: 基准日
     *   - `base_share`: 基准股本（万）
     * 
     * @see [分红送股文档](https://tushare.pro/document/2?doc_id=103)
     */
    public suspend fun getDividend(params: DividendParams): List<DividendResult>

    /**
     * 获取财务指标数据
     * 
     * 调用TuShare API: `fina_indicator`
     * 
     * **权限要求**: 需2000积分以上，5000积分以上可使用VIP接口
     * **数据限制**: 单次最大1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司财务指标数据，为投资决策提供参考
     * 
     * @param params 财务指标查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 报告期开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 报告期结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     * 
     * @return 返回财务指标数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `eps`: 基本每股收益
     *   - `dt_eps`: 稀释每股收益
     *   - `total_revenue_ps`: 每股营业总收入
     *   - `revenue_ps`: 每股营业收入
     *   - `capital_rese_ps`: 每股资本公积
     *   - `surplus_rese_ps`: 每股盈余公积
     *   - `undist_profit_ps`: 每股未分配利润
     *   - `extra_item`: 非经常性损益
     *   - `profit_dedt`: 扣除非经常性损益后的净利润
     *   - `gross_margin`: 毛利
     *   - `current_ratio`: 流动比率
     *   - `quick_ratio`: 速动比率
     *   - `cash_ratio`: 保守速动比率
     *   - `invturn_days`: 存货周转天数
     *   - `arturn_days`: 应收账款周转天数
     *   - `inv_turn`: 存货周转率
     *   - `ar_turn`: 应收账款周转率
     *   - `ca_turn`: 流动资产周转率
     *   - `fa_turn`: 固定资产周转率
     *   - `assets_turn`: 总资产周转率
     *   - `op_income`: 经营活动净收益
     *   - `valuechange_income`: 价值变动净收益
     *   - `interst_income`: 利息费用
     *   - `daa`: 总资产及总资产回报率
     *   - `ebit`: 息税前利润
     *   - `ebitda`: 息税折旧摊销前利润
     *   - `fcff`: 企业自由现金流量
     *   - `fcfe`: 股权自由现金流量
     *   - `current_exint`: 无息流动负债
     *   - `noncurrent_exint`: 无息非流动负债
     *   - `interestdebt`: 带息债务
     *   - `netdebt`: 净债务
     *   - `tangible_asset`: 有形资产
     *   - `working_capital`: 营运资金
     *   - `networking_capital`: 营运流动资金
     *   - `invest_capital`: 全部投入资本
     *   - `retained_earnings`: 留存收益
     *   - `diluted2_eps`: 期末摊薄每股收益
     *   - `bps`: 每股净资产
     *   - `ocfps`: 每股经营活动产生的现金流量净额
     *   - `retainedps`: 每股留存收益
     *   - `cfps`: 每股现金流量净额
     *   - `ebit_ps`: 每股息税前利润
     *   - `fcff_ps`: 每股企业自由现金流量
     *   - `fcfe_ps`: 每股股东自由现金流量
     *   - `netprofit_margin`: 销售净利率
     *   - `grossprofit_margin`: 销售毛利率
     *   - `cogs_of_sales`: 销售成本率
     *   - `expense_of_sales`: 销售期间费用率
     *   - `profit_to_gr`: 净利润/营业总收入
     *   - `saleexp_to_gr`: 销售费用/营业总收入
     *   - `adminexp_of_gr`: 管理费用/营业总收入
     *   - `finaexp_of_gr`: 财务费用/营业总收入
     *   - `impai_ttm`: 资产减值损失/营业总收入
     *   - `gc_of_gr`: 营业总成本/营业总收入
     *   - `op_of_gr`: 营业利润/营业总收入
     *   - `ebit_of_gr`: 息税前利润/营业总收入
     *   - `roe`: 净资产收益率
     *   - `roe_waa`: 加权平均净资产收益率
     *   - `roe_dt`: 净资产收益率(扣除非经常损益)
     *   - `roa`: 总资产报酬率
     *   - `npta`: 总资产净利润
     *   - `roic`: 投入资本回报率
     *   - `roe_yearly`: 年化净资产收益率
     *   - `roa2_yearly`: 年化总资产报酬率
     *   - `roe_avg`: 平均净资产收益率(增发条件)
     *   - `opincome_of_ebt`: 经营活动净收益/利润总额
     *   - `investincome_of_ebt`: 价值变动净收益/利润总额
     *   - `n_op_profit_of_ebt`: 营业外收支净额/利润总额
     *   - `tax_to_ebt`: 所得税/利润总额
     *   - `dtprofit_to_profit`: 扣除非经常损益后的净利润/净利润
     *   - `salescash_to_or`: 销售商品提供劳务收到的现金/营业收入
     *   - `ocf_to_or`: 经营活动产生的现金流量净额/营业收入
     *   - `ocf_to_opincome`: 经营活动产生的现金流量净额/经营活动净收益
     *   - `capitalized_to_da`: 资本化支出/折旧和摊销
     *   - `debt_to_assets`: 资产负债率
     *   - `assets_to_eqt`: 权益乘数
     *   - `dp_assets_to_eqt`: 权益乘数(杜邦分析)
     *   - `ca_to_assets`: 流动资产/总资产
     *   - `nca_to_assets`: 非流动资产/总资产
     *   - `tbassets_to_totalassets`: 有形资产/总资产
     *   - `int_to_talcap`: 带息债务/全部投入资本
     *   - `eqt_to_talcapital`: 归属于母公司的股东权益/全部投入资本
     *   - `currentdebt_to_debt`: 流动负债/负债合计
     *   - `longdeb_to_debt`: 非流动负债/负债合计
     *   - `ocf_to_shortdebt`: 经营活动产生的现金流量净额/流动负债
     *   - `debt_to_eqt`: 产权比率
     *   - `eqt_to_debt`: 归属于母公司的股东权益/负债合计
     *   - `eqt_to_interestdebt`: 归属于母公司的股东权益/带息债务
     *   - `tangibleasset_to_debt`: 有形资产/负债合计
     *   - `tangasset_to_intdebt`: 有形资产/带息债务
     *   - `tangibleasset_to_netdebt`: 有形资产/净债务
     *   - `ocf_to_debt`: 经营活动产生的现金流量净额/负债合计
     *   - `ocf_to_interestdebt`: 经营活动产生的现金流量净额/带息债务
     *   - `ocf_to_netdebt`: 经营活动产生的现金流量净额/净债务
     *   - `ebit_to_interest`: 已获利息倍数(EBIT/利息费用)
     *   - `longdebt_to_workingcapital`: 长期债务与营运资金比率
     *   - `ebitda_to_debt`: 息税折旧摊销前利润/负债合计
     *   - `turn_days`: 营业周期
     *   - `roa_yearly`: 年化总资产净利率
     *   - `roa_dp`: 总资产净利率(杜邦分析)
     *   - `fixed_assets`: 固定资产合计
     *   - `profit_prefin_exp`: 扣除财务费用前营业利润
     *   - `non_op_profit`: 非营业利润
     *   - `op_to_ebt`: 营业利润／利润总额
     *   - `nop_to_ebt`: 非营业利润／利润总额
     *   - `ocf_to_profit`: 经营活动产生的现金流量净额／营业利润
     *   - `cash_to_liqdebt`: 货币资金／流动负债
     *   - `cash_to_liqdebt_withinterest`: 货币资金／带息流动负债
     *   - `op_to_liqdebt`: 营业利润／流动负债
     *   - `op_to_debt`: 营业利润／负债合计
     *   - `roic_yearly`: 年化投入资本回报率
     *   - `total_fa_trun`: 固定资产合计周转率
     *   - `profit_to_op`: 利润总额／营业收入
     *   - `q_opincome`: 经营活动单季度净收益
     *   - `q_investincome`: 价值变动单季度净收益
     *   - `q_dtprofit`: 扣除非经常损益后的单季度净利润
     *   - `q_eps`: 每股收益(单季度)
     *   - `q_netprofit_margin`: 销售净利率(单季度)
     *   - `q_gsprofit_margin`: 销售毛利率(单季度)
     *   - `q_exp_to_sales`: 销售期间费用率(单季度)
     *   - `q_profit_to_gr`: 净利润／营业总收入(单季度)
     *   - `q_saleexp_to_gr`: 销售费用／营业总收入 (单季度)
     *   - `q_adminexp_to_gr`: 管理费用／营业总收入 (单季度)
     *   - `q_finaexp_to_gr`: 财务费用／营业总收入 (单季度)
     *   - `q_impair_to_gr_ttm`: 资产减值损失／营业总收入(单季度)
     *   - `q_gc_to_gr`: 营业总成本／营业总收入 (单季度)
     *   - `q_op_to_gr`: 营业利润／营业总收入(单季度)
     *   - `q_roe`: 净资产收益率(单季度)
     *   - `q_dt_roe`: 净资产收益率(扣除非经常损益)(单季度)
     *   - `q_npta`: 总资产净利润(单季度)
     *   - `q_opincome_to_ebt`: 经营活动净收益／利润总额(单季度)
     *   - `q_investincome_to_ebt`: 价值变动净收益／利润总额(单季度)
     *   - `q_dtprofit_to_profit`: 扣除非经常损益后的净利润／净利润(单季度)
     *   - `q_salescash_to_or`: 销售商品提供劳务收到的现金／营业收入(单季度)
     *   - `q_ocf_to_sales`: 经营活动产生的现金流量净额／营业收入(单季度)
     *   - `q_ocf_to_or`: 经营活动产生的现金流量净额／经营活动净收益(单季度)
     *   - `basic_eps_yoy`: 基本每股收益同比增长率(%)
     *   - `dt_eps_yoy`: 稀释每股收益同比增长率(%)
     *   - `cfps_yoy`: 每股经营活动产生的现金流量净额同比增长率(%)
     *   - `op_yoy`: 营业利润同比增长率(%)
     *   - `ebt_yoy`: 利润总额同比增长率(%)
     *   - `netprofit_yoy`: 归属母公司股东的净利润同比增长率(%)
     *   - `dt_netprofit_yoy`: 归属母公司股东的净利润(扣除非经常损益)同比增长率(%)
     *   - `ocf_yoy`: 经营活动产生的现金流量净额同比增长率(%)
     *   - `roe_yoy`: 净资产收益率(摊薄)同比增长率(%)
     *   - `bps_yoy`: 每股净资产相对年初增长率(%)
     *   - `assets_yoy`: 资产总计相对年初增长率(%)
     *   - `eqt_yoy`: 归属母公司的股东权益相对年初增长率(%)
     *   - `tr_yoy`: 营业总收入同比增长率(%)
     *   - `or_yoy`: 营业收入同比增长率(%)
     *   - `q_gr_yoy`: 营业总收入同比增长率(%)(单季度)
     *   - `q_gr_qoq`: 营业总收入环比增长率(%)(单季度)
     *   - `q_sales_yoy`: 营业收入同比增长率(%)(单季度)
     *   - `q_sales_qoq`: 营业收入环比增长率(%)(单季度)
     *   - `q_op_yoy`: 营业利润同比增长率(%)(单季度)
     *   - `q_op_qoq`: 营业利润环比增长率(%)(单季度)
     *   - `q_profit_yoy`: 净利润同比增长率(%)(单季度)
     *   - `q_profit_qoq`: 净利润环比增长率(%)(单季度)
     *   - `q_netprofit_yoy`: 归属母公司股东的净利润同比增长率(%)(单季度)
     *   - `q_netprofit_qoq`: 归属母公司股东的净利润环比增长率(%)(单季度)
     *   - `equity_yoy`: 净资产同比增长率
     *   - `rd_exp`: 研发费用
     *   - `update_flag`: 更新标识
     * 
     * @see [财务指标数据文档](https://tushare.pro/document/2?doc_id=79)
     */
    public suspend fun getFinaIndicator(params: FinaIndicatorParams): List<FinaIndicatorResult>

    /**
     * 获取财务审计意见数据
     * 
     * 调用TuShare API: `fina_audit`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大1000条数据，可根据日期参数循环获取
     * **数据说明**: 获取上市公司定期报告审计意见数据
     * 
     * @param params 财务审计意见查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `period`: 报告期（可选）
     * 
     * @return 返回财务审计意见数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `audit_result`: 审计结果
     *   - `audit_fees`: 审计总费用（万元）
     *   - `audit_agency`: 会计事务所
     *   - `audit_sign`: 签字会计师
     * 
     * @see [财务审计意见文档](https://tushare.pro/document/2?doc_id=80)
     */
    public suspend fun getFinaAudit(params: FinaAuditParams): List<FinaAuditResult>

    /**
     * 获取上市公司主营业务构成数据
     * 
     * 调用TuShare API: `fina_mainbz`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大1000条数据，可根据日期参数循环获取
     * **数据说明**: 获得上市公司主营业务构成，分地区和产品两种方式
     * 
     * @param params 主营业务构成查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `period`: 报告期（可选）
     *   - `type`: 类型（可选，P按产品/D按地区）
     *   - `start_date`: 报告期开始日期（可选）
     *   - `end_date`: 报告期结束日期（可选）
     * 
     * @return 返回主营业务构成数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `end_date`: 报告期
     *   - `bz_item`: 主营业务来源
     *   - `bz_sales`: 主营业务收入（元）
     *   - `bz_profit`: 主营业务利润（元）
     *   - `bz_cost`: 主营业务成本（元）
     *   - `curr_type`: 货币代码
     *   - `update_flag`: 是否更新
     * 
     * @see [主营业务构成文档](https://tushare.pro/document/2?doc_id=81)
     */
    public suspend fun getFinaMainbz(params: FinaMainbzParams): List<FinaMainbzResult>

    /**
     * 获取财报披露计划数据
     * 
     * 调用TuShare API: `disclosure_date`
     * 
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大3000条数据，可根据日期参数循环获取
     * **数据说明**: 获取财报披露计划日期
     * 
     * @param params 财报披露计划查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `end_date`: 财报周期（可选）
     *   - `pre_date`: 计划披露日期（可选）
     *   - `actual_date`: 实际披露日期（可选）
     * 
     * @return 返回财报披露计划数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 最新披露公告日
     *   - `end_date`: 报告期
     *   - `pre_date`: 预计披露日期
     *   - `actual_date`: 实际披露日期
     *   - `modify_date`: 披露日期修正次数
     * 
     * @see [财报披露计划文档](https://tushare.pro/document/2?doc_id=162)
     */
    public suspend fun getDisclosureDate(params: DisclosureDateParams): List<DisclosureDateResult>
}
