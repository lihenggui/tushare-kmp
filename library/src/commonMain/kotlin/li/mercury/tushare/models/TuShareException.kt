package li.mercury.tushare.models

/**
 * TuShare API调用失败时抛出的异常
 */
public class TuShareException(
    message: String,
    public val code: Int,
) : Exception(message)
