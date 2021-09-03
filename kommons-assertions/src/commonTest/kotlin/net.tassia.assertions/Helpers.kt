package net.tassia.assertions

val config = AssertionConfiguration().also {
	it.enabled = true
}

inline fun expectSuccess(block: () -> Unit) {
	block()
}

inline fun <reified E : Throwable> expectFailure(block: () -> Unit) {
	try {
		block()
		throw AssertionError("Block was expected to throw ${E::class.simpleName}, but it didn't throw anything.")
	} catch (ex: Throwable) {
		if (ex !is E) {
			throw ex
		}
	}
}
