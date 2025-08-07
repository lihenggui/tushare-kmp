/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package li.mercury.tushare.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.number
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
        // 格式化为 "yyyy-MM-dd HH:mm:ss" 格式
        val formattedDateTime =
            "${value.year.toString().padStart(4, '0')}-" +
                "${value.month.number.toString().padStart(2, '0')}-" +
                "${value.day.toString().padStart(2, '0')} " +
                "${value.hour.toString().padStart(2, '0')}:" +
                "${value.minute.toString().padStart(2, '0')}:" +
                value.second.toString().padStart(2, '0')
        encoder.encodeString(formattedDateTime)
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val raw = decoder.decodeString().trim()

        // 兼容多种时间格式：
        // - "yyyy-MM-dd HH:mm:ss"（官方文档）
        // - "yyyy-MM-dd HH:mm"（部分接口秒数缺失）
        // - ISO "yyyy-MM-ddTHH:mm[:ss]"（兜底）
        // 优先用手动解析以保持多平台兼容性而不依赖平台特定的格式化器。
        fun parseTimeParts(time: String): Triple<Int, Int, Int> {
            val parts = time.split(":")
            val hour = parts.getOrNull(0)?.toIntOrNull() ?: 0
            val minute = parts.getOrNull(1)?.toIntOrNull() ?: 0
            val secondStr = parts.getOrNull(2) ?: "0"
            // 去除可能的毫秒/其他尾部（如 30.123）
            val second = secondStr.takeWhile { it.isDigit() }.toIntOrNull() ?: 0
            return Triple(hour, minute, second)
        }

        // 如果是包含空格的常见格式
        if (raw.contains(' ')) {
            val (date, time) = raw.split(' ', limit = 2)
            val dateParts = date.split('-')
            if (dateParts.size == 3) {
                val year = dateParts[0].toInt()
                val month = dateParts[1].toInt()
                val day = dateParts[2].toInt()
                val (h, m, s) = parseTimeParts(time)
                return LocalDateTime(year, month, day, h, m, s)
            }
        }

        // 如果是 ISO 或者包含 'T' 分隔符
        if (raw.contains('T')) {
            // 若没有秒（长度形如 yyyy-MM-ddTHH:mm），补齐秒
            val iso = if (raw.length == 16 && raw[10] == 'T') "$raw:00" else raw
            return LocalDateTime.parse(iso)
        }

        // 最后兜底：尝试把空格替换为 'T'，若缺秒补 ":00"
        val normalized =
            buildString {
                append(raw.replace(' ', 'T'))
                // 简单判断是否只有到分钟
                if (length == 16 && this[10] == 'T') append(":00")
            }
        return LocalDateTime.parse(normalized)
    }
}
