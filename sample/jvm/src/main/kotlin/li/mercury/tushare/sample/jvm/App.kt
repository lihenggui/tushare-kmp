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
