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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 主营业务构成返回对象类
 */
@Serializable
public data class FinaMainbzResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 报告期 */
    @SerialName("end_date")
    val endDate: String,
    /** 主营业务来源 */
    @SerialName("bz_item")
    val bzItem: String? = null,
    /** 主营业务收入（元） */
    @SerialName("bz_sales")
    val bzSales: Double? = null,
    /** 主营业务利润（元） */
    @SerialName("bz_profit")
    val bzProfit: Double? = null,
    /** 主营业务成本（元） */
    @SerialName("bz_cost")
    val bzCost: Double? = null,
    /** 货币代码 */
    @SerialName("curr_type")
    val currType: String? = null,
    /** 是否更新 */
    @SerialName("update_flag")
    val updateFlag: String? = null,
)
