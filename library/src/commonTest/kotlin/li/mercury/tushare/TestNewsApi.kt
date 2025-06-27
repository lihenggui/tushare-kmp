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
package li.mercury.tushare

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import li.mercury.tushare.api.news.models.AnnouncementParams
import li.mercury.tushare.api.news.models.CctvNewsParams
import li.mercury.tushare.api.news.models.IrmQaShParams
import li.mercury.tushare.api.news.models.IrmQaSzParams
import li.mercury.tushare.api.news.models.MajorNewsParams
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestNewsApi : TestTuShare() {
    //    @Test
    // Test skipped, no permission
    fun testAnnsDWorks() =
        test {
            val annsConfig = createConfigWithMockEngine("anns_d.json")
            val tuShareInstance = generateTuShare(annsConfig)

            val result =
                tuShareInstance.getAnnsD(
                    AnnouncementParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Announcement data should not be null")
        }

    @Test
    fun testIrmQaShWorks() =
        test {
            val config = createConfigWithMockEngine("irm_qa_sh.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIrmQaSh(
                    IrmQaShParams(
                        tradeDate = LocalDate(2025, 2, 12),
                        tsCode = TsCode("601121", "SH"),
                    ),
                )
            assertNotNull(result, "Shanghai E-interactive Q&A data should not be null")
        }

    @Test
    fun testNewsWorks() =
        test {
            val config = createConfigWithMockEngine("news.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getNews(
                    NewsParams(
                        startDate = LocalDateTime(2025, 2, 12, 9, 0, 0),
                        endDate = LocalDateTime(2025, 2, 12, 9, 10, 0),
                    ),
                )
            assertNotNull(result, "News data should not be null")
        }

    // Test skipped, no permission
    // @Test
    fun testCctvNewsWorks() =
        test {
            val config = createConfigWithMockEngine("cctv_news.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCctvNews(
                    CctvNewsParams(date = LocalDate(2025, 2, 12)),
                )
            assertNotNull(result, "CCTV news data should not be null")
        }

    @Test
    fun testMajorNewsWorks() =
        test {
            val config = createConfigWithMockEngine("major_news.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMajorNews(
                    MajorNewsParams(
                        startDate = LocalDateTime(2018, 11, 21, 9, 0, 0),
                        endDate = LocalDateTime(2018, 11, 22, 10, 10, 0),
                        src = "人民网",
                    ),
                )
            assertNotNull(result, "Major news data should not be null")
        }

    @Test
    fun testIrmQaSzWorks() =
        test {
            val config = createConfigWithMockEngine("irm_qa_sz.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIrmQaSz(
                    IrmQaSzParams(
                        tradeDate = LocalDate(2025, 2, 12),
                        tsCode = TsCode("002254", "SZ"),
                    ),
                )
            assertNotNull(result, "Shenzhen interactive Q&A data should not be null")
        }
}
