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
package li.mercury.tushare.api.stock.market

import li.mercury.tushare.api.stock.market.models.AdjFactorParams
import li.mercury.tushare.api.stock.market.models.AdjFactorResult
import li.mercury.tushare.api.stock.market.models.BakDailyParams
import li.mercury.tushare.api.stock.market.models.BakDailyResult
import li.mercury.tushare.api.stock.market.models.DailyBasicParams
import li.mercury.tushare.api.stock.market.models.DailyBasicResult
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.api.stock.market.models.DailyResult
import li.mercury.tushare.api.stock.market.models.GgtDailyParams
import li.mercury.tushare.api.stock.market.models.GgtDailyResult
import li.mercury.tushare.api.stock.market.models.GgtMonthlyParams
import li.mercury.tushare.api.stock.market.models.GgtMonthlyResult
import li.mercury.tushare.api.stock.market.models.GgtTop10Params
import li.mercury.tushare.api.stock.market.models.GgtTop10Result
import li.mercury.tushare.api.stock.market.models.HsgtTop10Params
import li.mercury.tushare.api.stock.market.models.HsgtTop10Result
import li.mercury.tushare.api.stock.market.models.MinsParams
import li.mercury.tushare.api.stock.market.models.MinsResult
import li.mercury.tushare.api.stock.market.models.MonthlyParams
import li.mercury.tushare.api.stock.market.models.MonthlyResult
import li.mercury.tushare.api.stock.market.models.StkLimitParams
import li.mercury.tushare.api.stock.market.models.StkLimitResult
import li.mercury.tushare.api.stock.market.models.SuspendDParams
import li.mercury.tushare.api.stock.market.models.SuspendDResult
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyParams
import li.mercury.tushare.api.stock.market.models.WeeklyMonthlyResult
import li.mercury.tushare.api.stock.market.models.WeeklyParams
import li.mercury.tushare.api.stock.market.models.WeeklyResult

/**
 * 股票行情数据相关API接口
 *
 * 提供股票日线、分钟线、周月线行情数据，复权因子、涨跌停信息、停复牌信息，
 * 以及沪深港股通相关交易数据的访问接口
 */
public interface StockMarketApiInterface {
    /**
     * 获取股票日线行情数据
     *
     * 调用TuShare API: `daily`
     *
     * **权限要求**: 120积分，每分钟最多调取500次
     * **数据限制**: 每次最多返回6000条数据，相当于单次可提取23年历史数据
     * **数据说明**: 提供未复权行情数据，停牌期间不提供数据，交易日每天15:00～16:00之间入库
     *
     * @param params 日线行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选，支持多个股票同时提取，逗号分隔）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回日线行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `pre_close`: 昨收价（除权价，前复权）
     *   - `change`: 涨跌额
     *   - `pct_chg`: 涨跌幅（基于除权后的昨收计算）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *
     * @see [股票日线行情文档](https://tushare.pro/document/2?doc_id=27)
     */
    public suspend fun getDaily(params: DailyParams): List<DailyResult>

    /**
     * 获取股票分钟行情数据
     *
     * 调用TuShare API: `stk_mins`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000行记录，可循环提取
     * **数据说明**: 获取股票分钟级别的行情数据，包括1分钟、5分钟等不同频次
     *
     * @param params 分钟行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `freq`: 数据频度（可选，1min/5min/15min/30min/60min）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回分钟行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_time`: 交易时间
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *
     * @see [股票分钟行情文档](https://tushare.pro/document/2?doc_id=109)
     */
    public suspend fun getMins(params: MinsParams): List<MinsResult>

    /**
     * 获取A股周线行情数据
     *
     * 调用TuShare API: `weekly`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 每次最多提取4000条，总量不限制，用户需要循环获取
     * **数据说明**: 获取A股周线行情数据，未复权数据
     *
     * @param params 周线行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回周线行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期（周五日期，如遇假期则为最后一个交易日）
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `pre_close`: 昨收价
     *   - `change`: 涨跌额
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *
     * @see [股票周线行情文档](https://tushare.pro/document/2?doc_id=144)
     */
    public suspend fun getWeekly(params: WeeklyParams): List<WeeklyResult>

    /**
     * 获取A股月线行情数据
     *
     * 调用TuShare API: `monthly`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 每次最多提取4000条，总量不限制，用户需要循环获取
     * **数据说明**: 获取A股月线行情数据，未复权数据
     *
     * @param params 月线行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回月线行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期（月末最后一个交易日）
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `pre_close`: 昨收价
     *   - `change`: 涨跌额
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *
     * @see [股票月线行情文档](https://tushare.pro/document/2?doc_id=145)
     */
    public suspend fun getMonthly(params: MonthlyParams): List<MonthlyResult>

