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
package li.mercury.tushare.api.stock.basic

import li.mercury.tushare.api.stock.basic.models.BakBasicParams
import li.mercury.tushare.api.stock.basic.models.BakBasicResult
import li.mercury.tushare.api.stock.basic.models.HsConstParams
import li.mercury.tushare.api.stock.basic.models.HsConstResult
import li.mercury.tushare.api.stock.basic.models.NameChangeParams
import li.mercury.tushare.api.stock.basic.models.NameChangeResult
import li.mercury.tushare.api.stock.basic.models.NewShareParams
import li.mercury.tushare.api.stock.basic.models.NewShareResult
import li.mercury.tushare.api.stock.basic.models.StkManagersParams
import li.mercury.tushare.api.stock.basic.models.StkManagersResult
import li.mercury.tushare.api.stock.basic.models.StkPremarketParams
import li.mercury.tushare.api.stock.basic.models.StkPremarketResult
import li.mercury.tushare.api.stock.basic.models.StkRewardsParams
import li.mercury.tushare.api.stock.basic.models.StkRewardsResult
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.basic.models.StockBasicResult
import li.mercury.tushare.api.stock.basic.models.StockCompanyParams
import li.mercury.tushare.api.stock.basic.models.StockCompanyResult
import li.mercury.tushare.api.stock.basic.models.TradeCalParams
import li.mercury.tushare.api.stock.basic.models.TradeCalResult

/**
 * 股票基础数据相关API的存储库接口
 * 
 * 提供股票基本信息、股本数据、交易日历、公司管理层信息等基础数据的访问，
 * 涵盖沪深两市及北交所的股票基础信息数据
 */
public interface StockBasicApiInterface {
    /**
     * 获取股票基本信息
     * 
     * 调用TuShare API: `stock_basic`
     * 
     * **权限要求**: 2000积分起
     * **数据说明**: 获取基础信息数据，包括股票代码、名称、上市日期、退市日期等
     * **使用建议**: 此接口是基础信息，调取一次即可拉取完，建议保存到本地存储后使用
     * 
     * **支持的市场类型**:
     * - 主板/创业板/科创板/CDR/北交所
     * 
     * **支持的交易所**:
     * - `SSE`: 上交所
     * - `SZSE`: 深交所  
     * - `BSE`: 北交所
     * 
     * @param params 股票基本信息查询参数，包含以下字段：
     *   - `ts_code`: TS股票代码（可选）
     *   - `name`: 名称（可选）
     *   - `market`: 市场类别（可选，主板/创业板/科创板/CDR/北交所）
     *   - `list_status`: 上市状态（可选，L上市/D退市/P暂停上市，默认L）
     *   - `exchange`: 交易所（可选，SSE上交所/SZSE深交所/BSE北交所）
     *   - `is_hs`: 是否沪深港通标的（可选，N否/H沪股通/S深股通）
     * 
     * @return 返回股票基本信息列表，包含以下字段：
     *   - `ts_code`: TS代码
     *   - `symbol`: 股票代码
     *   - `name`: 股票名称
     *   - `area`: 地域
     *   - `industry`: 所属行业
     *   - `fullname`: 股票全称
     *   - `enname`: 英文全称
     *   - `cnspell`: 拼音缩写
     *   - `market`: 市场类型（主板/创业板/科创板/CDR）
     *   - `exchange`: 交易所代码
     *   - `curr_type`: 交易货币
     *   - `list_status`: 上市状态（L上市/D退市/P暂停上市）
     *   - `list_date`: 上市日期
     *   - `delist_date`: 退市日期
     *   - `is_hs`: 是否沪深港通标的（N否/H沪股通/S深股通）
     *   - `act_name`: 实控人名称
     *   - `act_ent_type`: 实控人企业性质
     * 
     * @see [股票基本信息文档](https://tushare.pro/document/2?doc_id=25)
     */
    public suspend fun getStockBasic(params: StockBasicParams): List<StockBasicResult>

