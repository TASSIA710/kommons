package net.tassia.logging.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A logging handler that writes logs to a given PrintStream.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public class PrintStreamHandler extends Handler {

	/**
	 * The stream.
	 */
	protected final PrintStream stream;



	/**
	 * Creates a {@link PrintStream} for the given file and then uses that.
	 *
	 * @param file the file to write to
	 * @param formatter the formatter to use
	 *
	 * @throws FileNotFoundException if the file couldn't be found
	 */
	public PrintStreamHandler(File file, Formatter formatter) throws FileNotFoundException {
		this(new PrintStream(file), formatter);
	}

	/**
	 * Creates new PrintStreamHandler with the given underlying PrintStream.
	 *
	 * @param stream the stream to use
	 * @param formatter the formatter to use
	 */
	public PrintStreamHandler(PrintStream stream, Formatter formatter) {
		this.stream = stream;
		setFormatter(formatter);
	}



	@Override
	public void publish(LogRecord record) {
		// Silently discord null records
		if (record == null) return;

		// Format & print the record
		String formatted = getFormatter().format(record);
		stream.print(formatted);
	}

	@Override
	public void flush() {
		// Flush the stream
		stream.flush();
	}

	@Override
	public void close() throws SecurityException {
		// Close the stream
		stream.close();
	}

}
