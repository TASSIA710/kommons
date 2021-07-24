package net.tassia.util;

import net.tassia.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Base16Test {

	@Test
	public void testRandomized() {
		for (int i = 0; i < Tests.ENTROPY_ITERATIONS; i++) {
			byte[] data = Tests.randomData();

			String encoded = Base16.ENCODER.encode(data);
			byte[] decoded = Base16.DECODER.decode(encoded);

			Assertions.assertArrayEquals(data, decoded);
		}
	}

	@Test
	public void testReferences() {
		// TODO
	}

}
