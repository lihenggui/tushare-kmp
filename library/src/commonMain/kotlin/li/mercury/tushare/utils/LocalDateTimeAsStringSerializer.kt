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
