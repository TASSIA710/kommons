package net.tassia.security.digest;

import net.tassia.security.digests.SHA512Digest;
import net.tassia.util.Base16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class SHA512Test {

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		byte[] hash = SHA512Digest.INSTANCE.create().digest(new byte[0], data);
		Assertions.assertEquals(expected, Base16.ENCODER.encode(hash));
	}

	@Test
	public void testReferences() {
		testReference("", "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e");
	}

}
