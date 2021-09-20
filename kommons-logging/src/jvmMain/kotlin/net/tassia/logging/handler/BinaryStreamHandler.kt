package net.tassia.logging.handler

import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets
import java.util.logging.Handler
import java.util.logging.LogRecord
import kotlin.experimental.inv

class BinaryStreamHandler(private val stream: DataOutputStream) : Handler() {

    constructor(file: File) : this(DataOutputStream(FileOutputStream(file)))

    override fun publish(record: LogRecord?) {
		// Silently discard null LogRecords
		if (record == null) return

		// Write log record meta
		stream.writeLong(record.millis)
		stream.writeLong(record.sequenceNumber)
		stream.writeShort(record.level.intValue())
		stream.writeInt(record.threadID)
		writeString(record.loggerName)
		writeString(record.sourceClassName)
		writeString(record.sourceMethodName)

		// Write message
		writeString(record.message)

		// Write throwable
		writeThrowable(record.thrown)
    }

    private fun writeThrowable(throwable: Throwable?) {
        // Break recursion on null
        if (throwable == null) {
            writeString(null)
            return
        }

        // Write class name
        writeString(throwable.javaClass.name)

        // Write message
        writeString(throwable.message)

        // Write stack trace
        val stackTrace = throwable.stackTrace
        stream.writeInt(stackTrace.size)
        for (element in stackTrace) {
            writeStackTraceElement(element)
        }

        // Write cause
        writeThrowable(throwable.cause)
    }

    private fun writeStackTraceElement(element: StackTraceElement) {
        var fileName = element.fileName
        if (fileName == null) fileName = "N/A"
        writeString(fileName)
        writeString(element.className)
        writeString(element.methodName)
        stream.writeInt(element.lineNumber)
    }

    private fun writeString(str: String?) {
        // Build bytes
        var str = str
        if (str == null) str = ""
        val bytes = str.toByteArray(StandardCharsets.UTF_8)
        for (i in bytes.indices) {
            bytes[i] = bytes[i].inv()
        }

        // Write data
        stream.writeInt(bytes.size)
        stream.write(bytes)
    }

    override fun flush() {
		stream.flush()
    }

    override fun close() {
		stream.close()
    }

    init {
        // Prepare
        writeString("LOG")
        stream.writeInt(1) // version
    }

}
