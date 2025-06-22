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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TsCodeTest {
    @Test
    fun testCreateTsCode() {
        val tsCode = TsCode("600000", "SH")
        assertEquals("600000", tsCode.code)
        assertEquals("SH", tsCode.market)
        assertEquals("600000.SH", tsCode.toString())
    }

    @Test
    fun testFromString() {
        val tsCode = TsCode.fromString("000001.SZ")
        assertEquals("000001", tsCode.code)
        assertEquals("SZ", tsCode.market)
        assertEquals("000001.SZ", tsCode.toString())
    }

    @Test
    fun testValidationForEmptyValues() {
        assertFailsWith<IllegalArgumentException> {
            TsCode("", "SH")
        }

        assertFailsWith<IllegalArgumentException> {
            TsCode("600000", "")
        }
    }

    @Test
    fun testValidationForInvalidCodeFormat() {
        // Shanghai and Shenzhen market codes should be 6 digits
        assertFailsWith<IllegalArgumentException> {
            TsCode("12345", "SH") // 5 digits is invalid
        }

        assertFailsWith<IllegalArgumentException> {
            TsCode("1234567", "SZ") // 7 digits is invalid
        }

        // Hong Kong market codes should be 5 digits
        assertFailsWith<IllegalArgumentException> {
            TsCode("123456", "HK") // 6 digits is invalid
        }
    }

    @Test
    fun testFactoryMethods() {
        val shCode = TsCode.sh("600000")
        assertEquals("600000.SH", shCode.toString())
        assertTrue(shCode.isShanghai())
        assertFalse(shCode.isShenzhen())

        val szCode = TsCode.sz("000001")
        assertEquals("000001.SZ", szCode.toString())
        assertTrue(szCode.isShenzhen())
        assertFalse(szCode.isShanghai())

        val siCode = TsCode.si("850431")
        assertEquals("850431.SI", siCode.toString())
        assertTrue(siCode.isSwIndex())

        val hkCode = TsCode.hk("00700")
        assertEquals("00700.HK", hkCode.toString())
        assertTrue(hkCode.isHongKong())
    }

    @Test
    fun testInvalidTsCodeString() {
        assertFailsWith<IllegalArgumentException> {
            TsCode.fromString("invalid")
        }

        assertFailsWith<IllegalArgumentException> {
            TsCode.fromString("123.456.789")
        }
    }
}
