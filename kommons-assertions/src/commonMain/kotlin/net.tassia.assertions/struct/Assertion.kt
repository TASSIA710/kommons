package net.tassia.assertions.struct

abstract class Assertion {

	@Throws(AssertionError::class)
	abstract fun check()

}
