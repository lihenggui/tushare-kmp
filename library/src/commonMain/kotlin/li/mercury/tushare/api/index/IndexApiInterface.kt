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
package li.mercury.tushare.api.index

import li.mercury.tushare.api.index.models.CiDailyParams
import li.mercury.tushare.api.index.models.CiDailyResult
import li.mercury.tushare.api.index.models.DailyInfoParams
import li.mercury.tushare.api.index.models.DailyInfoResult
import li.mercury.tushare.api.index.models.IdxFactorProParams
import li.mercury.tushare.api.index.models.IdxFactorProResult
import li.mercury.tushare.api.index.models.IndexBasicParams
import li.mercury.tushare.api.index.models.IndexBasicResult
import li.mercury.tushare.api.index.models.IndexClassifyParams
import li.mercury.tushare.api.index.models.IndexClassifyResult
import li.mercury.tushare.api.index.models.IndexDailyBasicParams
import li.mercury.tushare.api.index.models.IndexDailyBasicResult
import li.mercury.tushare.api.index.models.IndexDailyParams
import li.mercury.tushare.api.index.models.IndexDailyResult
import li.mercury.tushare.api.index.models.IndexGlobalParams
import li.mercury.tushare.api.index.models.IndexGlobalResult
import li.mercury.tushare.api.index.models.IndexMemberAllParams
import li.mercury.tushare.api.index.models.IndexMemberAllResult
import li.mercury.tushare.api.index.models.IndexMonthlyParams
import li.mercury.tushare.api.index.models.IndexMonthlyResult
import li.mercury.tushare.api.index.models.IndexWeeklyParams
import li.mercury.tushare.api.index.models.IndexWeeklyResult
import li.mercury.tushare.api.index.models.IndexWeightParams
import li.mercury.tushare.api.index.models.IndexWeightResult
import li.mercury.tushare.api.index.models.SwDailyParams
import li.mercury.tushare.api.index.models.SwDailyResult
import li.mercury.tushare.api.index.models.SzDailyInfoParams
import li.mercury.tushare.api.index.models.SzDailyInfoResult
import li.mercury.tushare.api.index.models.ThsDailyParams
import li.mercury.tushare.api.index.models.ThsDailyResult

/**
 * 指数相关API的存储库接口
 *
 * 提供对各类指数基本信息、行情数据、成分股、技术因子等数据的访问，
 * 涵盖上交所、深交所、申万、中信、同花顺等主要指数数据源
 */
public interface IndexApiInterface {
    /**
     * 获取指数基本信息
     *
     * 调用TuShare API: `index_basic`
     * 
     * **权限要求**: 2000积分以上
     * **数据说明**: 获取指数基础信息，包括指数代码、名称、发布商、类别等
     * 
     * **支持的市场类型**:
     * - `MSCI`: MSCI指数
     * - `CSI`: 中证指数
     * - `SSE`: 上交所指数（默认）
     * - `SZSE`: 深交所指数
     * - `CICC`: 中金指数
     * - `SW`: 申万指数
     * - `OTH`: 其他指数
     *
     * @param params 指数基本信息查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（可选）
     *   - `name`: 指数简称（可选）
     *   - `market`: 交易所或服务商（可选，默认SSE）
     *   - `publisher`: 发布商（可选）
     *   - `category`: 指数类别（可选）
     * 
     * @return 返回指数基本信息列表，包含以下字段：
     *   - `ts_code`: TS代码
     *   - `name`: 简称
     *   - `fullname`: 指数全称
     *   - `market`: 市场
     *   - `publisher`: 发布方
     *   - `index_type`: 指数风格
     *   - `category`: 指数类别
     *   - `base_date`: 基期
     *   - `base_point`: 基点
     *   - `list_date`: 发布日期
     *   - `weight_rule`: 加权方式
     *   - `desc`: 描述
     *   - `exp_date`: 终止日期
     * 
     * @see [指数基本信息文档](https://tushare.pro/document/2?doc_id=94)
     */
    public suspend fun getIndexBasic(params: IndexBasicParams): List<IndexBasicResult>

