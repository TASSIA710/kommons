package net.tassia.assertions.dsl

import net.tassia.assertions.struct.EqualAssertion
import net.tassia.assertions.struct.SameAssertion

infix fun <T : Any?> PendingValueBuilder<T>.eq(that: T): EqualAssertion<T> {
	return EqualAssertion(that, value, name)
}

infix fun <T : Any?> PendingValueBuilder<T>.neq(that: T): EqualAssertion<T> {
	TODO()
}

infix fun <T : Any?> PendingValueBuilder<T>.same(that: T): SameAssertion<T> {
	return SameAssertion(that, value, name)
}
