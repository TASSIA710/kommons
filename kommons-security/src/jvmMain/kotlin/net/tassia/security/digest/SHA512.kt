package net.tassia.security.digest

import net.tassia.security.digest.impl.NPDigestType
import net.tassia.security.digest.impl.NoParameters
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

actual object SHA512 : NPDigestType("sha512", "SHA-512") {

	override fun create(): DigestInstance<NoParameters> {
		try {
			val digest = MessageDigest.getInstance("SHA-512")
			return NativeNPDigestInstance(this, digest)
		} catch (ex: NoSuchAlgorithmException) {
			throw InternalError("SHA-512 is not supported on this system.", ex)
		}
	}

}
