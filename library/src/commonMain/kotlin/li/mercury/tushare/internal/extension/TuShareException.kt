package li.mercury.tushare.internal.extension

import kotlinx.serialization.Serializable

/**
 * TuShare API异常基类
 */
sealed class TuShareException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)

/**
 * HTTP传输层异常
 */
class TuShareHttpException(
    message: String,
    cause: Throwable? = null
) : TuShareException(message, cause)

/**
 * API业务异常
 */
open class TuShareAPIException(
    open val code: Int,
    open val error: TuShareError,
    cause: Throwable? = null
) : TuShareException(error.msg ?: "Unknown API error", cause)

/**
 * 认证异常
 */
class TuShareAuthenticationException(
    override val code: Int,
    override val error: TuShareError,
    cause: Throwable? = null
) : TuShareAPIException(code, error, cause)

/**
 * 请求频率限制异常
 */
class TuShareRateLimitException(
    override val code: Int,
    override val error: TuShareError,
    cause: Throwable? = null
) : TuShareAPIException(code, error, cause)

/**
 * 无效请求异常
 */
class TuShareInvalidRequestException(
    override val code: Int,
    override val error: TuShareError,
    cause: Throwable? = null
) : TuShareAPIException(code, error, cause)

/**
 * 服务器异常
 */
class TuShareServerException(
    override val code: Int,
    override val error: TuShareError,
    cause: Throwable? = null
) : TuShareAPIException(code, error, cause)

/**
 * 超时异常
 */
class TuShareTimeoutException(
    message: String,
    cause: Throwable? = null
) : TuShareException(message, cause)

/**
 * 网络IO异常
 */
class TuShareIOException(
    message: String,
    cause: Throwable? = null
) : TuShareException(message, cause)

/**
 * 通用API异常，用于不需要详细错误信息的情况
 */
class TuShareGenericException(
    message: String,
    cause: Throwable? = null
) : TuShareException(message, cause)

/**
 * TuShare错误响应
 */
@Serializable
data class TuShareError(
    val code: Int? = null,
    val msg: String? = null,
    val details: String? = null
)
