package net.tassia.util;

/**
 * Utility to class for encoding/decoding data in Base16.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class Base16 {

	/**
	 * The Base16 decoder.
	 */
	public static final Decoder DECODER = new Base16Decoder();

	/**
	 * The Base16 encoder.
	 */
	public static final Encoder ENCODER = new Base16Encoder();

	/**
	 * Static class.
	 */
	private Base16() {
	}





	/**
	 * {@link Encoder} implementation for Base16.
	 *
	 * @since Commons 1.0
	 * @author Tassilo
	 */
	private static final class Base16Encoder extends Encoder {

		private final char[] table = "0123456789abcdef".toCharArray();

		@Override
		public String encode(byte[] data) {
			final char[] table = this.table;
			final char[] encoded = new char[data.length * 2];

			for (int i = 0; i < data.length; i++) {
				byte value = data[i];
				encoded[i * 2] = table[(value >> 4) & 0xF];
				encoded[i * 2 + 1] = table[value & 0xF];
			}

			return new String(encoded);
		}

	}

	/**
	 * {@link Decoder} implementation for Base16.
	 *
	 * @since Commons 1.0
	 * @author Tassilo
	 */
	private static final class Base16Decoder extends Decoder {

		@Override
		public byte[] decode(String encoded) {
			char[] chars = encoded.toCharArray();
			byte[] buffer = new byte[chars.length / 2];

			for (int i = 0; i < buffer.length; i++) {
				byte a = decode(chars[i * 2]);
				byte b = decode(chars[i * 2 + 1]);
				buffer[i] = (byte) ((a << 4) | b);
			}

			return buffer;
		}

		private byte decode(char c) {
			switch (c) {
				case '0': return 0x0;
				case '1': return 0x1;
				case '2': return 0x2;
				case '3': return 0x3;
				case '4': return 0x4;
				case '5': return 0x5;
				case '6': return 0x6;
				case '7': return 0x7;
				case '8': return 0x8;
				case '9': return 0x9;
				case 'a': return 0xA;
				case 'b': return 0xB;
				case 'c': return 0xC;
				case 'd': return 0xD;
				case 'e': return 0xE;
				case 'f': return 0xF;
				default: throw new IllegalArgumentException("Illegal Base16 character: " + c);
			}
		}

	}

}
