package net.tassia.logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Utility class to manage loggers.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class Logging {

	/**
	 * A map containing all registered loggers.
	 */
	private static final Map<String, Logger> LOGGERS = new HashMap<>();

	/**
	 * A collection containing the default handlers.
	 */
	private static final Collection<Handler> DEFAULT_HANDLERS = new ArrayList<>();





	/**
	 * Returns (creates if necessary) a logger with the given name.
	 *
	 * @param name the name
	 * @return the logger
	 */
	public static Logger getLogger(String name) {
		return Logging.LOGGERS.computeIfAbsent(name, (key) -> {
			// Create the logger
			Logger logger = Logger.getLogger(name);

			// Register the logger
			Logging.LOGGERS.put(name, logger);

			// Initialize the logger
			reloadLogger(logger);

			// Return the logger
			return logger;
		});
	}





	/**
	 * Reloads all loggers.
	 *
	 * @see #reloadLogger(Logger)
	 */
	public static void reloadLoggers() {
		// TODO
	}

	/**
	 * Reloads the given logger. This clears it of all handlers and re-applies the default ones.
	 *
	 * @param logger the logger
	 */
	public static void reloadLogger(Logger logger) {
		// Don't use parent handlers
		logger.setUseParentHandlers(false);

		// Remove current handlers
		for (Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
		}

		// Add default handlers
		for (Handler handler : Logging.DEFAULT_HANDLERS) {
			logger.addHandler(handler);
		}
	}





	/**
	 * Returns a mutable collection of all default handlers.
	 *
	 * @return the default handlers
	 */
	public static Collection<Handler> getDefaultHandlers() {
		return Logging.DEFAULT_HANDLERS;
	}

	/**
	 * Adds the given handler to the defaults.
	 *
	 * <b>Note:</b> This method does not reload all current loggers.
	 *
	 * @param handler the handler to add
	 */
	public static void addDefaultHandler(Handler handler) {
		Logging.DEFAULT_HANDLERS.add(handler);
	}

	/**
	 * Removes the given handler from the defaults.
	 *
	 * <b>Note:</b> This method does not reload all current loggers.
	 *
	 * @param handler the handler to remove
	 */
	public static void removeDefaultHandler(Handler handler) {
		Logging.DEFAULT_HANDLERS.remove(handler);
	}





	/**
	 * Flushes all handlers of all loggers.
	 *
	 * @see #flushLogger(Logger)
	 */
	public static void flushLoggers() {
		for (Logger logger : Logging.LOGGERS.values()) {
			closeLogger(logger);
		}
	}

	/**
	 * Flushes all handlers of the given logger.
	 *
	 * @param logger the logger
	 */
	public static void flushLogger(Logger logger) {
		for (Handler handler : logger.getHandlers()) {
			handler.flush();
		}
	}





	/**
	 * Closes all handlers of all loggers.
	 *
	 * @see #closeLogger(Logger)
	 */
	public static void closeLoggers() {
		for (Logger logger : Logging.LOGGERS.values()) {
			closeLogger(logger);
		}
	}

	/**
	 * Closes all handlers of the given logger.
	 *
	 * @param logger the logger
	 */
	public static void closeLogger(Logger logger) {
		for (Handler handler : logger.getHandlers()) {
			handler.close();
		}
		Logging.LOGGERS.remove(logger.getName());
	}





	/**
	 * Static class.
	 */
	private Logging() {
	}

}