    /**
     * 获取股本情况（盘前）数据
     * 
     * 调用TuShare API: `stk_premarket`
     * 
     * **权限要求**: 与积分无关，需单独开权限
     * **数据限制**: 单次最大8000条数据，可循环提取
     * **数据说明**: 每日开盘前获取当日股票的股本情况，包括总股本和流通股本，涨跌停价格等
     * 
     * @param params 股本情况查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回股本情况数据列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS股票代码
     *   - `total_share`: 总股本（万股）
     *   - `float_share`: 流通股本（万股）
     *   - `pre_close`: 昨日收盘价
     *   - `up_limit`: 今日涨停价
     *   - `down_limit`: 今日跌停价
     * 
     * @see [股本情况文档](https://tushare.pro/document/2?doc_id=282)
     */
    public suspend fun getStkPremarket(params: StkPremarketParams): List<StkPremarketResult>

    /**
     * 获取交易日历数据
     * 
     * 调用TuShare API: `trade_cal`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取各大交易所交易日历数据，默认提取的是上交所
     * 
     * **支持的交易所**:
     * - `SSE`: 上交所
     * - `SZSE`: 深交所
     * - `CFFEX`: 中金所
     * - `SHFE`: 上期所
     * - `CZCE`: 郑商所
     * - `DCE`: 大商所
     * - `INE`: 上能源
     * 
     * @param params 交易日历查询参数，包含以下字段：
     *   - `exchange`: 交易所（可选，默认空为上交所）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `is_open`: 是否交易（可选，0休市/1交易）
     * 
     * @return 返回交易日历数据列表，包含以下字段：
     *   - `exchange`: 交易所
     *   - `cal_date`: 日历日期
     *   - `is_open`: 是否交易（0休市/1交易）
     *   - `pretrade_date`: 上一个交易日
     * 
     * @see [交易日历文档](https://tushare.pro/document/2?doc_id=26)
     */
    public suspend fun getTradeCal(params: TradeCalParams): List<TradeCalResult>

    /**
     * 获取股票曾用名信息
     * 
     * 调用TuShare API: `namechange`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 历史名称变更记录
     * 
     * @param params 股票曾用名查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回股票曾用名列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `name`: 证券名称
     *   - `start_date`: 开始日期
     *   - `end_date`: 结束日期
     *   - `ann_date`: 公告日期
     *   - `change_reason`: 变更原因
     * 
     * @see [股票曾用名文档](https://tushare.pro/document/2?doc_id=100)
     */
    public suspend fun getNameChange(params: NameChangeParams): List<NameChangeResult>

    /**
     * 获取沪深股通成份股数据
     * 
     * 调用TuShare API: `hs_const`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取沪股通、深股通成分股数据
     * 
     * @param params 沪深股通成份股查询参数，包含以下字段：
     *   - `hs_type`: 沪深股通类型（可选，SH沪股通/SZ深股通）
     *   - `is_new`: 是否最新（可选，1是/0否）
     * 
     * @return 返回沪深股通成份股数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `hs_type`: 沪深股通类型（SH沪股通/SZ深股通）
     *   - `in_date`: 纳入日期
     *   - `out_date`: 剔除日期
     *   - `is_new`: 是否最新
     * 
     * @see [沪深股通成份股文档](https://tushare.pro/document/2?doc_id=104)
     */
    public suspend fun getHsConst(params: HsConstParams): List<HsConstResult>

    /**
     * 获取上市公司基本信息
     * 
     * 调用TuShare API: `stock_company`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取上市公司基本信息，包括公司名称、办公地址、网站、业务范围等
     * 
     * @param params 上市公司基本信息查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `exchange`: 交易所（可选）
     * 
     * @return 返回上市公司基本信息列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `exchange`: 交易所代码
     *   - `chairman`: 法人代表
     *   - `manager`: 总经理
     *   - `secretary`: 董秘
     *   - `reg_capital`: 注册资本
     *   - `setup_date`: 注册日期
     *   - `province`: 所在省份
     *   - `city`: 所在城市
     *   - `introduction`: 公司介绍
     *   - `website`: 公司主页
     *   - `email`: 电子邮件
     *   - `office`: 办公室
     *   - `employees`: 员工人数
     *   - `main_business`: 主要业务及产品
     *   - `business_scope`: 经营范围
     * 
     * @see [上市公司基本信息文档](https://tushare.pro/document/2?doc_id=112)
     */
    public suspend fun getStockCompany(params: StockCompanyParams): List<StockCompanyResult>

