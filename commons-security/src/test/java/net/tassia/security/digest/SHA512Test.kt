package net.tassia.security.digest

import net.tassia.encoding.base16
import net.tassia.security.digests.SHA512Digest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

@DisplayName("SHA-512")
class SHA512Test {

	private fun testReference(text: String, expected: String) {
		val data = text.toByteArray(StandardCharsets.UTF_8)
		val hash = SHA512Digest.INSTANCE.create().digest(ByteArray(0), data)
		Assertions.assertEquals(expected, hash.base16())
	}

	@Test
	@DisplayName("References")
	fun testReferences() {
		testReference("", "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e")
	}

}
