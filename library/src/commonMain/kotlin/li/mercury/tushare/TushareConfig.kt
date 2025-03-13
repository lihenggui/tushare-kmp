package li.mercury.tushare

object TushareConfig {
    private var _token: String? = null

    val TOKEN: String
        get() = _token ?: throw IllegalStateException(
            """
            Tushare token is not config, use command to config: TushareConfig.initialize("your_token") 
            """.trimIndent()
        )

    fun initialize(token: String) {
        _token = token
    }
}