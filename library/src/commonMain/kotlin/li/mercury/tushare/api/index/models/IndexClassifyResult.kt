package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndexClassifyResult(
    /** 指数代码*/
    @SerialName("index_code")
    val indexCode: String,
    /** 行业名称*/
    @SerialName("industry_name")
    val industryName: String,
    /** 父级代码*/
    @SerialName("parent_code")
    val parentCode: String,
    /** 行业分级（L1/L2/L3）*/
    val level: String,
    /** 行业代码*/
    @SerialName("industry_code")
    val industryCode: String,
    /** 是否发布指数*/
    @SerialName("is_pub")
    val isPub: String,
    /** 行业分类来源*/
    val src: String?
) 