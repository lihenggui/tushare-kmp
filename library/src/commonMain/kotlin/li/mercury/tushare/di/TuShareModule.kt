package li.mercury.tushare.di

import kotlinx.serialization.json.Json
import li.mercury.tushare.TuShareClient
import org.koin.dsl.module

val jsonModule = module {
    single {
        Json {
            explicitNulls = false
            encodeDefaults = true
        }
    }
}

val tuShareClientModule = module {
    single<TuShareClient> {
        TuShareClient(get())
    }
}
