package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestSame {

	@Test
	fun test1() {
		assert(config) { expect(42) same 42 }
	}

	@Test
	fun test2() {
		expectError<AssertionFailure> {
			assert(config) { expect(42) same 41 }
		}
	}

	@Test
	fun test3() {
		val str = "Hello World!"
		assert(config) { expect(str) same str }
	}

	@Test
	fun test4() {
		expectError<AssertionFailure> {
			assert(config) { expect("Hello World!") same "Hello World!" }
		}
	}

	@Test
	fun test5() {
		expectError<AssertionFailure> {
			assert(config) { expect("Hello World!") same "Hello Other World!" }
		}
	}

}
