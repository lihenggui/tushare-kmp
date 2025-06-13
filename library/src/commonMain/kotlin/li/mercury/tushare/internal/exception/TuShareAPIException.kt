package li.mercury.tushare.internal.exception

/**
 * Represents an exception thrown when an error occurs while interacting with the TuShare API.
 *
 * @property statusCode the HTTP status code associated with the error.
 * @property error an instance of [TuShareError] containing information about the error that occurred.
 */
public sealed class TuShareAPIException(
    public val statusCode: Int,
    public val error: TuShareError,
    throwable: Throwable? = null,
) : TuShareException(message = error.detail?.msg, throwable = throwable)

/**
 * Represents an exception thrown when the TuShare API rate limit is exceeded.
 */
public class RateLimitException(
    statusCode: Int,
    error: TuShareError,
    throwable: Throwable? = null,
) : TuShareAPIException(statusCode, error, throwable)

/**
 * Represents an exception thrown when an invalid request is made to the TuShare API.
 */
public class InvalidRequestException(
    statusCode: Int,
    error: TuShareError,
    throwable: Throwable? = null,
) : TuShareAPIException(statusCode, error, throwable)

/**
 * Represents an exception thrown when an authentication error occurs while interacting with the TuShare API.
 */
public class AuthenticationException(
    statusCode: Int,
    error: TuShareError,
    throwable: Throwable? = null,
) : TuShareAPIException(statusCode, error, throwable)

/**
 * Represents an exception thrown when a permission error occurs while interacting with the TuShare API.
 */
public class PermissionException(
    statusCode: Int,
    error: TuShareError,
    throwable: Throwable? = null,
) : TuShareAPIException(statusCode, error, throwable)

/**
 * Represents an exception thrown when an unknown error occurs while interacting with the TuShare API.
 * This exception is used when the specific type of error is not covered by the existing subclasses.
 */
public class UnknownAPIException(
    statusCode: Int,
    error: TuShareError,
    throwable: Throwable? = null,
) : TuShareAPIException(statusCode, error, throwable)
