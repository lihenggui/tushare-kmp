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
package li.mercury.tushare.http

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.typeInfo

/**
 * HTTP请求器接口
 * 提供类型安全的HTTP请求抽象
 */
internal interface HttpRequester : AutoCloseable {
    /**
     * 执行HTTP请求并返回指定类型的结果
     * @param info 类型信息，用于反序列化
     * @param block HTTP请求构建器
     * @return 反序列化后的响应对象
     */
    suspend fun <T : Any> perform(
        info: TypeInfo,
        block: suspend (HttpClient) -> HttpResponse,
    ): T

    /**
     * 执行HTTP请求并处理响应
     * @param builder HTTP请求构建器
     * @param block 响应处理器
     * @return 处理后的结果
     */
    suspend fun <T : Any> perform(
        builder: HttpRequestBuilder,
        block: suspend (response: HttpResponse) -> T,
    )
}

/**
 * 内联函数，提供类型安全的HTTP请求
 */
internal suspend inline fun <reified T> HttpRequester.perform(noinline block: suspend (HttpClient) -> HttpResponse): T =
    perform(typeInfo<T>(), block)
