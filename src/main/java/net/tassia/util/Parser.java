package net.tassia.util;

import java.util.function.Predicate;

public class Parser {

	public static final char EOF = (char) -1;

	protected final String source;
	protected int index = 0;

	public Parser(String source) {
		this.source = source;
	}



	public void reset() {
		this.index = 0;
	}



	public char peek() {
		return peekAt(index);
	}

	public char peekAt(int index) {
		return index < source.length() ? source.charAt(index) : EOF;
	}

	public String peek(int length) {
		int end = Math.min(source.length(), index + length);
		return source.substring(index, end);
	}



	public char next() {
		char c = peek();
		this.index++;
		return c;
	}

	public String next(int length) {
		String str = peek(length);
		this.index += length;
		return str;
	}

	public boolean isNext(char test) {
		if (peek() == test) {
			this.index++;
			return true;
		} else {
			return false;
		}
	}

	public boolean isNext(String test) {
		if (peek(test.length()).equals(test)) {
			this.index += test.length();
			return true;
		} else {
			return false;
		}
	}



	public boolean hasEndReached() {
		return index >= source.length();
	}



	public String readWhile(Predicate<Character> predicate) {
		StringBuilder builder = new StringBuilder();
		while (predicate.test(peek()) && !hasEndReached()) {
			builder.append(next());
		}
		return builder.toString();
	}



	public String readUntil(char until) {
		StringBuilder builder = new StringBuilder();
		while (peek() != until && !hasEndReached()) {
			builder.append(next());
		}
		return builder.toString();
	}



	public void skipWhitespace() {
		readWhile(Character::isWhitespace);
	}

}
