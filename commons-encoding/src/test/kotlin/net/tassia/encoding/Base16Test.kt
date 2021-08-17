package net.tassia.encoding

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.random.Random

@DisplayName("Base16")
class Base16Test {

	@Test
	@DisplayName("Randomized")
	fun testRandomized() {
		repeat(4096 * 8) {

			// Generate random data
			val data = Random.nextBytes(Random.nextInt(4096))

			// Encode & decode
			val encoded = data.base16()
			val decoded = encoded.base16()

			// Assert
			Assertions.assertTrue(data contentEquals decoded)

		}
	}

}
