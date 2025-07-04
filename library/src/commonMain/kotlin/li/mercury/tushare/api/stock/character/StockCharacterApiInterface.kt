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
package li.mercury.tushare.api.stock.character

import li.mercury.tushare.api.stock.character.models.BrokerRecommendParams
import li.mercury.tushare.api.stock.character.models.BrokerRecommendResult
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailParams
import li.mercury.tushare.api.stock.character.models.CcassHoldDetailResult
import li.mercury.tushare.api.stock.character.models.CcassHoldParams
import li.mercury.tushare.api.stock.character.models.CcassHoldResult
import li.mercury.tushare.api.stock.character.models.CyqChipsParams
import li.mercury.tushare.api.stock.character.models.CyqChipsResult
import li.mercury.tushare.api.stock.character.models.CyqPerfParams
import li.mercury.tushare.api.stock.character.models.CyqPerfResult
import li.mercury.tushare.api.stock.character.models.HkHoldParams
import li.mercury.tushare.api.stock.character.models.HkHoldResult
import li.mercury.tushare.api.stock.character.models.ReportRcParams
import li.mercury.tushare.api.stock.character.models.ReportRcResult
import li.mercury.tushare.api.stock.character.models.StkAuctionCParams
import li.mercury.tushare.api.stock.character.models.StkAuctionCResult
import li.mercury.tushare.api.stock.character.models.StkAuctionOParams
import li.mercury.tushare.api.stock.character.models.StkAuctionOResult
import li.mercury.tushare.api.stock.character.models.StkFactorParams
import li.mercury.tushare.api.stock.character.models.StkFactorProParams
import li.mercury.tushare.api.stock.character.models.StkFactorProResult
import li.mercury.tushare.api.stock.character.models.StkFactorResult
import li.mercury.tushare.api.stock.character.models.StkNineturnParams
import li.mercury.tushare.api.stock.character.models.StkNineturnResult
import li.mercury.tushare.api.stock.character.models.StkSurvParams
import li.mercury.tushare.api.stock.character.models.StkSurvResult

/**
 * 股票特色数据相关API接口
 *
 * 提供对股票特色数据的访问，包括卖方研报分析、筹码分布、技术指标因子、
 * 港股通持股、集合竞价、九转指标、机构调研、券商荐股等多维度特色数据
 */
public interface StockCharacterApiInterface {
    /**
     * 获取卖方盈利预测数据
     *
     * 调用TuShare API: `report_rc`
     *
     * **权限要求**:
     * - 120积分可试用，每天10次请求
     * - 8000积分以上用户可每天请求100000次
     * - 10000积分以上用户无总量限制
     *
     * **数据限制**: 单次最大提取3000条数据，可通过分页和循环请求获取更多数据
     * **数据说明**: 获取券商（卖方）研报的盈利预测数据，数据从2010年开始，每晚19:00~22:00更新当日数据
     *
     * @param params 卖方盈利预测数据查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `report_date`: 研报日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 研报开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 研报结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回卖方盈利预测数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `report_date`: 研报日期
     *   - `report_title`: 报告标题
     *   - `report_type`: 报告类型
     *   - `classify`: 报告分类
     *   - `org_name`: 机构名称
     *   - `author_name`: 作者
     *   - `quarter`: 预测报告期
     *   - `op_rt`: 预测营业收入（万元）
     *   - `op_pr`: 预测营业利润（万元）
     *   - `tp`: 预测利润总额（万元）
     *   - `np`: 预测净利润（万元）
     *   - `eps`: 预测每股收益（元）
     *   - `pe`: 预测市盈率
     *   - `rd`: 预测股息率
     *   - `roe`: 预测净资产收益率
     *   - `ev_ebitda`: 预测EV/EBITDA
     *   - `rating`: 卖方评级
     *   - `max_price`: 预测最高目标价
     *   - `min_price`: 预测最低目标价
     *   - `imp_dg`: 机构关注度
     *   - `create_time`: TS数据更新时间
     *
     * @see [卖方盈利预测数据文档](readme/沪深股票/特色数据/卖方盈利预测数据.md)
     */
    public suspend fun getReportRc(params: ReportRcParams): List<ReportRcResult>

