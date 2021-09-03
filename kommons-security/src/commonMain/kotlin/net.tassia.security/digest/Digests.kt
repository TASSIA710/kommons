package net.tassia.security.digest

import net.tassia.encoding.base64

/**
 * This class is used to represent a set of digests, which in turn are
 * used to generate encoded digest strings and to properly decode them.
 *
 * @param digests a set containing all digests in this environment
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
open class Digests(val digests: Set<DigestType<*>>) {

	inline fun findDigest(where: (DigestType<*>) -> Boolean): DigestType<*>? {
		return digests.find(where)
	}

	fun findDigest(identifier: String): DigestType<*>? {
		return findDigest { it.identifier == identifier }
	}



	fun <P : DigestParameters> digest(type: DigestType<P>, data: ByteArray, salt: ByteArray? = null, params: P = type.defaultParameters): String {
		val digest = type.digest(data, salt, params)
		return encodeDigestString(type, params, digest, salt)
	}

	fun verify(str: String, data: ByteArray): Boolean {
		// Decode string
		val (identifier, bytes) = decodeDigestString(str) ?: return false

		// Find digest
		val digest = findDigest(identifier) ?: return false

		// Verify digest
		return verifyDigest(digest, bytes[0], bytes[1], bytes[2], data)
	}

	private fun <P : DigestParameters> verifyDigest(type: DigestType<P>, params: ByteArray, digest: ByteArray, salt: ByteArray, data: ByteArray): Boolean {
		// Deserialize parameters
		val parameters = type.deserialize(params)

		// Verify
		return digest contentEquals type.digest(data, salt, parameters)
	}



	private fun <P : DigestParameters> encodeDigestString(type: DigestType<P>, params: P, digest: ByteArray, salt: ByteArray?): String {
		// Format: {identifier}${parameters}${digest}${salt}
		val paramsStr = type.serialize(params).base64()
		val digestStr = digest.base64()
		val saltStr = salt?.base64() ?: ""
		return type.identifier + '$' + paramsStr + '$' + digestStr + '$' + saltStr
	}

	private fun decodeDigestString(str: String): Pair<String, Array<ByteArray>>? {
		val split = str.split('$')
		if (split.size != 4) return null
		val params = split[1].base64()
		val digest = split[2].base64()
		val salt = split[3].base64()
		return split[0] to arrayOf(params, digest, salt)
	}



	companion object : Digests(setOf(MD5, SHA1, SHA256, SHA512))

}
