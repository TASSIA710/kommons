package net.tassia.logging.formatter

import net.tassia.ANSI
import java.util.logging.Formatter
import java.util.logging.Level
import java.util.logging.LogRecord

/**
 * A log formatter that wraps all logs in ANSI color codes.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
class AnsiFormatter(

	/**
	 * The base formatter.
	 */
	private val base: Formatter = ReadableLogFormatter()

) : Formatter() {

	override fun format(record: LogRecord): String {
		// Get prefix
		val level = record.level
		var prefix = ""
		if (level === Level.FINE || level === Level.FINER || level === Level.FINEST) {
			prefix = ANSI.GRAY
		} else if (level === Level.WARNING) {
			prefix = ANSI.YELLOW
		} else if (level === Level.SEVERE) {
			prefix = ANSI.RED
		}

		// Build message
		return prefix + base.format(record) + ANSI.RESET
	}

}
