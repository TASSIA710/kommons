package net.tassia.assertions

import net.tassia.assertions.dsl.PendingValueBuilder
import net.tassia.assertions.struct.EqualAssertion
import net.tassia.assertions.struct.NotEqualAssertion
import net.tassia.assertions.struct.SameAssertion

infix fun <T : Any?> PendingValueBuilder<T>.eq(that: T): EqualAssertion<T> {
	return EqualAssertion(that, value)
}

infix fun <T : Any?> PendingValueBuilder<T>.neq(that: T): NotEqualAssertion<T> {
	return NotEqualAssertion(that, value)
}

infix fun <T : Any?> PendingValueBuilder<T>.same(that: T): SameAssertion<T> {
	return SameAssertion(that, value)
}
