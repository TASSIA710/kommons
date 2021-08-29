package net.tassia.assertions

import net.tassia.assertions.dsl.le
import net.tassia.assertions.error.AssertionFailure
import kotlin.test.Test

class TestLessEqual {

	@Test
	fun test1() {
		expectSuccess {
			assert(config) { expect(3) le 3 }
		}
	}

	@Test
	fun test2() {
		expectSuccess {
			assert(config) { expect(2) le 3 }
		}
	}

	@Test
	fun test3() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(4) le 3 }
		}
	}

	@Test
	fun test4() {
		expectSuccess {
			assert(config) { expect(3.0) le 3.0 }
		}
	}

	@Test
	fun test5() {
		expectSuccess {
			assert(config) { expect(2.5) le 3.0 }
		}
	}

	@Test
	fun test6() {
		expectFailure<AssertionFailure> {
			assert(config) { expect(3.5) le 3.0 }
		}
	}

}
