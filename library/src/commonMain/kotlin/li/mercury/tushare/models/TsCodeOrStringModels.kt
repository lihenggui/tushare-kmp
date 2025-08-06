package li.mercury.tushare.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 新增一个类型安全的封装，兼容股票代码和特殊字符串
 */
@Serializable(with = TsCodeOrStringSerializer::class)
public sealed class TsCodeOrString {
    public data class Code(val tsCode: TsCode) : TsCodeOrString()
    public data class RawString(val value: String) : TsCodeOrString()
}

public object TsCodeOrStringSerializer : KSerializer<TsCodeOrString> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("TsCodeOrString", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: TsCodeOrString) {
        when (value) {
            is TsCodeOrString.Code -> encoder.encodeString(value.tsCode.toString())
            is TsCodeOrString.RawString -> encoder.encodeString(value.value)
        }
    }

    override fun deserialize(decoder: Decoder): TsCodeOrString {
        val value = decoder.decodeString()
        return try {
            TsCodeOrString.Code(TsCode.fromString(value))
        } catch (_: IllegalArgumentException) {
            TsCodeOrString.RawString(value)
        }
    }
}
