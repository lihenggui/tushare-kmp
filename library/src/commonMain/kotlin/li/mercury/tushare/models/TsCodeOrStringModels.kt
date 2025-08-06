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
    public data class Code(
        val tsCode: TsCode,
    ) : TsCodeOrString()

    public data class RawString(
        val value: String,
    ) : TsCodeOrString()
}

public object TsCodeOrStringSerializer : KSerializer<TsCodeOrString> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("TsCodeOrString", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: TsCodeOrString,
    ) {
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
