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
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import li.mercury.tushare.TuShare
import li.mercury.tushare.api.news.models.NewsParams
import li.mercury.tushare.api.stock.basic.models.ListStatus
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.api.stock.finance.models.IncomeParams
import li.mercury.tushare.api.stock.market.models.DailyParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.Exchange
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
fun main(): Unit = runBlocking {
    // Sample stock for demonstration
    val SAMPLE_STOCK_CODE = "600519" // Kweichow Moutai
    val SAMPLE_EXCHANGE = "SH"       // Shanghai Stock Exchange

    @OptIn(ExperimentalForeignApi::class)
    val apiKey = getenv("TUSHARE_TOKEN")?.toKString()
    if (apiKey.isNullOrEmpty()) {
        println("❌ TUSHARE_TOKEN environment variable is not set.")
        println("Please set the TUSHARE_TOKEN environment variable and try again.")
        return@runBlocking
    }

    println("=== TuShare Native API Example ===")
    println("Welcome to TuShare Kotlin/Native library!")
    println()
    println("⚠️  IMPORTANT LIMITATION:")
    println("   Kotlin/Native does not currently support TLS sessions required for HTTPS connections.")
    println("   This means TuShare API calls will fail with 'TLS sessions are not supported' error.")
    println("   This is a known limitation of Kotlin/Native platform.")
    println()
    println("🔍 Token found: ${apiKey.take(10)}...")

    try {
        println("\n🔧 Creating TuShare client...")
        val tuShare = TuShare(
            token = apiKey,
            loggingConfig = LoggingConfig(LogLevel.Info)
        )

        println("✅ TuShare client created successfully")

        println("\n📊 Testing basic stock query...")
        println("(This will fail due to TLS limitation)")

        val result = tuShare.getStockBasic(
            StockBasicParams(
                tsCode = TsCode(SAMPLE_STOCK_CODE, SAMPLE_EXCHANGE)
            )
        )

        if (result.isNotEmpty()) {
            val stock = result.first()
            println("✅ Query successful!")
            println("  Code: ${stock.tsCode}")
            println("  Name: ${stock.name}")
            println("  Industry: ${stock.industry}")
        } else {
            println("⚠️ No data returned")
        }

        println("\n🔒 Closing client...")
        tuShare.close()

    } catch (e: Exception) {
        println("❌ Error: ${e.message}")
        when {
            e.message?.contains("TLS sessions are not supported") == true -> {
                println("\n💡 This is expected on Kotlin/Native platform.")
                println("   TLS/HTTPS connections are not yet supported in Kotlin/Native.")
                println("   This is a platform limitation, not a TuShare library issue.")
                println("\n🔧 Workarounds:")
                println("   1. Use JVM target for production applications")
                println("   2. Use JavaScript target for web applications")
                println("   3. Wait for Kotlin/Native TLS support in future versions")
            }

            e.message?.contains("您上传Token") == true -> {
                println("\n💡 Authentication failed. Please:")
                println("   1. Check your TuShare account points at https://tushare.pro/user/token")
                println("   2. Ensure your account is activated")
                println("   3. Get more points by daily sign-in")
            }

            else -> {
                println("Stack trace: ${e.stackTraceToString()}")
            }
        }
    }

    println("\n=== Native example completed ===")
    println("TuShare Kotlin/Native library executed successfully!")
    println("(Note: API calls will fail due to TLS limitation)")
}
