package li.mercury.tushare.internal.extension

import kotlin.time.Duration

/**
 * Http operations timeouts.
 *
 * @param request time period required to process an HTTP call: from sending a request to receiving a response
 * @param connect time period in which a client should establish a connection with a server
 * @param socket maximum time of inactivity between two data packets when exchanging data with a server
 */
class Timeout(
    val request: Duration? = null,
    val connect: Duration? = null,
    val socket: Duration? = null,
)
