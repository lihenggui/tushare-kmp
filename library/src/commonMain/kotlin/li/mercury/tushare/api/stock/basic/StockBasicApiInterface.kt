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
 * 股票基础数据API接口
 * 
 * 提供获取股票基础信息的各种接口，包括股票基本信息、公司信息、
 * 管理层信息、交易日历、新股发行等数据。这些接口是股票分析和投资决策的基础。
 * 
 * ## 主要功能
 * - **股票基本信息** - 获取A股市场所有股票的基本信息
 * - **公司信息** - 获取上市公司的详细信息  
 * - **管理层信息** - 获取公司管理层和薪酬信息
 * - **交易日历** - 获取股票市场的交易日历
 * - **沪深股通** - 获取沪深港通标的股票信息
 * - **新股发行** - 获取IPO新股信息
 * - **历史数据** - 获取历史股票列表信息
 * 
 * ```kotlin
 * // 获取所有A股基本信息
 * val allStocks = tuShare.getStockBasic(
 *     StockBasicParams(isHs = "N", listStatus = "L")
 * )
 * 
 * // 获取特定股票信息
 * val stock = tuShare.getStockBasic(
 *     StockBasicParams(tsCode = "000001.SZ")
 * )
 * 
 * // 获取交易日历
 * val tradeCal = tuShare.getTradeCal(
 *     TradeCalParams(startDate = "20240101", endDate = "20241231")
 * )
 * ```
 * 
 * @see StockBasicResult 股票基本信息数据结构
 * @see StockCompanyResult 公司信息数据结构
 * @see TradeCalResult 交易日历数据结构
 */
public interface StockBasicApiInterface {
    /**
     * 获取股票基本信息
     * 
     * 获取A股市场股票基本信息，包括股票代码、名称、上市日期、
     * 退市日期、行业分类、地区等基础信息。支持按多种条件筛选。
     * 
     * **数据更新:** 每日更新，一般在早上9点前完成
     * **数据权重:** 免费
     * 
     * @param params 查询参数，包含筛选条件
     * @return 股票基本信息列表
     * 
     * ```kotlin
     * // 获取所有在市A股
     * val allStocks = tuShare.getStockBasic(
     *     StockBasicParams(isHs = "N", listStatus = "L")
     * )
     * 
     * // 获取特定股票
     * val stock = tuShare.getStockBasic(
     *     StockBasicParams(tsCode = "000001.SZ")
     * )
     * 
     * // 获取深交所股票
     * val szStocks = tuShare.getStockBasic(
     *     StockBasicParams(exchange = "SZSE")
     * )
     * ```
     * 
     * @see StockBasicParams 查询参数说明
     * @see StockBasicResult 返回数据结构
     */
    public suspend fun getStockBasic(params: StockBasicParams): List<StockBasicResult>

    /**
     * 获取股本情况（盘前）数据
     * 
     * 获取上市公司的股本结构信息，包括总股本、流通股本、
     * 限售股本等数据。通常在盘前更新。
     * 
     * **数据更新:** 每日盘前更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 股本情况数据列表
     * 
     * ```kotlin
     * val stockCap = tuShare.getStkPremarket(
     *     StkPremarketParams(tsCode = "000001.SZ")
     * )
     * ```
     */
    public suspend fun getStkPremarket(params: StkPremarketParams): List<StkPremarketResult>

    /**
     * 获取交易日历数据
     * 
     * 获取股票市场的交易日历信息，包括交易日、非交易日的标识。
     * 用于判断某个日期是否为交易日。
     * 
     * **数据更新:** 每年年初更新全年数据
     * **数据权重:** 免费
     * 
     * @param params 查询参数，包含日期范围
     * @return 交易日历数据列表
     * 
     * ```kotlin
     * // 获取2024年交易日历
     * val calendar = tuShare.getTradeCal(
     *     TradeCalParams(startDate = "20240101", endDate = "20241231")
     * )
     * 
     * // 获取指定交易所日历
     * val sseCalendar = tuShare.getTradeCal(
     *     TradeCalParams(exchange = "SSE", startDate = "20240101")
     * )
     * ```
     */
    public suspend fun getTradeCal(params: TradeCalParams): List<TradeCalResult>

