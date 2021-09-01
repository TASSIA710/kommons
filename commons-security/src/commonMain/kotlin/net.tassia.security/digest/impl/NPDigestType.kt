package net.tassia.security.digest.impl

import net.tassia.security.digest.DigestInstance
import net.tassia.security.digest.DigestType

/**
 * The digest type, that does not have any actual parameters. (NPDigestType = NoParameterDigestType)
 *
 * @param identifier the identifier of the digest
 * @param displayName the display name
 *
 * @see DigestType
 * @see NoParameters
 *
 * @since Commons 1.0
 * @author Tassilo
 */
abstract class NPDigestType(identifier: String, displayName: String) : DigestType<NoParameters>(identifier, displayName) {

	override val defaultParameters = NoParameters

	override fun create(params: NoParameters): DigestInstance<NoParameters> {
		return create()
	}

	override fun serialize(params: NoParameters): ByteArray {
		return ByteArray(0)
	}

	override fun deserialize(buffer: ByteArray): NoParameters {
		return NoParameters
	}


	/**
	 * Creates a new digest instance for this digest.
	 *
	 * @return the created instance
	 */
	abstract fun create(): DigestInstance<NoParameters>

}
