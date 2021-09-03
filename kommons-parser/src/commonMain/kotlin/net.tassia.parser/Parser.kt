package net.tassia.parser

import net.tassia.Namespace
import net.tassia.assertions.assert
import net.tassia.assertions.eq

abstract class Parser {

	abstract fun peek(): Char
	abstract fun peek(length: Int): String

	abstract fun next(): Char
	abstract fun next(length: Int): String

	abstract val hasEndReached: Boolean
	abstract val hasNotEndReached: Boolean



	open fun isNext(test: Char): Boolean {
		if (peek() == test) {
			val next = next()
			assert { expect(next) eq test }
			return true
		}
		return false
	}

	open fun isNext(test: String): Boolean {
		if (peek(test.length) == test) {
			val next = next(test.length)
			assert { expect(next) eq test }
			return true
		}
		return false
	}



	inline fun readWhile(predicate: (Char) -> Boolean): String {
		val builder = StringBuilder()
		while (predicate(peek()) && hasNotEndReached) {
			builder.append(next())
		}
		return builder.toString()
	}

	fun readUntil(until: Char): String {
		return readWhile { it != until }
	}



	fun skipWhitespace() {
		readWhile { it.isWhitespace() }
	}

	fun readAll(): String {
		return readWhile { true }
	}



	@Namespace
	companion object {

		const val EOF: Char = (-1).toChar()

	}

}
