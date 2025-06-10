package li.mercury.tushare.api.news

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import li.mercury.tushare.api.BaseApiImpl
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
import li.mercury.tushare.client.TuShareConfig
import li.mercury.tushare.http.HttpRequester

/**
 * 新闻相关API的实现类
 */
internal class NewsApi(
    requester: HttpRequester,
    config: TuShareConfig
) : BaseApiImpl(requester, config), NewsApiInterface {

    /**
     * 实现全量公告数据接口
     * @param params 查询请求
     * @return 返回公告数据
     */
    override suspend fun getAnnsD(
        params: AnnouncementParams
    ): List<AnnouncementResult> {
        return callApi(
            apiName = "anns_d",
            params = params,
            serializer = AnnouncementResult.serializer()
        )
    }

    /**
     * 实现上证E互动问答接口
     * @param params 查询参数
     * @return 返回问答数据
     */
    override fun getIrmQaSh(params: IrmQaShParams): Flow<List<IrmQaShResult>> = flow {
        val results = callApi(
            apiName = "irm_qa_sh",
            params = params,
            serializer = IrmQaShResult.serializer()
        )
        emit(results)
    }

    /**
     * 实现新闻快讯接口
     * @param params 查询参数
     * @return 返回新闻快讯数据
     */
    override fun getNews(params: NewsParams): Flow<List<NewsResult>> = flow {
        val results = callApi(
            apiName = "news",
            params = params,
            serializer = NewsResult.serializer()
        )
        emit(results)
    }

    /**
     * 实现新闻联播接口
     * @param params 查询参数
     * @return 返回新闻联播数据
     */
    override fun getCctvNews(params: CctvNewsParams): Flow<List<CctvNewsResult>> = flow {
        val results = callApi(
            apiName = "cctv_news",
            params = params,
            serializer = CctvNewsResult.serializer()
        )
        emit(results)
    }

    /**
     * 实现新闻通讯接口
     * @param params 查询参数
     * @return 返回新闻通讯数据
     */
    override fun getMajorNews(params: MajorNewsParams): Flow<List<MajorNewsResult>> = flow {
        val results = callApi(
            apiName = "major_news",
            params = params,
            serializer = MajorNewsResult.serializer()
        )
        emit(results)
    }

    /**
     * 实现深证互动易问答接口
     * @param params 查询参数
     * @return 返回问答数据
     */
    override fun getIrmQaSz(params: IrmQaSzParams): Flow<List<IrmQaSzResult>> = flow {
        val results = callApi(
            apiName = "irm_qa_sz",
            params = params,
            serializer = IrmQaSzResult.serializer()
        )
        emit(results)
    }
}
