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
