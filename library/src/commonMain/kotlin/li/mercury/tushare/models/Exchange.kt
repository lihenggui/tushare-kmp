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
package li.mercury.tushare.models

import kotlinx.serialization.Serializable

/**
 * 交易所代码
 */
@Serializable
public enum class Exchange {
    /** 上交所 */
    SSE,

    /** 深交所 */
    SZSE,

    /** 北交所 */
    BSE,

    /** 港交所 */
    HKEX,

    /** 沪股通（北向） */
    SH,

    /** 深股通（北向） */
    SZ,

    /** 港股通（南向持股） */
    HK,
}
