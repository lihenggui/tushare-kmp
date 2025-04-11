package li.mercury.tushare.api.news

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.AnnouncementResult
import li.mercury.tushare.api.news.models.CctvNewsParams
import li.mercury.tushare.api.news.models.CctvNewsResult
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaShResult
import li.mercury.tushare.api.news.models.MajorNewsParams
import li.mercury.tushare.api.news.models.MajorNewsResult
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.api.news.models.NewsResult

/**
 * 新闻相关API的存储库接口
 */
interface NewsApiInterface {
    /**
     * 获取全量公告数据
     */
    fun getAnnsD(params: AnnouncementParams): Flow<List<AnnouncementResult>>

    /**
     * 获取上证E互动问答数据
     */
    fun getIrmQaSh(params: IrmQaShParams): Flow<List<IrmQaShResult>>

    /**
     * 获取新闻快讯数据
     */
    fun getNews(params: NewsParams): Flow<List<NewsResult>>

    /**
     * 获取新闻联播数据
     */
    fun getCctvNews(params: CctvNewsParams): Flow<List<CctvNewsResult>>

    /**
     * 获取长篇通讯信息
     */
    fun getMajorNews(params: MajorNewsParams): Flow<List<MajorNewsResult>>

}