    /**
     * 获取股票周/月线行情数据(每日更新)
     *
     * 调用TuShare API: `weekly_monthly`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000行记录
     * **数据说明**: 获取股票周月线行情，相比weekly和monthly接口，该接口每日更新，方便获取最新数据
     *
     * @param params 周月线行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `freq`: 数据频度（必填，W周线/M月线）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回周月线行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `freq`: 数据频度
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `close`: 收盘价
     *   - `pre_close`: 昨收价
     *   - `change`: 涨跌额
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *
     * @see [股票周月线行情文档](https://tushare.pro/document/2?doc_id=146)
     */
    public suspend fun getWeeklyMonthly(params: WeeklyMonthlyParams): List<WeeklyMonthlyResult>

    /**
     * 获取股票复权因子数据
     *
     * 调用TuShare API: `adj_factor`
     *
     * **权限要求**: 需2000积分以上，5000积分以上无限制
     * **数据限制**: 单次最大2000条，总量不限制，用户需要循环获取
     * **数据说明**: 获取股票复权因子，用于前复权和后复权计算
     *
     * @param params 复权因子查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回复权因子数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `adj_factor`: 复权因子
     *
     * @see [复权因子文档](https://tushare.pro/document/2?doc_id=28)
     */
    public suspend fun getAdjFactor(params: AdjFactorParams): List<AdjFactorResult>

    /**
     * 获取股票每日指标数据
     *
     * 调用TuShare API: `daily_basic`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取5000行记录
     * **数据说明**: 获取全部股票每日重要的基本面指标，可用于选股分析、报表等，每日15:00～17:00之间更新
     *
     * @param params 每日指标查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回每日指标数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `close`: 当日收盘价
     *   - `turnover_rate`: 换手率（%）
     *   - `turnover_rate_f`: 换手率（自由流通股）
     *   - `volume_ratio`: 量比
     *   - `pe`: 市盈率（总市值/净利润，亏损的PE为空）
     *   - `pe_ttm`: 市盈率（TTM，即滚动12个月）
     *   - `pb`: 市净率（总市值/净资产）
     *   - `ps`: 市销率
     *   - `ps_ttm`: 市销率（TTM）
     *   - `dv_ratio`: 股息率（%）
     *   - `dv_ttm`: 股息率（TTM）（%）
     *   - `total_share`: 总股本（万股）
     *   - `float_share`: 流通股本（万股）
     *   - `free_share`: 自由流通股本（万）
     *   - `total_mv`: 总市值（万元）
     *   - `circ_mv`: 流通市值（万元）
     *
     * @see [每日指标文档](https://tushare.pro/document/2?doc_id=32)
     */
    public suspend fun getDailyBasic(params: DailyBasicParams): List<DailyBasicResult>

    /**
     * 获取每日涨跌停价格数据
     *
     * 调用TuShare API: `stk_limit`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000行记录
     * **数据说明**: 获取全市场（包含A/B股和基金）每日涨跌停价格，包括涨停价、跌停价等
     *
     * @param params 涨跌停价格查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回涨跌停价格数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `pre_close`: 昨日收盘价
     *   - `up_limit`: 涨停价
     *   - `down_limit`: 跌停价
     *
     * @see [每日涨跌停价格文档](https://tushare.pro/document/2?doc_id=183)
     */
    public suspend fun getStkLimit(params: StkLimitParams): List<StkLimitResult>

    /**
     * 获取每日停复牌信息
     *
     * 调用TuShare API: `suspend_d`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000行记录
     * **数据说明**: 获取每日停牌股票信息
     *
     * @param params 停复牌信息查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回停复牌信息列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `suspend_type`: 停牌类型
     *   - `suspend_reason`: 停牌原因
     *
     * @see [每日停复牌信息文档](https://tushare.pro/document/2?doc_id=31)
     */
    public suspend fun getSuspendD(params: SuspendDParams): List<SuspendDResult>

    /**
     * 获取沪深股通十大成交股数据
     *
     * 调用TuShare API: `hsgt_top10`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取5000行记录
     * **数据说明**: 获取沪股通、深股通每日前十大成交详细数据
     *
     * @param params 沪深股通十大成交股查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `market_type`: 市场类型（可选，1沪股通/3深股通）
     *
     * @return 返回沪深股通十大成交股数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `close`: 收盘价
     *   - `change`: 涨跌额
     *   - `rank`: 资金流入排名
     *   - `market_type`: 市场类型（1沪股通/3深股通）
     *   - `amount`: 成交金额（万）
     *   - `net_amount`: 净成交金额（万）
     *   - `buy`: 买入金额（万）
     *   - `sell`: 卖出金额（万）
     *
     * @see [沪深股通十大成交股文档](https://tushare.pro/document/2?doc_id=48)
     */
    public suspend fun getHsgtTop10(params: HsgtTop10Params): List<HsgtTop10Result>

