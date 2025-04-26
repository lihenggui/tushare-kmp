package li.mercury.tushare.api.news.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 新闻来源枚举
 */
@Serializable
enum class NewsSrc {
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