package net.tassia.encoding

/**
 * An encoder is used to encode raw binary data.
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
interface Encoder {

	/**
	 * Encodes the given data.
	 *
	 * @param data the data
	 * @return the encoded data
	 */
	fun encode(data: ByteArray): String

}
