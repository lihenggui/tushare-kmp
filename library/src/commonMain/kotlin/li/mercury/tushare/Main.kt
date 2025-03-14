package li.mercury.tushare

import li.mercury.tushare.di.jsonModule
import li.mercury.tushare.di.tuShareClientModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(jsonModule)
        modules(tuShareClientModule)
    }
}