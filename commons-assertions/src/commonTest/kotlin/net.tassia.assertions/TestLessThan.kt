package net.tassia.assertions

import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestLessThan {

	@Test
	fun test1() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3) lt 3 }
		}
	}

	@Test
	fun test2() {
		expectSuccess {
			assert(config) { expect(2) lt 3 }
		}
	}

	@Test
	fun test3() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(4) lt 3 }
		}
	}

	@Test
	fun test4() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3.0) lt 3.0 }
		}
	}

	@Test
	fun test5() {
		expectSuccess {
			assert(config) { expect(2.5) lt 3.0 }
		}
	}

	@Test
	fun test6() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3.5) lt 3.0 }
		}
	}

}
