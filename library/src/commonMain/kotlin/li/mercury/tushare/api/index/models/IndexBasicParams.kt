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
package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable
import li.mercury.tushare.models.Market
import li.mercury.tushare.models.TsCode

/**
 * 指数基本信息API请求参数
 */
@Serializable
public data class IndexBasicParams(
    /** 指数代码 */
    val tsCode: TsCode? = null,
    /** 指数简称 */
    val name: String? = null,
    /** 交易所或服务商，如SSE（上交所）, SZSE（深交所）等，默认SSE */
    val market: Market? = null,
    /** 发布商，如申万、中证等 */
    val publisher: String? = null,
    /** 指数类别，如主题指数、行业指数等 */
    val category: IndexCategory? = null,
)
