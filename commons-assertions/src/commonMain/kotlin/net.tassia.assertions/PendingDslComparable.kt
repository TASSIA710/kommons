package net.tassia.assertions

import net.tassia.assertions.dsl.PendingValueBuilder
import net.tassia.assertions.struct.GreaterEqualAssertion
import net.tassia.assertions.struct.GreaterThanAssertion
import net.tassia.assertions.struct.LessEqualAssertion
import net.tassia.assertions.struct.LessThanAssertion

infix fun <T : Comparable<T>> PendingValueBuilder<T>.lt(that: T): LessThanAssertion<T> {
	return LessThanAssertion(value, that, name)
}

infix fun <T : Comparable<T>> PendingValueBuilder<T>.le(that: T): LessEqualAssertion<T> {
	return LessEqualAssertion(value, that, name)
}

infix fun <T : Comparable<T>> PendingValueBuilder<T>.gt(that: T): GreaterThanAssertion<T> {
	return GreaterThanAssertion(value, that, name)
}

infix fun <T : Comparable<T>> PendingValueBuilder<T>.ge(that: T): GreaterEqualAssertion<T> {
	return GreaterEqualAssertion(value, that, name)
}
