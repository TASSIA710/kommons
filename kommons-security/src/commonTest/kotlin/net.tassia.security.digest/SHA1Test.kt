package net.tassia.security.digest

import kotlin.test.Test

class SHA1Test {

	@Test
	fun testRandomized() {
		digestTests(Digests, SHA1)
	}

	@Test
	fun test1() {
		testDSL(SHA1) {
			"da39a3ee5e6b4b0d3255bfef95601890afd80709" expect ""
		}
	}

	@Test
	fun test2() {
		testDSL(SHA1) {
			"2fd4e1c67a2d28fced849ee1bb76e7391b93eb12" expect "The quick brown fox jumps over the lazy dog"
		}
	}

	@Test
	fun test3() {
		testDSL(SHA1) {
			"de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3" expect "The quick brown fox jumps over the lazy cog"
		}
	}

}