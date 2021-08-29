package net.tassia.assertions.struct

class SameAssertion<T : Any?>(private val expected: T, private val actual: T, private val name: String?) : Assertion() {

	override fun check() {
		// Is valid?
		if (expected === actual) return

		// Build message
		TODO()
	}

}
