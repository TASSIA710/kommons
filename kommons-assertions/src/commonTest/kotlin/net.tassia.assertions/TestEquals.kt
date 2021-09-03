package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestEquals {

	@Test
	fun test1() {
		expectSuccess {
			assert(config) { expect(42) eq 42 }
		}
	}

	@Test
	fun test2() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(42) eq 41 }
		}
	}

	@Test
	fun test3() {
		expectSuccess {
			assert(config) { expect("Hello World!") eq "Hello World!" }
		}
	}

	@Test
	fun test4() {
		expectFailure<AssertionFailure> {
			assert(config) { expect("Hello World!") eq "Hello Other World!" }
		}
	}

}