    /**
     * 获取指数日线行情
     *
     * 调用TuShare API: `index_daily`
     * 
     * **权限要求**: 用户累积2000积分可调取，5000积分以上频次相对较高
     * **数据限制**: 单次调取最多8000行记录，可设置start和end日期补全
     * **特别说明**: 本接口不包括申万行情数据，申万等行业指数行情需5000积分以上
     * 
     * **注意事项**:
     * - 深证成指（399001.SZ）只包含500只成分股
     * - 如需获得与行情软件一样的成交数据，可调取深证A指（399107.SZ）
     *
     * @param params 指数日线行情查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填，来源指数基础信息接口）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回指数日线行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [指数日线行情文档](https://tushare.pro/document/2?doc_id=95)
     */
    public suspend fun getIndexDaily(params: IndexDailyParams): List<IndexDailyResult>

    /**
     * 获取指数周线行情
     *
     * 调用TuShare API: `index_weekly`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据限制**: 单次调取最多8000行记录
     *
     * @param params 指数周线行情查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回指数周线行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日（周末日期）
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [指数周线行情文档](https://tushare.pro/document/2?doc_id=96)
     */
    public suspend fun getIndexWeekly(params: IndexWeeklyParams): List<IndexWeeklyResult>

    /**
     * 获取指数月线行情
     *
     * 调用TuShare API: `index_monthly`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据限制**: 单次调取最多8000行记录
     *
     * @param params 指数月线行情查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回指数月线行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日（月末日期）
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [指数月线行情文档](https://tushare.pro/document/2?doc_id=97)
     */
    public suspend fun getIndexMonthly(params: IndexMonthlyParams): List<IndexMonthlyResult>

    /**
     * 获取指数成分和权重
     *
     * 调用TuShare API: `index_weight`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 获取各类指数成分股信息和权重，单次提取4000条
     *
     * @param params 指数成分和权重查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回指数成分和权重列表，包含以下字段：
     *   - `index_code`: 指数代码
     *   - `con_code`: 成分代码
     *   - `trade_date`: 交易日期
     *   - `weight`: 权重
     * 
     * @see [指数成分和权重文档](https://tushare.pro/document/2?doc_id=96)
     */
    public suspend fun getIndexWeight(params: IndexWeightParams): List<IndexWeightResult>

    /**
     * 获取大盘指数每日指标
     * 
     * 调用TuShare API: `index_dailybasic`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 获取指数每日重要的基本面指标，可用于选股分析、报表等
     * 
     * @param params 大盘指数每日指标查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回每日指标列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日期
     *   - `total_mv`: 当日总市值（元）
     *   - `float_mv`: 当日流通市值（元）
     *   - `total_share`: 当日总股本（股）
     *   - `float_share`: 当日流通股本（股）
     *   - `free_share`: 当日自由流通股本（股）
     *   - `turnover_rate`: 换手率（%）
     *   - `turnover_rate_f`: 换手率（基于自由流通股本）
     *   - `pe`: 市盈率
     *   - `pe_ttm`: 市盈率TTM
     *   - `pb`: 市净率
     * 
     * @see [大盘指数每日指标文档](https://tushare.pro/document/2?doc_id=128)
     */
    public suspend fun getIndexDailyBasic(params: IndexDailyBasicParams): List<IndexDailyBasicResult>

    /**
     * 获取申万行业分类数据
     * 
     * 调用TuShare API: `index_classify`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 申万行业分类，包括一级、二级、三级行业分类信息
     * 
     * @param params 申万行业分类查询参数，包含以下字段：
     *   - `index_code`: 指数代码（可选）
     *   - `level`: 行业分级（可选，L1/L2/L3）
     *   - `src`: 指数来源（可选，SW申万）
     * 
     * @return 返回行业分类数据列表，包含以下字段：
     *   - `index_code`: 指数代码
     *   - `industry_name`: 行业名称
     *   - `level`: 行业级别
     *   - `industry_code`: 行业代码
     *   - `src`: 行业分类来源
     * 
     * @see [申万行业分类文档](https://tushare.pro/document/2?doc_id=181)
     */
    public suspend fun getIndexClassify(params: IndexClassifyParams): List<IndexClassifyResult>

