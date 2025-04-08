package li.mercury.tushare.models

import kotlinx.serialization.Serializable

/**
 * 行业分级
 */
@Serializable
enum class Level {
    /** 一级 */
    L1,

    /** 二级 */
    L2,

    /** 三级 */
    L3;
}