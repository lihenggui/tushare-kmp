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
 * This example demonstrates basic TuShare API usage in a Kotlin/Native environment
 * using the Curl HTTP client engine which supports TLS connections.
 */
fun main(): Unit =
    runBlocking {
        // Sample stock for demonstration
        val sampleStockCode = "600519" // Kweichow Moutai
        val sampleExchange = "SH" // Shanghai Stock Exchange

        @OptIn(ExperimentalForeignApi::class)
        val apiKey = getenv("TUSHARE_TOKEN")?.toKString()

        // Debug: Print whether token was found
        if (apiKey == null) {
            println("❌ TUSHARE_TOKEN environment variable not found!")
            println("💡 Solutions:")
            println("   1. Set environment variable: export TUSHARE_TOKEN=your_token_here")
            println("   2. Or run: TUSHARE_TOKEN=your_token_here ./gradlew :sample:native:runDebugExecutableNative")
            println("   3. Or temporarily hardcode your token in the code (NOT recommended for production)")
            return@runBlocking
        } else {
            println("✅ Found TUSHARE_TOKEN (length: ${apiKey.length})")
            if (apiKey.isBlank()) {
                println("❌ Token is empty or contains only whitespace!")
                return@runBlocking
            }
            if (apiKey.length < 10) {
                println("⚠️  Token seems very short (${apiKey.length} chars) - TuShare tokens are typically longer")
            }
            // Show first and last few characters for debugging (safely)
            if (apiKey.length > 6) {
                println("🔍 Token preview: ${apiKey.take(3)}...${apiKey.takeLast(3)}")
            }
        }

        val token = apiKey
        println("🔧 Creating TuShare client...")
        val tuShare =
            TuShare(
                token = token,
                loggingConfig = LoggingConfig(LogLevel.All), // Enable logging to debug API calls
            )
        println("✅ TuShare client created successfully")

        try {
            println("\n> Getting Stock basic data...")
            val stockBasic =
                tuShare.getStockBasic(
                    StockBasicParams(tsCode = TsCode(sampleStockCode, sampleExchange)),
                )
            println("Stock basic data: $stockBasic")
        } catch (e: li.mercury.tushare.internal.exception.AuthenticationException) {
            println("❌ Authentication failed: ${e.message}")
            println("💡 This usually means:")
            println("   1. Your token is invalid or expired")
            println("   2. Your token doesn't have permission for this API")
            println("   3. Token format is incorrect")
            println("   Please verify your TuShare token at: https://tushare.pro/")
            return@runBlocking
        } catch (e: Exception) {
            println("❌ Error: ${e.message}")
            e.printStackTrace()
            return@runBlocking
        }

        try {
            println("\n> Getting Index basic data...")
            val indexBasic =
                tuShare.getIndexBasic(
                    li.mercury.tushare.api.index.models
                        .IndexBasicParams(tsCode = TsCode(sampleStockCode, sampleExchange)),
                )
            println("Index basic data: $indexBasic")
        } catch (e: li.mercury.tushare.internal.exception.AuthenticationException) {
            println("❌ Authentication failed: ${e.message}")
            println("💡 This usually means:")
            println("   1. Your token is invalid or expired")
            println("   2. Your token doesn't have permission for this API")
            println("   3. Token format is incorrect")
            println("   Please verify your TuShare token at: https://tushare.pro/")
        } catch (e: Exception) {
            println("❌ Error: ${e.message}")
            e.printStackTrace()
        }
    }
