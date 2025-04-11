package li.mercury.tushare.api.news

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.AnnouncementResult
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaShResult

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

}
