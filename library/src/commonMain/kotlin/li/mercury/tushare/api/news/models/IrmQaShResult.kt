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
package li.mercury.tushare.api.news.models

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateAsStringSerializer
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 上证E互动问答返回结果
 */
@Serializable
public data class IrmQaShResult(
    /**
     * 股票代码
     */
    @SerialName("ts_code")
    val tsCode: String,
    /**
     * 公司名称
     */
    @SerialName("name")
    val name: String,
    /**
     * 日期
     */
    @Serializable(with = LocalDateAsStringSerializer::class)
    @SerialName("trade_date")
    val tradeDate: LocalDate,
    /**
     * 问题
     */
    @SerialName("q")
    val q: String,
    /**
     * 回复
     */
    @SerialName("a")
    val a: String,
    /**
     * 回复时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("pub_time")
    val pubTime: LocalDateTime? = null,
)
