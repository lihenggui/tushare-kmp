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
