package kommons.encoding

/**
 * A decoder is used to decode data from a given format (e.g. a [String]) back into its binary format.
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 *
 * @see Encoder
 */
fun interface Decoder<T> {

	/**
	 * Decodes the given data.
	 *
	 * @param data the data to decode
	 * @return the decoded data
	 *
	 * @throws IllegalArgumentException if the data cannot be decoded
	 */
	@Throws(IllegalArgumentException::class)
	fun decode(data: T): ByteArray

}
