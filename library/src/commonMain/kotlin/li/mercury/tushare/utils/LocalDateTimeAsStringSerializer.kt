package li.mercury.tushare.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 自定义LocalDateTime序列化器，处理"yyyy-MM-dd HH:mm:ss"格式的字符串
 */
internal object LocalDateTimeAsStringSerializer : KSerializer<LocalDateTime> {
    override val descriptor = PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: LocalDateTime,
    ) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val dateTimeString = decoder.decodeString()
        // 处理格式为 "yyyy-MM-dd HH:mm:ss" 的字符串
        return try {
            val (date, time) = dateTimeString.split(" ", limit = 2)
            val (year, month, day) = date.split("-").map { it.toInt() }
            val (hour, minute, second) = time.split(":").map { it.toInt() }
            LocalDateTime(year, month, day, hour, minute, second)
        } catch (e: Exception) {
            // 尝试标准ISO格式解析
            LocalDateTime.parse(dateTimeString)
        }
    }
}
