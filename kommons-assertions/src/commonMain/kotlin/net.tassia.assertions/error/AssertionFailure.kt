package net.tassia.assertions.error

import net.tassia.MessageBlock
import net.tassia.MessageBlockBuilder
import net.tassia.assertions.struct.Assertion

open class AssertionFailure(val assertion: Assertion, override val message: String) : AssertionError(message) {

	internal constructor(assertion: Assertion, block: MessageBlock)
		: this(assertion, "\n\n" + block.buildUTF8() + "\n\n")

	internal constructor(assertion: Assertion, block: MessageBlockBuilder.() -> Unit)
		: this(assertion, MessageBlock("Assertion Failed", block))

}
