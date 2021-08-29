package net.tassia.assertions.struct

import net.tassia.assertions.error.AssertionFailure

class NotEqualAssertion<T : Any?>(private val expected: T, private val actual: T, private val name: String?) : Assertion() {

	override fun check() {
		// Is valid?
		if (expected != actual) return

		// Build message
		// TODO: Proper message
		throw AssertionFailure(this, "Assertion failed.")
	}

}
