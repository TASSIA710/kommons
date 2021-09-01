package net.tassia.security.digest

import net.tassia.security.digest.impl.NPDigestType
import net.tassia.security.digest.impl.NoParameters
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

actual object SHA1 : NPDigestType("sha1", "SHA-1") {

	override fun create(): DigestInstance<NoParameters> {
		try {
			val digest = MessageDigest.getInstance("SHA-1")
			return NativeNPDigestInstance(this, digest)
		} catch (ex: NoSuchAlgorithmException) {
			throw InternalError("SHA-1 is not supported on this system.", ex)
		}
	}

}
