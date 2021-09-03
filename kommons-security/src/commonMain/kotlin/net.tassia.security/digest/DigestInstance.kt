package net.tassia.security.digest

/**
 * A digest instance is a state of a digest algorithm.
 *
 * @param digest the type of this digest instance
 * @param params the parameters of this instance
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
abstract class DigestInstance<P : DigestParameters>(val digest: DigestType<P>, val params: P) {

	/**
	 * The size of the generated digest in bytes.
	 */
	abstract val digestSize: Int


	/**
	 * Creates a digest from the given data and salt (if applicable)
	 * and stores it in the buffer.
	 *
	 * @param data the data
	 * @param salt the salt
	 * @param buffer the buffer to store the digest in
	 * @param offset the offset in the buffer
	 */
	abstract fun digest(data: ByteArray, salt: ByteArray?, buffer: ByteArray, offset: Int)

}
