package com.aallam.openai.api.logging

/**
 * Http client logger.
 */
enum class Logger {

    /**
     * Default logger to use.
     */
    Default,

    /**
     * Logger using println.
     */
    Simple,

    /**
     * Empty Logger for test purpose.
     */
    Empty
}
