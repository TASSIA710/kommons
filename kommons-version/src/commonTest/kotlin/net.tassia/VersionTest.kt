package net.tassia

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class VersionTest {

	private fun randomExtension(): String? {
		if (Random.nextBoolean()) return null
		val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_/".toCharArray()
		return CharArray(Random.nextInt(64)) { chars.random() }.concatToString()
	}

	private fun randomGitBranch(): String? {
		if (Random.nextBoolean()) return null
		val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_/".toCharArray()
		return CharArray(Random.nextInt(64)) { chars.random() }.concatToString()
	}

	private fun randomGitHead(): String? {
		if (Random.nextBoolean()) return null
		val chars = "0123456789abcdef".toCharArray()
		return CharArray(40) { chars.random() }.concatToString()
	}

	private fun randomVersion(): Version {
		return Version(
			major = Random.nextInt(2 shl 16),
			minor = Random.nextInt(2 shl 16),
			patch = Random.nextInt(2 shl 16),
			build = Random.nextInt(2 shl 16),
			extension = randomExtension(),
			gitBranch = randomGitBranch(),
			gitHead = randomGitHead(),
		)
	}

	@Test
	fun testRandomized() {
		repeat(4096 * 8) {
			val version = randomVersion()
			val encoded = version.encodeToString()
			assertEquals(version, encoded.decodeToVersion())
		}
	}

}
