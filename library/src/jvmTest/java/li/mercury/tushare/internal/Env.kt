package li.mercury.ragflow.internal

internal actual fun env(name: String): String? = System.getenv(name)
