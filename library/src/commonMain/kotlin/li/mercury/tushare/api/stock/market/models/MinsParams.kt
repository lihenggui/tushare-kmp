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

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 股票分钟行情API请求参数
 */
@Serializable
public data class MinsParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode,
    /** 分钟频率（1min/5min/15min/30min/60min） */
    val freq: FreqMin,
    /** 开始日期（格式：YYYY-MM-DD HH:MM:SS） */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDateTime? = null,
    /** 结束日期（格式：YYYY-MM-DD HH:MM:SS） */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDateTime? = null,
)