    /**
     * 获取上市公司管理层信息
     * 
     * 调用TuShare API: `stk_managers`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取上市公司管理层人员信息，包括高管姓名、性别、学历、任职情况等
     * 
     * @param params 管理层信息查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回管理层信息列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `name`: 姓名
     *   - `gender`: 性别
     *   - `lev`: 岗位类别
     *   - `title`: 岗位
     *   - `edu`: 学历
     *   - `national`: 国籍
     *   - `begin_date`: 上任日期
     *   - `end_date`: 离任日期
     *   - `resume`: 个人简历
     * 
     * @see [上市公司管理层文档](https://tushare.pro/document/2?doc_id=114)
     */
    public suspend fun getStkManagers(params: StkManagersParams): List<StkManagersResult>

    /**
     * 获取上市公司管理层薪酬和持股情况
     * 
     * 调用TuShare API: `stk_rewards`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取上市公司管理层的薪酬和持股情况
     * 
     * @param params 管理层薪酬持股查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `end_date`: 报告期（可选，格式：YYYYMMDD）
     * 
     * @return 返回管理层薪酬持股列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `end_date`: 截止日期
     *   - `name`: 姓名
     *   - `title`: 职务
     *   - `reward`: 报酬
     *   - `hold_vol`: 持股数
     * 
     * @see [管理层薪酬和持股文档](https://tushare.pro/document/2?doc_id=115)
     */
    public suspend fun getStkRewards(params: StkRewardsParams): List<StkRewardsResult>

    /**
     * 获取IPO新股列表数据
     * 
     * 调用TuShare API: `new_share`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 获取新股上市列表数据
     * 
     * @param params IPO新股查询参数，包含以下字段：
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回IPO新股列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `sub_code`: 申购代码
     *   - `name`: 名称
     *   - `ipo_date`: 上网发行日期
     *   - `issue_date`: 上市日期
     *   - `amount`: 发行总量（万股）
     *   - `market_amount`: 上网发行总量（万股）
     *   - `price`: 发行价格
     *   - `pe`: 市盈率
     *   - `limit_amount`: 个人申购上限（万股）
     *   - `funds`: 募集资金（万元）
     *   - `ballot`: 中签率
     * 
     * @see [IPO新股列表文档](https://tushare.pro/document/2?doc_id=123)
     */
    public suspend fun getNewShare(params: NewShareParams): List<NewShareResult>

    /**
     * 备用基础列表（历史每天股票列表）
     * 
     * 调用TuShare API: `bak_basic`
     * 
     * **权限要求**: 需2000积分
     * **数据说明**: 备用行情，包含了前复权数据
     * 
     * @param params 备用基础列表查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `trade_date`: 交易日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     * 
     * @return 返回备用基础列表，包含以下字段：
     *   - `trade_date`: 交易日期
     *   - `ts_code`: TS股票代码
     *   - `name`: 股票名称
     *   - `industry`: 所属行业
     *   - `area`: 地域
     *   - `pe`: 市盈率（动）
     *   - `float_share`: 流通股本（万）
     *   - `total_share`: 总股本（万）
     *   - `total_assets`: 总资产（万）
     *   - `liquid_assets`: 流动资产
     *   - `fixed_assets`: 固定资产
     *   - `reserved`: 公积金
     *   - `reserved_pershare`: 每股公积金
     *   - `eps`: 每股收益
     *   - `bvps`: 每股净资产
     *   - `pb`: 市净率
     *   - `list_date`: 上市日期
     *   - `undp`: 未分利润
     *   - `per_undp`: 每股未分配
     *   - `rev_yoy`: 收入同比（%）
     *   - `profit_yoy`: 利润同比（%）
     *   - `gpr`: 毛利率（%）
     *   - `npr`: 净利润率（%）
     *   - `holder_num`: 股东人数
     * 
     * @see [备用基础列表文档](https://tushare.pro/document/2?doc_id=143)
     */
    public suspend fun getBakBasic(params: BakBasicParams): List<BakBasicResult>
}
