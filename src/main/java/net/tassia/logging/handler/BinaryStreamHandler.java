package net.tassia.logging.handler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class BinaryStreamHandler extends Handler {

	private final DataOutputStream stream;



	public BinaryStreamHandler(File file) throws IOException {
		this(new DataOutputStream(new FileOutputStream(file)));
	}

	public BinaryStreamHandler(DataOutputStream stream) throws IOException {
		// Assign fields
		this.stream = stream;

		// Prepare
		writeString("LOG");
		stream.writeInt(1); // version
	}



	@Override
	public void publish(LogRecord record) {
		try {
			// Silently discard null LogRecords
			if (record == null) return;

			// Write log record meta
			stream.writeLong(record.getMillis());
			stream.writeLong(record.getSequenceNumber());
			stream.writeShort(record.getLevel().intValue());
			stream.writeInt(record.getThreadID());
			writeString(record.getLoggerName());
			writeString(record.getSourceClassName());
			writeString(record.getSourceMethodName());

			// Write message
			writeString(record.getMessage());

			// Write throwable
			writeThrowable(record.getThrown());
		} catch (IOException ex) {
			throw new RuntimeException("Failed to publish log.", ex);
		}
	}

	private void writeThrowable(Throwable throwable) throws IOException {
		// Break recursion on null
		if (throwable == null) {
			writeString(null);
			return;
		}

		// Write class name
		writeString(throwable.getClass().getName());

		// Write message
		writeString(throwable.getMessage());

		// Write stack trace
		StackTraceElement[] stackTrace = throwable.getStackTrace();
		stream.writeInt(stackTrace.length);
		for (StackTraceElement element : stackTrace) {
			writeStackTraceElement(element);
		}

		// Write cause
		writeThrowable(throwable.getCause());
	}

	private void writeStackTraceElement(StackTraceElement element) throws IOException {
		String fileName = element.getFileName();
		if (fileName == null) fileName = "N/A";

		writeString(fileName);
		writeString(element.getClassName());
		writeString(element.getMethodName());
		stream.writeInt(element.getLineNumber());
	}

	private void writeString(String str) throws IOException {
		// Build bytes
		if (str == null) str = "";
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) ~bytes[i];
		}

		// Write data
		stream.writeInt(bytes.length);
		stream.write(bytes);
	}



	@Override
	public void flush() {
		try {
			stream.flush();
		} catch (IOException ex) {
			throw new RuntimeException("Failed to flush stream.", ex);
		}
	}

	@Override
	public void close() throws SecurityException {
		try {
			stream.close();
		} catch (IOException ex) {
			throw new RuntimeException("Failed to close stream.", ex);
		}
	}

}
