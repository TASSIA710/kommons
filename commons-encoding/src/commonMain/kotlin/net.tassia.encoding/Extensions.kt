package net.tassia.encoding

/**
 * Decodes this string.
 *
 * @param decoder the decoder to use
 * @return the decoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun String.decode(decoder: Decoder): ByteArray {
	return decoder.decode(this)
}

/**
 * Encodes this byte array.
 *
 * @param encoder the encoder to use
 * @return the encoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.encode(encoder: Encoder): String {
	return encoder.encode(this)
}



/**
 * Decodes this string using Base16.
 *
 * @return the decoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun String.base16(): ByteArray {
	return this.decode(Base16)
}

/**
 * Encodes this byte array using Base16.
 *
 * @return the encoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.base16(): String {
	return this.encode(Base16)
}



/**
 * Decodes this string using Base64.
 *
 * @return the decoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun String.base64(): ByteArray {
	return this.decode(Base64)
}

/**
 * Encodes this byte array using Base64.
 *
 * @return the encoded data
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.base64(): String {
	return this.encode(Base64)
}
