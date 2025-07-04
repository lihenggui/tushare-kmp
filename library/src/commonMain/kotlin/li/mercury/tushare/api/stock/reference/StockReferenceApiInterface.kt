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
package li.mercury.tushare.api.stock.reference

import li.mercury.tushare.api.stock.reference.models.BlockTradeParams
import li.mercury.tushare.api.stock.reference.models.BlockTradeResult
import li.mercury.tushare.api.stock.reference.models.ConceptDetailParams
import li.mercury.tushare.api.stock.reference.models.ConceptDetailResult
import li.mercury.tushare.api.stock.reference.models.ConceptParams
import li.mercury.tushare.api.stock.reference.models.ConceptResult
import li.mercury.tushare.api.stock.reference.models.PledgeDetailParams
import li.mercury.tushare.api.stock.reference.models.PledgeDetailResult
import li.mercury.tushare.api.stock.reference.models.PledgeStatParams
import li.mercury.tushare.api.stock.reference.models.PledgeStatResult
import li.mercury.tushare.api.stock.reference.models.RepurchaseParams
import li.mercury.tushare.api.stock.reference.models.RepurchaseResult
import li.mercury.tushare.api.stock.reference.models.ShareFloatParams
import li.mercury.tushare.api.stock.reference.models.ShareFloatResult
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberParams
import li.mercury.tushare.api.stock.reference.models.StockHolderNumberResult
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeParams
import li.mercury.tushare.api.stock.reference.models.StockHolderTradeResult
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10FloatHoldersResult
import li.mercury.tushare.api.stock.reference.models.Top10HoldersParams
import li.mercury.tushare.api.stock.reference.models.Top10HoldersResult

/**
 * 股票参考数据相关API接口
 *
 * 提供对股票参考数据的访问，包括股东信息、股权质押、股票回购、概念股分类、
 * 限售股解禁、大宗交易、股东人数变动、股东增减持等重要参考数据
 */
public interface StockReferenceApiInterface {
    /**
     * 获取前十大股东
     *
     * 调用TuShare API: `top10_holders`
     *
     * **权限要求**:
     * - 2000积分以上用户可调用
     * - 5000积分以上用户可提高调用频次
     *
     * **数据限制**: 单次最大提取1000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司前十大股东数据，包括持股数量、持股比例、股东类型等信息，支持历史数据查询
     *
     * @param params 前十大股东查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（必填，如 600000.SH / 000001.SZ）
     *   - `period`: 报告期（可选，格式：YYYYMMDD，一般为每个季度最后一天，如 20231231 表示 2023年年报）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 报告期开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 报告期结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回前十大股东数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `holder_name`: 股东名称
     *   - `hold_amount`: 持有数量（股）
     *   - `hold_ratio`: 占总股本比例（%）
     *   - `hold_float_ratio`: 占流通股本比例（%）
     *   - `hold_change`: 持股变动
     *   - `holder_type`: 股东类型
     *
     * @see [前十大股东文档](readme/沪深股票/参考数据/前十大股东.md)
     */
    public suspend fun getTop10Holders(params: Top10HoldersParams): List<Top10HoldersResult>

    /**
     * 获取前十大流通股东
     *
     * 调用TuShare API: `top10_floatholders`
     *
     * **权限要求**:
     * - 2000积分以上用户可调用
     * - 5000积分以上用户可提高调用频次
     *
     * **数据限制**: 单次最大提取1000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司前十大流通股东数据，包括持股数量、持股比例、股东类型等信息，支持历史数据查询
     *
     * @param params 前十大流通股东查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（必填，如 600000.SH / 000001.SZ）
     *   - `period`: 报告期（可选，格式：YYYYMMDD，一般为每个季度最后一天，如 20231231 表示 2023年年报）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 报告期开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 报告期结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回前十大流通股东数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 报告期
     *   - `holder_name`: 股东名称
     *   - `hold_amount`: 持有数量（股）
     *   - `hold_ratio`: 占总股本比例（%）
     *   - `hold_float_ratio`: 占流通股本比例（%）
     *   - `hold_change`: 持股变动
     *   - `holder_type`: 股东类型
     *
     * @see [前十大流通股东文档](readme/沪深股票/参考数据/前十大流通股东.md)
     */
    public suspend fun getTop10FloatHolders(params: Top10FloatHoldersParams): List<Top10FloatHoldersResult>

