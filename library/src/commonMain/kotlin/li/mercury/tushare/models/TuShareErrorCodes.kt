package li.mercury.tushare.models

/**
 * TuShare API返回的错误代码
 */
object TuShareErrorCodes {
    const val SUCCESS = 0
    const val AUTH_FAILED = 2002
    const val RATE_LIMIT_EXCEEDED = 2003
    const val PERMISSION_DENIED = 2004
    const val INVALID_PARAMS = 2005
    const val INTERNAL_ERROR = 5000
}
