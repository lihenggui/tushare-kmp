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
package li.mercury.tushare.sample.jvm

import kotlinx.coroutines.runBlocking
import li.mercury.tushare.TuShare
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel

fun main() =
    runBlocking {
        val sampleStockCode = "600519" // Kweichow Moutai
        val sampleExchange = "SH" // Shanghai Stock Exchange

        val apiKey = System.getenv("TUSHARE_TOKEN")
            ?: throw IllegalArgumentException("Please set the TUSHARE_TOKEN environment variable with your TuShare API key.")
        val tuShare =
            TuShare(
                token = apiKey,
                loggingConfig = LoggingConfig(LogLevel.None),
            )

        while (true) {
            println("Select an option:")
            println("1 - Stock Basic Information")
            println("2 - Market Data")
            println("3 - Financial Data")
            println("4 - Reference Data")
            println("5 - Index Data")
            println("0 - Quit")

            suspend fun stockBasicInfo() {
                println("Select an option:")
                println("1 - Single Stock Query")
                println("2 - Multiple Stocks Query")
                println("0 - Back")

                when (val option = readlnOrNull()?.toIntOrNull()) {
                    1 -> singleStockQuery(tuShare, sampleStockCode, sampleExchange)
                    2 -> multipleStocksQuery(tuShare)
                    0 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option selected: $option")
                }
            }

            suspend fun marketData() {
                println("Select an option:")
                println("1 - Daily Market Data")
                println("2 - Weekly Market Data")
                println("3 - Monthly Market Data")
                println("0 - Back")

                when (val option = readlnOrNull()?.toIntOrNull()) {
                    1 -> dailyMarketData(tuShare)
                    2 -> weeklyMarketData(tuShare)
                    3 -> monthlyMarketData(tuShare)
                    0 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option selected: $option")
                }
            }

            suspend fun financialData() {
                println("Select an option:")
                println("1 - Income Statements")
                println("2 - Balance Sheets")
                println("3 - Cash Flow Statements")
                println("0 - Back")

                when (val option = readlnOrNull()?.toIntOrNull()) {
                    1 -> incomeStatements(tuShare)
                    2 -> balanceSheets(tuShare)
                    3 -> cashFlowStatements(tuShare)
                    0 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option selected: $option")
                }
            }

            suspend fun referenceData() {
                println("Select an option:")
                println("1 - Trade Calendars")
                println("2 - Stock Companies")
                println("3 - Stk Premarket")
                println("0 - Back")

                when (val option = readlnOrNull()?.toIntOrNull()) {
                    1 -> tradeCalendars(tuShare)
                    2 -> stockCompanies(tuShare)
                    3 -> stkPremarket(tuShare)
                    0 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option selected: $option")
                }
            }

            suspend fun indexData() {
                println("Select an option:")
                println("1 - Index Basic Info")
                println("2 - Index Daily Data")
                println("3 - SW Daily Data")
                println("0 - Back")

                when (val option = readlnOrNull()?.toIntOrNull()) {
                    1 -> getIndexBasic(tuShare)
                    2 -> indexDailyData(tuShare)
                    3 -> swDaily(tuShare)
                    0 -> {
                        println("Exiting...")
                        return
                    }

                    else -> println("Invalid option selected: $option")
                }
            }

            when (val option = readlnOrNull()?.toIntOrNull()) {
                1 -> stockBasicInfo()
                2 -> marketData()
                3 -> financialData()
                4 -> referenceData()
                5 -> indexData()
                0 -> {
                    println("Exiting...")
                    return@runBlocking
                }

                else -> println("Invalid option selected: $option")
            }
            println("\n----------\n") // for readability
        }
    }
