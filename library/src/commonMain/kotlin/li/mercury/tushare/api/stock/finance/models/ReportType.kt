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

/**
 * 报告类型枚举
 */
@Serializable
public enum class ReportType {
    /** 合并报表 */
    @SerialName("1")
    CONSOLIDATED,

    /** 单季合并 */
    @SerialName("2")
    SINGLE_QUARTER_CONSOLIDATED,

    /** 调整单季合并表 */
    @SerialName("3")
    ADJUSTED_SINGLE_QUARTER_CONSOLIDATED,

    /** 调整合并报表 */
    @SerialName("4")
    ADJUSTED_CONSOLIDATED,

    /** 调整前合并报表 */
    @SerialName("5")
    PRE_ADJUSTMENT_CONSOLIDATED,

    /** 母公司报表 */
    @SerialName("6")
    PARENT_COMPANY,

    /** 母公司单季表 */
    @SerialName("7")
    PARENT_COMPANY_SINGLE_QUARTER,

    /** 母公司调整单季表 */
    @SerialName("8")
    PARENT_COMPANY_ADJUSTED_SINGLE_QUARTER,

    /** 母公司调整表 */
    @SerialName("9")
    PARENT_COMPANY_ADJUSTED,

    /** 母公司调整前报表 */
    @SerialName("10")
    PARENT_COMPANY_PRE_ADJUSTMENT,

    /** 母公司调整前合并报表 */
    @SerialName("11")
    PARENT_COMPANY_PRE_ADJUSTMENT_CONSOLIDATED,

    /** 母公司调整前报表 */
    @SerialName("12")
    PARENT_COMPANY_PRE_ADJUSTMENT_REPORT,
}
