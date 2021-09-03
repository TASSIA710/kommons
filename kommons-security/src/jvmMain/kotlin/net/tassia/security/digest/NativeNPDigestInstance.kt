package net.tassia.security.digest

import net.tassia.security.digest.impl.NoParameters
import java.security.MessageDigest

internal class NativeNPDigestInstance(digest: DigestType<NoParameters>, private val base: MessageDigest)
	: DigestInstance<NoParameters>(digest, NoParameters) {

	override val digestSize: Int = base.digestLength

	override fun digest(data: ByteArray, salt: ByteArray?, buffer: ByteArray, offset: Int) {
		// Reset the instance
		base.reset()

		// Update the instance
		salt?.run { base.update(this) }
		base.update(data)

		// Finalization
		base.digest(buffer, offset, digestSize)
	}

}
