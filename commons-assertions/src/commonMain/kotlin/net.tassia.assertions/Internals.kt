package net.tassia.assertions

/*

Message Format:

╔══════════ « Assertion Failed » ══════════
║
║	What went wrong?
║	  ➥ Single line describing the problem.
║
║	Where's the difference?
║	  ├─ Expected: "String123"
║	  └─ But got: "String321"
║
║	Also cool: Nested blocks!
║	  ├─ Sub Text 1
║	  │    ├─ Sub-Sub Text 1
║	  │    └─ Sub-Sub Text 2
║	  └─ Sub Text 2
║
╚══════════════════════════════════════════

 */

internal fun buildMessage(blocks: List<MessageBlock>): String {
	val builder = StringBuilder()

	// Header
	builder.append("\n\n+---------- Assertion Failed ----------\n")
	builder.append("|\n")

	// Body
	for (block in blocks) {
		TODO()
		builder.append("|\n")
	}

	// Footer
	builder.append("+--------------------------------------\n\n")

	return builder.toString()
}
