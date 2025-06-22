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
package li.mercury.tushare.util

import kotlinx.io.RawSource
import kotlinx.io.Source
import kotlinx.io.files.FileSystem
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

/**
 * Represents a file resource.
 */
public class FileSource(
    /**
     * File name.
     */
    public val name: String,
    /**
     * File source.
     */
    public val source: RawSource,
) {
    /**
     * Create [FileSource] instance.
     *
     * @param path the file path to upload
     * @param fileSystem file system to be used
     */
    public constructor(path: Path, fileSystem: FileSystem = SystemFileSystem) : this(path.name, fileSystem.source(path))
}

/**
 * Represents a file resource.
 */
public fun fileSource(block: FileSourceBuilder.() -> Unit): FileSource = FileSourceBuilder().apply(block).build()

/**
 * Builder of [FileSource] instances.
 */
public class FileSourceBuilder {
    /**
     * File name.
     */
    public var name: String? = null

    /**
     * File source.
     */
    public var source: Source? = null

    /**
     * Creates the [FileSource] instance
     */
    public fun build(): FileSource =
        FileSource(
            name = requireNotNull(name) { "name is required" },
            source = requireNotNull(source) { "source is required" },
        )
}
