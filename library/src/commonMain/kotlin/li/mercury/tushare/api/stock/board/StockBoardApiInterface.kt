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
package li.mercury.tushare.api.stock.board

import li.mercury.tushare.api.stock.board.models.DcHotParams
import li.mercury.tushare.api.stock.board.models.DcHotResult
import li.mercury.tushare.api.stock.board.models.DcIndexParams
import li.mercury.tushare.api.stock.board.models.DcIndexResult
import li.mercury.tushare.api.stock.board.models.DcMemberParams
import li.mercury.tushare.api.stock.board.models.DcMemberResult
import li.mercury.tushare.api.stock.board.models.HmDetailParams
import li.mercury.tushare.api.stock.board.models.HmDetailResult
import li.mercury.tushare.api.stock.board.models.HmListParams
import li.mercury.tushare.api.stock.board.models.HmListResult
import li.mercury.tushare.api.stock.board.models.KplConceptConsParams
import li.mercury.tushare.api.stock.board.models.KplConceptConsResult
import li.mercury.tushare.api.stock.board.models.KplConceptParams
import li.mercury.tushare.api.stock.board.models.KplConceptResult
import li.mercury.tushare.api.stock.board.models.KplListParams
import li.mercury.tushare.api.stock.board.models.KplListResult
import li.mercury.tushare.api.stock.board.models.LimitCptListParams
import li.mercury.tushare.api.stock.board.models.LimitCptListResult
import li.mercury.tushare.api.stock.board.models.LimitListDParams
import li.mercury.tushare.api.stock.board.models.LimitListDResult
import li.mercury.tushare.api.stock.board.models.LimitListThsParams
import li.mercury.tushare.api.stock.board.models.LimitListThsResult
import li.mercury.tushare.api.stock.board.models.LimitStepParams
import li.mercury.tushare.api.stock.board.models.LimitStepResult
import li.mercury.tushare.api.stock.board.models.StkAuctionParams
import li.mercury.tushare.api.stock.board.models.StkAuctionResult
import li.mercury.tushare.api.stock.board.models.ThsHotParams
import li.mercury.tushare.api.stock.board.models.ThsHotResult
import li.mercury.tushare.api.stock.board.models.ThsIndexParams
import li.mercury.tushare.api.stock.board.models.ThsIndexResult
import li.mercury.tushare.api.stock.board.models.ThsMemberParams
import li.mercury.tushare.api.stock.board.models.ThsMemberResult
import li.mercury.tushare.api.stock.board.models.TopInstParams
import li.mercury.tushare.api.stock.board.models.TopInstResult
import li.mercury.tushare.api.stock.board.models.TopListParams
import li.mercury.tushare.api.stock.board.models.TopListResult

/**
 * 股票打板专题数据相关API接口
 *
 * 提供A股打板相关数据的访问，包括涨跌停分析、龙虎榜数据、板块热点、
 * 游资操作、连板统计等多种打板专题数据，支持东方财富、同花顺、开盘啦等数据源
 */
public interface StockBoardApiInterface {
    /**
     * 获取东方财富板块成分数据
     *
     * 调用TuShare API: `dc_member`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据板块代码或日期循环提取
     * **数据说明**: 获取东方财富概念板块成分股信息
     *
     * @param params 东方财富板块成分查询参数，包含以下字段：
     *   - `ts_code`: 板块代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富板块成分数据列表，包含以下字段：
     *   - `ts_code`: 板块代码
     *   - `trade_date`: 交易日期
     *   - `stock_code`: 股票代码
     *   - `stock_name`: 股票名称
     *   - `weight`: 权重
     *
     * @see [东方财富板块成分文档](readme/沪深股票/打板专题数据/东方财富板块成分.md)
     */
    public suspend fun getDcMember(params: DcMemberParams): List<DcMemberResult>

