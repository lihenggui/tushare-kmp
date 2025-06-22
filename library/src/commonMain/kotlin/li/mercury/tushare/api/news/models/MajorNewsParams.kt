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

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.utils.LocalDateTimeAsStringSerializer

/**
 * 新闻通讯查询参数
 */
@Serializable
public data class MajorNewsParams(
    /**
     * 新闻来源（新华网、凤凰财经、同花顺、新浪财经、华尔街见闻、中证网）
     */
    val src: String? = null,
    /**
     * 新闻发布开始时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDateTime? = null,
    /**
     * 新闻发布结束时间
     */
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDateTime? = null,
)
