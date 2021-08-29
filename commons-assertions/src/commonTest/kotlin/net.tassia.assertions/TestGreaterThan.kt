package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestGreaterThan {

	@Test
	fun test1() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3) gt 3 }
		}
	}

	@Test
	fun test2() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(2) gt 3 }
		}
	}

	@Test
	fun test3() {
		expectSuccess {
			assert(config) { expect(4) gt 3 }
		}
	}

	@Test
	fun test4() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3.0) gt 3.0 }
		}
	}

	@Test
	fun test5() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(2.5) gt 3.0 }
		}
	}

	@Test
	fun test6() {
		expectSuccess {
			assert(config) { expect(3.5) gt 3.0 }
		}
	}

}