    /**
     * 获取东方财富概念板块数据
     *
     * 调用TuShare API: `dc_index`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大可获取5000条数据，历史数据可根据日期循环获取
     * **数据说明**: 获取东方财富每个交易日的概念板块数据，支持按日期查询
     *
     * @param params 东方财富概念板块查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（可选，支持多个代码同时输入，用逗号分隔）
     *   - `name`: 板块名称（可选，例如：人形机器人）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富概念板块数据列表，包含以下字段：
     *   - `ts_code`: 概念代码
     *   - `trade_date`: 交易日期
     *   - `name`: 概念名称
     *   - `leading`: 领涨股票名称
     *   - `leading_code`: 领涨股票代码
     *   - `pct_change`: 涨跌幅
     *   - `leading_pct`: 领涨股票涨跌幅
     *   - `total_mv`: 总市值（万元）
     *   - `turnover_rate`: 换手率
     *   - `up_num`: 上涨家数
     *   - `down_num`: 下降家数
     *
     * @see [东方财富概念板块文档](readme/沪深股票/打板专题数据/东方财富概念板块.md)
     */
    public suspend fun getDcIndex(params: DcIndexParams): List<DcIndexResult>

    /**
     * 获取东方财富热板数据
     *
     * 调用TuShare API: `dc_hot`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期循环提取
     * **数据说明**: 获取东方财富热门板块数据，反映市场热点变化
     *
     * @param params 东方财富热板查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回东方财富热板数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 板块代码
     *   - `name`: 板块名称
     *   - `rank`: 排名
     *   - `hot_score`: 热度分数
     *   - `pct_change`: 涨跌幅
     *
     * @see [东方财富热板文档](readme/沪深股票/打板专题数据/东方财富热板.md)
     */
    public suspend fun getDcHot(params: DcHotParams): List<DcHotResult>

    /**
     * 获取同花顺概念和行业指数数据
     *
     * 调用TuShare API: `ths_index`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据代码或日期循环提取
     * **数据说明**: 获取同花顺概念和行业指数信息
     *
     * @param params 同花顺概念和行业指数查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（可选）
     *   - `name`: 指数名称（可选）
     *   - `exchange`: 交易所（可选）
     *   - `type`: 指数类型（可选）
     *
     * @return 返回同花顺概念和行业指数数据列表，包含以下字段：
     *   - `ts_code`: 指数代码
     *   - `name`: 指数名称
     *   - `exchange`: 交易所
     *   - `type`: 指数类型
     *   - `count`: 成分股数量
     *
     * @see [同花顺概念和行业指数文档](readme/沪深股票/打板专题数据/同花顺概念和行业指数.md)
     */
    public suspend fun getThsIndex(params: ThsIndexParams): List<ThsIndexResult>

    /**
     * 获取同花顺概念板块成分数据
     *
     * 调用TuShare API: `ths_member`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据板块代码循环提取
     * **数据说明**: 获取同花顺概念板块成分股信息
     *
     * @param params 同花顺概念板块成分查询参数，包含以下字段：
     *   - `ts_code`: 指数代码（必填）
     *   - `code`: 股票代码（可选）
     *
     * @return 返回同花顺概念板块成分数据列表，包含以下字段：
     *   - `ts_code`: 指数代码
     *   - `code`: 股票代码
     *   - `name`: 股票名称
     *   - `weight`: 权重
     *   - `in_date`: 纳入日期
     *   - `out_date`: 剔除日期
     *
     * @see [同花顺概念板块成分文档](readme/沪深股票/打板专题数据/同花顺概念板块成分.md)
     */
    public suspend fun getThsMember(params: ThsMemberParams): List<ThsMemberResult>

    /**
     * 获取同花顺热榜数据
     *
     * 调用TuShare API: `ths_hot`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期循环提取
     * **数据说明**: 获取同花顺热榜数据，反映市场关注度
     *
     * @param params 同花顺热榜查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回同花顺热榜数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `rank`: 排名
     *   - `hot_score`: 热度分数
     *   - `pct_change`: 涨跌幅
     *
     * @see [同花顺热榜文档](readme/沪深股票/打板专题数据/同花顺热榜.md)
     */
    public suspend fun getThsHot(params: ThsHotParams): List<ThsHotResult>

