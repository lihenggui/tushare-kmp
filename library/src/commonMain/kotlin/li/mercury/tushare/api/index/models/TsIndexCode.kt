package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable

/**
 * 国际指数代码枚举
 *
 * 根据Tushare官方文档定义的国际指数代码列表
 */
@Suppress("ktlint:standard:enum-entry-name-case")
@Serializable
enum class TsIndexCode(
    /** 指数中文名称 */
    val chineseName: String,
) {
    XIN9("富时中国A50指数 (富时A50)"),
    HSI("恒生指数"),
    HKTECH("恒生科技指数"),
    HKAH("恒生AH股H指数"),
    DJI("道琼斯工业指数"),
    SPX("标普500指数"),
    IXIC("纳斯达克指数"),
    FTSE("富时100指数"),
    FCHI("法国CAC40指数"),
    GDAXI("德国DAX指数"),
    N225("日经225指数"),
    KS11("韩国综合指数"),
    AS51("澳大利亚标普200指数"),
    SENSEX("印度孟买SENSEX指数"),
    IBOVESPA("巴西IBOVESPA指数"),
    RTS("俄罗斯RTS指数"),
    TWII("台湾加权指数"),
    CKLSE("马来西亚指数"),
    SPTSX("加拿大S&P/TSX指数"),
    CSX5P("STOXX欧洲50指数"),
    RUT("罗素2000指数"),
}
