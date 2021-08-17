package net.tassia.security.digest

import net.tassia.encoding.base16
import net.tassia.security.digests.SHA1Digest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

@DisplayName("SHA-1")
class SHA1Test {

	private fun testReference(text: String, expected: String) {
		val data = text.toByteArray(StandardCharsets.UTF_8)
		val hash = SHA1Digest.INSTANCE.create().digest(ByteArray(0), data)
		Assertions.assertEquals(expected, hash.base16())
	}

	@Test
	@DisplayName("References")
	fun testReferences() {
		testReference("The quick brown fox jumps over the lazy dog", "2fd4e1c67a2d28fced849ee1bb76e7391b93eb12")
		testReference("The quick brown fox jumps over the lazy cog", "de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3")
		testReference("", "da39a3ee5e6b4b0d3255bfef95601890afd80709")
	}

}
