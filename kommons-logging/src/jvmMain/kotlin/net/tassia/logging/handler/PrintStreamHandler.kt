package net.tassia.logging.handler

import java.io.File
import java.io.PrintStream
import java.util.logging.Formatter
import java.util.logging.Handler
import java.util.logging.LogRecord

/**
 * A logging handler that writes logs to a given PrintStream.
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
class PrintStreamHandler(private val stream: PrintStream, formatter: Formatter) : Handler() {

    /**
     * Creates a [PrintStream] for the given file and then uses that.
     *
     * @param file the file to write to
     * @param formatter the formatter to use
     */
    constructor(file: File, formatter: Formatter) : this(PrintStream(file), formatter)

	override fun publish(record: LogRecord?) {
        // Silently discord null records
        if (record == null) return

        // Format & print the record
        val formatted = formatter.format(record)
        stream.print(formatted)
    }

    override fun flush() {
        // Flush the stream
        stream.flush()
    }

    override fun close() {
        // Close the stream
        stream.close()
    }

    /**
     * Creates new PrintStreamHandler with the given underlying PrintStream.
     *
     * @param stream the stream to use
     * @param formatter the formatter to use
     */
    init {
        setFormatter(formatter)
    }

}
