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

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer

/**
 * 同花顺板块指数行情请求参数
 */
@Serializable
public data class ThsDailyParams(
    /**
     * 指数代码
     *
     * 可选参数，示例："865001.TI"
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 交易日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val tradeDate: LocalDate? = null,
    /**
     * 开始日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val startDate: LocalDate? = null,
    /**
     * 结束日期
     *
     * 可选参数，日期格式：YYYYMMDD
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    val endDate: LocalDate? = null,
)
