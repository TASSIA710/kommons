package kommons.test

import kotlin.test.fail

@TestAssertionDSL
inline fun <reified E : Throwable> assertThrows(block: () -> Unit): E {
	try {
		block()
		fail("Expected an exception: ${E::class}")
	} catch (ex: Throwable) {
		if (ex is E) {
			// Expected!
			return ex
		} else throw ex
	}
}
