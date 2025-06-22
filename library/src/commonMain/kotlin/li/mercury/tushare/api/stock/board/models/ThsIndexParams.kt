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
package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

@Serializable
public data class ThsIndexParams(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 市场类型（A- A股，HK- 港股，US- 美股） */
    val exchange: String? = null,
    /** 指数类型 */
    val type: ThsIndexType? = null,
)

/**
 * 同花顺指数类型
 */
public enum class ThsIndexType {
    /** 概念指数 */
    @SerialName("N")
    CONCEPT,

    /** 行业指数 */
    @SerialName("I")
    INDUSTRY,

    /** 地域指数 */
    @SerialName("R")
    REGION,

    /** 同花顺特色指数 */
    @SerialName("S")
    SPECIAL,

    /** 同花顺风格指数 */
    @SerialName("ST")
    STYLE,

    /** 同花顺主题指数 */
    @SerialName("TH")
    THEME,

    /** 同花顺宽基指数 */
    @SerialName("BB")
    BROAD_BASED,
}
