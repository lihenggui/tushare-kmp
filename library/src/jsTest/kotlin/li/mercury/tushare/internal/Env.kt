package li.mercury.ragflow.internal

internal actual fun env(name: String): String? = js("globalThis.process.env[name]") as String?
