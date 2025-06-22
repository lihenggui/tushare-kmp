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
package li.mercury.tushare.api.stock.finance.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 业绩预告返回结果
 */
@Serializable
public data class ForecastResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 公告日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ann_date")
    val annDate: LocalDate,
    /** 报告期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate,
    /** 业绩预告类型(预增/预减/扭亏/首亏/续亏/续盈/略增/略减) */
    val type: ForecastType,
    /** 预告净利润变动幅度下限(%) */
    @SerialName("p_change_min")
    val pChangeMin: Float? = null,
    /** 预告净利润变动幅度上限(%) */
    @SerialName("p_change_max")
    val pChangeMax: Float? = null,
    /** 预告净利润下限(万元) */
    @SerialName("net_profit_min")
    val netProfitMin: Float? = null,
    /** 预告净利润上限(万元) */
    @SerialName("net_profit_max")
    val netProfitMax: Float? = null,
    /** 上年同期归属母公司净利润 */
    @SerialName("last_parent_net")
    val lastParentNet: Float? = null,
    /** 首次公告日 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("first_ann_date")
    val firstAnnDate: LocalDate? = null,
    /** 业绩预告摘要 */
    val summary: String? = null,
    /** 业绩变动原因 */
    @SerialName("change_reason")
    val changeReason: String? = null,
)
