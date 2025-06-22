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
 * 新闻通讯返回结果
 */
@Serializable
public data class MajorNewsResult(
    /**
     * 标题
     */
    val title: String,
    /**
     * 内容
     */
    val content: String? = null,
    /**
     * 发布时间
     */
    @SerialName("pub_time")
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    val pubTime: LocalDateTime,
    /**
     * 来源网站
     */
    val src: String,
)
