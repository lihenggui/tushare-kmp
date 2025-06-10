package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 申万行业分类API请求参数
 */
@Serializable
data class IndexClassifyParams(
    /**
     * 指数代码
     *
     * 可选参数，来源指数基础信息接口
     */
    @SerialName("index_code")
    val indexCode: String? = null,
    /**
     * 行业分级
     *
     * 可选参数，L1/L2/L3
     */
    val level: Level? = null,
    /**
     * 父级代码
     *
     * 可选参数，一级为0
     */
    @SerialName("parent_code")
    val parentCode: String? = null,
    /**
     * 指数来源
     *
     * 可选参数 (SW2014：申万 2014 年版本，SW2021：申万 2021 年版本)
     */
    val src: String? = null,
)
