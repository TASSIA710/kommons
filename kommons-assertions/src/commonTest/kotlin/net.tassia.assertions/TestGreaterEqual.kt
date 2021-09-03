package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestGreaterEqual {

	@Test
	fun test1() {
		expectSuccess {
			assert(config) { expect(3) ge 3 }
		}
	}

	@Test
	fun test2() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(2) ge 3 }
		}
	}

	@Test
	fun test3() {
		expectSuccess {
			assert(config) { expect(4) ge 3 }
		}
	}

	@Test
	fun test4() {
		expectSuccess {
			assert(config) { expect(3.0) ge 3.0 }
		}
	}

	@Test
	fun test5() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(2.5) ge 3.0 }
		}
	}

	@Test
	fun test6() {
		expectSuccess {
			assert(config) { expect(3.5) ge 3.0 }
		}
	}

}
