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
