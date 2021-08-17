package net.tassia.security

import net.tassia.security.digests.*

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.md5(): ByteArray {
	return MD5Digest.INSTANCE.create().digest(byteArrayOf(), this)
}

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.sha1(): ByteArray {
	return SHA1Digest.INSTANCE.create().digest(byteArrayOf(), this)
}

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.sha224(): ByteArray {
	return SHA224Digest.INSTANCE.create().digest(byteArrayOf(), this)
}

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.sha256(): ByteArray {
	return SHA256Digest.INSTANCE.create().digest(byteArrayOf(), this)
}

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.sha384(): ByteArray {
	return SHA384Digest.INSTANCE.create().digest(byteArrayOf(), this)
}

@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.sha512(): ByteArray {
	return SHA512Digest.INSTANCE.create().digest(byteArrayOf(), this)
}
