package li.mercury.tushare.models

/**
 * TuShare API返回的错误代码
 */
public object TuShareErrorCodes {
    public const val SUCCESS: Int = 0
    public const val AUTH_FAILED: Int = 2002
    public const val RATE_LIMIT_EXCEEDED: Int = 2003
    public const val PERMISSION_DENIED: Int = 2004
    public const val INVALID_PARAMS: Int = 2005
    public const val INTERNAL_ERROR: Int = 5000
}
