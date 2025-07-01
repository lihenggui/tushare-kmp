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
import li.mercury.tushare.api.stock.finance.models.BalanceSheetParams
import li.mercury.tushare.api.stock.finance.models.CashflowParams
import li.mercury.tushare.api.stock.finance.models.DisclosureDateParams
import li.mercury.tushare.api.stock.finance.models.DividendParams
import li.mercury.tushare.api.stock.finance.models.ExpressParams
import li.mercury.tushare.api.stock.finance.models.FinaAuditParams
import li.mercury.tushare.api.stock.finance.models.FinaIndicatorParams
import li.mercury.tushare.api.stock.finance.models.FinaMainbzParams
import li.mercury.tushare.api.stock.finance.models.ForecastParams
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockFinanceApi : TestTuShare() {
    @Test
    fun testIncomeWorks() =
        test {
            val config = createConfigWithMockEngine("income.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getIncome(
                    IncomeParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Income statement data should not be null")
        }

    @Test
    fun testBalanceSheetWorks() =
        test {
            val config = createConfigWithMockEngine("balancesheet.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getBalanceSheet(
                    BalanceSheetParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Balance sheet data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testCashflowWorks() =
        test {
            val config = createConfigWithMockEngine("cashflow.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getCashflow(
                    CashflowParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Cash flow statement data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testForecastWorks() =
        test {
            val config = createConfigWithMockEngine("forecast.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getForecast(
                    ForecastParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Earnings forecast data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testExpressWorks() =
        test {
            val config = createConfigWithMockEngine("express.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getExpress(
                    ExpressParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Express report data should not be null")
        }

    @Test
    fun testDividendWorks() =
        test {
            val config = createConfigWithMockEngine("dividend.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDividend(
                    DividendParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Dividend data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testFinaIndicatorWorks() =
        test {
            val config = createConfigWithMockEngine("fina_indicator.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getFinaIndicator(
                    FinaIndicatorParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Financial indicator data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testFinaAuditWorks() =
        test {
            val config = createConfigWithMockEngine("fina_audit.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getFinaAudit(
                    FinaAuditParams(
                        tsCode = TsCode("000001", "SZ"),
                    ),
                )
            assertNotNull(result, "Financial audit opinion data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testFinaMainbzWorks() =
        test {
            val config = createConfigWithMockEngine("fina_mainbz.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getFinaMainbz(
                    FinaMainbzParams(
                        tsCode = TsCode("000001", "SZ"),
                        startDate = LocalDate(2018, 1, 1),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Main business composition data should not be null")
        }

    //    @Test
//    Skipped due to permission issues
    fun testDisclosureDateWorks() =
        test {
            val config = createConfigWithMockEngine("disclosure_date.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getDisclosureDate(
                    DisclosureDateParams(
                        tsCode = TsCode("000001", "SZ"),
                        endDate = LocalDate(2018, 12, 31),
                    ),
                )
            assertNotNull(result, "Financial report disclosure plan data should not be null")
        }
}