    /**
     * 获取股权质押统计数据
     *
     * 调用TuShare API: `pledge_stat`
     *
     * **权限要求**: 500积分以上用户可调用
     *
     * **数据限制**: 单次最大提取1000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司股票质押统计数据，包括质押次数、质押股份数量、质押比例等信息，支持历史数据查询
     *
     * @param params 股权质押统计数据查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `end_date`: 截止日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股权质押统计数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `end_date`: 截止日期
     *   - `pledge_count`: 质押次数
     *   - `unrest_pledge`: 无限售股质押数量（万股）
     *   - `rest_pledge`: 限售股份质押数量（万股）
     *   - `total_share`: 总股本（万股）
     *   - `pledge_ratio`: 质押比例（%）
     *
     * @see [股权质押统计数据文档](readme/沪深股票/参考数据/股权质押统计数据.md)
     */
    public suspend fun getPledgeStat(params: PledgeStatParams): List<PledgeStatResult>

    /**
     * 获取股权质押明细数据
     *
     * 调用TuShare API: `pledge_detail`
     *
     * **权限要求**: 500积分以上用户可调用
     *
     * **数据限制**: 单次最大提取1000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司股票质押明细数据，包括质押股东、质押数量、质押方、质押比例、是否回购等信息，支持历史数据查询
     *
     * @param params 股权质押明细数据查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（必填，如 600000.SH / 000001.SZ）
     *
     * @return 返回股权质押明细数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `holder_name`: 股东名称
     *   - `pledge_amount`: 质押数量（万股）
     *   - `start_date`: 质押开始日期
     *   - `end_date`: 质押结束日期
     *   - `is_release`: 是否已解押（Y/N）
     *   - `release_date`: 解押日期
     *   - `pledgor`: 质押方
     *   - `holding_amount`: 持股总数（万股）
     *   - `pledged_amount`: 质押总数（万股）
     *   - `p_total_ratio`: 本次质押占总股本比例（%）
     *   - `h_total_ratio`: 持股总数占总股本比例（%）
     *   - `is_buyback`: 是否回购（Y/N）
     *
     * @see [股权质押明细文档](readme/沪深股票/参考数据/股权质押明细.md)
     */
    public suspend fun getPledgeDetail(params: PledgeDetailParams): List<PledgeDetailResult>

    /**
     * 获取股票回购信息
     *
     * 调用TuShare API: `repurchase`
     *
     * **权限要求**: 600积分以上用户可调用
     *
     * **数据限制**: 单次最大提取2000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司回购股票数据，包括回购数量、回购金额、回购价格区间、回购进度等信息，支持历史数据查询
     *
     * @param params 股票回购查询参数，包含以下字段：
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股票回购数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 截止日期
     *   - `proc`: 进度（如 实施、完成、股东大会通过）
     *   - `exp_date`: 过期日期
     *   - `vol`: 回购数量（股）
     *   - `amount`: 回购金额（元）
     *   - `high_limit`: 回购最高价（元）
     *   - `low_limit`: 回购最低价（元）
     *
     * @see [股票回购文档](readme/沪深股票/参考数据/股票回购.md)
     */
    public suspend fun getRepurchase(params: RepurchaseParams): List<RepurchaseResult>

    /**
     * 获取概念股分类
     *
     * 调用TuShare API: `concept`
     *
     * **重要说明**: 本接口数据已停止更新，建议使用同花顺概念接口获取最新数据
     *
     * **数据说明**: 该接口提供概念股分类信息，包括概念分类ID、概念名称、数据来源等
     *
     * @param params 概念股分类查询参数，包含以下字段：
     *   - `src`: 来源（可选，默认为 ts）
     *
     * @return 返回概念股分类数据列表，包含以下字段：
     *   - `code`: 概念分类ID
     *   - `name`: 概念分类名称
     *   - `src`: 数据来源（目前仅 ts）
     *
     * @see [概念股分类文档](readme/沪深股票/参考数据/概念股分类.md)
     */
    public suspend fun getConcept(params: ConceptParams): List<ConceptResult>

    /**
     * 获取概念股列表
     *
     * 调用TuShare API: `concept_detail`
     *
     * **重要说明**: 本接口数据已停止更新，建议使用同花顺概念接口获取最新数据
     *
     * **数据说明**: 该接口提供概念股分类明细，包括概念代码、概念名称、股票代码、股票名称、纳入日期、剔除日期等信息
     *
     * @param params 概念股列表查询参数，包含以下字段：
     *   - `id`: 概念分类ID（可选，来自 concept 接口）
     *   - `ts_code`: 股票代码（可选，id 和 ts_code 二选一）
     *
     * @return 返回概念股列表数据，包含以下字段：
     *   - `id`: 概念代码
     *   - `concept_name`: 概念名称
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `in_date`: 纳入日期
     *   - `out_date`: 剔除日期
     *
     * @see [概念股列表文档](readme/沪深股票/参考数据/概念股列表.md)
     */
    public suspend fun getConceptDetail(params: ConceptDetailParams): List<ConceptDetailResult>