    /**
     * 获取每日筹码及胜率数据
     *
     * 调用TuShare API: `cyq_perf`
     *
     * **权限要求**:
     * - 120积分可试用（查看数据）
     * - 5000积分每天可请求20000次
     * - 10000积分每天可请求200000次
     * - 15000积分以上用户不限总量
     *
     * **数据限制**: 单次最大提取5000条数据，可通过分页和循环请求获取更多数据
     * **数据说明**: 获取A股每日筹码平均成本和胜率数据，数据从2018年开始，每天17:00~18:00更新当日数据
     *
     * @param params 每日筹码及胜率查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回每日筹码及胜率数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `his_low`: 历史最低价
     *   - `his_high`: 历史最高价
     *   - `cost_5pct`: 5分位成本
     *   - `cost_15pct`: 15分位成本
     *   - `cost_50pct`: 50分位成本
     *   - `cost_85pct`: 85分位成本
     *   - `cost_95pct`: 95分位成本
     *   - `weight_avg`: 加权平均成本
     *   - `winner_rate`: 胜率
     *
     * @see [每日筹码及胜率文档](readme/沪深股票/特色数据/每日筹码及胜率.md)
     */
    public suspend fun getCyqPerf(params: CyqPerfParams): List<CyqPerfResult>

    /**
     * 获取每日筹码分布数据
     *
     * 调用TuShare API: `cyq_chips`
     *
     * **权限要求**:
     * - 120积分可试用（查看数据）
     * - 5000积分每天可请求20000次
     * - 10000积分每天可请求200000次
     * - 15000积分以上用户不限总量
     *
     * **数据限制**: 单次最大提取2000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取A股每日筹码分布数据，包括不同价格的筹码占比，数据从2018年开始，每天17:00~18:00更新当日数据
     *
     * @param params 每日筹码分布查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回每日筹码分布数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `price`: 成本价格
     *   - `percent`: 价格占比（%）
     *
     * @see [每日筹码分布文档](readme/沪深股票/特色数据/每日筹码分布.md)
     */
    public suspend fun getCyqChips(params: CyqChipsParams): List<CyqChipsResult>

    /**
     * 获取股票技术因子数据
     *
     * 调用TuShare API: `stk_factor`
     *
     * **权限要求**:
     * - 5000积分每分钟可请求100次
     * - 8000积分以上用户每分钟可请求500次
     *
     * **数据限制**: 单次最大提取10000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取A股每日技术面因子数据，包括MACD、KDJ、RSI、BOLL、CCI等技术指标，数据覆盖全历史，每天更新
     *
     * **注意事项**:
     * - 本接口的前复权行情是从最新一个交易日开始往前复权，与行情软件一致
     * - 所有技术指标均基于前复权价格计算
     *
     * @param params 股票技术因子查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股票技术因子数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `close`: 收盘价
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `pre_close`: 昨收价
     *   - `change`: 涨跌额
     *   - `pct_change`: 涨跌幅
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *   - `adj_factor`: 复权因子
     *   - `open_hfq`: 开盘价后复权
     *   - `open_qfq`: 开盘价前复权
     *   - `close_hfq`: 收盘价后复权
     *   - `close_qfq`: 收盘价前复权
     *   - `high_hfq`: 最高价后复权
     *   - `high_qfq`: 最高价前复权
     *   - `low_hfq`: 最低价后复权
     *   - `low_qfq`: 最低价前复权
     *   - `pre_close_hfq`: 昨收价后复权
     *   - `pre_close_qfq`: 昨收价前复权
     *   - `macd_dif`: MACD_DIF（基于前复权价格计算）
     *   - `macd_dea`: MACD_DEA
     *   - `macd`: MACD
     *   - `kdj_k`: KDJ_K
     *   - `kdj_d`: KDJ_D
     *   - `kdj_j`: KDJ_J
     *   - `rsi_6`: RSI_6
     *   - `rsi_12`: RSI_12
     *   - `rsi_24`: RSI_24
     *   - `boll_upper`: BOLL_UPPER
     *   - `boll_mid`: BOLL_MID
     *   - `boll_lower`: BOLL_LOWER
     *   - `cci`: CCI
     *
     * @see [股票技术因子文档](readme/沪深股票/特色数据/股票技术因子（量化因子）.md)
     */
    public suspend fun getStkFactor(params: StkFactorParams): List<StkFactorResult>

    /**
     * 获取股票技术面因子（专业版）
     *
     * 调用TuShare API: `stk_factor_pro`
     *
     * **权限要求**:
     * - 5000积分每分钟可请求30次
     * - 8000积分以上用户每分钟可请求500次
     *
     * **数据限制**: 单次最大提取10000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取A股每日技术面因子数据，包括KDJ、MACD、RSI、BOLL、CCI、均线、换手率、市盈率等多种技术指标，数据覆盖全历史，每天更新
     *
     * **注意事项**:
     * - 输出参数_bfq表示不复权，_qfq表示前复权，_hfq表示后复权
     * - 所有技术指标均基于前复权价格计算，除非特别说明
     *
     * @param params 股票技术面因子查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股票技术面因子数据列表，包含多种技术指标和市场数据
     *
     * @see [股票技术面因子专业版文档](readme/沪深股票/特色数据/股票技术面因子(专业版).md)
     */
    public suspend fun getStkFactorPro(params: StkFactorProParams): List<StkFactorProResult>

