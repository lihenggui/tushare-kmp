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
 * 股票打版专题数据相关API接口
 */
public interface StockBoardApiInterface {
    /**
     * 获取东方财富板块成分
     * @param params 请求参数
     * @return 东方财富板块成分数据
     */
    public suspend fun getDcMember(params: DcMemberParams): List<DcMemberResult>

    /**
     * 获取东方财富概念板块数据
     * @param params 请求参数
     * @return 东方财富概念板块数据
     */
    public suspend fun getDcIndex(params: DcIndexParams): List<DcIndexResult>

    /**
     * 获取东方财富热板数据
     * @param params 请求参数
     * @return 东方财富热板数据
     */
    public suspend fun getDcHot(params: DcHotParams): List<DcHotResult>

    /**
     * 获取同花顺概念和行业指数
     * @param params 请求参数
     * @return 同花顺概念和行业指数数据
     */
    public suspend fun getThsIndex(params: ThsIndexParams): List<ThsIndexResult>

    /**
     * 获取同花顺概念板块成分
     * @param params 请求参数
     * @return 同花顺概念板块成分数据
     */
    public suspend fun getThsMember(params: ThsMemberParams): List<ThsMemberResult>

    /**
     * 获取同花顺热榜数据
     * @param params 请求参数
     * @return 同花顺热榜数据
     */
    public suspend fun getThsHot(params: ThsHotParams): List<ThsHotResult>

    /**
     * 获取开盘啦榜单数据
     * @param params 请求参数
     * @return 开盘啦榜单数据
     */
    public suspend fun getKplList(params: KplListParams): List<KplListResult>

    /**
     * 获取开盘啦题材库数据
     * @param params 请求参数
     * @return 开盘啦题材库数据
     */
    public suspend fun getKplConcept(params: KplConceptParams): List<KplConceptResult>

    /**
     * 获取开盘啦题材成分数据
     * @param params 请求参数
     * @return 开盘啦题材成分数据
     */
    public suspend fun getKplConceptCons(params: KplConceptConsParams): List<KplConceptConsResult>

    /**
     * 获取当日集合竞价数据
     * @param params 请求参数
     * @return 当日集合竞价数据
     */
    public suspend fun getStkAuction(params: StkAuctionParams): List<StkAuctionResult>

    /**
     * 获取最强板块统计数据
     * @param params 请求参数
     * @return 最强板块统计数据
     */
    public suspend fun getLimitCptList(params: LimitCptListParams): List<LimitCptListResult>

    /**
     * 获取涨跌停列表数据（新）
     * @param params 请求参数
     * @return 涨跌停列表数据
     */
    public suspend fun getLimitListD(params: LimitListDParams): List<LimitListDResult>

    /**
     * 获取同花顺每日涨跌停榜单数据
     * @param params 请求参数
     * @return 同花顺涨跌停榜单数据
     */
    public suspend fun getLimitListThs(params: LimitListThsParams): List<LimitListThsResult>

    /**
     * 获取游资名录数据
     * @param params 请求参数
     * @return 游资名录数据
     */
    public suspend fun getHmList(params: HmListParams): List<HmListResult>

    /**
     * 获取游资每日明细数据
     * @param params 请求参数
     * @return 游资每日明细数据
     */
    public suspend fun getHmDetail(params: HmDetailParams): List<HmDetailResult>

    /**
     * 获取连板天梯数据
     * @param params 请求参数
     * @return 连板天梯数据
     */
    public suspend fun getLimitStep(params: LimitStepParams): List<LimitStepResult>

    /**
     * 获取龙虎榜机构成交明细
     * @param params 请求参数
     * @return 龙虎榜机构成交明细数据
     */
    public suspend fun getTopInst(params: TopInstParams): List<TopInstResult>

    /**
     * 获取龙虎榜每日交易明细
     * @param params 请求参数
     * @return 龙虎榜每日交易明细数据
     */
    public suspend fun getTopList(params: TopListParams): List<TopListResult>
}
