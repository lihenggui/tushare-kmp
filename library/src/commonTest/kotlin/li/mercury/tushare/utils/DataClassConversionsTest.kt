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

import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

class DataClassConversionsTest {
    @Test
    fun testCamelToSnakeCase() {
        assertEquals("hello_world", DataClassConversions.camelToSnakeCase("helloWorld"))
        assertEquals("this_is_a_test", DataClassConversions.camelToSnakeCase("thisIsATest"))
        assertEquals("http_request", DataClassConversions.camelToSnakeCase("httpRequest"))
        assertEquals("already_snake", DataClassConversions.camelToSnakeCase("already_snake"))
        assertEquals("", DataClassConversions.camelToSnakeCase(""))
        assertEquals("a", DataClassConversions.camelToSnakeCase("a"))
    }

    @Serializable
    data class TestParams(
        val name: String,
        val userId: Int,
        val isActive: Boolean,
        val nullableValue: String? = null,
    )

    @Test
    fun testToMap() {
        val testData =
            TestParams(
                name = "张三",
                userId = 123,
                isActive = true,
            )

        // 测试转蛇形命名
        val snakeCaseMap = DataClassConversions.toMap(testData, true)
        assertEquals("张三", snakeCaseMap["name"])
        assertEquals("123", snakeCaseMap["user_id"])
        assertEquals("true", snakeCaseMap["is_active"])
        assertEquals(null, snakeCaseMap["nullable_value"])

        // 测试保持驼峰命名
        val camelCaseMap = DataClassConversions.toMap(testData, false)
        assertEquals("张三", camelCaseMap["name"])
        assertEquals("123", camelCaseMap["userId"])
        assertEquals("true", camelCaseMap["isActive"])
    }

    @Test
    fun testToApiParams() {
        val testData =
            TestParams(
                name = "李四",
                userId = 456,
                isActive = false,
            )

        val params = testData.toApiParams()
        assertEquals("李四", params["name"])
        assertEquals("456", params["user_id"])
        assertEquals("false", params["is_active"])

        val camelParams = testData.toApiParams(snakeCase = false)
        assertEquals("李四", camelParams["name"])
        assertEquals("456", camelParams["userId"])
    }

    @Serializable
    data class NestedData(
        val simpleData: TestParams,
        val listData: List<String>,
    )

    @Test
    fun testComplexDataStructure() {
        val nested =
            NestedData(
                simpleData = TestParams("王五", 789, true),
                listData = listOf("one", "two"),
            )

        val map = DataClassConversions.toMap(nested)
        assertEquals("{\"name\":\"王五\",\"userId\":789,\"isActive\":true}", map["simple_data"])
        assertEquals("[\"one\",\"two\"]", map["list_data"])
    }
}
