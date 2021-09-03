package net.tassia.parser

import kotlin.math.min

class StringParser(val source: String) : Parser() {

	var index: Int = 0
		private set



	override fun peek(): Char {
		return if (hasEndReached) EOF else source[index]
	}

	override fun peek(length: Int): String {
		val end = min(source.length, index + length)
		return source.substring(index, end)
	}

	override fun next(): Char {
		return peek().also {
			this.index += 1
		}
	}

	override fun next(length: Int): String {
		return peek(length).also {
			this.index += length
		}
	}



	override val hasEndReached: Boolean
		get() = index >= source.length

	override val hasNotEndReached: Boolean
		get() = index < source.length



	fun reset() {
		this.index = 0
	}

}
