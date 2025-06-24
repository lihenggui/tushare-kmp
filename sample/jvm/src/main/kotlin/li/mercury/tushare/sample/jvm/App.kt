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
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.TsCode

/**
 * TuShare Kotlin/JVM example application.
 *
 * This example demonstrates:
 * - TuShare client initialization and configuration
 * - Basic stock information queries
 * - Comprehensive error handling
 */
fun main() = runBlocking {
    // Sample stock for demonstration
    val SAMPLE_STOCK_CODE = "600519" // Kweichow Moutai
    val SAMPLE_EXCHANGE = "SH"       // Shanghai Stock Exchange

    val apiKey = System.getenv("TUSHARE_TOKEN")
    if (apiKey.isNullOrEmpty()) {
        println("❌ Please set TUSHARE_TOKEN environment variable.")
        return@runBlocking
    }

    try {
        println("🔧 Initializing TuShare client...")
        val tuShare = TuShare(
            token = apiKey,
            loggingConfig = LoggingConfig(LogLevel.None)
        )

        println("✅ TuShare client created successfully")

        println("\n📊 Testing single stock query (Kweichow Moutai)...")
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
            println("❌ No data found")
        }

        println("\n🔒 Closing client...")
        tuShare.close()

    } catch (e: Exception) {
        println("❌ Error: ${e.message}")
        when {
            e.message?.contains("您上传Token") == true -> {
                println("\n💡 Authentication failed. Possible solutions:")
                println("   1. Check your TuShare account points at https://tushare.pro/user/token")
                println("   2. Ensure your account is activated (verify phone/email)")
                println("   3. Get more points by daily sign-in at https://tushare.pro/user/sign")
                println("   4. Participate in TuShare community or consider donating for points")
            }

            else -> e.printStackTrace()
        }
    }

    println("\n✅ Test completed")
}
