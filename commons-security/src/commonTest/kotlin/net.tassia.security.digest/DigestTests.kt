package net.tassia.security.digest

import net.tassia.encoding.base16
import kotlin.random.Random
import kotlin.test.assertContentEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

inline fun <P : DigestParameters> testDSL(type: DigestType<P>, params: P = type.defaultParameters, block: TestDSLBuilder<P>.() -> Unit) {
	TestDSLBuilder(type, params).block()
}

data class TestDSLBuilder<P : DigestParameters>(val type: DigestType<P>, val params: P) {

	infix fun String.expect(text: String) {
		val hash = this.base16()
		val bytes = text.encodeToByteArray()
		assertContentEquals(hash, type.digest(bytes, params = params))
	}

}

fun <P : DigestParameters> digestTests(digests: Digests, type: DigestType<P>, params: P = type.defaultParameters) {
	repeat(4096 * 2) {

		// Generate salt and data
		val salt = Random.nextBytes(Random.nextInt(4096))
		val data = Random.nextBytes(Random.nextInt(4096))

		// Generate digest
		val str = digests.digest(type, data, salt, params)
		assertTrue(digests.verify(str, data))

		// Check for flipped data
		if (data.isNotEmpty()) {
			val flipped = ByteArray(data.size) { data[it].toInt().inv().toByte() }
			assertFalse(Digests.verify(str, flipped))
		}

	}
}
