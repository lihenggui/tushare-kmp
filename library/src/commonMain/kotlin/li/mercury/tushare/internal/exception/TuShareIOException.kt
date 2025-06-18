package li.mercury.tushare.internal.exception

/** An exception thrown in case of an I/O error */
public sealed class TuShareIOException(
    throwable: Throwable? = null,
) : TuShareException(message = throwable?.message, throwable = throwable)

/** An exception thrown in case a request times out. */
public class TuShareTimeoutException(
    throwable: Throwable,
) : TuShareIOException(throwable = throwable)

/** An exception thrown in case of an I/O error */
public class GenericIOException(
    throwable: Throwable? = null,
) : TuShareIOException(throwable = throwable)
