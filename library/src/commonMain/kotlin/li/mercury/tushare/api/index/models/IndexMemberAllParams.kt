package li.mercury.tushare.api.index.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

/**
 * 申万行业成分构成API请求参数
 */
@Serializable
data class IndexMemberAllParams(
    /**
     * 一级行业代码
     *
     * 可选参数
     */
    @SerialName("l1_code")
    val l1Code: String? = null,
    /**
     * 二级行业代码
     *
     * 可选参数
     */
    @SerialName("l2_code")
    val l2Code: String? = null,
    /**
     * 三级行业代码
     *
     * 可选参数
     */
    @SerialName("l3_code")
    val l3Code: String? = null,
    /**
     * 股票代码
     *
     * 可选参数
     */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /**
     * 是否最新（默认为"Y"是）
     *
     * 可选参数
     */
    @SerialName("is_new")
    val isNew: String? = null
) 
