package net.tassia.security.digest

import net.tassia.encoding.base16
import net.tassia.security.digests.SHA256Digest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

@DisplayName("SHA-256")
class SHA256Test {

	private fun testReference(text: String, expected: String) {
		val data = text.toByteArray(StandardCharsets.UTF_8)
		val hash = SHA256Digest.INSTANCE.create().digest(ByteArray(0), data)
		Assertions.assertEquals(expected, hash.base16())
	}

	@Test
	@DisplayName("References")
	fun testReferences() {
		testReference("", "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855")
	}

}
