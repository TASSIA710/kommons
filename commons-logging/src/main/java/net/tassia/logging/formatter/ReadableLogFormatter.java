package net.tassia.logging.formatter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * A log formatter used to generate nice looking, easily readable log messages.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public class ReadableLogFormatter extends Formatter {

	/**
	 * The date format to use.
	 */
	protected final DateFormat dateFormat;

	/**
	 * The line seperator to use.
	 */
	protected final String crlf = System.lineSeparator();



	/**
	 * Creates a new ReadableLogFormatter with the default date format (HH:mm:ss.SSS).
	 */
	public ReadableLogFormatter() {
		this(new SimpleDateFormat("HH':'mm':'ss'.'SSS"));
	}

	/**
	 * Creates a new ReadableLogFormatter with the given date format.
	 *
	 * @param dateFormat the date format to use
	 */
	public ReadableLogFormatter(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}



	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();

		// Build prefix
		String date = dateFormat.format(new Date(record.getMillis()));
		String name = record.getLoggerName();
		name = name != null ? name + "@" + record.getLevel().getLocalizedName() : record.getLevel().getLocalizedName();
		String prefix = date + " | " + name + ": ";

		// Append message
		String msg = record.getMessage();
		if (msg != null) {
			builder.append(prefix);
			builder.append(msg);
			builder.append(crlf);
		}

		// Append exception
		Throwable cause = record.getThrown();
		if (cause != null) {
			StringWriter sw = new StringWriter();
			cause.printStackTrace(new PrintWriter(sw));

			builder.append(prefix);
			builder.append(sw);
			builder.append(crlf);
		}

		return builder.toString();
	}

}
