package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable

/**
 * 深圳市场板块代码枚举
 */
@Suppress("NonAsciiCharacters", "ktlint:standard:enum-entry-name-case")
@Serializable
public enum class SzTsCode {
    股票,
    主板A股,
    主板B股,
    创业板A股,
    基金,
    ETF,
    LOF,
    封闭式基金,
    基础设施基金,
    债券,
    债券现券,
    债券回购,
    ABS,
    期权,
    中小板,
    分级基金,
}
