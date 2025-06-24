import li.mercury.tushare.TuShare
import li.mercury.tushare.api.stock.basic.models.StockBasicParams
import li.mercury.tushare.client.LoggingConfig
import li.mercury.tushare.internal.logging.LogLevel
import li.mercury.tushare.models.TsCode

/**
 * TuShare Kotlin/JS example application.
 *
 * This example demonstrates basic usage of the TuShare API for JavaScript/Node.js environments.
 * It shows how to:
 * - Initialize the TuShare client
 * - Perform basic stock information queries
 * - Handle errors appropriately
 *
 * Note: This example uses minimal APIs to avoid authentication/points issues for new users.
 */
suspend fun main() {
    println("=== TuShare JavaScript Example ===")

    // Sample stock codes for demonstration
    val SAMPLE_STOCK_CODE = "600519" // Kweichow Moutai
    val SAMPLE_EXCHANGE = "SH"       // Shanghai Stock Exchange

    val apiKey = js("process.env.TUSHARE_TOKEN").unsafeCast<String?>()
    if (apiKey.isNullOrEmpty()) {
        println("❌ TUSHARE_TOKEN environment variable is not set.")
        println("Please set the TUSHARE_TOKEN environment variable and try again.")
        return
    }

    println("🔍 Token found: ${apiKey.take(10)}...")

    try {
        println("\n🔧 Creating TuShare client...")
        val tuShare = TuShare(
            token = apiKey,
            loggingConfig = LoggingConfig(LogLevel.None)
        )

        println("✅ TuShare client created successfully")

        println("\n📊 Testing basic stock query...")
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

    println("\n=== JavaScript Example completed ===")
}
