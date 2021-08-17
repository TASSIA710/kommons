package net.tassia.security.digest

import net.tassia.encoding.base16
import net.tassia.security.digests.MD5Digest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

@DisplayName("MD5")
class MD5Test {

	private fun testReference(text: String, expected: String) {
		val data = text.toByteArray(StandardCharsets.UTF_8)
		val hash = MD5Digest.INSTANCE.create().digest(ByteArray(0), data)
		Assertions.assertEquals(expected, hash.base16())
	}

	@Test
	@DisplayName("References")
	fun testReferences() {
		testReference("The quick brown fox jumps over the lazy dog", "9e107d9d372bb6826bd81d3542a419d6")
		testReference("The quick brown fox jumps over the lazy dog.", "e4d909c290d0fb1ca068ffaddf22cbd0")
		testReference("", "d41d8cd98f00b204e9800998ecf8427e")
	}

}
