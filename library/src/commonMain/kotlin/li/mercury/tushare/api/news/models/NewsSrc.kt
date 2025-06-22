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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 新闻来源枚举
 */
@Serializable
public enum class NewsSrc {
    /** 新浪财经 */
    @SerialName("sina")
    SINA,

    /** 华尔街见闻 */
    @SerialName("wallstreetcn")
    WALLSTREETCN,

    /** 同花顺 */
    @SerialName("10jqka")
    JQKA,

    /** 东方财富 */
    @SerialName("eastmoney")
    EASTMONEY,

    /** 云财经 */
    @SerialName("yuncaijing")
    YUNCAIJING,

    /** 凤凰新闻 */
    @SerialName("fenghuang")
    FENGHUANG,

    /** 金融界 */
    @SerialName("jinrongjie")
    JINRONGJIE,
}
