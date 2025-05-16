package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import li.mercury.tushare.models.TsCode

@Serializable
data class ThsIndexParams(
    /** 指数代码 */
    @SerialName("ts_code")
    val tsCode: TsCode? = null,
    /** 市场类型（A- A股，HK- 港股，US- 美股） */
    val exchange: String? = null,
    /** 指数类型 */
    val type: ThsIndexType? = null,
)

/**
 * 同花顺指数类型
 */
enum class ThsIndexType {
    /** 概念指数 */
    @SerialName("N")
    CONCEPT,

    /** 行业指数 */
    @SerialName("I")
    INDUSTRY,

    /** 地域指数 */
    @SerialName("R")
    REGION,

    /** 同花顺特色指数 */
    @SerialName("S")
    SPECIAL,

    /** 同花顺风格指数 */
    @SerialName("ST")
    STYLE,

    /** 同花顺主题指数 */
    @SerialName("TH")
    THEME,

    /** 同花顺宽基指数 */
    @SerialName("BB")
    BROAD_BASED,
}
