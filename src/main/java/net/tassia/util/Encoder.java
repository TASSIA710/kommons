package net.tassia.util;

/**
 * An encoder is used to encode raw binary data.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public abstract class Encoder {

	/**
	 * Encodes the given data.
	 *
	 * @param data the data
	 * @return the encoded data
	 */
	public abstract String encode(byte[] data);

}
