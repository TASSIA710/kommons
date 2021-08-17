package net.tassia.security.digest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

@DisplayName("Digests")
class DigestsTest {

	@ParameterizedTest
	@ValueSource(strings = ["MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"])
	@DisplayName("Randomized")
	fun testRandomized(digestName: String) {
		repeat(4096 * 4) {

			// Generate salt and data
			val salt = Random.nextBytes(Random.nextInt(4096))
			val data = Random.nextBytes(Random.nextInt(4096))

			// Generate digest
			val digest = Digests.getDigest(digestName)
			val str = Digests.digest(digest, salt, data)
			Assertions.assertTrue(Digests.verify(str, data))

			// Check for flipped data
			if (data.isNotEmpty()) {
				val flipped = ByteArray(data.size) { data[it].toInt().inv().toByte() }
				Assertions.assertFalse(Digests.verify(str, flipped))
			}

		}
	}

}
