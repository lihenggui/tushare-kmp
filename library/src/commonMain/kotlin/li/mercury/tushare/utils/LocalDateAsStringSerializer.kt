package li.mercury.tushare.utils

import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Custom serializer for LocalDate that formats to YYYYMMDD string
 */
object LocalDateAsStringSerializer : KSerializer<LocalDate> {
    override val descriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: LocalDate,
    ) {
        encoder.encodeString(value.toString().replace("-", ""))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        val dateString = decoder.decodeString()
        return if (dateString.length == 8) {
            LocalDate.parse("${dateString.substring(0, 4)}-${dateString.substring(4, 6)}-${dateString.substring(6, 8)}")
        } else {
            LocalDate.parse(dateString)
        }
    }
}
