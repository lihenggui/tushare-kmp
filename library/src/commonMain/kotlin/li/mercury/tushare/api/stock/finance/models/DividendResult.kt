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
 * 分红送股返回结果
 */
@Serializable
public data class DividendResult(
    /** TS代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 分红年度 */
    @SerialName("end_date")
    val endDate: String? = null,
    /** 预案公告日 */
    @SerialName("ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val annDate: LocalDate? = null,
    /** 实施进度 */
    @SerialName("div_proc")
    val divProc: String? = null,
    /** 每股送转 */
    @SerialName("stk_div")
    val stkDiv: Float? = null,
    /** 每股送股比例 */
    @SerialName("stk_bo_rate")
    val stkBoRate: Float? = null,
    /** 每股转增比例 */
    @SerialName("stk_co_rate")
    val stkCoRate: Float? = null,
    /** 每股分红（税后） */
    @SerialName("cash_div")
    val cashDiv: Float? = null,
    /** 每股分红（税前） */
    @SerialName("cash_div_tax")
    val cashDivTax: Float? = null,
    /** 股权登记日 */
    @SerialName("record_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val recordDate: LocalDate? = null,
    /** 除权除息日 */
    @SerialName("ex_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val exDate: LocalDate? = null,
    /** 派息日 */
    @SerialName("pay_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val payDate: LocalDate? = null,
    /** 红股上市日 */
    @SerialName("div_listdate")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val divListdate: LocalDate? = null,
    /** 实施公告日 */
    @SerialName("imp_ann_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val impAnnDate: LocalDate? = null,
    /** 基准日 */
    @SerialName("base_date")
    @Serializable(with = LocalDateAsStringSerializer::class)
    val baseDate: LocalDate? = null,
    /** 基准股本（万） */
    @SerialName("base_share")
    val baseShare: Float? = null,
)
