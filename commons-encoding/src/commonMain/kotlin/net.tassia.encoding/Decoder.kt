package net.tassia.encoding

/**
 * A decoder is used to decode encoded data back to raw binary data.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
interface Decoder {

	/**
	 * Decodes the given encoded data.
	 *
	 * @param encoded the encoded data
	 * @return the decoded binary data
	 */
	fun decode(encoded: String): ByteArray

}