    /**
     * 申万行业成分构成接口
     *
     * 调用TuShare API: `index_member`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 申万行业成分股，包括申万一级、二级、三级行业的成分股信息
     *
     * @param params 申万行业成分构成查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（可选）
     *   - `index_code`: 指数代码（可选）
     *   - `is_new`: 是否最新（可选）
     * 
     * @return 返回行业成分构成列表，包含以下字段：
     *   - `index_code`: 指数代码
     *   - `index_name`: 指数名称
     *   - `con_code`: 成分股代码
     *   - `con_name`: 成分股名称
     *   - `in_date`: 纳入日期
     *   - `out_date`: 剔除日期
     *   - `is_new`: 是否最新
     * 
     * @see [申万行业成分构成文档](https://tushare.pro/document/2?doc_id=182)
     */
    public suspend fun getIndexMemberAll(params: IndexMemberAllParams): List<IndexMemberAllResult>

    /**
     * 获取申万行业日线行情
     *
     * 调用TuShare API: `sw_daily`
     * 
     * **权限要求**: 用户累积5000积分以上可调取
     * **数据限制**: 单次调取最多8000行记录
     * **数据说明**: 申万行业指数日线行情，包括一级、二级、三级行业指数
     *
     * @param params 申万行业日线行情查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回申万行业日线行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [申万行业日线行情文档](https://tushare.pro/document/2?doc_id=180)
     */
    public suspend fun getSwDaily(params: SwDailyParams): List<SwDailyResult>

    /**
     * 获取市场交易统计数据
     *
     * 调用TuShare API: `daily_info`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 获取沪深两市交易统计数据，包括成交金额、成交量、上涨下跌家数等
     *
     * @param params 市场交易统计查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange`: 交易所（可选，SSE上交所/SZSE深交所/BSE北交所）
     * 
     * @return 返回市场交易统计数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `exchange`: 交易所
     *   - `ts_vol`: 成交量（股）
     *   - `ts_amount`: 成交金额（元）
     *   - `deal_amount`: 成交笔数
     *   - `up_count`: 上涨家数
     *   - `down_count`: 下跌家数
     *   - `avg_price`: 平均价格
     * 
     * @see [市场交易统计文档](https://tushare.pro/document/2?doc_id=32)
     */
    public suspend fun getDailyInfo(params: DailyInfoParams): List<DailyInfoResult>

    /**
     * 获取深圳市场每日交易概况
     *
     * 调用TuShare API: `sz_daily_info`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据说明**: 深圳证券交易所每日股票交易概况，包含主板、中小企业板、创业板的详细交易统计
     *
     * @param params 深圳市场交易概况查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回交易概况数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_vol`: 总成交量（股）
     *   - `ts_amount`: 总成交金额（元）
     *   - `deal_amount`: 总成交笔数
     *   - `mainboard_count`: 主板上市数
     *   - `mainboard_amount`: 主板成交金额
     *   - `mainboard_vol`: 主板成交量
     *   - `sme_count`: 中小板上市数
     *   - `sme_amount`: 中小板成交金额
     *   - `sme_vol`: 中小板成交量
     *   - `gem_count`: 创业板上市数
     *   - `gem_amount`: 创业板成交金额
     *   - `gem_vol`: 创业板成交量
     * 
     * @see [深圳市场每日交易概况文档](https://tushare.pro/document/2?doc_id=33)
     */
    public suspend fun getSzDailyInfo(params: SzDailyInfoParams): List<SzDailyInfoResult>

