package net.tassia.parser

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringParserTest {

	@Test
	fun test1() {
		val str = "Hello World!"
		val chars = str.toCharArray()
		val parser: Parser = StringParser(str)

		for (char in chars) {
			assertEquals(char, parser.peek())
			assertEquals(char, parser.peek())
			assertEquals(char, parser.next())
		}
	}

	@Test
	fun test2() {
		val str = "Hello World!"
		val parser: Parser = StringParser(str)

		assertEquals("", parser.peek(0))
		assertEquals("H", parser.peek(1))
		assertEquals("Hello", parser.peek(5))
		assertEquals("Hello World!", parser.peek(12))
		assertEquals("Hello World!", parser.peek(13))
	}

	@Test
	fun test3() {
		val str = "Hello World!"
		val parser = StringParser(str)

		assertEquals("", parser.next(0))
		assertEquals("", parser.next(0))
		assertEquals("H", parser.next(1))
		assertEquals("ello", parser.next(4))

		parser.reset()
		assertEquals("H", parser.next(1))

		parser.reset()
		assertEquals("Hello", parser.next(5))

		parser.reset()
		assertEquals("Hello World!", parser.next(12))

		parser.reset()
		assertEquals("Hello World!", parser.next(13))
	}

	@Test
	fun test4() {
		val str = "Hello World!"
		val chars = str.toCharArray()
		val parser: Parser = StringParser(str)

		for (char in chars) {
			assertFalse(parser.isNext(char + 1))
			assertTrue(parser.isNext(char))
		}
	}

	@Test
	fun test5() {
		val str = "Hello World!"
		val parser = StringParser(str)

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)
		assertTrue(parser.isNext("H"))
		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		parser.reset()
		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)
		assertFalse(parser.isNext("Ello"))
		assertTrue(parser.isNext("Hello"))
		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		parser.reset()
		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)
		assertFalse(parser.isNext("Hello Word!"))
		assertTrue(parser.isNext("Hello World!"))
		assertTrue(parser.hasEndReached)
		assertFalse(parser.hasNotEndReached)
	}

	@Test
	fun test6() {
		val str = " \t \n\r Hello World!"
		val parser: Parser = StringParser(str)

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)
		assertFalse(parser.isNext("Hello World!"))
		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		parser.skipWhitespace()

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)
		assertTrue(parser.isNext("Hello World!"))
		assertTrue(parser.hasEndReached)
		assertFalse(parser.hasNotEndReached)
	}

	@Test
	fun test7() {
		val str = " \t \n\r Hello World!"
		val parser: Parser = StringParser(str)

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		parser.skipWhitespace()
		assertEquals("Hello World!", parser.readAll())

		assertTrue(parser.hasEndReached)
		assertFalse(parser.hasNotEndReached)
	}

	@Test
	fun test8() {
		val str = "[Hello World!]"
		val parser: Parser = StringParser(str)

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		assertTrue(parser.isNext('['))

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		assertEquals("Hello World!", parser.readUntil(']'))

		assertFalse(parser.hasEndReached)
		assertTrue(parser.hasNotEndReached)

		assertTrue(parser.isNext(']'))

		assertTrue(parser.hasEndReached)
		assertFalse(parser.hasNotEndReached)
	}

}
