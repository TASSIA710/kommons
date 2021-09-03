package net.tassia.security.digest

import net.tassia.security.digest.impl.NPDigestType
import net.tassia.security.digest.impl.NoParameters
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

actual object SHA256 : NPDigestType("sha256", "SHA-256") {

	override fun create(): DigestInstance<NoParameters> {
		try {
			val digest = MessageDigest.getInstance("SHA-256")
			return NativeNPDigestInstance(this, digest)
		} catch (ex: NoSuchAlgorithmException) {
			throw InternalError("SHA-256 is not supported on this system.", ex)
		}
	}

}
