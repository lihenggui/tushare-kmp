package li.mercury.tushare.api.stock.finance.models

import kotlinx.serialization.Serializable

/**
 * 主营业务构成类型
 */
@Serializable
public enum class MainbzType {
    /** 按产品 */
    P,

    /** 按地区 */
    D,

    /** 按行业 */
    I,
}
