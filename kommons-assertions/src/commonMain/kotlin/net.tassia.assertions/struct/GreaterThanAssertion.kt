package net.tassia.assertions.struct

import net.tassia.assertions.error.AssertionFailure
import net.tassia.assertions.toDisplayString
import net.tassia.assertions.toRepresentativeString

class GreaterThanAssertion<T : Comparable<T>>(private val value: T, private val limit: T) : Assertion() {

	override fun check() {
		// Is valid?
		if (value > limit) return

		// Build message
		throw AssertionFailure(this) {

			child("What went wrong?") {
				val value = value.toDisplayString()
				val limit = limit.toDisplayString()
				child("A value ($value) was expected to be greater than a limit ($limit).")
			}

			child("Interpretive Representation") {
				child("Assertion: THIS > THAT")
				child("THIS: ${value.toRepresentativeString()}")
				child("THAT: ${limit.toRepresentativeString()}")
			}

		}
	}

}