    /**
     * 获取港股通十大成交股数据
     *
     * 调用TuShare API: `ggt_top10`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取1000条记录
     * **数据说明**: 获取港股通每日成交数据，其中包括沪市、深市详细数据
     *
     * @param params 港股通十大成交股查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `market_type`: 市场类型（可选，2港股通（沪）/4港股通（深））
     *
     * @return 返回港股通十大成交股数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `close`: 收盘价
     *   - `change`: 涨跌额
     *   - `rank`: 资金流入排名
     *   - `market_type`: 市场类型（2沪港通/4深港通）
     *   - `amount`: 成交金额（万港元）
     *   - `net_amount`: 净成交金额（万港元）
     *   - `buy`: 买入金额（万港元）
     *   - `sell`: 卖出金额（万港元）
     *
     * @see [港股通十大成交股文档](https://tushare.pro/document/2?doc_id=49)
     */
    public suspend fun getGgtTop10(params: GgtTop10Params): List<GgtTop10Result>

    /**
     * 获取港股通每日成交统计
     *
     * 调用TuShare API: `ggt_daily`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000条记录
     * **数据说明**: 获取港股通每日成交信息，数据从2014年开始
     *
     * @param params 港股通每日成交统计查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回港股通每日成交统计数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ggt_ss`: 港股通（上海）
     *   - `ggt_sz`: 港股通（深圳）
     *   - `hk_hold`: 港资持股（万股）
     *   - `hk_buy`: 港资买入（万港元）
     *   - `hk_sell`: 港资卖出（万港元）
     *
     * @see [港股通每日成交统计文档](https://tushare.pro/document/2?doc_id=196)
     */
    public suspend fun getGgtDaily(params: GgtDailyParams): List<GgtDailyResult>

    /**
     * 获取港股通每月成交统计
     *
     * 调用TuShare API: `ggt_monthly`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取5000条记录
     * **数据说明**: 获取港股通每月成交信息汇总，数据从2014年开始
     *
     * @param params 港股通每月成交统计查询参数，包含以下字段：
     *   - `month`: 月份（可选，格式：YYYYMM）
     *   - `start_month`: 开始月份（可选，格式：YYYYMM）
     *   - `end_month`: 结束月份（可选，格式：YYYYMM）
     *
     * @return 返回港股通每月成交统计数据列表，包含以下字段：
     *   - `month`: 月份
     *   - `ggt_ss`: 港股通（上海）（亿港元）
     *   - `ggt_sz`: 港股通（深圳）（亿港元）
     *   - `ggt_total`: 港股通（合计）（亿港元）
     *
     * @see [港股通每月成交统计文档](https://tushare.pro/document/2?doc_id=197)
     */
    public suspend fun getGgtMonthly(params: GgtMonthlyParams): List<GgtMonthlyResult>

    /**
     * 获取备用行情数据
     *
     * 调用TuShare API: `bak_daily`
     *
     * **权限要求**: 需2000积分以上
     * **数据限制**: 单次最大提取8000行记录
     * **数据说明**: 备用行情，包含了前复权数据
     *
     * @param params 备用行情查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回备用行情数据列表，包含以下字段：
     *   - `ts_code`: 股票代码
     *   - `trade_date`: 交易日期
     *   - `name`: 股票名称
     *   - `pct_chg`: 涨跌幅
     *   - `close`: 收盘价
     *   - `change`: 涨跌额
     *   - `open`: 开盘价
     *   - `high`: 最高价
     *   - `low`: 最低价
     *   - `pre_close`: 昨收价（前复权）
     *   - `vol_ratio`: 量比
     *   - `turn_over`: 换手率（%）
     *   - `swing`: 振幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     *   - `selling`: 外盘（手）
     *   - `buying`: 内盘（手）
     *   - `total_share`: 总股本（万）
     *   - `float_share`: 流通股本（万）
     *   - `pe`: 市盈率
     *   - `industry`: 所属行业
     *   - `area`: 地域
     *   - `float_mv`: 流通市值
     *   - `total_mv`: 总市值
     *   - `avg_price`: 平均价
     *   - `strength`: 强弱度（%）
     *   - `activity`: 活跃度（%）
     *   - `avg_turnover`: 笔换手
     *   - `attack`: 攻击波（%）
     *   - `interval_3`: 近3月涨跌幅（%）
     *   - `interval_6`: 近6月涨跌幅（%）
     *
     * @see [备用行情文档](https://tushare.pro/document/2?doc_id=158)
     */
    public suspend fun getBakDaily(params: BakDailyParams): List<BakDailyResult>
}
