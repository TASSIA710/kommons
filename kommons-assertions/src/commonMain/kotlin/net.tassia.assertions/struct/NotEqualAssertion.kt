package net.tassia.assertions.struct

import net.tassia.assertions.error.AssertionFailure
import net.tassia.assertions.toDisplayString
import net.tassia.assertions.toRepresentativeString

class NotEqualAssertion<T : Any?>(private val expected: T, private val actual: T) : Assertion() {

	override fun check() {
		// Is valid?
		if (expected != actual) return

		// Build message
		throw AssertionFailure(this) {

			child("What went wrong?") {
				child("A different value was expected.")
			}

			child("What was not expected?") {
				child(expected.toDisplayString())
			}

			child("Interpretive Representation") {
				child("Assertion: THIS != THAT")
				child("THIS: ${expected.toRepresentativeString()}")
				child("THAT: ${actual.toRepresentativeString()}")
			}

		}
	}

}
