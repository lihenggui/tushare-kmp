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

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
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
import li.mercury.tushare.http.HttpRequester
import li.mercury.tushare.http.perform
import li.mercury.tushare.models.TuShareRequest
import li.mercury.tushare.utils.toApiParams

/**
 * 新闻相关API的实现类
 */
internal class NewsApi(
    private val requester: HttpRequester,
) : NewsApiInterface {
    /**
     * 实现全量公告数据接口
     * @param params 查询请求
     * @return 返回公告数据
     */
    override suspend fun getAnnsD(params: AnnouncementParams): List<AnnouncementResult> {
        val request =
            TuShareRequest(
                apiName = "anns_d",
                params = params.toApiParams(),
                fields = "ann_date, ts_code, name, title, url, rec_time",
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 实现上证E互动问答接口
     * @param params 查询参数
     * @return 返回问答数据
     */
    override suspend fun getIrmQaSh(params: IrmQaShParams): List<IrmQaShResult> {
        val request =
            TuShareRequest(
                apiName = "irm_qa_sh",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 实现新闻快讯接口
     * @param params 查询参数
     * @return 返回新闻快讯数据
     */
    override suspend fun getNews(params: NewsParams): List<NewsResult> {
        val request =
            TuShareRequest(
                apiName = "news",
                params = params.toApiParams(),
                fields = "datetime, content, title, channels, score",
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 实现新闻联播接口
     * @param params 查询参数
     * @return 返回新闻联播数据
     */
    override suspend fun getCctvNews(params: CctvNewsParams): List<CctvNewsResult> {
        val request =
            TuShareRequest(
                apiName = "cctv_news",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 实现新闻通讯接口
     * @param params 查询参数
     * @return 返回新闻通讯数据
     */
    override suspend fun getMajorNews(params: MajorNewsParams): List<MajorNewsResult> {
        val request =
            TuShareRequest(
                apiName = "major_news",
                params = params.toApiParams(),
                fields = "pub_time, content, title, src, url",
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }

    /**
     * 实现深证互动易问答接口
     * @param params 查询参数
     * @return 返回问答数据
     */
    override suspend fun getIrmQaSz(params: IrmQaSzParams): List<IrmQaSzResult> {
        val request =
            TuShareRequest(
                apiName = "irm_qa_sz",
                params = params.toApiParams(),
            )
        return requester.perform { it.post { setBody(request) }.body() }
    }
}
