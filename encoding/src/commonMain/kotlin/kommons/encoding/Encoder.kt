package kommons.encoding

/**
 * An encoder encodes binary data into an output format (e.g. a [String]).
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 *
 * @see Decoder
 */
fun interface Encoder<T> {

	/**
	 * Encodes the given data.
	 *
	 * @param data the data to encode
	 * @return the encoded data
	 *
	 * @throws IllegalArgumentException if the data cannot be encoded
	 */
	@Throws(IllegalArgumentException::class)
	fun encode(data: ByteArray): T

}
