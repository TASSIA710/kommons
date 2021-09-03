package net.tassia

@MessageBlockDSL
inline fun MessageBlock(title: String, block: MessageBlockBuilder.() -> Unit): MessageBlock {
	return MessageBlockBuilder(title).also(block).build()
}



@DslMarker
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class MessageBlockDSL

data class MessageBlock(val title: String, val children: List<MessageBlock>) {

	fun buildASCII(): String {
		val builder = StringBuilder()

		// Header
		builder.append("+---------- << $title >> ----------\n")
		builder.append("|\n")

		// Body
		for (child in children) {
			builder.append("|\t${child.title}\n")
			builder.appendAsciiChild("|\t", child)
			builder.append("|\n")
		}

		// Footer
		builder.append("+----------------------------" + "-".repeat(title.length))

		return builder.toString()
	}

	private fun StringBuilder.appendAsciiChild(prefix: String, child: MessageBlock) {
		if (child.children.isEmpty()) return

		if (child.children.size == 1) {
			val sub = child.children.single()
			append("$prefix  -> ${sub.title}\n")
			appendAsciiChild("$prefix  |  ", sub)
			return
		}

		for (i in child.children.indices) {
			val sub = child.children[i]
			val isLast = i == child.children.size - 1
			if (isLast) {
				append("$prefix  +- ${sub.title}\n")
				appendAsciiChild("$prefix     ", sub)
			} else {
				append("$prefix  +- ${sub.title}\n")
				appendAsciiChild("$prefix  |  ", sub)
			}
		}
	}

	fun buildUTF8(): String {
		val builder = StringBuilder()

		// Header
		builder.append("╔══════════ « $title » ══════════\n")
		builder.append("║\n")

		// Body
		for (child in children) {
			builder.append("║\t${child.title}\n")
			builder.appendUTF8Child("║\t", child)
			builder.append("║\n")
		}

		// Footer
		builder.append("╚══════════════════════════" + "═".repeat(title.length))

		return builder.toString()
	}

	private fun StringBuilder.appendUTF8Child(prefix: String, child: MessageBlock) {
		if (child.children.isEmpty()) return

		if (child.children.size == 1) {
			val sub = child.children.single()
			append("$prefix  ➥ ${sub.title}\n")
			appendUTF8Child("$prefix  │  ", sub)
			return
		}

		for (i in child.children.indices) {
			val sub = child.children[i]
			val isLast = i == child.children.size - 1
			if (isLast) {
				append("$prefix  └─ ${sub.title}\n")
				appendUTF8Child("$prefix     ", sub)
			} else {
				append("$prefix  ├─ ${sub.title}\n")
				appendUTF8Child("$prefix  │  ", sub)
			}
		}
	}

}

class MessageBlockBuilder @PublishedApi internal constructor(private val title: String) {

	@PublishedApi
	internal val children: MutableList<MessageBlockBuilder> = mutableListOf()

	inline fun child(title: String, block: MessageBlockBuilder.() -> Unit = {}) {
		val builder = MessageBlockBuilder(title)
		builder.block()
		children.add(builder)
	}

	@PublishedApi
	internal fun build(): MessageBlock {
		return MessageBlock(title, children.map { it.build() })
	}

}