    /**
     * 获取限售股解禁数据
     *
     * 调用TuShare API: `share_float`
     *
     * **权限要求**:
     * - 120积分以上用户可调用
     * - 超过5000积分的用户可获得更高的调用频次
     *
     * **数据限制**: 单次最大提取6000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司限售股解禁数据，包括解禁日期、解禁股份数量、解禁比例、股东名称、股份类型等信息，支持历史数据查询
     *
     * @param params 限售股解禁查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `float_date`: 解禁日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 解禁开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 解禁结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回限售股解禁数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `float_date`: 解禁日期
     *   - `float_share`: 解禁股份数量（股）
     *   - `float_ratio`: 解禁股份占总股本比例（%）
     *   - `holder_name`: 股东名称
     *   - `share_type`: 股份类型（如 定增股份、首发原股东限售股份）
     *
     * @see [限售股解禁文档](readme/沪深股票/参考数据/限售股解禁.md)
     */
    public suspend fun getShareFloat(params: ShareFloatParams): List<ShareFloatResult>

    /**
     * 获取大宗交易数据
     *
     * 调用TuShare API: `block_trade`
     *
     * **权限要求**:
     * - 300积分以上用户可调用
     * - 超过5000积分的用户可获得更高的调用频次
     *
     * **数据限制**: 单次最大提取1000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司大宗交易数据，包括成交价、成交量、成交金额、买方营业部、卖方营业部等信息，支持历史数据查询
     *
     * **注意事项**: ts_code 和 trade_date 至少输入一个参数
     *
     * @param params 大宗交易查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回大宗交易数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `trade_date`: 交易日期
     *   - `price`: 成交价（元）
     *   - `vol`: 成交量（万股）
     *   - `amount`: 成交金额（万元）
     *   - `buyer`: 买方营业部
     *   - `seller`: 卖方营业部
     *
     * @see [大宗交易文档](readme/沪深股票/参考数据/大宗交易.md)
     */
    public suspend fun getBlockTrade(params: BlockTradeParams): List<BlockTradeResult>

    /**
     * 获取股东人数
     *
     * 调用TuShare API: `stk_holdernumber`
     *
     * **权限要求**:
     * - 600积分以上用户可调用
     * - 超过5000积分的用户可获得更高的调用频次
     *
     * **数据限制**: 单次最大提取3000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司股东户数数据，包括公告日期、截止日期、股东户数等信息，数据不定期公布，具体发布时间取决于上市公司公告
     *
     * @param params 股东人数查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 截止日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回股东人数数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 截止日期
     *   - `holder_num`: 股东户数
     *
     * @see [股东人数文档](readme/沪深股票/参考数据/股东人数.md)
     */
    public suspend fun getStockHolderNumber(params: StockHolderNumberParams): List<StockHolderNumberResult>

    /**
     * 获取股东增减持数据
     *
     * 调用TuShare API: `stk_holdertrade`
     *
     * **权限要求**:
     * - 2000积分以上用户可调用
     * - 超过5000积分的用户可获得更高的调用频次
     *
     * **数据限制**: 单次最大提取3000条数据，可通过循环请求获取更多数据
     * **数据说明**: 获取上市公司股东增减持数据，包括股东名称、股东类型、增减持类型、变动数量、变动后持股、平均价格等信息，
     * 数据不定期公布，具体发布时间取决于上市公司公告
     *
     * @param params 股东增减持查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选，如 600000.SH / 000001.SZ）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 公告开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 公告结束日期（可选，格式：YYYYMMDD）
     *   - `trade_type`: 交易类型（可选，IN 增持，DE 减持）
     *   - `holder_type`: 股东类型（可选，C 公司，P 个人，G 高管）
     *
     * @return 返回股东增减持数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `holder_name`: 股东名称
     *   - `holder_type`: 股东类型（G 高管，P 个人，C 公司）
     *   - `in_de`: 类型（IN 增持，DE 减持）
     *   - `change_vol`: 变动数量（股）
     *   - `change_ratio`: 占流通比例（%）
     *   - `after_share`: 变动后持股（股）
     *   - `after_ratio`: 变动后占流通比例（%）
     *   - `avg_price`: 平均价格（元）
     *   - `total_share`: 持股总数（股）
     *   - `begin_date`: 增减持开始日期
     *   - `close_date`: 增减持结束日期
     *
     * @see [股东增减持文档](readme/沪深股票/参考数据/股东增减持.md)
     */
    public suspend fun getStockHolderTrade(params: StockHolderTradeParams): List<StockHolderTradeResult>
}
