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
package li.mercury.tushare.api.stock.flow

import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowResult
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsResult

/**
 * 股票资金流向相关API接口
 *
 * 提供个股、板块、大盘资金流向数据的访问，包括主力资金流向、大单中单小单分析、
 * 沪深港通资金流向等数据，支持多种数据源（同花顺、东方财富等）
 */
public interface StockFlowApiInterface {
    /**
     * 获取个股资金流向数据
     *
     * 调用TuShare API: `moneyflow`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次最大提取6000行记录，总量不限制
     * **数据说明**: 获取沪深A股票资金流向数据，分析大单小单成交情况，用于判别资金动向
     * **数据起始**: 2010年开始
     *
     * **资金分类规则**:
     * - 小单：5万以下
     * - 中单：5万～20万
     * - 大单：20万～100万
     * - 特大单：成交额 >= 100万
     *
     * @param params 个股资金流向查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，股票和时间参数至少输入一个）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回个股资金流向数据列表，包含以下字段：
     *   - `ts_code`: TS代码
     *   - `trade_date`: 交易日期
     *   - `buy_sm_vol`: 小单买入量（手）
     *   - `buy_sm_amount`: 小单买入金额（万元）
     *   - `sell_sm_vol`: 小单卖出量（手）
     *   - `sell_sm_amount`: 小单卖出金额（万元）
     *   - `buy_md_vol`: 中单买入量（手）
     *   - `buy_md_amount`: 中单买入金额（万元）
     *   - `sell_md_vol`: 中单卖出量（手）
     *   - `sell_md_amount`: 中单卖出金额（万元）
     *   - `buy_lg_vol`: 大单买入量（手）
     *   - `buy_lg_amount`: 大单买入金额（万元）
     *   - `sell_lg_vol`: 大单卖出量（手）
     *   - `sell_lg_amount`: 大单卖出金额（万元）
     *   - `buy_elg_vol`: 特大单买入量（手）
     *   - `buy_elg_amount`: 特大单买入金额（万元）
     *   - `sell_elg_vol`: 特大单卖出量（手）
     *   - `sell_elg_amount`: 特大单卖出金额（万元）
     *   - `net_mf_vol`: 净流入量（手）
     *   - `net_mf_amount`: 净流入额（万元）
     *
     * @see [个股资金流向文档](readme/沪深股票/资金流向数据/个股资金流向.md)
     */
    public suspend fun getMoneyflow(params: MoneyflowParams): List<MoneyflowResult>

    /**
     * 获取同花顺个股资金流向数据
     *
     * 调用TuShare API: `moneyflow_ths`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大6000条记录，可根据日期或股票代码循环提取
     * **数据说明**: 获取同花顺个股资金流向数据，每日盘后更新
     *
     * @param params 同花顺个股资金流向查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回同花顺个股资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `pct_change`: 涨跌幅
     *   - `latest`: 最新价
     *   - `net_amount`: 资金净流入（万元）
     *   - `net_d5_amount`: 5日主力净额（万元）
     *   - `buy_lg_amount`: 今日大单净流入额（万元）
     *   - `buy_lg_amount_rate`: 今日大单净流入占比（%）
     *   - `buy_md_amount`: 今日中单净流入额（万元）
     *   - `buy_md_amount_rate`: 今日中单净流入占比（%）
     *   - `buy_sm_amount`: 今日小单净流入额（万元）
     *   - `buy_sm_amount_rate`: 今日小单净流入占比（%）
     *
     * @see [个股资金流向（THS）文档](readme/沪深股票/资金流向数据/个股资金流向（THS）.md)
     */
    public suspend fun getMoneyflowThs(params: MoneyflowThsParams): List<MoneyflowThsResult>

    /**
     * 获取东方财富个股资金流向数据
     *
     * 调用TuShare API: `moneyflow_dc`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取6000条数据，可根据日期或股票代码循环提取
     * **数据说明**: 获取东方财富个股资金流向数据，每日盘后更新
     * **数据起始**: 2023年9月11日开始
     *
     * @param params 东方财富个股资金流向查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富个股资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `pct_change`: 涨跌幅
     *   - `close`: 最新价
     *   - `net_amount`: 今日主力净流入额（万元）
     *   - `net_amount_rate`: 今日主力净流入净占比（%）
     *   - `buy_elg_amount`: 今日超大单净流入额（万元）
     *   - `buy_elg_amount_rate`: 今日超大单净流入占比（%）
     *   - `buy_lg_amount`: 今日大单净流入额（万元）
     *   - `buy_lg_amount_rate`: 今日大单净流入占比（%）
     *   - `buy_md_amount`: 今日中单净流入额（万元）
     *   - `buy_md_amount_rate`: 今日中单净流入占比（%）
     *   - `buy_sm_amount`: 今日小单净流入额（万元）
     *   - `buy_sm_amount_rate`: 今日小单净流入占比（%）
     *
     * @see [个股资金流向（DC）文档](readme/沪深股票/资金流向数据/个股资金流向（DC）.md)
     */
    public suspend fun getMoneyflowDc(params: MoneyflowDcParams): List<MoneyflowDcResult>

