package li.mercury.tushare.utils

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateAsStringSerializerTest {
    @Serializable
    data class TestData(
        @Serializable(with = LocalDateAsStringSerializer::class)
        val date: LocalDate,
    )

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun testSerialize() {
        val testDate = LocalDate(2023, 5, 15)
        val testData = TestData(testDate)

        val serialized = json.encodeToString(TestData.serializer(), testData)
        assertEquals("""{"date":"20230515"}""", serialized)
    }

    @Test
    fun testDeserialize() {
        val jsonString = """{"date":"20230515"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)

        assertEquals(LocalDate(2023, 5, 15), data.date)
    }

    @Test
    fun testDeserializeWithHyphens() {
        val jsonString = """{"date":"2023-05-15"}"""
        val data = json.decodeFromString(TestData.serializer(), jsonString)

        assertEquals(LocalDate(2023, 5, 15), data.date)
    }

    @Test
    fun testEdgeCases() {
        val testCases =
            listOf(
                LocalDate(2000, 1, 1) to "20000101",
                LocalDate(2099, 12, 31) to "20991231",
                LocalDate(1990, 2, 28) to "19900228",
            )

        testCases.forEach { (date, expected) ->
            val testData = TestData(date)
            val serialized = json.encodeToString(TestData.serializer(), testData)
            assertEquals("""{"date":"$expected"}""", serialized)

            val jsonString = """{"date":"$expected"}"""
            val decoded = json.decodeFromString(TestData.serializer(), jsonString)
            assertEquals(date, decoded.date)
        }
    }

    @Test
    fun testSerializerDirectly() {
        val testDate = LocalDate(2023, 7, 21)
        val serialized = Json.encodeToString(LocalDateAsStringSerializer, testDate)
        assertEquals("\"20230721\"", serialized)

        val deserialized = Json.decodeFromString(LocalDateAsStringSerializer, "\"20230721\"")
        assertEquals(testDate, deserialized)
    }
}
