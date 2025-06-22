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
 * 公司类型枚举
 */
@Serializable
public enum class CompType {
    /** 一般工商业 */
    @SerialName("1")
    GENERAL,

    /** 银行 */
    @SerialName("2")
    BANK,

    /** 保险 */
    @SerialName("3")
    INSURANCE,

    /** 证券 */
    @SerialName("4")
    SECURITIES,
}
