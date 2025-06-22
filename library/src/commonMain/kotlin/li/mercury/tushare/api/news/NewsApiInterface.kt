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
package li.mercury.tushare.api.news

import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.AnnouncementResult
import li.mercury.tushare.api.news.models.CctvNewsParams
import li.mercury.tushare.api.news.models.CctvNewsResult
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaShResult
import li.mercury.tushare.api.news.models.IrmQaSzParams
import li.mercury.tushare.api.news.models.IrmQaSzResult
import li.mercury.tushare.api.news.models.MajorNewsParams
import li.mercury.tushare.api.news.models.MajorNewsResult
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.api.news.models.NewsResult

/**
 * 新闻相关API的存储库接口
 */
public interface NewsApiInterface {
    /**
     * 获取全量公告数据
     */
    public suspend fun getAnnsD(params: AnnouncementParams): List<AnnouncementResult>

    /**
     * 获取上证E互动问答数据
     */
    public suspend fun getIrmQaSh(params: IrmQaShParams): List<IrmQaShResult>

    /**
     * 获取新闻快讯数据
     */
    public suspend fun getNews(params: NewsParams): List<NewsResult>

    /**
     * 获取新闻联播数据
     */
    public suspend fun getCctvNews(params: CctvNewsParams): List<CctvNewsResult>

    /**
     * 获取长篇通讯信息
     */
    public suspend fun getMajorNews(params: MajorNewsParams): List<MajorNewsResult>

    /**
     * 获取深证互动易问答数据
     */
    public suspend fun getIrmQaSz(params: IrmQaSzParams): List<IrmQaSzResult>
}
