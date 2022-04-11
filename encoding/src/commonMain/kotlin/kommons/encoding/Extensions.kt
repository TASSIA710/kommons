package kommons.encoding

/**
 * Encodes this byte-array using Base16 (hexadecimal).
 *
 * @receiver the data to encode
 * @return the encoded data
 *
 * @see [Base16]
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
fun ByteArray.base16(): String {
	return Base16.encode(this)
}

/**
 * Decodes this hexadecimal string back to a byte-array.
 *
 * @receiver the string to decode
 * @return the decoded data
 *
 * @see Base16
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
fun String.base16(): ByteArray {
	return Base16.decode(this)
}

/**
 * Encodes this byte-array using Base64.
 *
 * @receiver the data to encode
 * @return the encoded data
 *
 * @see [Base64]
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
fun ByteArray.base64(): String {
	return Base64.encode(this)
}

/**
 * Decodes this Base64 string back to a byte-array.
 *
 * @receiver the string to decode
 * @return the decoded data
 *
 * @see Base64
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
fun String.base64(): ByteArray {
	return Base64.decode(this)
}
