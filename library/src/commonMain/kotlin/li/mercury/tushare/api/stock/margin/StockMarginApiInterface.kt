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
package li.mercury.tushare.api.stock.margin

import li.mercury.tushare.api.stock.margin.models.MarginDetailParams
import li.mercury.tushare.api.stock.margin.models.MarginDetailResult
import li.mercury.tushare.api.stock.margin.models.MarginParams
import li.mercury.tushare.api.stock.margin.models.MarginResult
import li.mercury.tushare.api.stock.margin.models.MarginSecsParams
import li.mercury.tushare.api.stock.margin.models.MarginSecsResult
import li.mercury.tushare.api.stock.margin.models.SlbLenMmParams
import li.mercury.tushare.api.stock.margin.models.SlbLenMmResult
import li.mercury.tushare.api.stock.margin.models.SlbLenParams
import li.mercury.tushare.api.stock.margin.models.SlbLenResult
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailParams
import li.mercury.tushare.api.stock.margin.models.SlbSecDetailResult
import li.mercury.tushare.api.stock.margin.models.SlbSecParams
import li.mercury.tushare.api.stock.margin.models.SlbSecResult

/**
 * 股票融资融券相关API接口
 *
 * 提供融资融券交易数据的访问，包括融资融券交易汇总、明细、标的股票信息，
 * 转融券、转融资数据，以及做市借券交易数据等两融及融转通相关信息
 */
public interface StockMarginApiInterface {
    /**
     * 获取融资融券交易汇总数据
     *
     * 调用TuShare API: `margin`
     *
     * **权限要求**: 2000积分以上用户可调用，积分越高权限越大
     * **数据限制**: 单次请求最大返回4000行数据，可根据日期循环
     * **数据说明**: 获取融资融券每日交易汇总数据，从证券交易所网站直接获取
     *
     * **计算公式**:
     * - 本日融资余额(元) = 前日融资余额 + 本日融资买入 - 本日融资偿还额
     * - 本日融券余量(股) = 前日融券余量 + 本日融券卖出量 - 本日融券买入量 - 本日现券偿还量
     * - 本日融券余额(元) = 本日融券余量 × 本日收盘价
     * - 本日融资融券余额(元) = 本日融资余额 + 本日融券余额
     *
     * @param params 融资融券交易汇总查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange_id`: 交易所代码（可选，SSE上交所/SZSE深交所/BSE北交所）
     *
     * @return 返回融资融券交易汇总数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `exchange_id`: 交易所代码（SSE上交所/SZSE深交所/BSE北交所）
     *   - `rzye`: 融资余额（元）
     *   - `rzmre`: 融资买入额（元）
     *   - `rzche`: 融资偿还额（元）
     *   - `rqye`: 融券余额（元）
     *   - `rqmcl`: 融券卖出量（股、份、手）
     *   - `rzrqye`: 融资融券余额（元）
     *   - `rqyl`: 融券余量（股、份、手）
     *
     * @see [融资融券交易汇总文档](readme/沪深股票/两融及融转通/融资融券交易汇总.md)
     */
    public suspend fun getMargin(params: MarginParams): List<MarginResult>

    /**
     * 获取融资融券交易明细数据
     *
     * 调用TuShare API: `margin_detail`
     *
     * **权限要求**: 2000积分以上用户可调用，积分越高权限越大
     * **数据限制**: 单次请求最大返回4000行数据，可根据日期循环
     * **数据说明**: 获取沪深两市每日融资融券明细，基于证券公司报送的融资融券余额数据汇总生成
     *
     * **单位说明**:
     * - 股（标的证券为股票）
     * - 份（标的证券为基金）
     * - 手（标的证券为债券）
     *
     * @param params 融资融券交易明细查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `ts_code`: TS代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回融资融券交易明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS股票代码
     *   - `name`: 股票名称（20190910后有数据）
     *   - `rzye`: 融资余额（元）
     *   - `rqye`: 融券余额（元）
     *   - `rzmre`: 融资买入额（元）
     *   - `rqyl`: 融券余量（股）
     *   - `rzche`: 融资偿还额（元）
     *   - `rqchl`: 融券偿还量（股）
     *   - `rqmcl`: 融券卖出量（股、份、手）
     *   - `rzrqye`: 融资融券余额（元）
     *
     * @see [融资融券交易明细文档](readme/沪深股票/两融及融转通/融资融券交易明细.md)
     */
    public suspend fun getMarginDetail(params: MarginDetailParams): List<MarginDetailResult>

