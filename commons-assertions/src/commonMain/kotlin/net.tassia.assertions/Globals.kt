package net.tassia.assertions

import net.tassia.assertions.dsl.AssertionBuilder
import net.tassia.assertions.dsl.AssertionDSL
import net.tassia.assertions.struct.Assertion

@AssertionDSL
@Throws(AssertionError::class)
inline fun assert(config: AssertionConfiguration = AssertionConfiguration.Default, block: AssertionBuilder.() -> Assertion) {
	if (config.enabled) {
		AssertionBuilder(config).block().check()
	}
}
