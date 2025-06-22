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
package li.mercury.tushare.api.stock.character.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 神奇九转指标请求参数
 */
@Serializable
public data class StkNineturnParams(
    /** TS股票代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 交易日期 */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDateTime? = null,
    /** 频率（日/分钟） */
    val freq: FreqEnum? = null,
    /** 开始日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate? = null,
    /** 结束日期 */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate? = null,
)

/**
 * 频率枚举
 */
public enum class FreqEnum {
    /** 日线 */
    @SerialName("daily")
    DAILY,

    /** 60分钟线 */
    @SerialName("60min")
    MIN_60,
}
