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
 * 新闻快讯返回结果
 */
@Serializable
public data class NewsResult(
    /**
     * 新闻发布时间
     */
    @SerialName("datetime")
    @Serializable(with = LocalDateTimeAsStringSerializer::class)
    val datetime: LocalDateTime,
    /**
     * 新闻内容
     */
    @SerialName("content")
    val content: String,
    /**
     * 新闻标题
     */
    @SerialName("title")
    val title: String? = null,
    /**
     * 新闻分类（多个分类用逗号分隔）
     */
    @SerialName("channels")
    val channels: String? = null,
    /**
     * 新闻分数
     */
    val score: Int? = null,
)