    /**
     * 获取开盘啦榜单数据
     *
     * 调用TuShare API: `kpl_list`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期或榜单类型循环提取
     * **数据说明**: 获取开盘啦各类榜单数据，包括涨跌幅、换手率等排名
     *
     * @param params 开盘啦榜单查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `list_type`: 榜单类型（可选）
     *
     * @return 返回开盘啦榜单数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `list_type`: 榜单类型
     *   - `rank`: 排名
     *   - `value`: 榜单数值
     *
     * @see [开盘啦榜单数据文档](readme/沪深股票/打板专题数据/开盘啦榜单数据.md)
     */
    public suspend fun getKplList(params: KplListParams): List<KplListResult>

    /**
     * 获取开盘啦题材库数据
     *
     * 调用TuShare API: `kpl_concept`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据题材代码循环提取
     * **数据说明**: 获取开盘啦题材库信息，包含各种投资题材分类
     *
     * @param params 开盘啦题材库查询参数，包含以下字段：
     *   - `concept_code`: 题材代码（可选）
     *   - `concept_name`: 题材名称（可选）
     *
     * @return 返回开盘啦题材库数据列表，包含以下字段：
     *   - `concept_code`: 题材代码
     *   - `concept_name`: 题材名称
     *   - `description`: 题材描述
     *   - `stock_count`: 成分股数量
     *
     * @see [开盘啦题材库文档](readme/沪深股票/打板专题数据/开盘啦题材库.md)
     */
    public suspend fun getKplConcept(params: KplConceptParams): List<KplConceptResult>

    /**
     * 获取开盘啦题材成分数据
     *
     * 调用TuShare API: `kpl_concept_cons`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据题材代码循环提取
     * **数据说明**: 获取开盘啦题材成分股信息
     *
     * @param params 开盘啦题材成分查询参数，包含以下字段：
     *   - `concept_code`: 题材代码（必填）
     *   - `ts_code`: 股票代码（可选）
     *
     * @return 返回开盘啦题材成分数据列表，包含以下字段：
     *   - `concept_code`: 题材代码
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `in_date`: 纳入日期
     *   - `out_date`: 剔除日期
     *
     * @see [开盘啦题材成分文档](readme/沪深股票/打板专题数据/开盘啦题材成分.md)
     */
    public suspend fun getKplConceptCons(params: KplConceptConsParams): List<KplConceptConsResult>

    /**
     * 获取当日集合竞价数据
     *
     * 调用TuShare API: `stk_auction`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据日期或股票代码循环提取
     * **数据说明**: 获取A股集合竞价期间的委托和成交数据
     *
     * @param params 当日集合竞价查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回当日集合竞价数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `auction_price`: 集合竞价成交价
     *   - `auction_vol`: 集合竞价成交量
     *   - `auction_amount`: 集合竞价成交额
     *   - `buy_vol`: 买入总量
     *   - `sell_vol`: 卖出总量
     *
     * @see [当日集合竞价文档](readme/沪深股票/打板专题数据/当日集合竞价.md)
     */
    public suspend fun getStkAuction(params: StkAuctionParams): List<StkAuctionResult>

    /**
     * 获取最强板块统计数据
     *
     * 调用TuShare API: `limit_cpt_list`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期循环提取
     * **数据说明**: 获取每日最强板块统计，分析板块涨停集中度
     *
     * @param params 最强板块统计查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回最强板块统计数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `concept_name`: 概念名称
     *   - `limit_count`: 涨停数量
     *   - `total_count`: 成分股总数
     *   - `limit_ratio`: 涨停占比
     *   - `avg_pct_chg`: 平均涨幅
     *
     * @see [最强板块统计文档](readme/沪深股票/打板专题数据/最强板块统计.md)
     */
    public suspend fun getLimitCptList(params: LimitCptListParams): List<LimitCptListResult>

