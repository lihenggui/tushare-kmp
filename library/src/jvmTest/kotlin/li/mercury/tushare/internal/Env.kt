package li.mercury.tushare.internal

internal actual fun env(name: String): String? = System.getenv(name)
