package net.tassia.encoding

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets
import kotlin.random.Random

@DisplayName("Base64")
class Base64Test {

	@Test
	@DisplayName("Randomized")
	fun testRandomized() {
		repeat(4096 * 8) {

			// Generate random data
			val data = Random.nextBytes(Random.nextInt(4096))

			// Encode & decode
			val encoded = data.base64()
			val decoded = encoded.base64()

			// Assert
			Assertions.assertTrue(data contentEquals decoded)

		}
	}

	private fun testReference(text: String, expected: String) {
		val data = text.toByteArray(StandardCharsets.UTF_8)
		val encoded: String = data.base64()
		Assertions.assertEquals(expected, encoded)

		val decoded: ByteArray = encoded.base64()
		val decodedText = String(decoded, StandardCharsets.UTF_8)
		Assertions.assertEquals(text, decodedText)
	}

	@Test
	@DisplayName("References (Wikipedia)")
	fun testWikipediaReferences() {
		// Source: https://en.wikipedia.org/wiki/Base64
		testReference(
			"Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure.",
			"TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="
		)
		testReference("any carnal pleasure.", "YW55IGNhcm5hbCBwbGVhc3VyZS4=")
		testReference("any carnal pleasure", "YW55IGNhcm5hbCBwbGVhc3VyZQ==")
		testReference("any carnal pleasur", "YW55IGNhcm5hbCBwbGVhc3Vy")
		testReference("any carnal pleasu", "YW55IGNhcm5hbCBwbGVhc3U=")
		testReference("any carnal pleas", "YW55IGNhcm5hbCBwbGVhcw==")
		testReference("pleasure.", "cGxlYXN1cmUu")
		testReference("leasure.", "bGVhc3VyZS4=")
		testReference("easure.", "ZWFzdXJlLg==")
		testReference("asure.", "YXN1cmUu")
		testReference("sure.", "c3VyZS4=")
	}

}
