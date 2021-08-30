package net.tassia.assertions.struct

import net.tassia.assertions.error.AssertionFailure
import net.tassia.assertions.toDisplayString
import net.tassia.assertions.toRepresentativeString

class EqualAssertion<T : Any?>(private val expected: T, private val actual: T) : Assertion() {

	override fun check() {
		// Is valid?
		if (expected == actual) return

		// Build message
		throw AssertionFailure(this) {

			child("What went wrong?") {
				child("A different value was expected.")
			}

			child("Where's the difference?") {
				child("Expected: ${expected.toDisplayString()}")
				child("But got: ${actual.toDisplayString()}")
			}

			child("Interpretive Representation") {
				child("Assertion: THIS == THAT")
				child("THIS: ${expected.toRepresentativeString()}")
				child("THAT: ${actual.toRepresentativeString()}")
			}

		}
	}

}
