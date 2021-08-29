package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestEquals {

	@Test
	fun test1() {
		assert(config) { expect(42) eq 42 }
	}

	@Test
	fun test2() {
		expectError<AssertionFailure> {
			assert(config) { expect(42) eq 41 }
		}
	}

	@Test
	fun test3() {
		assert(config) { expect("Hello World!") eq "Hello World!" }
	}

	@Test
	fun test4() {
		expectError<AssertionFailure> {
			assert(config) { expect("Hello World!") eq "Hello Other World!" }
		}
	}

}
