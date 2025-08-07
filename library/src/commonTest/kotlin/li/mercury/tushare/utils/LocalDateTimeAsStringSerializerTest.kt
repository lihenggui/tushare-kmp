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
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTimeAsStringSerializerTest {
    @Serializable
    data class TestData(
        @Serializable(with = LocalDateTimeAsStringSerializer::class)
        val dateTime: LocalDateTime,
    )

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun testSerialize() {
        val testDateTime = LocalDateTime(2025, 7, 27, 17, 24, 30)
        val testData = TestData(testDateTime)

        val serialized = json.encodeToString(TestData.serializer(), testData)
        assertEquals("""{"dateTime":"2025-07-27 17:24:30"}""", serialized)
    }

    @Test
    fun testDeserialize() {
        val jsonString = """{"dateTime":"2025-07-27 17:24:30"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)

        assertEquals(LocalDateTime(2025, 7, 27, 17, 24, 30), data.dateTime)
    }

    @Test
    fun testDeserializeISOFormat() {
        // Test that the deserializer still handles ISO format as fallback
        val jsonString = """{"dateTime":"2025-07-27T17:24:30"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)

        assertEquals(LocalDateTime(2025, 7, 27, 17, 24, 30), data.dateTime)
    }

    @Test
    fun testEdgeCases() {
        val testCases =
            listOf(
                LocalDateTime(2000, 1, 1, 0, 0, 0) to "2000-01-01 00:00:00",
                LocalDateTime(2099, 12, 31, 23, 59, 59) to "2099-12-31 23:59:59",
                LocalDateTime(1990, 2, 28, 12, 30, 45) to "1990-02-28 12:30:45",
                LocalDateTime(2024, 2, 29, 6, 5, 4) to "2024-02-29 06:05:04", // Leap year
            )

        testCases.forEach { (dateTime, expected) ->
            val testData = TestData(dateTime)
            val serialized = json.encodeToString(TestData.serializer(), testData)
            assertEquals("""{"dateTime":"$expected"}""", serialized)

            val jsonString = """{"dateTime":"$expected"}"""
            val decoded = json.decodeFromString(TestData.serializer(), jsonString)
            assertEquals(dateTime, decoded.dateTime)
        }
    }

    @Test
    fun testSerializerDirectly() {
        val testDateTime = LocalDateTime(2025, 7, 27, 17, 24, 30)
        val serialized = Json.encodeToString(LocalDateTimeAsStringSerializer, testDateTime)
        assertEquals("\"2025-07-27 17:24:30\"", serialized)

        val deserialized = Json.decodeFromString(LocalDateTimeAsStringSerializer, "\"2025-07-27 17:24:30\"")
        assertEquals(testDateTime, deserialized)
    }

    @Test
    fun testRoundTrip() {
        val originalDateTime = LocalDateTime(2025, 7, 27, 17, 24, 30)
        val testData = TestData(originalDateTime)

        // Serialize to JSON
        val serialized = json.encodeToString(TestData.serializer(), testData)

        // Deserialize back
        val deserialized = json.decodeFromString(TestData.serializer(), serialized)

        // Should be equal
        assertEquals(originalDateTime, deserialized.dateTime)
    }

    @Test
    fun testDeserializeWithoutSeconds_Space() {
        val jsonString = """{"dateTime":"2025-08-07 14:16"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)
        assertEquals(LocalDateTime(2025, 8, 7, 14, 16, 0), data.dateTime)
    }

    @Test
    fun testDeserializeWithoutSeconds_ISO() {
        val jsonString = """{"dateTime":"2025-08-07T14:16"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)
        assertEquals(LocalDateTime(2025, 8, 7, 14, 16, 0), data.dateTime)
    }
}
