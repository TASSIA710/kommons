package net.tassia.logging.formatter;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * A log formatter that wraps all logs in ANSI color codes.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public class AnsiFormatter extends Formatter {

	public static final String ANSI_GRAY = "\u001B[38;2;127;127;127m";
	public static final String ANSI_YELLOW = "\u001b[33m";
	public static final String ANSI_RED = "\u001b[31m";

	public static final String ANSI_RESET= "\u001b[0m";

	/**
	 * The base formatter.
	 */
	private final Formatter base;



	/**
	 * Creates a new AnsiFormatter using a {@link ReadableLogFormatter} as base.
	 */
	public AnsiFormatter() {
		this(new ReadableLogFormatter());
	}

	/**
	 * Creates a new AnsiFormatter with the given base formatter.
	 * The base formatter generates the text that will be wrapped around ANSI color tags.
	 *
	 * @param base the base formatter
	 */
	public AnsiFormatter(Formatter base) {
		this.base = base;
	}



	@Override
	public String format(LogRecord record) {
		// Get prefix
		Level level = record.getLevel();
		String prefix = "";
		if (level == Level.FINE || level == Level.FINER || level == Level.FINEST) {
			prefix = ANSI_GRAY;
		} else if (level == Level.WARNING) {
			prefix = ANSI_YELLOW;
		} else if (level == Level.SEVERE) {
			prefix = ANSI_RED;
		}

		// Build message
		return prefix + base.format(record) + ANSI_RESET;
	}

}
