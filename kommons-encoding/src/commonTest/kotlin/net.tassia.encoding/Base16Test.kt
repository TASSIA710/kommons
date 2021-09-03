package net.tassia.encoding

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class Base16Test {

	@Test
	fun testRandomized() {
		repeat(4096 * 8) {

			// Generate random data
			val data = Random.nextBytes(Random.nextInt(4096))

			// Encode & decode
			val encoded = data.base16()
			val decoded = encoded.base16()

			// Assert
			assertTrue(data contentEquals decoded)

		}
	}

}
