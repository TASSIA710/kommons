package net.tassia.security

import net.tassia.security.digest.MD5
import net.tassia.security.digest.SHA1
import net.tassia.security.digest.SHA256
import net.tassia.security.digest.SHA512

fun ByteArray.md5(): ByteArray {
	return MD5.digest(this)
}

fun ByteArray.sha1(): ByteArray {
	return SHA1.digest(this)
}

fun ByteArray.sha256(): ByteArray {
	return SHA256.digest(this)
}

fun ByteArray.sha512(): ByteArray {
	return SHA512.digest(this)
}