    /**
     * 获取中央结算系统持股汇总数据
     *
     * 调用TuShare API: `ccass_hold`
     *
     * **权限要求**:
     * - 120积分可以试用看数据
     * - 5000积分每分钟可以请求300次
     * - 8000积分以上可以请求500次每分钟
     *
     * **数据限制**: 单次最大5000条数据，可循环或分页提供全部
     * **数据说明**: 获取中央结算系统持股汇总数据，覆盖全部历史数据，根据交易所披露时间，当日数据在下一交易日早上9点前完成入库
     *
     * @param params 中央结算系统持股汇总查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 605009.SH）
     *   - `hk_code`: 港交所代码（可选，如 95009）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回中央结算系统持股汇总数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代号
     *   - `name`: 股票名称
     *   - `shareholding`: 于中央结算系统的持股量（股）
     *   - `hold_nums`: 参与者数目（个）
     *   - `hold_ratio`: 占于上交所上市及交易的A股总数的百分比（%）
     *
     * @see [中央结算系统持股汇总文档](readme/沪深股票/特色数据/中央结算系统持股汇总.md)
     */
    public suspend fun getCcassHold(params: CcassHoldParams): List<CcassHoldResult>

    /**
     * 获取中央结算系统持股明细数据
     *
     * 调用TuShare API: `ccass_hold_detail`
     *
     * **权限要求**: 用户积8000积分可调取，每分钟可以请求300次
     *
     * **数据限制**: 单次最大返回6000条数据，可以循环或分页提取
     * **数据说明**: 获取中央结算系统机构席位持股明细，数据覆盖全历史，根据交易所披露时间，当日数据在下一交易日早上9点前完成
     *
     * @param params 中央结算系统持股明细查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，如 605009.SH）
     *   - `hk_code`: 港交所代码（可选，如 95009）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回中央结算系统持股明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代号
     *   - `name`: 股票名称
     *   - `col_participant_id`: 参与者编号
     *   - `col_participant_name`: 机构名称
     *   - `col_shareholding`: 持股量（股）
     *   - `col_shareholding_percent`: 占已发行股份/权证/单位百分比（%）
     *
     * @see [中央结算系统持股明细文档](readme/沪深股票/特色数据/中央结算系统持股明细.md)
     */
    public suspend fun getCcassHoldDetail(params: CcassHoldDetailParams): List<CcassHoldDetailResult>

    /**
     * 获取沪深港股通持股明细
     *
     * 调用TuShare API: `hk_hold`
     *
     * **权限要求**:
     * - 120积分可调取试用
     * - 2000积分可正常使用，单位分钟有流控，积分越高流量越大
     *
     * **数据限制**: 单次最多提取3800条记录，可循环调取，总量不限制
     * **数据说明**: 获取沪深港股通持股明细，数据来源港交所
     *
     * **注意事项**: 交易所于2024年8月20日开始停止发布北向资金数据
     *
     * @param params 沪深港股通持股明细查询参数，包含以下字段：
     *   - `code`: 交易所代码（可选）
     *   - `ts_code`: TS股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange`: 类型（可选，SH 沪股通（北向）、SZ 深股通（北向）、HK 港股通（南向持股））
     *
     * @return 返回沪深港股通持股明细数据列表，包含以下字段：
     *   - `code`: 原始代码
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS代码
     *   - `name`: 股票名称
     *   - `vol`: 持股数量（股）
     *   - `ratio`: 持股占比（%），占已发行股份百分比
     *   - `exchange`: 类型（SH 沪股通、SZ 深股通、HK 港股通）
     *
     * @see [沪深港股通持股明细文档](readme/沪深股票/特色数据/沪深港股通持股明细.md)
     */
    public suspend fun getHkHold(params: HkHoldParams): List<HkHoldResult>

    /**
     * 获取股票开盘集合竞价数据
     *
     * 调用TuShare API: `stk_auction_o`
     *
     * **权限要求**: 开通了股票分钟权限后可获得本接口权限
     *
     * **数据限制**: 单次请求最大返回10000行数据，可根据日期循环
     * **数据说明**: 股票开盘9:30集合竞价数据，每天盘后更新
     *
     * @param params 股票开盘集合竞价查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股票开盘集合竞价数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `close`: 开盘集合竞价收盘价
     *   - `open`: 开盘集合竞价开盘价
     *   - `high`: 开盘集合竞价最高价
     *   - `low`: 开盘集合竞价最低价
     *   - `vol`: 开盘集合竞价成交量
     *   - `amount`: 开盘集合竞价成交额
     *   - `vwap`: 开盘集合竞价均价
     *
     * @see [股票开盘集合竞价数据文档](readme/沪深股票/特色数据/股票开盘集合竞价数据.md)
     */
    public suspend fun getStkAuctionO(params: StkAuctionOParams): List<StkAuctionOResult>

