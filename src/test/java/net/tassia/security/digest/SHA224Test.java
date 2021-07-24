package net.tassia.security.digest;

import net.tassia.security.digests.SHA224Digest;
import net.tassia.util.Base16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class SHA224Test {

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		byte[] hash = SHA224Digest.INSTANCE.create().digest(new byte[0], data);
		Assertions.assertEquals(expected, Base16.ENCODER.encode(hash));
	}

	@Test
	public void testReferences() {
		testReference("The quick brown fox jumps over the lazy dog", "730e109bd7a8a32b1cb9d9a09aa2325d2430587ddbc0c38bad911525");
		testReference("The quick brown fox jumps over the lazy dog.", "619cba8e8e05826e9b8c519c0a5c68f4fb653e8a3d8aa04bb2c8cd4c");
		testReference("", "d14a028c2a3a2bc9476102bb288234c415a2b01f828ea62ac5b3e42f");
	}

}
