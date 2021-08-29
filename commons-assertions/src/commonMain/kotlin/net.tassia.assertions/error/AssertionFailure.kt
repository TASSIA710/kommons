package net.tassia.assertions.error

import net.tassia.assertions.struct.Assertion

open class AssertionFailure(val assertion: Assertion, override val message: String) : AssertionError(message)
