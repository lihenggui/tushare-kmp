package li.mercury.tushare.api.stock.models

import kotlinx.serialization.Serializable

/**
 * 业绩预告类型
 */
@Suppress("NonAsciiCharacters", "ktlint:standard:enum-entry-name-case")
@Serializable
enum class ForecastType {
    预增,
    预减,
    扭亏,
    首亏,
    续亏,
    续盈,
    略增,
    略减,
}
