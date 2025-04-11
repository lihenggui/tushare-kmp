package li.mercury.tushare.api.news

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.AnnouncementResult
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaShResult
import li.mercury.tushare.utils.toApiParams

/**
 * 新闻相关API的实现类
 */
internal class NewsApi (
    private val tuShare: TuShare,
): NewsApiInterface {

    /**
     * 实现全量公告数据接口
     * @param params 查询参数
     * @return 返回公告数据
     */
    override fun getAnnsD(params: AnnouncementParams): Flow<List<AnnouncementResult>> = flow {
        val apiParams = params.toApiParams()

        val response = tuShare.callApi(
            apiName = "anns_d",
            params = apiParams
        )

        val results = response.getResponseItems(AnnouncementResult.serializer())
        emit(results)
    }

    /**
     * 实现上证E互动问答接口
     * @param params 查询参数
     * @return 返回问答数据
     */
    override fun getIrmQaSh(params: IrmQaShParams): Flow<List<IrmQaShResult>> = flow {
        val apiParams = params.toApiParams()

        val response = tuShare.callApi(
            apiName = "irm_qa_sh",
            params = apiParams
        )

        val results = response.getResponseItems(IrmQaShResult.serializer())
        emit(results)
    }
}
