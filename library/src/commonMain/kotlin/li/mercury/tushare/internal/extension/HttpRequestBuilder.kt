/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *
 * Copyright (C) 2025 Mercury Li
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package li.mercury.tushare.internal.extension

import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder

/**
 * Apply request options to the request builder.
 */
internal fun HttpRequestBuilder.requestOptions(requestOptions: RequestOptions? = null) {
    if (requestOptions == null) return
    requestOptions.headers.forEach { (key, value) ->
        if (headers.contains(key)) headers.remove(key)
        headers[key] = value
    }
    requestOptions.urlParameters.forEach { (key, value) -> url.parameters.append(key, value) }
    requestOptions.timeout?.let { timeout ->
        timeout {
            timeout.connect?.let { connectTimeout -> connectTimeoutMillis = connectTimeout.inWholeMilliseconds }
            timeout.request?.let { requestTimeout -> requestTimeoutMillis = requestTimeout.inWholeMilliseconds }
            timeout.socket?.let { socketTimeout -> socketTimeoutMillis = socketTimeout.inWholeMilliseconds }
        }
    }
}
