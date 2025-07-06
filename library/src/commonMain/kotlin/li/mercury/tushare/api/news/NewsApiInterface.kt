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
 * 新闻快讯和公告相关API的存储库接口
 *
 * 提供获取各类新闻资讯、公告、互动问答等数据的功能
 */
public interface NewsApiInterface {
    /**
     * 获取上市公司全量公告数据
     *
     * 调用TuShare API: `anns`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大5000条公告，可根据时间参数循环提取历史数据
     *
     * @param params 公告查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `ann_date`: 公告日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `year`: 年份（可选）
     *   - `ann_type`: 公告类型（可选）
     *
     * @return 返回公告数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `ann_date`: 公告日期
     *   - `ann_type`: 公告类型
     *   - `title`: 公告标题
     *   - `content`: 公告内容
     *   - `pub_time`: 发布时间
     *
     * @see [上市公司全量公告文档](https://tushare.pro/document/2?doc_id=25)
     */
    public suspend fun getAnnsD(params: AnnouncementParams): List<AnnouncementResult>

    /**
     * 获取上证E互动问答数据
     *
     * 调用TuShare API: `irm_qa_sh`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大1000条记录，可根据时间参数循环提取历史数据
     *
     * @param params 上证E互动查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `pub_date`: 发布日期（可选，格式：YYYYMMDD）
     *
     * @return 返回上证E互动问答数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `pub_date`: 发布日期
     *   - `title`: 问答标题
     *   - `question`: 问题内容
     *   - `answer`: 回答内容
     *   - `qtype`: 问题类型
     *
     * @see [上证E互动文档](https://tushare.pro/document/2?doc_id=26)
     */
    public suspend fun getIrmQaSh(params: IrmQaShParams): List<IrmQaShResult>

    /**
     * 获取新闻快讯数据
     *
     * 调用TuShare API: `news`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大1500条新闻，可根据时间参数循环提取历史数据
     *
     * **支持的新闻来源**:
     * - `sina`: 新浪财经
     * - `wallstreetcn`: 华尔街见闻
     * - `10jqka`: 同花顺
     * - `eastmoney`: 东方财富
     * - `yuncaijing`: 云财经
     * - `fenghuang`: 凤凰新闻
     * - `jinrongjie`: 金融界
     *
     * @param params 新闻查询参数，包含以下字段：
     *   - `start_date`: 开始日期（必填，格式：YYYY-MM-DD HH:MM:SS）
     *   - `end_date`: 结束日期（必填，格式：YYYY-MM-DD HH:MM:SS）
     *   - `src`: 新闻来源（必填，见上述支持的来源）
     *
     * @return 返回新闻数据列表，包含以下字段：
     *   - `datetime`: 新闻时间
     *   - `content`: 新闻内容
     *   - `title`: 新闻标题
     *   - `channels`: 新闻分类
     *
     * @see [新闻快讯文档](https://tushare.pro/document/2?doc_id=65)
     */
    public suspend fun getNews(params: NewsParams): List<NewsResult>

    /**
     * 获取新闻联播数据
     *
     * 调用TuShare API: `cctv_news`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大1000条记录，可根据时间参数循环提取历史数据
     *
     * @param params 新闻联播查询参数，包含以下字段：
     *   - `date`: 日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *
     * @return 返回新闻联播数据列表，包含以下字段：
     *   - `date`: 日期
     *   - `title`: 新闻标题
     *   - `content`: 新闻内容
     *   - `time`: 播出时间
     *
     * @see [新闻联播文档](https://tushare.pro/document/2?doc_id=143)
     */
    public suspend fun getCctvNews(params: CctvNewsParams): List<CctvNewsResult>

    /**
     * 获取长篇通讯信息
     *
     * 调用TuShare API: `major_news`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大1000条记录，可根据时间参数循环提取历史数据
     *
     * @param params 长篇通讯查询参数，包含以下字段：
     *   - `date`: 日期（可选，格式：YYYYMMDD）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `src`: 来源（可选）
     *
     * @return 返回长篇通讯数据列表，包含以下字段：
     *   - `date`: 日期
     *   - `title`: 标题
     *   - `content`: 内容
     *   - `src`: 来源
     *   - `time`: 发布时间
     *
     * @see [长篇通讯文档](https://tushare.pro/document/2?doc_id=144)
     */
    public suspend fun getMajorNews(params: MajorNewsParams): List<MajorNewsResult>

    /**
     * 获取深证互动易问答数据
     *
     * 调用TuShare API: `irm_qa_sz`
     *
     * **权限要求**: 需要单独开通权限（与积分无关）
     * **数据限制**: 单次最大1000条记录，可根据时间参数循环提取历史数据
     *
     * @param params 深证互动易查询参数，包含以下字段：
     *   - `ts_code`: 股票代码（可选）
     *   - `start_date`: 开始日期（可选，格式：YYYYMMDD）
     *   - `end_date`: 结束日期（可选，格式：YYYYMMDD）
     *   - `pub_date`: 发布日期（可选，格式：YYYYMMDD）
     *
     * @return 返回深证互动易问答数据列表，包含以下字段：
     *   - `ts_code`: TS股票代码
     *   - `pub_date`: 发布日期
     *   - `title`: 问答标题
     *   - `question`: 问题内容
     *   - `answer`: 回答内容
     *   - `qtype`: 问题类型
     *
     * @see [深证互动易文档](https://tushare.pro/document/2?doc_id=27)
     */
    public suspend fun getIrmQaSz(params: IrmQaSzParams): List<IrmQaSzResult>
}
