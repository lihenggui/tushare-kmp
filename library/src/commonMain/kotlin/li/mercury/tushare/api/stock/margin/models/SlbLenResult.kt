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
package li.mercury.tushare.api.stock.margin.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 转融资交易汇总返回对象类
 */
@Serializable
public data class SlbLenResult(
    /** 交易日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /** 期初余额(亿元) */
    val ob: Double? = null,
    /** 竞价成交金额(亿元) */
    @SerialName("auc_amount")
    val aucAmount: Double? = null,
    /** 再借成交金额(亿元) */
    @SerialName("repo_amount")
    val repoAmount: Double? = null,
    /** 偿还金额(亿元) */
    @SerialName("repay_amount")
    val repayAmount: Double? = null,
    /** 期末余额(亿元) */
    val cb: Double? = null,
)
