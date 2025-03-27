package li.mercury.tushare.models

/**
 * TuShare API调用失败时抛出的异常
 */
class TuShareException(message: String, val code: Int) : Exception(message) 