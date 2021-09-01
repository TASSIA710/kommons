package net.tassia.security.digest

import net.tassia.security.digest.impl.NPDigestType
import net.tassia.security.digest.impl.NoParameters
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

actual object MD5 : NPDigestType("md5", "MD5") {

	override fun create(): DigestInstance<NoParameters> {
		try {
			val digest = MessageDigest.getInstance("MD5")
			return NativeNPDigestInstance(this, digest)
		} catch (ex: NoSuchAlgorithmException) {
			throw InternalError("MD5 is not supported on this system.", ex)
		}
	}

}
