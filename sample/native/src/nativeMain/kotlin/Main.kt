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
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import kotlinx.coroutines.runBlocking
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.TsCode
import platform.posix.getenv

/**
 * TuShare Kotlin/Native example application.
 *
 * This example demonstrates basic TuShare API usage in a Kotlin/Native environment.
 *
 * IMPORTANT LIMITATION:
 * Kotlin/Native does not currently support TLS sessions required for HTTPS connections.
 * This means all TuShare API calls will fail with "TLS sessions are not supported" error.
 * This is a known platform limitation, not a library issue.
 *
 * Recommended alternatives:
 * 1. Use JVM target for production applications
 * 2. Use JavaScript target for web applications
 * 3. Wait for Kotlin/Native TLS support in future versions
 */
fun main(): Unit =
    runBlocking {
        // Sample stock for demonstration
        val sampleStockCode = "600519" // Kweichow Moutai
        val sampleExchange = "SH" // Shanghai Stock Exchange

        @OptIn(ExperimentalForeignApi::class)
        val apiKey = getenv("TUSHARE_TOKEN")?.toKString()
        val token = requireNotNull(apiKey) { "TUSHARE_TOKEN environment variable must be set." }
        val tuShare =
            TuShare(
                token = token,
                loggingConfig = LoggingConfig(LogLevel.None),
            )

        println("\n> Getting Stock basic data...")
        val stockBasic =
            tuShare.getStockBasic(
                StockBasicParams(tsCode = TsCode(sampleStockCode, sampleExchange)),
            )
        println("Stock basic data: $stockBasic")

        println("\n> Getting Index basic data...")
        val indexBasic =
            tuShare.getIndexBasic(
                li.mercury.tushare.api.index.models.IndexBasicParams(tsCode = TsCode("000001", "SH")),
            )
        println("Index basic data: $indexBasic")
    }
