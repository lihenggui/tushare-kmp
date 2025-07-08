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
package li.mercury.tushare.api.stock.reference.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 股权质押明细返回对象类
 */
@Serializable
public data class PledgeDetailResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate? = null,
    /** 股东名称 */
    @SerialName("holder_name")
    val holderName: String? = null,
    /** 质押数量（万股） */
    @SerialName("pledge_amount")
    val pledgeAmount: Float? = null,
    /** a质押开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 质押结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
    /** 是否已解押 */
    @SerialName("is_release")
    val isRelease: Int? = null,
    /** 解押日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("release_date")
    val releaseDate: LocalDate? = null,
    /** 质押方 */
    val pledgor: String? = null,
    /** 持股总数（万股） */
    @SerialName("holding_amount")
    val holdingAmount: Float? = null,
    /** 质押总数（万股） */
    @SerialName("pledged_amount")
    val pledgedAmount: Float? = null,
    /** 本次质押占总股本比例（%） */
    @SerialName("p_total_ratio")
    val pTotalRatio: Float? = null,
    /** 持股总数占总股本比例（%） */
    @SerialName("h_total_ratio")
    val hTotalRatio: Float? = null,
    /** 是否回购 */
    @SerialName("is_buyback")
    val isBuyback: Int? = null,
)