    /**
     * 获取融资融券标的（盘前更新）数据
     *
     * 调用TuShare API: `margin_secs`
     *
     * **权限要求**: 2000积分可调取，5000积分无总量限制
     * **数据限制**: 单次最大6000行数据，可根据股票代码、交易日期、交易所代码循环提取
     * **数据说明**: 获取沪深京三大交易所融资融券标的（包括ETF），每天盘前更新
     *
     * @param params 融资融券标的查询参数，包含以下字段：
     *   - `ts_code`: 标的代码（可选）
     *   - `trade_date`: 交易日（可选，格式：YYYYMMDD）
     *   - `exchange`: 交易所（可选，SSE上交所/SZSE深交所/BSE北交所）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回融资融券标的数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 标的代码
     *   - `name`: 标的名称
     *   - `exchange`: 交易所
     *
     * @see [融资融券标的（盘前更新）文档](readme/沪深股票/两融及融转通/融资融券标的（盘前更新）.md)
     */
    public suspend fun getMarginSecs(params: MarginSecsParams): List<MarginSecsResult>

    /**
     * 获取转融券交易汇总数据
     *
     * 调用TuShare API: `slb_sec`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次最大4000条数据，可根据日期循环提取
     * **数据说明**: 获取转融券交易汇总数据，反映转融券市场整体情况
     *
     * @param params 转融券交易汇总查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange`: 交易所（可选）
     *
     * @return 返回转融券交易汇总数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `exchange`: 交易所
     *   - `slb_amt`: 转融券余额（元）
     *   - `slb_vol`: 转融券余量（股）
     *   - `slb_amt_in`: 转融券借入额（元）
     *   - `slb_vol_in`: 转融券借入量（股）
     *   - `slb_amt_out`: 转融券偿还额（元）
     *   - `slb_vol_out`: 转融券偿还量（股）
     *
     * @see [转融券交易汇总文档](readme/沪深股票/两融及融转通/转融券交易汇总.md)
     */
    public suspend fun getSlbSec(params: SlbSecParams): List<SlbSecResult>

    /**
     * 获取转融资交易汇总数据
     *
     * 调用TuShare API: `slb_len`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次最大4000条数据，可根据日期循环提取
     * **数据说明**: 获取转融资交易汇总数据，反映转融资市场整体情况
     *
     * @param params 转融资交易汇总查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange`: 交易所（可选）
     *
     * @return 返回转融资交易汇总数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `exchange`: 交易所
     *   - `slb_amt`: 转融资余额（元）
     *   - `slb_amt_in`: 转融资借入额（元）
     *   - `slb_amt_out`: 转融资偿还额（元）
     *   - `slb_rate`: 转融资利率（%）
     *
     * @see [转融资交易汇总文档](readme/沪深股票/两融及融转通/转融资交易汇总.md)
     */
    public suspend fun getSlbLen(params: SlbLenParams): List<SlbLenResult>

    /**
     * 获取转融券交易明细数据
     *
     * 调用TuShare API: `slb_sec_detail`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次最大4000条数据，可根据日期或股票代码循环提取
     * **数据说明**: 获取转融券交易明细数据，按股票分类的转融券交易情况
     *
     * @param params 转融券交易明细查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `ts_code`: 股票代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回转融券交易明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `slb_amt`: 转融券余额（元）
     *   - `slb_vol`: 转融券余量（股）
     *   - `slb_amt_in`: 转融券借入额（元）
     *   - `slb_vol_in`: 转融券借入量（股）
     *   - `slb_amt_out`: 转融券偿还额（元）
     *   - `slb_vol_out`: 转融券偿还量（股）
     *   - `slb_rate`: 转融券费率（%）
     *
     * @see [转融券交易明细文档](readme/沪深股票/两融及融转通/转融券交易明细.md)
     */
    public suspend fun getSlbSecDetail(params: SlbSecDetailParams): List<SlbSecDetailResult>

    /**
     * 获取做市借券交易汇总数据
     *
     * 调用TuShare API: `slb_len_mm`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次最大4000条数据，可根据日期循环提取
     * **数据说明**: 获取做市借券交易汇总数据，反映做市商借券情况
     *
     * @param params 做市借券交易汇总查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `exchange`: 交易所（可选）
     *
     * @return 返回做市借券交易汇总数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `exchange`: 交易所
     *   - `mm_amt`: 做市借券余额（元）
     *   - `mm_vol`: 做市借券余量（股）
     *   - `mm_amt_in`: 做市借券借入额（元）
     *   - `mm_vol_in`: 做市借券借入量（股）
     *   - `mm_amt_out`: 做市借券偿还额（元）
     *   - `mm_vol_out`: 做市借券偿还量（股）
     *
     * @see [做市借券交易汇总文档](readme/沪深股票/两融及融转通/做市借券交易汇总.md)
     */
    public suspend fun getSlbLenMm(params: SlbLenMmParams): List<SlbLenMmResult>
}
