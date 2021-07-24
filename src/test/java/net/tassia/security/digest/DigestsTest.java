package net.tassia.security.digest;

import net.tassia.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DigestsTest {

	@ParameterizedTest
	@ValueSource(strings = {
		"MD5"
	})
	public void testRandomized(String digestName) {
		for (int i = 0; i < Tests.ENTROPY_ITERATIONS; i++) {
			byte[] salt = Tests.randomData();
			byte[] data = Tests.randomData();

			Digest<?> digest = Digests.getDigest(digestName);
			String str = Digests.digest(digest, salt, data);
			Assertions.assertTrue(Digests.verify(str, data));

			if (data.length > 0) {
				for (int x = 0; x < data.length; x++) {
					data[x] = (byte) ~data[x];
				}
				Assertions.assertFalse(Digests.verify(str, data));
			}
		}
	}

}
