package net.tassia.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides common utilities for streams.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class Streams {

	/**
	 * Reads all bytes from the given input stream. This method uses a reasonable
	 * buffer size. The current value is <code>4096 bytes</code>, however this value
	 * is subject to change at any time.
	 *
	 * @param input the input stream
	 * @return the bytes read from the input stream
	 * @throws IOException if an I/O error occurs
	 */
	public static byte[] readAllBytes(InputStream input) throws IOException {
		return readAllBytes(input, 4096);
	}

	/**
	 * Reads all bytes from the given input stream.
	 *
	 * @param input the input stream
	 * @param bufferSize the size of the internal buffer (the buffer will still increase if needed)
	 * @return the bytes read from the input stream
	 * @throws IOException if an I/O error occurs
	 */
	public static byte[] readAllBytes(InputStream input, int bufferSize) throws IOException {
		// Check buffer size
		if (bufferSize <= 0) {
			throw new IllegalArgumentException("Illegal buffer size: " + bufferSize);
		}

		// Initialize variables
		int offset = 0;
		byte[] buffer = new byte[bufferSize];

		// Main loop
		while (true) {
			int count = input.read(buffer, offset, buffer.length - offset);

			// Done reading
			if (count == -1) {
				byte[] finalBuffer = new byte[offset];
				System.arraycopy(buffer, 0, finalBuffer, 0, offset);
				return finalBuffer;
			}
			if (count < buffer.length - offset) {
				byte[] finalBuffer = new byte[offset + count];
				System.arraycopy(buffer, 0, finalBuffer, 0, finalBuffer.length);
				return finalBuffer;
			}

			// There's still data left
			byte[] temp = buffer;
			buffer = new byte[temp.length * 2];
			offset = temp.length;
			System.arraycopy(temp, 0, buffer, 0, temp.length);
		}
	}



	/**
	 * Static class.
	 */
	private Streams() {
	}

}
