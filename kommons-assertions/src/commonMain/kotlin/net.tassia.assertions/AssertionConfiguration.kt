package net.tassia.assertions

import net.tassia.Namespace

class AssertionConfiguration {

	var enabled: Boolean = false



	@Namespace
	companion object {

		val Default = AssertionConfiguration()

	}

}
