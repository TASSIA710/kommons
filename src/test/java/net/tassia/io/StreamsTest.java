package net.tassia.io;

import net.tassia.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamsTest {

	@Test
	public void test1() throws IOException {
		for (int i = 0; i < Tests.ENTROPY_ITERATIONS; i++) {
			byte[] data = Tests.randomData();

			InputStream in = new ByteArrayInputStream(data);
			byte[] data2 = Streams.readAllBytes(in, Tests.RANDOM.nextInt(4096 * 4) + 1);

			Assertions.assertArrayEquals(data, data2);
		}
	}

	@Test
	public void test2() throws IOException {
		for (int i = 0; i < Tests.ENTROPY_ITERATIONS; i++) {
			byte[] data = Tests.randomData();

			InputStream in = new ByteArrayInputStream(data);
			byte[] data2 = Streams.readAllBytes(in);

			Assertions.assertArrayEquals(data, data2);
		}
	}

}