    /**
     * 获取同花顺板块指数行情
     *
     * 调用TuShare API: `ths_daily`
     * 
     * **权限要求**: 用户累积5000积分以上可调取
     * **数据限制**: 单次调取最多8000行记录
     * **数据说明**: 同花顺概念和行业板块指数行情数据
     *
     * @param params 同花顺指数行情查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回同花顺指数行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `avg_price`: 平均价格
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [同花顺板块指数行情文档](https://tushare.pro/document/2?doc_id=127)
     */
    public suspend fun getThsDaily(params: ThsDailyParams): List<ThsDailyResult>

    /**
     * 获取中信行业指数日线行情
     *
     * 调用TuShare API: `ci_daily`
     * 
     * **权限要求**: 用户累积5000积分以上可调取
     * **数据限制**: 单次调取最多8000行记录
     * **数据说明**: 中信行业指数日线行情数据
     *
     * @param params 中信行业指数查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回中信行业指数行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量（手）
     *   - `amount`: 成交额（千元）
     * 
     * @see [中信行业指数行情文档](https://tushare.pro/document/2?doc_id=178)
     */
    public suspend fun getCiDaily(params: CiDailyParams): List<CiDailyResult>

    /**
     * 获取国际主要指数日线行情
     *
     * 调用TuShare API: `index_global`
     * 
     * **权限要求**: 用户累积2000积分可调取
     * **数据限制**: 单次调取最多8000行记录
     * **数据说明**: 国际主要股票指数行情，包括道琼斯、纳斯达克、标普500、日经225等
     *
     * @param params 国际指数查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回国际指数行情列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日
     *   - `close`: 收盘点位
     *   - `open`: 开盘点位
     *   - `high`: 最高点位
     *   - `low`: 最低点位
     *   - `pre_close`: 昨日收盘点
     *   - `change`: 涨跌点
     *   - `pct_chg`: 涨跌幅（%）
     *   - `vol`: 成交量
     *   - `amount`: 成交额
     * 
     * @see [国际指数文档](https://tushare.pro/document/2?doc_id=139)
     */
    public suspend fun getIndexGlobal(params: IndexGlobalParams): List<IndexGlobalResult>

    /**
     * 获取指数技术因子专业版数据
     * 
     * 调用TuShare API: `idx_factor_pro`
     * 
     * **权限要求**: 需要专业版权限
     * **数据说明**: 获取指数技术因子数据，包括各种技术分析指标，用于量化分析
     * **数据限制**: 单次最大5000条，总量不限制，用户需要循环获取
     * 
     * @param params 技术因子查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回技术因子数据列表，包含以下字段：
     *   - `ts_code`: TS指数代码
     *   - `trade_date`: 交易日期
     *   - `macd_dif`: MACD DIF
     *   - `macd_dea`: MACD DEA
     *   - `macd_macd`: MACD值
     *   - `kdj_k`: KDJ指标K值
     *   - `kdj_d`: KDJ指标D值
     *   - `kdj_j`: KDJ指标J值
     *   - `rsi_6`: 6日RSI
     *   - `rsi_12`: 12日RSI
     *   - `rsi_24`: 24日RSI
     *   - `boll_upper`: 布林上轨
     *   - `boll_mid`: 布林中轨
     *   - `boll_lower`: 布林下轨
     *   - `cci`: CCI指标
     *   - `adx`: ADX指标
     *   - `adxr`: ADXR指标
     *   - `trix`: TRIX指标
     *   - `vr`: VR指标
     *   - `wr_10`: 10日威廉指标
     *   - `wr_6`: 6日威廉指标
     *   - `bias_6`: 6日乖离率
     *   - `bias_12`: 12日乖离率
     *   - `bias_24`: 24日乖离率
     * 
     * @see [指数技术因子专业版文档](https://tushare.pro/document/2?doc_id=183)
     */
    public suspend fun getIdxFactorPro(params: IdxFactorProParams): List<IdxFactorProResult>
}
