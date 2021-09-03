package net.tassia.logging

import java.util.ArrayList
import java.util.HashMap
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Utility class to manage loggers.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
object Logging {

    /**
     * A map containing all registered loggers.
     */
    private val LOGGERS: MutableMap<String, Logger> = HashMap()

    /**
     * A collection containing the default handlers.
     */
    private val DEFAULT_HANDLERS: MutableCollection<Handler> = ArrayList()

    /**
     * The default logging level.
     */
    var defaultLevel = Level.INFO



    /**
     * Returns (creates if necessary) a logger with the given name.
     *
     * @param name the name
     * @return the logger
     */
    operator fun get(name: String): Logger {
        return LOGGERS.computeIfAbsent(name) { key: String? ->
            // Create the logger
            val logger = Logger.getLogger(name)

            // Set level
            logger.level = defaultLevel

            // Initialize the logger
            reloadLogger(logger)
            logger
        }
    }





    /**
     * Reloads all loggers.
     *
     * @see .reloadLogger
     */
    fun reloadLoggers() {
        for (logger in LOGGERS.values) {
            reloadLogger(logger)
        }
    }

    /**
     * Reloads the given logger. This clears it of all handlers and re-applies the default ones.
     *
     * @param logger the logger
     */
    fun reloadLogger(logger: Logger) {
        // Don't use parent handlers
        logger.useParentHandlers = false

        // Remove current handlers
        for (handler in logger.handlers) {
            logger.removeHandler(handler)
        }

        // Add default handlers
        for (handler in DEFAULT_HANDLERS) {
            logger.addHandler(handler)
        }
    }





    /**
     * Returns a mutable collection of all default handlers.
     *
     * @return the default handlers
     */
    val defaultHandlers: Collection<Handler>
        get() = DEFAULT_HANDLERS

    /**
     * Adds the given handler to the defaults.
     *
     * **Note:** This method does not reload all current loggers.
     *
     * @param handler the handler to add
     */
    fun addDefaultHandler(handler: Handler) {
        DEFAULT_HANDLERS.add(handler)
    }

    /**
     * Removes the given handler from the defaults.
     *
     * **Note:** This method does not reload all current loggers.
     *
     * @param handler the handler to remove
     */
    fun removeDefaultHandler(handler: Handler) {
        DEFAULT_HANDLERS.remove(handler)
    }





    /**
     * Flushes all handlers of all loggers.
     *
     * @see .flushLogger
     */
    fun flushLoggers() {
        for (logger in LOGGERS.values) {
            flushLogger(logger)
        }
    }

    /**
     * Flushes all handlers of the given logger.
     *
     * @param logger the logger
     */
    fun flushLogger(logger: Logger) {
        for (handler in logger.handlers) {
            handler.flush()
        }
    }





    /**
     * Closes all handlers of all loggers.
     *
     * @see .closeLogger
     */
    fun closeLoggers() {
        val loggers = LOGGERS.values.toTypedArray()
        for (logger in loggers) {
            closeLogger(logger)
        }
    }

    /**
     * Closes all handlers of the given logger.
     *
     * @param logger the logger
     */
    fun closeLogger(logger: Logger) {
        for (handler in logger.handlers) {
            handler.close()
        }
        LOGGERS.remove(logger.name)
    }

}
