package net.tassia.security.digest;

import net.tassia.security.digests.SHA1Digest;
import net.tassia.util.Base16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class SHA1Test {

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		byte[] hash = SHA1Digest.INSTANCE.create().digest(new byte[0], data);
		Assertions.assertEquals(expected, Base16.ENCODER.encode(hash));
	}

	@Test
	public void testReferences() {
		testReference("The quick brown fox jumps over the lazy dog", "2fd4e1c67a2d28fced849ee1bb76e7391b93eb12");
		testReference("The quick brown fox jumps over the lazy cog", "de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3");
		testReference("", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
	}

}