    /**
     * 获取涨跌停列表数据（新版）
     *
     * 调用TuShare API: `limit_list_d`
     *
     * **权限要求**: 5000积分每分钟可以请求200次，8000积分以上每分钟500次
     * **数据限制**: 单次最大可以获取1000条数据，可通过日期或者股票循环提取
     * **数据说明**: 获取A股每日涨跌停、炸板数据情况，不提供ST股票的统计
     * **数据起始**: 2020年开始
     *
     * @param params 涨跌停列表查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `ts_code`: 股票代码（可选）
     *   - `limit_type`: 涨跌停类型（可选，U涨停/D跌停/Z炸板）
     *   - `exchange`: 交易所（可选，SH上交所/SZ深交所/BJ北交所）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回涨跌停列表数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `industry`: 所属行业
     *   - `name`: 股票名称
     *   - `close`: 收盘价
     *   - `pct_chg`: 涨跌幅
     *   - `amount`: 成交额
     *   - `limit_amount`: 板上成交金额（涨停无此数据）
     *   - `float_mv`: 流通市值
     *   - `total_mv`: 总市值
     *   - `turnover_ratio`: 换手率
     *   - `fd_amount`: 封单金额
     *   - `first_time`: 首次封板时间（跌停无此数据）
     *   - `last_time`: 最后封板时间
     *   - `open_times`: 炸板次数（跌停为开板次数）
     *   - `up_stat`: 涨停统计（N/T，T天有N次涨停）
     *   - `limit_times`: 连板数
     *   - `limit`: D跌停/U涨停/Z炸板
     *
     * @see [涨跌停列表（新）文档](readme/沪深股票/打板专题数据/涨跌停列表（新）.md)
     */
    public suspend fun getLimitListD(params: LimitListDParams): List<LimitListDResult>

    /**
     * 获取同花顺涨跌停榜单数据
     *
     * 调用TuShare API: `limit_list_ths`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期或股票代码循环提取
     * **数据说明**: 获取同花顺每日涨跌停榜单数据
     *
     * @param params 同花顺涨跌停榜单查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `ts_code`: 股票代码（可选）
     *   - `limit_type`: 涨跌停类型（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回同花顺涨跌停榜单数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `limit_type`: 涨跌停类型
     *   - `pct_chg`: 涨跌幅
     *   - `close`: 收盘价
     *   - `amount`: 成交额
     *   - `turnover_ratio`: 换手率
     *
     * @see [涨跌停榜单（同花顺）文档](readme/沪深股票/打板专题数据/涨跌停榜单（同花顺）.md)
     */
    public suspend fun getLimitListThs(params: LimitListThsParams): List<LimitListThsResult>

    /**
     * 获取游资名录数据
     *
     * 调用TuShare API: `hm_list`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据游资代码循环提取
     * **数据说明**: 获取知名游资（热钱）的基本信息和操作风格
     *
     * @param params 游资名录查询参数，包含以下字段：
     *   - `hm_code`: 游资代码（可选）
     *   - `hm_name`: 游资名称（可选）
     *
     * @return 返回游资名录数据列表，包含以下字段：
     *   - `hm_code`: 游资代码
     *   - `hm_name`: 游资名称
     *   - `seat_name`: 席位名称
     *   - `style`: 操作风格
     *   - `description`: 游资描述
     *
     * @see [游资名录文档](readme/沪深股票/打板专题数据/游资名录.md)
     */
    public suspend fun getHmList(params: HmListParams): List<HmListResult>