    /**
     * 获取股票曾用名信息
     * 
     * 获取股票的历史名称变更记录，包括更名日期、曾用名称等信息。
     * 
     * **数据更新:** 不定期更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 股票曾用名信息列表
     * 
     * ```kotlin
     * val nameHistory = tuShare.getNameChange(
     *     NameChangeParams(tsCode = "000001.SZ")
     * )
     * ```
     */
    public suspend fun getNameChange(params: NameChangeParams): List<NameChangeResult>

    /**
     * 获取沪深股通成份股数据
     * 
     * 获取沪深港通标的股票信息，包括沪股通、深股通的成份股列表。
     * 
     * **数据更新:** 不定期更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 沪深股通成份股数据列表
     * 
     * ```kotlin
     * // 获取沪股通成份股
     * val hkStocks = tuShare.getHsConst(
     *     HsConstParams(hsType = "SH")
     * )
     * ```
     */
    public suspend fun getHsConst(params: HsConstParams): List<HsConstResult>

    /**
     * 获取上市公司基本信息
     * 
     * 获取上市公司的详细信息，包括公司全称、英文名称、
     * 注册地址、办公地址、联系方式、经营范围等。
     * 
     * **数据更新:** 不定期更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 上市公司基本信息列表
     * 
     * ```kotlin
     * val companyInfo = tuShare.getStockCompany(
     *     StockCompanyParams(tsCode = "000001.SZ")
     * )
     * ```
     */
    public suspend fun getStockCompany(params: StockCompanyParams): List<StockCompanyResult>

    /**
     * 获取上市公司管理层信息
     * 
     * 获取上市公司的管理层人员信息，包括姓名、职务、
     * 性别、年龄、学历、任职起始日期等。
     * 
     * **数据更新:** 不定期更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 上市公司管理层信息列表
     * 
     * ```kotlin
     * val managers = tuShare.getStkManagers(
     *     StkManagersParams(tsCode = "000001.SZ")
     * )
     * ```
     */
    public suspend fun getStkManagers(params: StkManagersParams): List<StkManagersResult>

    /**
     * 获取上市公司管理层薪酬和持股情况
     * 
     * 获取上市公司管理层的薪酬水平和持股情况，
     * 包括年度薪酬、持股数量、持股比例等信息。
     * 
     * **数据更新:** 年度更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 管理层薪酬和持股情况列表
     * 
     * ```kotlin
     * val rewards = tuShare.getStkRewards(
     *     StkRewardsParams(tsCode = "000001.SZ", endDate = "20231231")
     * )
     * ```
     */
    public suspend fun getStkRewards(params: StkRewardsParams): List<StkRewardsResult>

    /**
     * 获取IPO新股列表数据
     * 
     * 获取新股发行信息，包括股票代码、名称、发行日期、
     * 发行价格、发行数量、中签率等IPO相关信息。
     * 
     * **数据更新:** 实时更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return IPO新股列表数据
     * 
     * ```kotlin
     * // 获取最近的新股发行信息
     * val newShares = tuShare.getNewShare(
     *     NewShareParams(startDate = "20240101", endDate = "20241231")
     * )
     * ```
     */
    public suspend fun getNewShare(params: NewShareParams): List<NewShareResult>

    /**
     * 获取备用基础列表（历史每天股票列表）
     * 
     * 获取历史每个交易日的股票列表，用于回溯分析。
     * 记录每个交易日有哪些股票在交易。
     * 
     * **数据更新:** 每日更新
     * **数据权重:** 免费
     * 
     * @param params 查询参数
     * @return 历史股票列表数据
     * 
     * ```kotlin
     * val historicalStocks = tuShare.getBakBasic(
     *     BakBasicParams(tradeDate = "20240101")
     * )
     * ```
     */
    public suspend fun getBakBasic(params: BakBasicParams): List<BakBasicResult>
}
