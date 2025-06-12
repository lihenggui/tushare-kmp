package li.mercury.tushare.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 表示TuShare股票代码
 * 格式为：代码.市场，例如：600000.SH, 000001.SZ, 850431.SI
 */
@Serializable(with = TsCodeSerializer::class)
public data class TsCode(
    /** 股票代码 */
    val code: String,
    /** 交易市场/交易所后缀 */
    val market: String,
) {
    init {
        require(code.isNotBlank()) { "Stock code cannot be blank" }
        require(market.isNotBlank()) { "Market code cannot be blank" }
        // Validate code format based on market
        when (market) {
            "SH", "SZ" -> require(code.matches(Regex("\\d{6}"))) { "Invalid stock code format for $market market: $code" }
            "SI" -> require(code.matches(Regex("\\d{6}"))) { "Invalid index code format for $market market: $code" }
            "HK" -> require(code.matches(Regex("\\d{5}"))) { "Invalid HK stock code format: $code" }
        }
    }

    public companion object {
        /**
         * 从字符串格式解析TsCode
         *
         * @param tsCodeString 如 "600000.SH"
         * @return TsCode对象
         */
        public fun fromString(tsCodeString: String): TsCode {
            val parts = tsCodeString.split(".")
            require(parts.size == 2) { "Invalid TS code format: $tsCodeString" }
            return TsCode(parts[0], parts[1])
        }

        /**
         * 创建上海市场股票代码
         */
        public fun sh(code: String): TsCode = TsCode(code, "SH")

        /**
         * 创建深圳市场股票代码
         */
        public fun sz(code: String): TsCode = TsCode(code, "SZ")

        /**
         * 创建申万指数代码
         */
        public fun si(code: String): TsCode = TsCode(code, "SI")

        /**
         * 创建香港市场股票代码
         */
        public fun hk(code: String): TsCode = TsCode(code, "HK")
    }

    /**
     * 是否为上海市场代码
     */
    public fun isShanghai(): Boolean = market == "SH"

    /**
     * 是否为深圳市场代码
     */
    public fun isShenzhen(): Boolean = market == "SZ"

    /**
     * 是否为申万指数代码
     */
    public fun isSwIndex(): Boolean = market == "SI"

    /**
     * 是否为香港市场代码
     */
    public fun isHongKong(): Boolean = market == "HK"

    /**
     * 转换为字符串格式
     */
    override fun toString(): String = "$code.$market"
}

/**
 * TsCode的自定义序列化器，使其能在API中作为字符串表示
 */
internal object TsCodeSerializer : KSerializer<TsCode> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("TsCode", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): TsCode {
        val string = decoder.decodeString()
        return TsCode.fromString(string)
    }

    override fun serialize(
        encoder: Encoder,
        value: TsCode,
    ) {
        encoder.encodeString(value.toString())
    }
}
