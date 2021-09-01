package net.tassia.security.digest

import kotlin.test.Test

class MD5Test {

	@Test
	fun testRandomized() {
		digestTests(Digests, MD5)
	}

	@Test
	fun test1() {
		testDSL(MD5) {
			"d41d8cd98f00b204e9800998ecf8427e" expect ""
		}
	}

	@Test
	fun test2() {
		testDSL(MD5) {
			"9e107d9d372bb6826bd81d3542a419d6" expect "The quick brown fox jumps over the lazy dog"
		}
	}

	@Test
	fun test3() {
		testDSL(MD5) {
			"e4d909c290d0fb1ca068ffaddf22cbd0" expect "The quick brown fox jumps over the lazy dog."
		}
	}

}
