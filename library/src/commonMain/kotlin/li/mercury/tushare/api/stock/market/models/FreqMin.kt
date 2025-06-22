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
package li.mercury.tushare.api.stock.market.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 分钟行情频率枚举类
 */
@Serializable
public enum class FreqMin {
    /** 1分钟频率 */
    @SerialName("1min")
    MIN_1,

    /** 5分钟频率 */
    @SerialName("5min")
    MIN_5,

    /** 15分钟频率 */
    @SerialName("15min")
    MIN_15,

    /** 30分钟频率 */
    @SerialName("30min")
    MIN_30,

    /** 60分钟频率 */
    @SerialName("60min")
    MIN_60,
}
