package li.mercury.tushare.api.news

import kotlinx.coroutines.flow.Flow
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.AnnouncementResult

/**
    * 新闻相关API的存储库接口
 */
interface NewsApiInterface {
    /**
     * 获取全量公告数据
     */
    fun getAnnsD(params: AnnouncementParams): Flow<List<AnnouncementResult>>

}
