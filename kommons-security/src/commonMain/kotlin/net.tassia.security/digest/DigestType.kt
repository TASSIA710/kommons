package net.tassia.security.digest

/**
 * A message digest.
 *
 * **Requirements for the identifier:**
 * - Must be unique (at least within one [Digests] environment), as it will be used in the encoded string
 * - Must only consist of letters, digits, '-' and '_'
 * - Should be as short as possible, while remaining unique (e.g. "sha1" instead of "Secure-Hash-Algorithm-1")
 *
 * @param identifier the identifier of this digest
 * @param displayName a nicely formatted, readable display text for this digest
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
abstract class DigestType<P : DigestParameters>(val identifier: String, val displayName: String) {

	/**
	 * The default parameters of this digest.
	 */
	abstract val defaultParameters: P

	/**
	 * Creates a new digest instance for this digest using the given parameters.
	 *
	 * @param params the parameters to use
	 * @return the created digest instance
	 */
	abstract fun create(params: P = defaultParameters): DigestInstance<P>



	/**
	 * Serializes the parameters into a byte array.
	 *
	 * @param params the parameters to serialize
	 * @return serialized bytes
	 */
	abstract fun serialize(params: P): ByteArray

	/**
	 * Deserializes parameters from the given byte array.
	 *
	 * @param buffer the bytes to deserialize
	 * @return deserialized parameters
	 */
	abstract fun deserialize(buffer: ByteArray): P



	/**
	 * Generates a digest from the given data and salt (if applicable) using the given parameters.
	 *
	 * @param data the actual data
	 * @param salt an optional salt to add
	 * @param params the parameters to use
	 * @return the generated digest
	 */
	fun digest(data: ByteArray, salt: ByteArray? = null, params: P = defaultParameters): ByteArray {
		val instance = create(params)
		return ByteArray(instance.digestSize).also {
			instance.digest(data, salt, it, 0)
		}
	}

}
