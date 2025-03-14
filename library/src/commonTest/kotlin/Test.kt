import kotlinx.coroutines.runBlocking
import li.mercury.tushare.TuShareClient
import li.mercury.tushare.TushareConfig
import li.mercury.tushare.di.jsonModule
import li.mercury.tushare.di.tuShareClientModule
import li.mercury.tushare.model.Fields
import li.mercury.tushare.model.TushareApiConfig
import li.mercury.tushare.model.getApiParams
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import kotlin.test.Test

class TuShareClientTest : KoinTest {
    private val client: TuShareClient by inject()

    @Test
    fun main() = runBlocking {
        startKoin {
            modules(jsonModule)
            modules(tuShareClientModule)
        }
        // Set up the token before making any API calls
        TushareConfig.initialize("")
        test()
    }

    private suspend fun test() {
        try {
            val annDParams = getApiParams(TushareApiConfig.AnnsD)
            val annDFields = TushareApiConfig.AnnsD.availableFields
            println("Available fields: $annDFields")
            println("API parameters: $annDParams")

            val response = client.requestAnnD(
                fields = listOf(Fields.TS_CODE)
            ) {
                tsCode("000001.SZ")
            }

            if (response.code == 200) {
                println("Data received: ${response.data}")
            } else {
                println("Error: ${response.code} - ${response.msg}")
            }
        } catch (e: Exception) {
            println("Exception occurred: ${e.message}")
            e.printStackTrace()
        }
    }
}
