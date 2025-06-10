package li.mercury.tushare.api.stock.board.models

import kotlinx.serialization.Serializable

@Suppress("NonAsciiCharacters", "ktlint:standard:enum-entry-name-case")
@Serializable
public enum class KplListTag {
    涨停,
    炸板,
    跌停,
    自然涨停,
    竞价,
}
