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
import li.mercury.tushare.api.stock.flow.models.MoneyflowDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowHsgtParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowIndThsParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowMktDcParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowParams
import li.mercury.tushare.api.stock.flow.models.MoneyflowThsParams
import li.mercury.tushare.models.TsCode
import kotlin.test.Test
import kotlin.test.assertNotNull

class TestStockFlowApi : TestTuShare() {
    @Test
    fun testMoneyflowWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflow(
                    MoneyflowParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Individual stock money flow data should not be null")
        }

    @Test
    fun testMoneyflowThsWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ths.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowThs(
                    MoneyflowThsParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "THS individual stock money flow data should not be null")
        }

    @Test
    fun testMoneyflowDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowDc(
                    MoneyflowDcParams(
                        tsCode = TsCode("000001", "SZ"),
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Eastmoney individual stock money flow data should not be null")
        }

    @Test
    fun testMoneyflowMktDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_mkt_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowMktDc(
                    MoneyflowMktDcParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Eastmoney market money flow data should not be null")
        }

    @Test
    fun testMoneyflowIndDcWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ind_dc.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowIndDc(
                    MoneyflowIndDcParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Eastmoney sector money flow data should not be null")
        }

    @Test
    fun testMoneyflowIndThsWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_ind_ths.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowIndThs(
                    MoneyflowIndThsParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "THS industry sector money flow data should not be null")
        }

    @Test
    fun testMoneyflowHsgtWorks() =
        test {
            val config = createConfigWithMockEngine("moneyflow_hsgt.json")
            val tuShareInstance = generateTuShare(config)

            val result =
                tuShareInstance.getMoneyflowHsgt(
                    MoneyflowHsgtParams(
                        tradeDate = LocalDate(2018, 7, 16),
                    ),
                )
            assertNotNull(result, "Shanghai-Shenzhen-Hong Kong Stock Connect money flow data should not be null")
        }
}
