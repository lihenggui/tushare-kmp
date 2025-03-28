package li.mercury.tushare.api.index.models

import kotlinx.serialization.Serializable

/**
 * 指数类别枚举
 */
@Suppress("NonAsciiCharacters", "ktlint:standard:enum-entry-name-case")
@Serializable
enum class IndexCategory {
    主题指数,
    行业指数,
    大盘指数,
    风格指数,
    成长指数,
    价值指数,
    基本面指数,
    策略指数,
    综合指数,
    其他指数,
}
