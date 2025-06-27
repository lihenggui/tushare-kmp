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
package li.mercury.tushare.plugins

import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import kotlinx.serialization.json.Json
import li.mercury.tushare.client.JsonLenient
import li.mercury.tushare.models.TuShareRequest

/**
 * A plugin that transforms request bodies by adding a token to TuShareRequest objects.
 * This plugin uses transformRequestBody instead of onRequest to achieve the same functionality as AuthPlugin.
 */
internal val AuthPlugin =
    createClientPlugin("AuthPlugin", ::AuthPluginConfig) {
        val token = pluginConfig.token
        val json = pluginConfig.json

        // Transform the request body by adding the token
        transformRequestBody { request, content, bodyType ->
            if (bodyType?.type == TuShareRequest::class && content is TextContent) {
                // Extract the text content
                val jsonText = content.text

                // Try to parse it as a TuShareRequest
                val tuShareRequest = json.decodeFromString<TuShareRequest>(jsonText)

                // Create a new TuShareRequest with the token
                val bodyWithToken = tuShareRequest.copy(token = token)

                // Serialize back to JSON and return as TextContent
                val jsonContent = json.encodeToString(bodyWithToken)
                TextContent(jsonContent, ContentType.Application.Json)
            } else {
                // Return null to indicate that this transformation is not applicable
                null
            }
        }
    }

/**
 * Configuration for the AuthPlugin.
 */
internal class AuthPluginConfig(
    var token: String = "",
    var json: Json = JsonLenient,
)
