package li.mercury.tushare.internal

import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

internal val TestFileSystem = SystemFileSystem

fun testResponsePath(filename: String): Path = Path(libRoot, "ragflow/src/commonTest/resources/responses", filename)

private val libRoot: String
    get() = env("LIB_ROOT") ?: error("Can't find `LIB_ROOT` environment variable")
