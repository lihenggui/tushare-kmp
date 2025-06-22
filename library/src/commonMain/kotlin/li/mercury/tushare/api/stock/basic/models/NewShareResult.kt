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
package li.mercury.tushare.api.stock.basic.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * IPO新股列表返回对象类
 */
@Serializable
public data class NewShareResult(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 申购代码 */
    @SerialName("sub_code")
    val subCode: String,
    /** 名称 */
    val name: String,
    /** 上网发行日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("ipo_date")
    val ipoDate: LocalDate,
    /** 上市日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("issue_date")
    val issueDate: LocalDate? = null,
    /** 发行总量（万股） */
    val amount: Float? = null,
    /** 上网发行总量（万股） */
    @SerialName("market_amount")
    val marketAmount: Float? = null,
    /** 发行价格 */
    val price: Float? = null,
    /** 市盈率 */
    val pe: Float? = null,
    /** 个人申购上限（万股） */
    @SerialName("limit_amount")
    val limitAmount: Float? = null,
    /** 募集资金（亿元） */
    val funds: Float? = null,
    /** 中签率 */
    val ballot: Float? = null,
)
