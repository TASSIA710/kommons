package net.tassia;

import java.util.Random;

public class Tests {

	/**
	 * How many times a randomized test should be repeated for enough entropy to cover most edge cases.
	 */
	public static final int ENTROPY_ITERATIONS = 4096 * 4;

	public static final Random RANDOM = new Random();

	public static byte[] randomData() {
		byte[] buffer = new byte[RANDOM.nextInt(4096)];
		RANDOM.nextBytes(buffer);
		return buffer;
	}

}
