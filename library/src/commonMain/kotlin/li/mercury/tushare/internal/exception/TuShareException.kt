package li.mercury.tushare.internal.exception

/** TuShare client exception */
public sealed class TuShareException(
    message: String? = null,
    throwable: Throwable? = null,
) : RuntimeException(message, throwable)

/** Runtime Http Client exception */
public class TuShareHttpException(
    throwable: Throwable? = null,
) : TuShareException(throwable?.message, throwable)

/** An exception thrown in case of a server error */
public class TuShareServerException(
    throwable: Throwable? = null,
) : TuShareException(message = throwable?.message, throwable = throwable)
