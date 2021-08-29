package net.tassia.assertions.struct

import net.tassia.assertions.error.AssertionFailure

class LessEqualAssertion<T : Comparable<T>>(private val value: T, private val limit: T, private val name: String?) : Assertion() {

	override fun check() {
		// Is valid?
		if (value <= limit) return

		// Build message
		// TODO: Proper message
		throw AssertionFailure(this, "Assertion failed.")
	}

}
