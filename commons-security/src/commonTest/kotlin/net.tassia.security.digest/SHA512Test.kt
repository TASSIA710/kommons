package net.tassia.security.digest

import kotlin.test.Test

class SHA512Test {

	@Test
	fun testRandomized() {
		digestTests(Digests, SHA512)
	}

	@Test
	fun test1() {
		testDSL(SHA512) {
			"cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e" expect ""
		}
	}

}
