package li.mercury.tushare.internal.exception

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an error response from the TuShare API.
 *
 * @param detail information about the error that occurred.
 */
@Serializable
public data class TuShareError(
    @SerialName("error") public val detail: TuShareErrorDetails? = null,
)

/**
 * Represents an error object returned by the TuShare API.
 */
@Serializable
public data class TuShareErrorDetails(
    /**
     * An error code identifying the error type.
     */
    @SerialName("code") val code: String? = null,
    /**
     * A human-readable message providing more details about the error.
     */
    @SerialName("message") val msg: String? = null,
    /**
     * The data associated with the error, if applicable.
     */
    @SerialName("data") val data: String? = null,
    /**
     * The request ID associated with the error, useful for debugging and tracing requests.
     */
    @SerialName("request_id") val requestId: String? = null,
)
