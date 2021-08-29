package net.tassia.assertions.dsl

import net.tassia.assertions.struct.EqualsAssertion
import net.tassia.assertions.struct.SameAssertion

class PendingValueBuilder<T : Any?>(private val value: T, private val name: String?) {

	infix fun eq(that: T): EqualsAssertion<T> {
		return EqualsAssertion(that, value, name)
	}

	infix fun same(that: T): SameAssertion<T> {
		return SameAssertion(that, value, name)
	}

}
