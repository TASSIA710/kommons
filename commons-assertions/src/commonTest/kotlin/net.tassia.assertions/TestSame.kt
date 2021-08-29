package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestSame {

	@Test
	fun test1() {
		expectSuccess {
			assert(config) { expect(42) same 42 }
		}
	}

	@Test
	fun test2() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(42) same 41 }
		}
	}

	@Test
	fun test3() {
		expectSuccess {
			val str = "Hello World!"
			assert(config) { expect(str) same str }
		}
	}

	@Test
	fun test4() {
		expectFailure<AssertionFailure> {
			val str1 = "Hello World!"
			val str2 = "Other Hello World!".substring("Other ".length)
			assert(config) { expect(str1) same str2 }
		}
	}

	@Test
	fun test5() {
		expectFailure<AssertionFailure> {
			assert(config) { expect("Hello World!") same "Hello Other World!" }
		}
	}

}
