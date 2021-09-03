package net.tassia.logging.formatter

import java.io.PrintWriter
import java.io.StringWriter
import java.lang.StringBuilder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Formatter
import java.util.logging.LogRecord

/**
 * A log formatter used to generate nice looking, easily readable log messages.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
class ReadableLogFormatter(

	/**
	 * The date format to use.
	 */
	private val dateFormat: DateFormat = SimpleDateFormat("HH':'mm':'ss'.'SSS")

) : Formatter() {

	/**
	 * The line separator to use.
	 */
	private val crlf = System.lineSeparator()

	override fun format(record: LogRecord): String {
		val builder = StringBuilder()

		// Build prefix
		val date = dateFormat.format(Date(record.millis))
		var name = record.loggerName
		name = if (name != null) name + "@" + record.level.localizedName else record.level.localizedName
		val prefix = "$date | $name: "

		// Append message
		val msg = record.message
		if (msg != null) {
			builder.append(prefix)
			builder.append(msg)
			builder.append(crlf)
		}

		// Append exception
		val cause = record.thrown
		if (cause != null) {
			val sw = StringWriter()
			cause.printStackTrace(PrintWriter(sw))
			builder.append(prefix)
			builder.append(sw)
			builder.append(crlf)
		}
		return builder.toString()
	}

}
