package net.tassia.assertions.dsl

import net.tassia.assertions.AssertionConfiguration

class AssertionBuilder @PublishedApi internal constructor(private val config: AssertionConfiguration) {

	fun <T : Any?> expect(x: T): PendingValueBuilder<T> {
		return PendingValueBuilder(x)
	}

}
