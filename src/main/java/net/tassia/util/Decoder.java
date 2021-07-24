package net.tassia.util;

/**
 * An decoder is used to decode encoded data back to raw binary data.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public abstract class Decoder {

	/**
     * Decodes the given encoded data.
	 *
	 * @param encoded the encoded data
	 * @return the decoded binary data
	 */
	public abstract byte[] decode(String encoded);

}