    /**
     * 获取游资每日明细数据
     *
     * 调用TuShare API: `hm_detail`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取5000条数据，可根据日期或游资代码循环提取
     * **数据说明**: 获取游资每日交易明细，追踪知名游资操作
     *
     * @param params 游资每日明细查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `hm_code`: 游资代码（可选）
     *   - `ts_code`: 股票代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回游资每日明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: 股票代码
     *   - `name`: 股票名称
     *   - `hm_code`: 游资代码
     *   - `hm_name`: 游资名称
     *   - `buy_amount`: 买入金额
     *   - `sell_amount`: 卖出金额
     *   - `net_amount`: 净买入金额
     *
     * @see [游资每日明细文档](readme/沪深股票/打板专题数据/游资每日明细.md)
     */
    public suspend fun getHmDetail(params: HmDetailParams): List<HmDetailResult>

    /**
     * 获取连板天梯数据
     *
     * 调用TuShare API: `limit_step`
     *
     * **权限要求**: 5000积分以上用户可调用
     * **数据限制**: 单次最大获取1000条数据，可根据日期循环提取
     * **数据说明**: 获取每日连板天梯统计，分析连续涨停板分布情况
     *
     * @param params 连板天梯查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回连板天梯数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `step`: 连板数
     *   - `count`: 股票数量
     *   - `stock_list`: 股票列表
     *   - `total_amount`: 总成交额
     *   - `avg_pct_chg`: 平均涨幅
     *
     * @see [连板天梯文档](readme/沪深股票/打板专题数据/连板天梯.md)
     */
    public suspend fun getLimitStep(params: LimitStepParams): List<LimitStepResult>

    /**
     * 获取龙虎榜机构成交明细数据
     *
     * 调用TuShare API: `top_inst`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次请求返回最大10000行数据，可通过参数循环获取全部历史
     * **数据说明**: 获取龙虎榜机构席位成交明细
     * **数据历史**: 2005年至今
     *
     * @param params 龙虎榜机构成交明细查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（必填，格式：YYYYMMDD）
     *   - `ts_code`: 股票代码（可选）
     *
     * @return 返回龙虎榜机构成交明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS代码
     *   - `exalter`: 机构名称
     *   - `buy`: 买入金额
     *   - `buy_rate`: 买入占总成交比例
     *   - `sell`: 卖出金额
     *   - `sell_rate`: 卖出占总成交比例
     *   - `net_buy`: 净买入金额
     *
     * @see [龙虎榜机构明细文档](readme/沪深股票/打板专题数据/龙虎榜机构明细.md)
     */
    public suspend fun getTopInst(params: TopInstParams): List<TopInstResult>

    /**
     * 获取龙虎榜每日交易明细数据
     *
     * 调用TuShare API: `top_list`
     *
     * **权限要求**: 2000积分以上用户可调用
     * **数据限制**: 单次请求返回最大10000行数据，可通过参数循环获取全部历史
     * **数据说明**: 获取龙虎榜每日交易明细
     * **数据历史**: 2005年至今
     *
     * @param params 龙虎榜每日交易明细查询参数，包含以下字段：
     *   - `trade_date`: 交易日期（必填，格式：YYYYMMDD）
     *   - `ts_code`: 股票代码（可选）
     *
     * @return 返回龙虎榜每日交易明细数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS代码
     *   - `name`: 名称
     *   - `close`: 收盘价
     *   - `pct_change`: 涨跌幅
     *   - `turnover_rate`: 换手率
     *   - `amount`: 总成交额
     *   - `l_sell`: 龙虎榜卖出额
     *   - `l_buy`: 龙虎榜买入额
     *   - `l_amount`: 龙虎榜成交额
     *   - `net_amount`: 龙虎榜净买入额
     *   - `net_rate`: 龙虎榜净买额占比
     *   - `amount_rate`: 龙虎榜成交额占比
     *   - `float_values`: 当日流通市值
     *   - `reason`: 上榜理由
     *
     * @see [龙虎榜每日明细文档](readme/沪深股票/打板专题数据/龙虎榜每日明细.md)
     */
    public suspend fun getTopList(params: TopListParams): List<TopListResult>
}
