package net.tassia.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

	@Test
	public void test1() {
		String str = "Hello World!";
		Parser p = new Parser(str);

		char[] chars = {
			'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', Parser.EOF
		};

		for (char c : chars) {
			assertEquals(c, p.peek());
			assertEquals(c, p.peek());
			assertEquals(c, p.next());
		}

		for (int i = 0; i < chars.length; i++) {
			assertEquals(chars[i], p.peekAt(i));
		}
	}

	@Test
	public void test2() {
		String str = "Hello World!";
		Parser p = new Parser(str);

		assertEquals("", p.peek(0));
		assertEquals("H", p.peek(1));
		assertEquals("Hello", p.peek(5));
		assertEquals("Hello World!", p.peek(12));
		assertEquals("Hello World!", p.peek(13));
	}

	@Test
	public void test3() {
		String str = "Hello World!";
		Parser p = new Parser(str);

		assertEquals("", p.next(0));
		assertEquals("", p.next(0));
		assertEquals("H", p.next(1));
		assertEquals("ello", p.next(4));

		p.reset();
		assertEquals("H", p.next(1));

		p.reset();
		assertEquals("Hello", p.next(5));

		p.reset();
		assertEquals("Hello World!", p.next(12));

		p.reset();
		assertEquals("Hello World!", p.next(13));
	}

	@Test
	public void test4() {
		String str = "Hello World!";
		Parser p = new Parser(str);

		char[] chars = {
			'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', Parser.EOF
		};

		for (char c : chars) {
			assertFalse(p.isNext((char) (c + 1)));
			assertTrue(p.isNext(c));
		}
	}

	@Test
	public void test5() {
		String str = "Hello World!";
		Parser p = new Parser(str);

		assertFalse(p.hasEndReached());
		assertTrue(p.isNext("H"));
		assertFalse(p.hasEndReached());

		p.reset();
		assertFalse(p.hasEndReached());
		assertFalse(p.isNext("Ello"));
		assertTrue(p.isNext("Hello"));
		assertFalse(p.hasEndReached());

		p.reset();
		assertFalse(p.hasEndReached());
		assertFalse(p.isNext("Hello Word!"));
		assertTrue(p.isNext("Hello World!"));
		assertTrue(p.hasEndReached());
	}

	@Test
	public void test6() {
		String str = " \t \n\r Hello World!";
		Parser p = new Parser(str);

		assertFalse(p.hasEndReached());
		assertFalse(p.isNext("Hello World!"));
		assertFalse(p.hasEndReached());
		p.skipWhitespace();
		assertTrue(p.isNext("Hello World!"));
		assertTrue(p.hasEndReached());
	}

	@Test
	public void test7() {
		String str = "[Hello World!]";
		Parser p = new Parser(str);

		assertFalse(p.hasEndReached());
		assertTrue(p.isNext('['));
		assertFalse(p.hasEndReached());
		assertEquals("Hello World!", p.readUntil(']'));
		assertFalse(p.hasEndReached());
		assertTrue(p.isNext(']'));
		assertTrue(p.hasEndReached());
	}

}
