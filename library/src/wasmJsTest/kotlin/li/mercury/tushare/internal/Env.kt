package li.mercury.ragflow.internal

internal actual fun env(name: String): String? = getEnv(name)

fun getEnv(value: String): String? = js("""globalThis.process.env[value]""")
