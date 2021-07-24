package net.tassia.util;

/**
 * Utility to class for encoding/decoding data in Base64.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class Base64 {

	public static final Decoder DECODER = new Base64Decoder(java.util.Base64.getDecoder());
	public static final Encoder ENCODER = new Base64Encoder(java.util.Base64.getEncoder());

	public static final Decoder URL_DECODER = new Base64Decoder(java.util.Base64.getUrlDecoder());
	public static final Encoder URL_ENCODER = new Base64Encoder(java.util.Base64.getUrlEncoder());

	public static final Decoder MIME_DECODER = new Base64Decoder(java.util.Base64.getMimeDecoder());
	public static final Encoder MIME_ENCODER = new Base64Encoder(java.util.Base64.getMimeEncoder());



	/**
	 * Static class.
	 */
	private Base64() {
	}





	/**
	 * {@link Encoder} implementation using Java's native Base64 library.
	 *
	 * @since Commons 1.0
	 * @author Tassilo
	 */
	private static final class Base64Encoder extends Encoder {

		private final java.util.Base64.Encoder nativeEncoder;

		private Base64Encoder(java.util.Base64.Encoder nativeEncoder) {
			this.nativeEncoder = nativeEncoder;
		}

		@Override
		public String encode(byte[] data) {
			return nativeEncoder.encodeToString(data);
		}

	}

	/**
	 * {@link Decoder} implementation using Java's native Base64 library.
	 *
	 * @since Commons 1.0
	 * @author Tassilo
	 */
	private static final class Base64Decoder extends Decoder {

		private final java.util.Base64.Decoder nativeDecoder;

		private Base64Decoder(java.util.Base64.Decoder nativeDecoder) {
			this.nativeDecoder = nativeDecoder;
		}

		@Override
		public byte[] decode(String encoded) {
			return nativeDecoder.decode(encoded);
		}

	}

}