    /**
     * 获取股票收盘集合竞价数据
     *
     * 调用TuShare API: `stk_auction_c`
     *
     * **权限要求**: 开通了股票分钟权限后可获得本接口权限
     *
     * **数据限制**: 单次请求最大返回10000行数据，可根据日期循环
     * **数据说明**: 股票收盘15:00集合竞价数据，每天盘后更新
     *
     * @param params 股票收盘集合竞价查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股票收盘集合竞价数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `close`: 收盘集合竞价收盘价
     *   - `open`: 收盘集合竞价开盘价
     *   - `high`: 收盘集合竞价最高价
     *   - `low`: 收盘集合竞价最低价
     *   - `vol`: 收盘集合竞价成交量
     *   - `amount`: 收盘集合竞价成交额
     *   - `vwap`: 收盘集合竞价均价
     *
     * @see [股票收盘集合竞价数据文档](readme/沪深股票/特色数据/股票收盘集合竞价数据.md)
     */
    public suspend fun getStkAuctionC(params: StkAuctionCParams): List<StkAuctionCResult>

    /**
     * 获取神奇九转指标数据
     *
     * 调用TuShare API: `stk_nineturn`
     *
     * **权限要求**: 开通分钟权限直接可使用，或者联系管理员单独开通权限
     *
     * **数据限制**: 单次提取最大返回10000行数据，可通过股票代码和日期循环获取全部数据
     * **数据说明**: 神奇九转（又称"九转序列"）是一种基于技术分析的股票趋势反转指标，其思想来源于技术分析大师汤姆·迪马克的TD序列，
     * 通过识别股价在上涨或下跌过程中连续9天的特定走势，来判断股价的潜在反转点。日线级别配合60min的九转效果更好，数据从2023-01-01开始
     *
     * @param params 神奇九转指标查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYY-MM-DD HH:MM:SS）
     *   - `freq`: 频率（可选，日daily，分钟60min）
     *   - `start_date`: 开始时间（可选）
     *   - `end_date`: 结束时间（可选）
     *
     * @return 返回神奇九转指标数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `freq`: 频率（日daily，分钟60min）
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `vol`: 成交量
     *   - `amount`: 成交额
     *   - `up_count`: 上九转计数
     *   - `down_count`: 下九转计数
     *   - `nine_up_turn`: 是否上九转（+9表示上九转）
     *   - `nine_down_turn`: 是否下九转（-9表示下九转）
     *
     * @see [神奇九转指标文档](readme/沪深股票/特色数据/神奇九转指标.md)
     */
    public suspend fun getStkNineturn(params: StkNineturnParams): List<StkNineturnResult>

    /**
     * 获取机构调研表数据
     *
     * 调用TuShare API: `stk_surv`
     *
     * **权限要求**: 用户积5000积分可使用
     *
     * **数据限制**: 单次最大获取100条数据，可循环或分页提取
     * **数据说明**: 获取上市公司机构调研记录数据
     *
     * @param params 机构调研表查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 调研日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 调研开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 调研结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回机构调研表数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `surv_date`: 调研日期
     *   - `fund_visitors`: 机构参与人员
     *   - `rece_place`: 接待地点
     *   - `rece_mode`: 接待方式
     *   - `rece_org`: 接待的公司
     *   - `org_type`: 接待公司类型
     *   - `comp_rece`: 上市公司接待人员
     *   - `content`: 调研内容
     *
     * @see [机构调研表文档](readme/沪深股票/特色数据/机构调研表.md)
     */
    public suspend fun getStkSurv(params: StkSurvParams): List<StkSurvResult>

    /**
     * 获取券商每月荐股数据
     *
     * 调用TuShare API: `broker_recommend`
     *
     * **权限要求**: 积分达到2000即可调用
     *
     * **数据限制**: 单次最大1000行数据，可循环提取
     * **数据说明**: 获取券商月度金股，一般1日~3日内更新当月数据
     *
     * @param params 券商每月荐股查询参数，包含以下字段：
     *   - `month`: 月度（必填，格式：YYYYMM）
     *
     * @return 返回券商每月荐股数据列表，包含以下字段：
     *   - `month`: 月度
     *   - `broker`: 券商
     *   - `ts_code`: 股票代码
     *   - `name`: 股票简称
     *
     * @see [券商每月荐股文档](readme/沪深股票/特色数据/券商每月荐股.md)
     */
    public suspend fun getBrokerRecommend(params: BrokerRecommendParams): List<BrokerRecommendResult>
}
