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
