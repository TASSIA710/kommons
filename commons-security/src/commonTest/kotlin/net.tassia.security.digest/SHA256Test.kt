package net.tassia.security.digest

import kotlin.test.Test

class SHA256Test {

	@Test
	fun testRandomized() {
		digestTests(Digests, SHA256)
	}

	@Test
	fun test1() {
		testDSL(SHA256) {
			"e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855" expect ""
		}
	}

}