    /**
     * 获取东方财富大盘资金流向数据
     *
     * 调用TuShare API: `moneyflow_mkt_dc`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取6000条数据，可根据日期循环提取
     * **数据说明**: 获取东方财富大盘资金流向数据，每日盘后更新
     *
     * @param params 东方财富大盘资金流向查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富大盘资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `net_amount`: 今日主力净流入额（万元）
     *   - `net_amount_rate`: 今日主力净流入净占比（%）
     *   - `buy_elg_amount`: 今日超大单净流入额（万元）
     *   - `buy_elg_amount_rate`: 今日超大单净流入占比（%）
     *   - `buy_lg_amount`: 今日大单净流入额（万元）
     *   - `buy_lg_amount_rate`: 今日大单净流入占比（%）
     *   - `buy_md_amount`: 今日中单净流入额（万元）
     *   - `buy_md_amount_rate`: 今日中单净流入占比（%）
     *   - `buy_sm_amount`: 今日小单净流入额（万元）
     *   - `buy_sm_amount_rate`: 今日小单净流入占比（%）
     *
     * @see [大盘资金流向（DC）文档](readme/沪深股票/资金流向数据/大盘资金流向（DC）.md)
     */
    public suspend fun getMoneyflowMktDc(params: MoneyflowMktDcParams): List<MoneyflowMktDcResult>

    /**
     * 获取东方财富板块资金流向数据
     *
     * 调用TuShare API: `moneyflow_ind_dc`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取6000条数据，可根据日期或板块代码循环提取
     * **数据说明**: 获取东方财富板块资金流向数据，每日盘后更新
     *
     * @param params 东方财富板块资金流向查询参数，包含以下字段：
     *   - `ts_code`: 板块代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富板块资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 板块代码
     *   - `name`: 板块名称
     *   - `pct_change`: 涨跌幅
     *   - `net_amount`: 今日主力净流入额（万元）
     *   - `net_amount_rate`: 今日主力净流入净占比（%）
     *   - `buy_elg_amount`: 今日超大单净流入额（万元）
     *   - `buy_elg_amount_rate`: 今日超大单净流入占比（%）
     *   - `buy_lg_amount`: 今日大单净流入额（万元）
     *   - `buy_lg_amount_rate`: 今日大单净流入占比（%）
     *   - `buy_md_amount`: 今日中单净流入额（万元）
     *   - `buy_md_amount_rate`: 今日中单净流入占比（%）
     *   - `buy_sm_amount`: 今日小单净流入额（万元）
     *   - `buy_sm_amount_rate`: 今日小单净流入占比（%）
     *
     * @see [板块资金流向（DC）文档](readme/沪深股票/资金流向数据/板块资金流向（DC）.md)
     */
    public suspend fun getMoneyflowIndDc(params: MoneyflowIndDcParams): List<MoneyflowIndDcResult>

    /**
     * 获取同花顺行业板块资金流向数据
     *
     * 调用TuShare API: `moneyflow_ind_ths`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取6000条数据，可根据日期或板块代码循环提取
     * **数据说明**: 获取同花顺行业板块资金流向数据，每日盘后更新
     *
     * @param params 同花顺行业板块资金流向查询参数，包含以下字段：
     *   - `ts_code`: 板块代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回同花顺行业板块资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 板块代码
     *   - `name`: 板块名称
     *   - `pct_change`: 涨跌幅
     *   - `net_amount`: 今日主力净流入额（万元）
     *   - `net_amount_rate`: 今日主力净流入净占比（%）
     *   - `buy_lg_amount`: 今日大单净流入额（万元）
     *   - `buy_lg_amount_rate`: 今日大单净流入占比（%）
     *   - `buy_md_amount`: 今日中单净流入额（万元）
     *   - `buy_md_amount_rate`: 今日中单净流入占比（%）
     *   - `buy_sm_amount`: 今日小单净流入额（万元）
     *   - `buy_sm_amount_rate`: 今日小单净流入占比（%）
     *
     * @see [板块资金流向（THS）文档](readme/沪深股票/资金流向数据/板块资金流向（THS）.md)
     */
    public suspend fun getMoneyflowIndThs(params: MoneyflowIndThsParams): List<MoneyflowIndThsResult>

    /**
     * 获取沪深港通资金流向数据
     *
     * 调用TuShare API: `moneyflow_hsgt`
     *
     * **权限要求**: 2000积分以上用户可调用，5000积分每分钟可提取500次
     * **数据限制**: 每次最多返回300条记录，总量不限制
     * **数据说明**: 获取沪股通、深股通、港股通每日资金流向数据
     * **数据更新**: 每天18~20点之间完成当日更新
     *
     * @param params 沪深港通资金流向查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD，与start_date二选一）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD，与trade_date二选一）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回沪深港通资金流向数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ggt_ss`: 港股通（上海）
     *   - `ggt_sz`: 港股通（深圳）
     *   - `hgt`: 沪股通（百万元）
     *   - `sgt`: 深股通（百万元）
     *   - `north_money`: 北向资金（百万元）
     *   - `south_money`: 南向资金（百万元）
     *
     * @see [沪深港通资金流向文档](readme/沪深股票/资金流向数据/沪深港通资金流向.md)
     */
    public suspend fun getMoneyflowHsgt(params: MoneyflowHsgtParams): List<MoneyflowHsgtResult>
}
